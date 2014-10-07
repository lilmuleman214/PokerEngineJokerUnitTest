package Hands;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import poker.Card;
import poker.Hand;
import poker.eHandStrength;
import poker.eRank;
import poker.eSuit;

public class TestWilds {

	@Test
	public final void TestRoyalFlush(){
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO, true));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO, true));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO, true));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TWO, true));
		rfHand.add(new Card(eSuit.CLUBS, eRank.TEN, false));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be rf:", eHandStrength.RoyalFlush.getHandStrength(), h.getHandStrength());
		assertEquals("Should be natural:", 0, h.getNatural());
	}
}
