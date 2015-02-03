package com.bcsg.entity;

import java.util.Date;

import com.bcsg.strategy.BankStrategy;

/**
 * The entity represent a Card (bank, number and expiry date)
 *
 */
public class Card implements Comparable<Card> {
	
	private BankStrategy bank;
	private String number;
	private Date expiryDate;
	
	public Card() {
	}
	
	public BankStrategy getBank() {
		return bank;
	}
	public void setBank(BankStrategy bank) {
		this.bank = bank;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * Get the mask for the card number with the bank strategy
	 * 
	 * @return the mask for the card number
	 */
	public String getMask() {
		return this.getBank().mask(this.number);
	}
	
	/**
	 * Compare with another card according to the expiry date
	 * 
	 * @param otherCard : the other Card
	 * 
	 * @return the value 0 if the argument Date is equal to this Date; a value less than 0 if this Date is before the Date argument; and a value greater than 0 if this Date is after the Date argument.
	 */
	public int compareTo(Card otherCard) {
		return getExpiryDate().compareTo(otherCard.getExpiryDate());
	}
}
