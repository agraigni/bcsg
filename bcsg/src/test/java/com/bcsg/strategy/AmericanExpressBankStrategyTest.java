package com.bcsg.strategy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test of AmericanExpressBankStrategy
 *
 */
public class AmericanExpressBankStrategyTest {

	private AmericanExpressBankStrategy bankStrategy;

	@Before
	public void setUp() {
		bankStrategy = new AmericanExpressBankStrategy();   
	}

	@After
	public void tearDown() {     
	}	

	@Test
	public void testMask() {
		// Test if the mask of a code number is correct
		Assert.assertEquals("xxxx-xxxx-xxxx-808", bankStrategy.mask("3454-3456-4332-808"));
	}

}
