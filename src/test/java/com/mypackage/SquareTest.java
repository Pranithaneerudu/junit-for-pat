package com.mypackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareTest {

	//@Test
	void test() {
		Square s = new Square();
		int x = s.squareFunction(5);
		assertEquals(25, x);
	}

}
