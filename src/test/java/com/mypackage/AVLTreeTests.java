package com.mypackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.mypackage.AVLTree.Node;

class AVLTreeTests {

	@Test
    void testingEqualsItself() {
		AVLTree tree = new AVLTree();
        assertEquals(tree, tree);
    }
	
	@Test
	void testingDefaultConstructor() {
		AVLTree tree = new AVLTree();
		assertNotNull(tree);
	}
	
	@Test
	void testingIntegerConstructor() {
		AVLTree tree = new AVLTree();
		AVLTree.Node node = tree.new Node(5);
		assertEquals(5, node.key);
	}
	
	@Test
	void testingGetFunction() {
		AVLTree tree = new AVLTree();
		tree.insert(10);
		assertNotNull(tree.getRoot());
	}
	
	@Test
    void testingInsertFunction() {
		AVLTree tree = new AVLTree();
		tree.insert(10);
		Node node = tree.getRoot();
		assertEquals(10, node.key);
    }
	
	@Test
    void testingMultipleInsertionFunction() {
		AVLTree tree = new AVLTree();
		tree.insert(10);
		tree.insert(12);
		tree.insert(9);
		Node node = tree.getRoot();
		assertEquals(10, tree.find(10).key);
    }
	
	@Test
    void testingFindFunction() {
		AVLTree tree = new AVLTree();
		tree.insert(10);
		Node node = tree.find(10);
		assertEquals(10, node.key);
    }
	
	@Test
    void testingLeftFindFunction() {
		AVLTree tree = new AVLTree();
		tree.insert(10);
		tree.insert(12);
		tree.insert(9);
		Node node = tree.getRoot();
		assertEquals(9, node.left.key);
    }
	
	@Test
    void testingRightFindFunction() {
		AVLTree tree = new AVLTree();
		tree.insert(10);
		tree.insert(12);
		tree.insert(9);
		Node node = tree.getRoot();
		assertEquals(12, node.right.key);
    }
	
	@Test
    void testingDeleteFunction() {
		AVLTree tree = new AVLTree();
		tree.insert(10);
		tree.insert(12);
		tree.delete(10);
		assertNull(tree.find(10));
    }
	
	@Test
    void testingGetBalanceFunction() {
		AVLTree tree = new AVLTree();
		tree.insert(10);
		tree.insert(12);
		tree.insert(9);
		tree.insert(15);
		assertEquals(1, tree.getBalance(tree.find(12)));
    }
	
	
}


