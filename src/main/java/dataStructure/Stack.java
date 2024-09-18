package dataStructure;

class Stack {
    private Node top;

    // Linked list node
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Push an item onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top; // Make new node point to the top
        top = newNode; // Move the top to point to the new node
        System.out.println(data + " pushed to stack");
    }

    // Pop an item from the stack
    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = top.data;
        top = top.next; // Move top to the next node
        return popped;
    }

    // Peek the top item from the stack
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop() + " popped from stack");
        System.out.println("Top element is: " + stack.peek());
        System.out.println("Top element is: " + stack.pop());
        System.out.println("Top element is: " + stack.pop());
        System.out.println("Top element is: " + stack.pop());


        if(3 > 7*8) System.out.println();
    }
}
