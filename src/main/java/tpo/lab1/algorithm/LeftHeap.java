package tpo.lab1.algorithm;

class LeftHeap {
   
    // Now parameter is created named head.
    private Node head;
 
    // Its constructor is created named left heap
    // Returns null
    public LeftHeap() { head = null; }
 
    // Now we will write function to check if the list is
    // empty
    public boolean isEmpty()
    {
        // If head is null returns true
        return head == null;
    }
   
    // Now we will write a function clear
    public void clear()
    {
        // We will put head is null
        head = null;
    }
 
    // Now let us create a function merge which will
    // help us merge
    public void merge(LeftHeap rhs)
    {
        // If the present function is rhs
        // then we return it
        if (this == rhs)
            return;
       
        // Here we call the function merge
        // And make rhs is equal to null
        head = merge(head, rhs.head);
        rhs.head = null;
    }
 
    // Function merge with two Nodes a and b
    public Node merge(Node a, Node b)
    {
        // If A is null
        // We return b
        if (a == null)
            return b;
       
        // If b is null
        // we return A
        if (b == null)
            return a;
 
        // If we put a element greater than b element
        if (a.element > b.element) {
           
            // We write the swap code
            Node temp = a;
            a = b;
            b = temp;
        }
 
        // Now we call the function merge to merge a and b
        a.right = merge(a.right, b);
       
        // If a is null we swap right with left and empty
        // right
        if (a.left == null) {
            a.left = a.right;
            a.right = null;
        }
       
        // else
        // if value in a is less than the svalue of right
        // If the condition is satisfied , we swap the left
        // with right
        else {
           
            if (a.left.sValue < a.right.sValue) {
                Node temp = a.left;
                a.left = a.right;
                a.right = temp;
            }
           
            // we store the value in a s Value of right
            // SValue
            a.sValue = a.right.sValue + 1;
        }
       
        // We now return the value of a
        return a;
    }
 
    // Function insert
    public void insert(int a)
    {
        // This root will help us insert a new variable
        head = merge(new Node(a), head);
    }
   
    // The below function will help us delete minimum
    // function present in the Heap
    public int del()
    {
        // If is empty return -1
        if (isEmpty())
            return -1;
 
        // Now we will store the element in variable and
        // Call the merge function to del that is converging
        // to head then  we return min
        int min = head.element;
       
        head = merge(head.left, head.right);
        return min;
    }
 
    // Function order
    // will print the starting and ending points in order.
    public void order()
    {
        order(head);
        System.out.println();
    }
 
    // Function order with Node r
    // If r not equal to r
    // It prints all the elements iterating from order left
    // to right
    private void order(Node r)
    {
        if (r != null) {
            order(r.left);
            System.out.print(r.element + " ");
            order(r.right);
        }
    }
}