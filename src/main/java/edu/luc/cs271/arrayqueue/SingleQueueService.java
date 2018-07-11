package edu.luc.cs271.arrayqueue;

import java.util.Scanner;

public class SingleQueueService {

  /** Service time per customer in ms. */
  static final int SERVICE_TIME = 2000;

  public static void main(final String[] args) throws InterruptedException {
    // Completed read successive input lines until EOF and try to add them to the queue


    // queue for customer names
    final SimpleQueue<String> queue = new FixedArrayQueue<>(5);

    // lock object for thread safety
    final Object lock = new Object();

    // background activity for serving customers
    final Thread consumer =
        new Thread(
            () -> {
              while (true) {
                String current;
		int remaining;
                synchronized (lock) {
                  current = queue.poll(); // Completed try to take next name from queue
		          remaining = queue.size(); // Completed determine resulting size of queue
                }
                if (current == null) {
                  System.out.println("no one waiting");
                } else {
                  System.out.println(current + " is being served, " + remaining + " still waiting");
                }
                try {
                  Thread.sleep(SERVICE_TIME);
                } catch (final InterruptedException ex) {
                  return;
                }
              }
            });
    consumer.setDaemon(true);
    consumer.start();

    // foreground activity for reading customer names from input
    final Scanner input = new Scanner(System.in);
    System.out.print("enter next customer: ");
    while (input.hasNextLine()) {
      final String name = input.nextLine();
      if (name.equals("")) {
        break;
      }
      boolean result;
      synchronized (lock) {
        result = true; // Completed try to add this name to the queue
        if (queue.size() == 5) {
          result = false;
        }
      }
      if (result) {
        queue.offer(name);
        System.out.println(name + " has joined the queue");
      } else {
        System.out.println("queue full, " + name + " unable to join");
      }
    }
  }
}
