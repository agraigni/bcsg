package com.bcsg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bcsg.entity.Card;
import com.bcsg.factory.CardFactory;

/**
 * The BCSG Application launcher
 *
 */
public class BcsgApp {
	
	private static CardFactory cardFactory;

	/**
	 * Launcher of the VML Application
	 * @param args : the parameter are the cards
	 */
	public static void main(String[] args) {
		try {
			init();
			storeCards(args);
		}
		catch(Exception e) {
			System.exit(1);
		}
		System.exit(0);
	}

	/**
	 * Initialize the context and variables
	 */
	private static void init() {
		cardFactory = new CardFactory();
	}

	/**
	 * Store the cards, sort it by descending order and print the masks
	 * 
	 * @param cards : tab of cards to stored
	 */
	private static void storeCards(String[] cards) {
		List<Card> cardsList = new ArrayList<Card>();

		// Create cards if the bank exist
		int i = 0;
		while(cards.length>i) {
			Card card = cardFactory.createCard(cards[i]);
			if(card != null) {
				cardsList.add(card);
			} else {
				System.out.println("Bank is not found for : " + cards[i]);
			}
			i++;
		}

		// Sort the data by Expiry date in descending order
		Collections.sort(cardsList, Collections.reverseOrder());

		// Each card number must be masked to below
		System.out.println("List of cards sorted : ");
		for(Card card : cardsList) {
			System.out.println(card.getMask());
		}
	}

}
