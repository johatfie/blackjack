package Blackjack;

import java.util.ArrayList;


/**
 *
 */

/**
 * @author Jon Hatfield
 *         <p>
 *         Represents a standard playing card with a rank and a suit, e.g. an
 *         Ace of Clubs
 *         </p>
 */
public class Card
{

    /**
     * @author Jon Hatfield
     *         <p>
     *         The suit of a card.
     *         </p>
     */
    public static enum Suit
    {
        // @formatter:off
        CLUBS(    "Clubs"    ),
        DIAMONDS( "Diamonds" ),
        HEARTS(   "Hearts"   ),
        SPADES(   "Spades"   );
        // @formatter:on

        private Suit( String name )
        {
            this.name = name;
        }

        /**
         * @return The name of the suit
         */
        public String getName()
        {
            return name;
        }

        private final String name;
    }

    /**
     * @author Jon Hatfield
     *         <p>
     *         The type of a card, i.e. a number or one of the face cards.
     *         </p>
     */
    public static enum Rank
    {
        // @formatter:off
        DEUCE( "Deuce" , 2  ),
        THREE( "Three" , 3  ),
        FOUR(  "Four"  , 4  ),
        FIVE(  "Five"  , 5  ),
        SIX(   "Six"   , 6  ),
        SEVEN( "Seven" , 7  ),
        EIGHT( "Eight" , 8  ),
        NINE(  "Nine"  , 9  ),
        TEN(   "Ten"   , 10 ),
        JACK(  "Jack"  , 10 ),
        QUEEN( "Queen" , 10 ),
        KING(  "King"  , 10 ),
        ACE(   "Ace"   , 11 );
        // @formatter:on

        private Rank( String name, int value )
        {
            // @formatter:off
            this.name  = name;
            this.value = value;
            // @formatter:on
        }

        /**
         * @return The name of the rank, e.g. Ace, Two, King, etc.
         */
        public String getName()
        {
            return name;
        }

        /**
         * @return The score of a card in a game of blackjack.
         *         <p>
         *         Number cards have their face value. Face cards are worth 10.
         *         And an Ace can be worth 11 or 1.
         *         </p>
         */
        public int value()
        {
            return value;
        }

        /**
         * Increase the value of an ace from 1 to 11
         */
        public void increaseAce()
        {
            if (this == Rank.ACE)
            {
                value = 11;
            }
        }

        /**
         * Reduce the value of an ace from 11 to 1
         */
        public void reduceAce()
        {
            if (this == Rank.ACE)
            {
                value = 1;
            }
        }

        private final String name;
        private int          value;
    }


    /**
     * @param rank
     *            The rank of the card
     * @param suit
     *            The suit of the card
     *
     */
    public Card( Rank rank, Suit suit )
    {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * @return The rank of the card.
     */
    public Rank getRank()
    {
        return rank;
    }

    /**
     * @return The suit of the card.
     */
    public Suit getSuit()
    {
        return suit;
    }

    @Override
    public String toString()
    {
        return rank.getName() + " of " + suit.getName();
    }

    /**
     * @return An ArrayList&lt;Card&gt; containing 52 cards as in a standard
     *         deck of
     *         playing cards
     */
    public static ArrayList<Card> getDeck()
    {
        ArrayList<Card> deck = new ArrayList<Card>( 52 );

        for( Suit s : Suit.values() )
        {
            for( Rank r : Rank.values() )
            {
                deck.add( new Card( r, s ) );
            }
        }

        return deck;
    }

    /**
     * @param theShoe
     *            An ArrayList&lt;Card&gt;
     *            <p>
     *            Appends a deck of cards to the provided ArrayList&lt;Card&gt;
     *            </p>
     *            <p>
     *            Used to load a "shoe" with multiple decks of playing cards
     *            </p>
     */
    public static void getDeck( ArrayList<Card> theShoe )
    {
        for( Suit s : Suit.values() )
        {
            for( Rank r : Rank.values() )
            {
                theShoe.add( new Card( r, s ) );
            }
        }
    }


    private final Suit suit;
    private final Rank rank;

}
