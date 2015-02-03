package com.bcsg.factory;

import java.util.Calendar;

import com.bcsg.entity.Card;
import com.bcsg.strategy.AmericanExpressBankStrategy;
import com.bcsg.strategy.BankStrategy;
import com.bcsg.strategy.HsbcBankStrategy;
import com.bcsg.strategy.RoyalBankCanadaBankStrategy;

/**
 * Factory to create a card with it's bank strategy
 *
 */
public class CardFactory {
	
	/**
	 * Create a new card if the Bank is known
	 * 
	 * @param cardLine : The line representing a card
	 * 
	 * @return the card created, null is the bank is unknown
	 */
	public Card createCard(String cardLine) {
		String[] cardNumberSplit = cardLine.split(";");

		// Get the bank strategy for the name of the bank
		BankStrategy bankStrategy = this.getBankStrategy(cardNumberSplit[0], cardNumberSplit[1]);

		// If the bank is known create the card
		if(bankStrategy != null) {
			Card card = new Card();
			card.setBank(bankStrategy);;
			card.setNumber(cardNumberSplit[1]);

			Calendar calendar = Calendar.getInstance();
			String[] dateSplit = cardNumberSplit[2].split("-");
			calendar.set(Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[0])-1, 1);
			card.setExpiryDate(calendar.getTime());
			
			return card;
		}

		// If the bank is unknown return null 
		return null;
	}
	
	/**
	 * Get the bank strategy for the bank if it's exist
	 * 
	 * @param bankName : name of the bank
	 * 
	 * @return the bank strategy of the bank
	 */
	private BankStrategy getBankStrategy(String bankName, String cardNumber) {
		if(bankName.equals(AmericanExpressBankStrategy.BANK_NAME) && cardNumber.replaceAll("-", "").length()==AmericanExpressBankStrategy.CARD_NUMBER_SIZE) {
			return new AmericanExpressBankStrategy();
		} else if(bankName.equals(HsbcBankStrategy.BANK_NAME) && cardNumber.replaceAll("-", "").length()==HsbcBankStrategy.CARD_NUMBER_SIZE) {
			return new HsbcBankStrategy();
		} else if(bankName.equals(RoyalBankCanadaBankStrategy.BANK_NAME) && cardNumber.replaceAll("-", "").length()==RoyalBankCanadaBankStrategy.CARD_NUMBER_SIZE) {
			return new RoyalBankCanadaBankStrategy();
		}

		return null;
	}
}
