package com.bcsg.strategy;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test of RoyalBankCanadaBankStrategy
 *
 */
public class RoyalBankCanadaBankStrategyTest {

	private RoyalBankCanadaBankStrategy bankStrategy;
	
	@Before
	public void setUp() {
		bankStrategy = new RoyalBankCanadaBankStrategy();
	}

	@After
	public void tearDown() {        
	}	

	@Test
	public void testMask() {
		// Test if the mask of a code number is correct
		Assert.assertEquals("3454-xxxx-xxxx-xxxx", bankStrategy.mask("3454-3456-4332-9808"));
	}
}
