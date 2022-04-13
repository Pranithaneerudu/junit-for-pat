package com.mypackage;

public class AVLTree {

	//Done
    public class Node {
        int key;
        int height;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    //Done//got accuracy
    private Node root;

    //Done//got accuracy
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
               break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    //DONE//got accuracy
    public void insert(int key) {
        root = insert(root, key);
    }

    //DONE//got accuracy
    public void delete(int key) {
        root = delete(root, key);
    }

    //DONE//got accuracy
    public Node getRoot() {
        return root;
    }

  //got accuracy
    public int height() {
        return root == null ? -1 : root.height;
    }

    //Done//got accuracy
    private Node insert(Node node, int key) {
    	
        if (node == null) {
            return new Node(key);
        } else if (node.key > key) {
            node.left = insert(node.left, key);
        } else if (node.key < key) {
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node);
    }

    //Done(passing accuracy)
    private Node delete(Node node, int key) {
        if (node == null) {
        	return node;
        } else if (node.key > key) {
        	node.left = delete(node.left, key);
        } else if (node.key < key) {
        	node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
            	node = (node.left == null) ? node.right : node.left;
            } else {
            	Node mostLeftChild = mostLeftChild(node.right);
            	node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

  //Done(passing accuracy)
    private Node mostLeftChild(Node node) {
        Node current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
  //got accuracy
    private Node rebalance(Node z) {
    	updateHeight(z);
    	int balance = getBalance(z);
    	if (balance > 1) {
        	if (height(z.right.right) > height(z.right.left)) {
            	z = rotateLeft(z);
            } else {
            	z.right = rotateRight(z.right);
            	z = rotateLeft(z);
            }
        } else if (balance < -1) {
        	System.out.println("hello16");
            if (height(z.left.left) > height(z.left.right)) {
            	z = rotateRight(z);
            } else {
            	z.left = rotateLeft(z.left);
            	z = rotateRight(z);
            }
        }
        return z;
    }

    //got accuracy
    private Node rotateRight(Node y) {
    	Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
    	updateHeight(y);
    	updateHeight(x);
    	return x;
    }

  //got accuracy
    private Node rotateLeft(Node y) {
    	Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
    	updateHeight(x);
    	return x;
    }

  //got accuracy
    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

  //got accuracy
    private int height(Node n) {
    	return n == null ? -1 : n.height;
    }

  //got accuracy
    public int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }
}