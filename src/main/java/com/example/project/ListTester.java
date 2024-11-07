package com.example.project;

public class ListTester {
  public static <T> void circularLeftShift(List<T> list, int n) {
    if (list == null || list.isEmpty() || n <= 0) {
        return; // No shift needed if the list is empty or n is non-positive
    }

    int size = list.size();
    n = n % size; // To handle cases where n > size

    // Perform the shift by rearranging elements
    List<T> temp = new ArrayList<>(list.subList(n, size)); // Elements from index n to end
    temp.addAll(list.subList(0, n)); // Elements from start to index n-1
    list.clear();
    list.addAll(temp);
}

  public static <T> void reverseCopy(DLL<T> l1, DLL<T> l2) {
    if (l1.head == null) {
        return; // If l1 is empty, there's nothing to copy
    }

    // Start from the tail of l1 to copy in reverse
    Node<T> current = l1.tail;

    while (current != null) {
        // Add each element from l1's tail to l2's head
        l2.add(current.data);
        current = current.prev;
    }
}

}
