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


/*
public class AVLTreeTests {

    @Test
    public void testInsertToEmptyTree() {
        AvlTree t1 = new AvlTree();
        t1.insert(1);
        Assert.assertEquals(1, t1.mRoot.mValue);
    }

    @Test
    public void testEqualsItself() {
        AvlTree t1 = new AvlTree();
        Assert.assertEquals(t1, t1);
    }

    @Test
    public void testNotEqualNotAvlInstance() {
        AvlTree t1 = new AvlTree();
        Object object = new Object();
        Assert.assertNotEquals(t1, object);
    }

    @Test
    public void testEmptyEqual() {
        AvlTree t1 = new AvlTree();
        AvlTree t2 = new AvlTree();
        Assert.assertEquals(t1, t2);
    }

    @Test
    public void testFirstEmpty() {
        AvlTree t1 = new AvlTree();
        AvlTree t2 = new AvlTree(1);
        Assert.assertNotEquals(t1, t2);
    }

    @Test
    public void testSecondEmpty() {
        AvlTree t1 = new AvlTree(1);
        AvlTree t2 = new AvlTree();
        Assert.assertNotEquals(t1, t2);
    }

    @Test
    public void testRootsEqual() {
        AvlTree t1 = new AvlTree(1);
        AvlTree t2 = new AvlTree(1);
        Assert.assertEquals(t1, t2);
    }

    @Test
    public void testRootAndLeftEqual() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(2);
        AvlTree t2 = new AvlTree(10);
        t2.insert(2);
        Assert.assertEquals(t1, t2);
    }

    @Test
    public void testRootAndRightEqual() {
        AvlTree t1 = new AvlTree(1);
        t1.insert(2);
        AvlTree t2 = new AvlTree(1);
        t2.insert(2);
        Assert.assertEquals(t1, t2);
    }

    @Test
    public void testRootsEqual_LeftsNotEqual() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(2);
        AvlTree t2 = new AvlTree(10);
        t2.insert(1);
        Assert.assertNotEquals(t1, t2);
    }

    @Test
    public void testRootsEqual_RightsNotEqual() {
        AvlTree t1 = new AvlTree(1);
        t1.insert(2);
        AvlTree t2 = new AvlTree(1);
        t2.insert(4);
        Assert.assertNotEquals(t1, t2);
    }

    @Test
    public void testEmptyTreeHashCode() {
        AvlTree t1 = new AvlTree();
        Assert.assertEquals(0, t1.hashCode());
    }

    @Test
    public void testEqualTreesEqualHashCodes() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(2, 12);
        AvlTree t2 = new AvlTree(10);
        t2.insert(2, 12);
        Assert.assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void testToStringEmpty() {
        AvlTree t1 = new AvlTree();
        Assert.assertEquals("[]", t1.toString());
    }

    @Test
    public void testToStringSingleNode() {
        AvlTree t1 = new AvlTree(1);
        Assert.assertEquals("[1]", t1.toString());
    }

    @Test
    public void testToStringManyNodes() {
        AvlTree t1 = new AvlTree(1);
        t1.insert(12, 56, 7, 2, 1);
        Assert.assertEquals("[1, 1, 2, 7, 12, 56]", t1.toString());
    }

    @Test
    public void testSingleRotateLeft() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(14, 56);
        Assert.assertEquals(t1.mRoot.mValue, 14);
        Assert.assertEquals(t1.mRoot.mLeft.mValue, 10);
        Assert.assertEquals(t1.mRoot.mRight.mValue, 56);
    }

    @Test
    public void testSingleRotateRight() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(2, 1);
        Assert.assertEquals(t1.mRoot.mValue, 2);
        Assert.assertEquals(t1.mRoot.mLeft.mValue, 1);
        Assert.assertEquals(t1.mRoot.mRight.mValue, 10);
    }

    @Test
    public void testDoubleRotateLeftRight() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(4, 9);
        Assert.assertEquals(t1.mRoot.mValue, 9);
        Assert.assertEquals(t1.mRoot.mLeft.mValue, 4);
        Assert.assertEquals(t1.mRoot.mRight.mValue, 10);
    }

    @Test
    public void testDoubleRotateRightLeft() {
        AvlTree t1 = new AvlTree(10);
        t1.insert(14, 12);
        Assert.assertEquals(t1.mRoot.mValue, 12);
        Assert.assertEquals(t1.mRoot.mLeft.mValue, 10);
        Assert.assertEquals(t1.mRoot.mRight.mValue, 14);
    }
}*/


