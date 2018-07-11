package edu.luc.cs271.arrayqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FixedArrayQueue<E> implements SimpleQueue<E> {

  private final int capacity;

  private int size;

  private int front;

  private int rear;

  private final E[] data;

  // Completed why do we need an explicit constructor?

  @SuppressWarnings("unchecked")
  public FixedArrayQueue(final int capacity) { //10
    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
    this.size = 0;
    this.front = 0;
    this.rear = -1;
  }

  @Override
  public boolean offer(final E obj) {
    if (rear == capacity - 1) {
      rear = -1;
    }
    if ((size != capacity)) {
      rear++;
      this.data[rear] = obj;
      size++;
      return true;
    }
    else{
      return false;
    }
  }

  @Override
  public E peek() {
    if (isEmpty())
      return null;
    else
      return data[front];
  }

  @Override
  public E poll() {
    if (front == capacity) {
      front = 0;
    }
    E temp = data[front];
    front++;
    size--;
    return temp;
  }

  @Override
  public boolean isEmpty() {
    if (size() == 0)
      return true;
    else
      return false;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public List<E> asList() {
    // Completed implement using an ArrayList preallocated with the right size
    List<E> arrayQueue = new ArrayList<>();
    int counter =0;
    while (!isEmpty()) {
      arrayQueue.add(poll());
      counter++;
    }
    this.size = counter;
    return arrayQueue;
  }
}
