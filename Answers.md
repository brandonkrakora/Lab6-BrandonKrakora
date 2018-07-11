- why do we need an explicit constructor?
  - We need to define an explicit constructor because by default java defined an implicit constructor with no arguments requested.
    It is called implicitly when we create an instance. By defining the constructor explicitly, we can may construct whatever data we want
    to pass in explicitly into the queue. In this case, the user can provide the size of queue of his or her choice.
- What happens when you offer an item to a full `FixedArrayQueue`?
    - The queue shouldn't let the item be inserted because it is full. The queue is not dynamic since it is fixed to a certain number of spaces.
- What happens when you poll an empty `FixedArrayQueue`?
    - You get previously inserted data because it cycles through the circular queue when you delete instead deleting the actual data in the cell.
- What is the time and (extra) space complexity of each of the `FixedArrayQueue` methods?
    - Time Complexity
        offer(final E obj) - 0(1)
        peek() - O(1)
        poll() - O(1)
        isEmpty() - O(1)
        size() - O(1)
        asList() - O(n)
    - Space Complexity
        offer(final E obj) - 0(3)
        peek() - O(1)
        poll() - O(3)
        isEmpty() - O(1)
        size() - O(1)
        asList() - O(2 + n) -> O(n)
