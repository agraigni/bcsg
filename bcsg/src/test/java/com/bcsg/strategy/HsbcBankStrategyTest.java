package com.bcsg.strategy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test of HsbcBankStrategy
 *
 */
public class HsbcBankStrategyTest {

	private HsbcBankStrategy bankStrategy;

	@Before
	public void setUp() {
		bankStrategy = new HsbcBankStrategy();  
	}

	@After
	public void tearDown() {      
	}	

	@Test
	public void testMask() {
		// Test if the mask of a code number is correct
		Assert.assertEquals("34xx-xxxx-xxxx-xxxx", bankStrategy.mask("3454-3456-4332-9808"));
	}

}
