package com.example.project;

public class DLL<T> {
	private DLLNode<T> head;
	private DLLNode<T> current;

    public DLL() {
        head = current = null;
    }
    public boolean empty() {
        return head == null;
    }
    public boolean last() {
        return current.next == null;
    }
    public boolean first() {
        return current.previous == null;
    }
    public boolean full() {
        return false;
    }
    public void findFirst() {
        current = head;
    }
    public void findNext() {
        current = current.next;
    }
    public void findPrevious() {
        current = current.previous;
    }
    public T retrieve() {
        return current.data;
    }
    public void update(T val) {
        current.data = val;
    }
    public void insert(T val) {
        DLLNode<T> tmp = new DLLNode<T>(val);
        if(empty()) {
            current = head = tmp;
        }
        else {
            tmp.next = current.next;
            tmp.previous = current;
            if(current.next != null)
                current.next.previous = tmp;
            current.next = tmp;
            current = tmp;
        }
    }
    public void remove() {
        if(current == head) {
            head = head.next;
            if(head != null)
               head.previous = null;
        }
        else {
            current.previous.next = current.next;
            if(current.next != null)
               current.next.previous = current.previous;
        }
        if(current.next == null)
            current = head;
        else
            current = current.next;
    }
    public void removeBetween(T e1, T e2) {
       public void removeBetween(T e1, T e2) {
    // Find the node with e1
    Node<T> current = head;
    while (current != null && !current.data.equals(e1)) {
        current = current.next;
    }
    
    // If e1 is not found, return
    if (current == null) {
        return;
    }
    
    // Start from the node after e1 to search for e2
    Node<T> start = current;
    current = current.next;

    // Traverse until we find e2 or reach the end of the list
    while (current != null && !current.data.equals(e2)) {
        current = current.next;
    }

    // If e2 is not found, return
    if (current == null) {
        return;
    }

    // At this point, 'start' is the node with e1 and 'current' is the node with e2.
    // We need to remove all nodes between start and current (e1 and e2 not included).
    Node<T> temp = start.next;

    // Remove nodes between e1 and e2
    while (temp != current) {
        Node<T> nextNode = temp.next;
        temp.next = temp.prev = null;  // Disconnect the node
        temp = nextNode;
    }

    // Link e1's node to e2's node to bypass the removed nodes
    start.next = current;
    current.prev = start;

    // Move current pointer to head if the removal was successful
    this.current = head;
}

        
    }
}
