package tpo.lab1.algorithm;

// Class Node
class Node {
   
    // elements, and sValue are the variables in class Node
    int element, sValue;
   
    // class has two parameters
    Node left, right;
 
    public Node(int element) { this(element, null, null); }
 
    // Function Node where we are using this keyword
    // Which will help us to avoid confusion if we are having
    // same elements
 
    public Node(int element, Node left, Node right)
    {
        this.element = element;
        this.left = left;
        this.right = right;
        this.sValue = 0;
    }
}