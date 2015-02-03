package com.bcsg.strategy;

/**
 * The AmericanExpressBankStrategy is the bank strategy for the bank "American Express"
 *
 */
public class AmericanExpressBankStrategy implements BankStrategy {

	public static String BANK_NAME = "American Express";
	public static int CARD_NUMBER_SIZE = 15;
	
	/**
	 * Mask the card number like "xxxx-xxxx-xxxx-000"
	 * 
	 * @return  the card number masked
	 */
	public String mask(String cardNumber) {
		return "xxxx-xxxx-xxxx-" + cardNumber.substring(15, 18);
	}

}
