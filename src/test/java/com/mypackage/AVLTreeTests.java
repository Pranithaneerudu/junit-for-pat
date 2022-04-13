package com.mypackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.mypackage.AVLTree.Node;

class AVLTreeTests {

	@Test
    void testCaseEqualsItself() {
		AVLTree tree = null;
		tree = new AVLTree();
        assertEquals(tree, tree);
    }
	
	@Test
	void testCaseDefaultConstructor() {
		AVLTree tree = null;
		tree = new AVLTree();
		assertNotNull(tree);
	}
	
	@Test
	void testCaseIntegerConstructor() {
		AVLTree tree = null;
		tree = new AVLTree();
		AVLTree.Node node = tree.new Node(5);
		assertEquals(5, node.key);
	}
	
	@Test
	void testCaseGetFunction() {
		AVLTree tree = null;
		tree = new AVLTree();
		tree.insert(10);
		Object obj = tree.getRoot();
		assertNotNull(obj);
	}
	
	@Test
    void testCaseInsertFunction() {
		AVLTree tree = null;
		tree = new AVLTree();
		tree.insert(10);
		Node node = tree.getRoot();
		assertEquals(10, node.key);
    }
	
	@Test
    void testCaseLeftFindFunction() {
		AVLTree tree = null;
		tree = new AVLTree();
		tree.insert(10);
		tree.insert(12);
		tree.insert(9);
		Node node = tree.getRoot();
		assertEquals(9, node.left.key);
    }
	
	@Test
    void testCaseRightFindFunction() {
		AVLTree tree = null;
		tree = new AVLTree();
		tree.insert(10);
		tree.insert(12);
		tree.insert(9);
		Node node = null;
		node = tree.getRoot();
		assertEquals(12, node.right.key);
    }
	
	@Test//DONE
    void testCaseDeleteFunction() {
		AVLTree tree = null;
		tree = new AVLTree();
		tree.delete(15);
		tree.insert(11);
		tree.insert(10);
		tree.insert(12);
		tree.insert(5);
		tree.delete(12);
		tree.delete(15);
		tree.delete(5);
		tree.delete(11);
		tree.delete(10);
		
		tree.insert(10);
		tree.insert(8);
		tree.insert(12);
		tree.insert(11);
		tree.delete(10);
		tree.delete(11);
		assertNull(tree.find(11));
		assertNull(tree.find(5));
		assertNull(tree.find(10));
		assertNull(tree.find(10));
    }
	
	@Test
    void testCaseGetBalanceFunction() {
		AVLTree tree = null;
		tree = new AVLTree();
		tree.insert(10);
		tree.insert(12);
		tree.insert(9);
		tree.insert(15);
		assertEquals(1, tree.getBalance(tree.find(12)));
    }
	
	@Test
    void testCaseMultipleInsertionFunction() {
		AVLTree tree = null;
		tree = new AVLTree();
		tree.insert(10);
		tree.insert(12);
		tree.insert(9);
		Node node = null;
		node = tree.getRoot();
		assertEquals(10, tree.find(10).key);
    }
	
	@Test
    void testCaseFindFunction() {
		AVLTree tree = null;
		tree = new AVLTree();
		tree.insert(10);
		Node node = null;
		node = tree.find(10);
		assertEquals(10, node.key);
    }
	
	@Test//DONE
    void testCaseRebalanceFunction() {
		AVLTree tree = null;
		tree = new AVLTree();
		tree.insert(10);
		tree.insert(8);
		tree.insert(12);
		tree.insert(13);
		tree.insert(11);
		tree.insert(9);
		tree.insert(7);
		
		tree.delete(10);
		tree.delete(8);
		tree.delete(12);
		tree.delete(13);
		tree.delete(11);
		tree.delete(7);
		assertNull(tree.find(10));
    }
	
	@Test//DONE
    void testCaseRebalancFunction() {
		AVLTree tree = null;
		tree = new AVLTree();
		tree.insert(20);
		tree.insert(15);
		tree.insert(11);
		tree.insert(4);
		tree.insert(12);
		tree.insert(14);
		tree.insert(1);
		assertNull(tree.find(10));
    }
	
	@Test//DONE
    void testCaseLeftRotateFunction() {
		AVLTree tree = null;
		tree = new AVLTree();
		tree.insert(12);
		tree.insert(10);
		tree.insert(15);
		tree.insert(17);
		tree.delete(10);
		assertNull(tree.find(10));
    }
	
	@Test//DONE
    void testCaseRightRotateFunction() {
		AVLTree tree = null;
		tree = new AVLTree();
		tree.insert(10);
		tree.insert(20);
		tree.insert(30);
		tree.insert(40);
		tree.insert(50);
		tree.insert(25);
		tree.delete(15);
		assertNull(tree.find(15));
    }
	
	
}


