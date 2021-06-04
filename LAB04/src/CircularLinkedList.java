public class CircularLinkedList<T> {
    private static CircularLinkedList<Integer> myList = new CircularLinkedList<>();

    private Node<T> head = null;
    private Node<T> tail = null;
    private Node<T> current = null;
    private int size = 0;

    CircularLinkedList(){}

    public boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
    }

    public void insert(T data) {
        if (head == null) { // if there hasn't been anything added to the linked list
            Node<T> newNode = new Node<T>(data);
            head = newNode; // the new node becomes the head because it is the first node to be added in to the list
            current = newNode; // set the current node for further processing (if necessary)
            tail = newNode; // the new node also becomes the tail because it is the only node in the list
            current.setNext(head); // set the current node to hold the reference of the head to make it circular
        } else { // if it already contains nodes inside of it
            current.setNext(new Node<T>(data)); // set the current to hold the reference of that new node
            current.getNext().setNext(head); // set that new node to hold the reference of the head
            current = current.getNext();
            tail = current; // the new node (current) becomes the tail
        }
        size++;
    }

    public Node<T> search(T data) {
        Node<T> trace = head;

        if (head == null)
            return null;
        do {
            if (trace.getData() == data)
                return trace;
            trace = trace.getNext();
        } while (trace != head);
        return null;
    }

    public void step() {
        current = current.getNext();
    }

    public void delete(T data) {
        Node<T> trace = head;
        Node<T> prev = tail;

        if (head == null)
            return;
        if (head.getNext() == head && head.getData() == data) {
            head = null;
            return;
        }
        if (head.getNext() != head) {
            if (head.getData() == data) {
                trace = head.getNext();
                prev.setNext(head.getNext());
                size--;
            }
            do {
                if (trace.getData() == data) {
                    prev.setNext(trace.getNext());
                    trace = trace.getNext();
                    size--;
                }
                prev = prev.getNext();
                trace = trace.getNext();
            } while (trace != head);
        }
    }

    public void display() {
        System.out.println("Circular Linked List: " + this.toString());
    }

    public Node<T> getCurrent() {
        return current;
    }

    public void setCurrent(Node<T> current) {
        this.current = current;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String string = new String();
        Node<T> trace = head;

        if (trace == null)
            return "null";
        do {
            string += trace.toString() + " ";
            trace = trace.getNext();
        } while (trace != head);
        return string;
    }


    class Node<T> {
        private T data = null;
        private Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }

        // get the reference of the next node from the current one
        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        @Override
        public Node<T> clone() {
            Node<T> cloner = new Node<T>(this.data);
            cloner.setNext(getNext());
            return cloner;
        }

        @Override
        public String toString() {
            if (this.data == null)
                return "null";
            return this.data.toString();
        }


    }


    public static void main(String[] args) {
        myList.insert(0);
        myList.insert(10);
        myList.insert(20);
        myList.insert(30);
        myList.display();

        if (myList.search(2) != null)
            System.out.println("Found: " + myList.search(2));
        else
            System.out.println("Not found");

        myList.delete(10);
        myList.display();



    }

}
