import java.util.Stack;

class Node {
    public Integer data1; // data item (key)
    public Double data2; // data item
    public Node leftChild; // this node's left child
    public Node rightChild; // this node's right child

    public void displayNode() // display ourself
    {
        System.out.print('{');
        System.out.print(data1);
        System.out.print(", ");
        System.out.print(data2);
        System.out.print("} ");
    }
}

public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public Node find(int key) {
        Node current = root;
        while (current.data1 != key) {
            if (key < current.data1) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.data1 = id;
        newNode.data2 = dd;
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.data1) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.data1 != key) {
            parent = current;
            if (key < current.data1) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }

        }
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }

        } else {
            Node successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }


    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while ((current != null)) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
            ;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void traverse(int traversalType) {
        switch ((traversalType)) {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    // -------------------------------------------------------------
    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data1 + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    // -------------------------------------------------------------
    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.data1 + " ");
            inOrder(localRoot.rightChild);
        }
    }

    // -------------------------------------------------------------
    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.data1 + " ");
        }
    }

    // -------------------------------------------------------------
    public void displayTree() {
        Stack<Node> globalStack = new Stack<Node>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (isRowEmpty == false) {
            Stack<Node> localStack = new Stack<Node>();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data1);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            } // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        } // end while isRowEmpty is false
        System.out.println("......................................................");
    } // end displayTree()

    public int count() {
        int count = 0;
        if (root == null) {
            return 0;
        }
        Stack<Node> stack = new Stack<Node>();
        Node node = root;

        while (node != null) {
            stack.push(node);
            node = node.leftChild;
        }

        while (stack.size() > 0) {
            node = stack.pop();
            count++;
            if (node.rightChild != null) {
                node = node.rightChild;
                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.leftChild;
                }
            }
        }
        return count;
    }

    private int heightCounter(Node localRoot, int height) {
        if (localRoot != null) {
            int heightL = heightCounter(localRoot.leftChild, height + 1);
            int heightR = heightCounter(localRoot.rightChild, height + 1);
            if (heightL > heightR) {
                return heightL + 1;
            } else {
                return heightR + 1;
            }
        }
        return 0;
    }

    public int getHeight() {
        return heightCounter(root, 0);
    }

    private int leavesCounter(Node localRoot, int leaves) {
        if (localRoot != null) {
            int leavesL = 0;
            int leavesR = 0;
            if (localRoot.leftChild == null && localRoot.rightChild == null)
                return leaves + 1;
            if (localRoot.leftChild != null)
                leavesL = leavesCounter(localRoot.leftChild, leaves);
            if (localRoot.rightChild != null)
                leavesR = leavesCounter(localRoot.rightChild, leaves);

            return leavesL + leavesR;
        }
        return 0;
    }

    public int getLeaves() {
        return leavesCounter(root, 0);
    }

    public boolean isFullyBalanced() {
        int height = this.getHeight();
        int count = this.count();
        if (Math.pow(2, height) - 1 == count)
            return true;
        return false;
    }

    public boolean equals(Node root1, Node root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.data1.equals(root2.data1) && equals(root1.leftChild, root2.leftChild)
                && equals(root1.rightChild, root2.rightChild);
    }

    public boolean checkIdentical(Tree compareTree) {
        return this.equals(this.root, compareTree.root);
    }
}
