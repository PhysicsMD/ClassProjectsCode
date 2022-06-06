package lab8;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {

    @SuppressWarnings("rawtypes")
	public Node head;
    @SuppressWarnings("rawtypes")
	public Node tail;
    int size;

    DoublyLinkedList() {
        size = 0;
    }

    @SuppressWarnings("unchecked")
	ListIterator<Integer> DoublyListIterator() {
        return (ListIterator<Integer>) new DoublyListIterator();
    }

    @SuppressWarnings("hiding")
	private class Node<T> {

        private T Data;
        @SuppressWarnings("rawtypes")
		private Node next;
        @SuppressWarnings("rawtypes")
		private Node prev;

        @SuppressWarnings("rawtypes")
		Node(T value, Node previous, Node NextNode) {
            Data = value;
            next = NextNode;
            prev = previous;
        }
    }

    /**
     * The isEmpty method checks for how many elements are inside the array by a
     * variable counter called size
     *
     * @return
     */
    private boolean isEmpty() {
        return size == 0;
    }

    /**
     * When called the toString method converts the list into a printed list
     * output
     *
     * @return
     */
    public String toString() {
        @SuppressWarnings("rawtypes")
		Node position = head;
        String out = "";
        out += "[";
        while (position != null) {
            if (position != tail) {
                out += position.Data + ", ";
            } else {
                out += position.Data;
            }

            position = position.next;
        }
        out += "]";
        return out;
    }

    /**
     * The add first method adds a node to the begining of our list
     *
     * @param value
     */
    @SuppressWarnings("unchecked")
	public void addFirst(T value) {
        @SuppressWarnings("rawtypes")
		Node newNode = new Node(value, null, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size += 1;
    }

    /**
     * The add last method adds a node to the end of our list
     *
     * @param value
     */
    @SuppressWarnings("unchecked")
	public void addLast(T value) {
        @SuppressWarnings("rawtypes")
		Node newNode = new Node(value, null, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size += 1;
    }

    /**
     * get first returns the first elements data in the list
     * @return First Node
     */
    @SuppressWarnings("unchecked")
	public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return (T) head.Data;
        }
    }

    /**
     * get last returns the last elements data in the list
     * @return Last Node
     */
    @SuppressWarnings("unchecked")
	public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return (T) tail.Data;
        }
    }

    /**
     * remove first, removes the first element in our list
     */
    @SuppressWarnings("unchecked")
	public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        size -= 1;

        if (head.next != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        head = head.next;
    }

    /**
     * remove last, removes the last element in our list
     */
    @SuppressWarnings("unchecked")
	public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        size -= 1;

        if (tail.prev == null) {
            head = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    /**
     * size gives the user the size of the list
     * @return size of our list
     */
    public int size() {
        return size;
    }

    /**
     * get finds the Node at a given Index
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
	public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int i = index;
        @SuppressWarnings("rawtypes")
		Node tNode;
        if (index < size / 2) {
            tNode = head;
            while (i > 0) {
                tNode = tNode.next;
                i -= 1;
            }
        } else {
            tNode = tail;
            while (++i < size) {
                tNode = tNode.prev;
            }
        }
        return (T) tNode.Data;
    }

    /**
     * indexof returns the index of a node that contains the value asked for
     *
     * @param value
     * @return
     */
    public int indexOf(T value) {
        int Index = 0;
        @SuppressWarnings("rawtypes")
		Node tHead = head;
        while (tHead != null) {
            if (tHead.Data.equals(value)) {
                return Index;
            }
            Index += 1;
            tHead = tHead.next;
        }
        return -1;
    }

    /**
     * remove node removes a node based off of a given node
     *
     * @param targetedNode
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private void RemoveNode(Node targetedNode) {
        size -= 1;
        if (isEmpty()) {
            head = tail = null;
        } else {
            if (targetedNode.equals(head)) {
                head = targetedNode.next;
                targetedNode.next = null;
                targetedNode.prev = null;
            } else if (targetedNode.equals(tail)) {
                tail = targetedNode.prev;
                targetedNode.next = null;
                targetedNode.prev = null;
            } else {
                targetedNode.next.prev = targetedNode.prev;
                targetedNode.prev.next = targetedNode.next;
            }
        }

    }

    private class DoublyListIterator implements ListIterator<T> {

        @SuppressWarnings("rawtypes")
		private Node NextNode, previous, holder;
        int position;

        DoublyListIterator() {
            NextNode = head;
            previous = head.prev;
            position = 0;
        }

        /**
         * add adds a node to our list
         * @param e
         */
        @SuppressWarnings("unchecked")
		@Override
        public void add(T e) {
            size += 1;
            position += 1;
            @SuppressWarnings("rawtypes")
			Node tNode = new Node(e, previous, NextNode);
            if (previous != null) {
                previous.next = tNode;
            } else {
                addFirst(e);
            }

            if (NextNode != null) {
                NextNode.prev = tNode;
            } else {
                addLast(e);
            }

        }

        /**
         * has next find weather we have a future node or not and returns a 
         * boolean statement
         * @return
         */
        @Override
        public boolean hasNext() {
            return NextNode.next != null;
        }

        /**
         * has previous find weather we have a previous node or not and returns 
         * a boolean statement
         * @return
         */
        @Override
        public boolean hasPrevious() {
            return NextNode.prev != null;
        }

        /**
         * next returns our next node
         * @return
         */
        @SuppressWarnings("unchecked")
		@Override
        public T next() {
            if (NextNode == null) {
                throw new NoSuchElementException();
            }
            holder = previous = NextNode;
            NextNode = holder.next;
            return (T) holder.Data;

        }

        /**
         * previous returns our past node
         * @return
         */
        @SuppressWarnings("unchecked")
		@Override
        public T previous() {
            if (previous == null) {
                throw new NoSuchElementException();
            }
            holder = NextNode = previous;
            previous = holder.prev;
            return (T) holder.Data;
        }

        /**
         * remove deletes a node
         */
        @Override
        public void remove() {
            if (holder != null) {
                if (holder == previous) {
                    position -= 1;
                }
                NextNode = holder.next;
                previous = holder.prev;
                RemoveNode(holder);
            }
        }

        /**
         * set allocates the data to a node data parameter
         * @param e
         */
        @SuppressWarnings("unchecked")
		@Override
        public void set(T e) {
            if (holder == null) {
                throw new NoSuchElementException();
            }
            holder.Data = e;

        }
    }
}
