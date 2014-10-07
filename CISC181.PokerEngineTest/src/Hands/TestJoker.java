package Hands;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import poker.Hand;
import poker.eHandStrength;
import poker.eRank;
import poker.eSuit;
import poker.Card;

public class TestJoker {

	@Test
	public void testRoyalFlush() {
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be rf:", eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());
		assertEquals("Should be natural:", 1, h.getNatural());
	}
	
	@Test
	public void testJokerRoyalFlush() {
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be rf:", eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());
		assertEquals("Should be natural:", 0, h.getNatural());
	}
	
	@Test
	public void testJokerFourOfAKind() {
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be rf:", eHandStrength.FourOfAKind.getHandStrength(), h.getHandStrength());
		assertEquals("Should be natural:", 0, h.getNatural());
	}
	
	@Test
	public void testJokerThreeOfAKind() {
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JOKER));
		rfHand.add(new Card(eSuit.CLUBS, eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS, eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS, eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be rf:", eHandStrength.ThreeOfAKind.getHandStrength(), h.getHandStrength());
		assertEquals("Should be natural:", 0, h.getNatural());
	}
}
