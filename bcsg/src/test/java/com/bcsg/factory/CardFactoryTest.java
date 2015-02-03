package com.bcsg.factory;


import java.util.Calendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bcsg.entity.Card;
import com.bcsg.strategy.AmericanExpressBankStrategy;
import com.bcsg.strategy.HsbcBankStrategy;
import com.bcsg.strategy.RoyalBankCanadaBankStrategy;

/**
 * Test of CardFactory
 *
 */
public class CardFactoryTest {
	
	private CardFactory factory;
	
	@Before
	public void setUp() {
		factory = new CardFactory();
	}

	@After
	public void tearDown() {        
	}	

	@Test
	public void testCreateCard() {
		Calendar calendar = Calendar.getInstance();
		
		// Test of a card for the bank HSBC Canada known and a card number correct
		Card card = factory.createCard("HSBC Canada;5601-2345-3446-5678;11-2017");
		Assert.assertNotNull(card);
		Assert.assertEquals(card.getBank().getClass(), HsbcBankStrategy.class);
		Assert.assertEquals(card.getNumber(), "5601-2345-3446-5678");
		calendar.setTime(card.getExpiryDate());
		Assert.assertEquals(calendar.get(Calendar.MONTH), 11-1);
		Assert.assertEquals(calendar.get(Calendar.YEAR), 2017);

		// Test of a card for the bank HSBC France unknown and a card number correct
		card = factory.createCard("HSBC France;5601-2345-3446-5678;11-2017");
		Assert.assertNull(card);

		// Test of a card for the bank HSBC Canada known and a card number wrong
		card = factory.createCard("HSBC Canada;56-2345-3446-5678;11-2017");
		Assert.assertNull(card);
		

		// Test of a card for the bank Royal Bank of Canada known and a card number correct
		card = factory.createCard("Royal Bank of Canada;4519-4532-4524-2456;10-2017");
		Assert.assertNotNull(card);
		Assert.assertEquals(card.getBank().getClass(), RoyalBankCanadaBankStrategy.class);
		Assert.assertEquals(card.getNumber(), "4519-4532-4524-2456");
		calendar.setTime(card.getExpiryDate());
		Assert.assertEquals(calendar.get(Calendar.MONTH), 10-1);
		Assert.assertEquals(calendar.get(Calendar.YEAR), 2017);

		// Test of a card for the bank Royal Bank of France unknown and a card number correct
		card = factory.createCard("Royal Bank of France;4519-4532-4524-2456;10-2017");
		Assert.assertNull(card);

		// Test of a card for the bank Royal Bank of Canada known and a card number wrong
		card = factory.createCard("Royal Bank of Canada;4519-4532-44-2456;10-2017");
		Assert.assertNull(card);
		

		// Test of a card for the bank American Express known and a card number correct
		card = factory.createCard("American Express;3786-7334-8965-345;12-2018");
		Assert.assertNotNull(card);
		Assert.assertEquals(card.getBank().getClass(), 	AmericanExpressBankStrategy.class);
		Assert.assertEquals(card.getNumber(), "3786-7334-8965-345");
		calendar.setTime(card.getExpiryDate());
		Assert.assertEquals(calendar.get(Calendar.MONTH), 12-1);
		Assert.assertEquals(calendar.get(Calendar.YEAR), 2018);

		// Test of a card for the bank France Express unknown and a card number correct
		card = factory.createCard("France Express;3786-7334-8965-345;12-2018");
		Assert.assertNull(card);

		// Test of a card for the bank American Express known and a card number wrong
		card = factory.createCard("American Express;3786-7334-8965-5;12-2018");
		Assert.assertNull(card);
	}
}
