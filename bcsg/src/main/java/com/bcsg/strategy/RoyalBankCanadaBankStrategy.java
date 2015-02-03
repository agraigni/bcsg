package com.bcsg.strategy;

/**
 * The RoyalBankCanadaBankStrategy is the bank strategy for the Bank "Royal Bank of Canada"
 *
 */
public class RoyalBankCanadaBankStrategy implements BankStrategy {
	
	public static String BANK_NAME = "Royal Bank of Canada";
	public static int CARD_NUMBER_SIZE = 16;
	
	/**
	 * Mask the card number like "0000-xxxx-xxxx-xxxx"
	 * 
	 * @return  the card number masked
	 */
	public String mask(String cardNumber) {
		return cardNumber.substring(0, 4) + "-xxxx-xxxx-xxxx";
	}

}
