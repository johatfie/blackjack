package blackjack;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 *
 */

/**
 * @author jhatfield
 *
 */
public class CardTest
{
    Card deuce = new Card( Card.Rank.DEUCE, Card.Suit.CLUBS );
    Card king  = new Card( Card.Rank.KING, Card.Suit.DIAMONDS );
    Card ten   = new Card( Card.Rank.TEN, Card.Suit.SPADES );

    /**
     * @throws java.lang.Exception
     */
    //@Before
    //public void setUp() throws Exception
    //{
    //}

    /**
     * @throws java.lang.Exception
     */
    //@After
    //public void tearDown() throws Exception
    //{
    //}

    /**
     * Test method for {@link Card#Card(Card.Rank, Card.Suit)}.
     */
    //@Test
    //public final void testCard()
    //{
        //fail( "Not yet implemented" ); // TODO
    //}

    /**
     * Test method for {@link Card#getDeck()}.
     */
    @Test
    public final void testGetDeck()
    {
        fail( "Not yet implemented" ); // TODO
    }

    /**
     * Test method for {@link Card#getDeck(java.util.ArrayList)}.
     */
    @Test
    public final void testGetDeckArrayListOfCard()
    {
        fail( "Not yet implemented" ); // TODO
    }

    /**
     * Test method for {@link Card#getRank()}.
     */
    @Test
    public final void testGetRank()
    {
        assertTrue( ten.getRank() == Card.Rank.TEN );
        assertTrue( deuce.getRank() == Card.Rank.DEUCE );
        assertTrue( king.getRank() == Card.Rank.KING );
    }

    /**
     * Test method for {@link Card#getSuit()}.
     */
    @Test
    public final void testGetSuit()
    {
        assertTrue( ten.getSuit() == Card.Suit.SPADES );
        assertTrue( king.getSuit() == Card.Suit.DIAMONDS );
        assertTrue( deuce.getSuit() == Card.Suit.CLUBS );
    }

    /**
	 * Test method for {@link blackjack.Card.Rank#getName()}.
	 */
	@Test
	public final void testRankGetName()
    {
        assertTrue( Card.Rank.DEUCE.getName().equals( "Deuce" ) );
        assertTrue( Card.Rank.THREE.getName().equals( "Three" ) );
        assertTrue( Card.Rank.FOUR.getName().equals( "Four" ) );
        assertTrue( Card.Rank.FIVE.getName().equals( "Five" ) );
        assertTrue( Card.Rank.SIX.getName().equals( "Six" ) );
        assertTrue( Card.Rank.SEVEN.getName().equals( "Seven" ) );
        assertTrue( Card.Rank.EIGHT.getName().equals( "Eight" ) );
        assertTrue( Card.Rank.NINE.getName().equals( "Nine" ) );
        assertTrue( Card.Rank.TEN.getName().equals( "Ten" ) );
        assertTrue( Card.Rank.JACK.getName().equals( "Jack" ) );
        assertTrue( Card.Rank.QUEEN.getName().equals( "Queen" ) );
        assertTrue( Card.Rank.KING.getName().equals( "King" ) );
        assertTrue( Card.Rank.ACE.getName().equals( "Ace" ) );
	}

	/**
	 * Test method for {@link blackjack.Card.Rank#getValue()}.
	 */
	@Test
	public final void testRankGetValue()
    {
        assertTrue( Card.Rank.DEUCE.getValue() == 2 );
        assertTrue( Card.Rank.THREE.getValue() == 3 );
        assertTrue( Card.Rank.FOUR.getValue()  == 4 );
        assertTrue( Card.Rank.FIVE.getValue()  == 5 );
        assertTrue( Card.Rank.SIX.getValue()   == 6 );
        assertTrue( Card.Rank.SEVEN.getValue() == 7 );
        assertTrue( Card.Rank.EIGHT.getValue() == 8 );
        assertTrue( Card.Rank.NINE.getValue()  == 9 );
        assertTrue( Card.Rank.TEN.getValue()   == 10 );
        assertTrue( Card.Rank.JACK.getValue()  == 10 );
        assertTrue( Card.Rank.QUEEN.getValue() == 10 );
        assertTrue( Card.Rank.KING.getValue()  == 10 );
        assertTrue( Card.Rank.ACE.getValue()   == 11 );
	}

	/**
	 * Test method for {@link blackjack.Card.Suit#getName()}.
	 */
	@Test
	public final void testSuitGetName()
    {
        assertTrue( Card.Suit.CLUBS.getName().equals( "Clubs" ) );
        assertTrue( Card.Suit.DIAMONDS.getName().equals( "Diamonds" ) );
        assertTrue( Card.Suit.HEARTS.getName().equals( "Hearts" ) );
        assertTrue( Card.Suit.SPADES.getName().equals( "Spades" ) );
	}

	/**
     * Test method for {@link Card#toString()}.
     */
    @Test
    public final void testToString()
    {
        assertTrue( deuce.toString().equals( "Deuce of Clubs" ) );
        assertTrue( ten.toString().equals( "Ten of Spades" ) );
        assertTrue( king.toString().equals( "King of Diamonds" ) );
    }

}
