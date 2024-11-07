package com.example.project;

public class LinkedList<T> implements List<T>{
	private Node<T> head;
	private Node<T> current;
	
    public LinkedList() {
		head = current = null;
	}
	public boolean empty() {
		return head == null;
	}
	public boolean last() {
		return current.next == null;
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
    public T retrieve() {
        return current.data;
    }
    public void update(T e) {
        current.data = e;
    }
    public void insert(T e) {
        if (empty()) {
            current = head = new Node<T>(e);
        } else {
            Node<T> tmp = current.next;
            current.next = new Node<T>(e);
            current = current.next;
            current.next = tmp;
        }
    }
    public void remove() {
        if (current == head) {
            head = head.next;
        } else {
            Node<T> tmp = head;
            while (tmp.next != current) {
                tmp = tmp.next;
            }
            tmp.next = current.next;
        }
        if (current.next == null) {
            current = head;
        } else {
            current = current.next;
        }
    }
    public T mostFrequentElement() {
    if (head == null) {
        return null; // Return null if the list is empty
    }

    T mostFrequent = head.data; // Assume the first element as the most frequent initially
    int maxFrequency = 1; // Initialize the maximum frequency to 1

    Node<T> outer = head;

    while (outer != null) {
        T currentData = outer.data;
        int currentFrequency = 0;

        // Inner loop to count occurrences of currentData
        Node<T> inner = head;
        while (inner != null) {
            if (inner.data.equals(currentData)) {
                currentFrequency++;
            }
            inner = inner.next;
        }

        // Check if current frequency is higher or if it's the first occurrence of max frequency
        if (currentFrequency > maxFrequency) {
            mostFrequent = currentData;
            maxFrequency = currentFrequency;
        }

        outer = outer.next;
    }

    return mostFrequent;
}

}
