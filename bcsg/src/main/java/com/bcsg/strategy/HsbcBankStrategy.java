package com.bcsg.strategy;

/**
 * The HsbcBankStrategy is the bank strategy for the bank "HSBC Canada"
 *
 */
public class HsbcBankStrategy implements BankStrategy {

	public static String BANK_NAME = "HSBC Canada";
	public static int CARD_NUMBER_SIZE = 16;
	
	/**
	 * Mask the card number like "00xx-xxxx-xxxx-xxxx"
	 * 
	 * @return  the card number masked
	 */
	public String mask(String cardNumber) {
		return cardNumber.substring(0, 2) + "xx-xxxx-xxxx-xxxx";
	}

}
