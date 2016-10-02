package blackjack;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */

/**
 * @author Jon Hatfield
 *         <p>
 *         Represents a standard playing card with a Rank and a Suit, e.g. an
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
            this.mName = name;
        }

        /**
         * @return The name of the Suit
         */
        public String getName()
        {
            return mName;
        }

        private final String mName;
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
            this.mName  = name;
            this.mValue = value;
            // @formatter:on
        }

        /**
         * @return The name of the Rank, e.g. Ace, Two, King, etc.
         */
        public String getName()
        {
            return mName;
        }

        /**
         * @return The score of a card in a game of blackjack.
         *         <p>
         *         Number cards have their face value. Face cards are worth 10.
         *         And an Ace can be worth 11 or 1.
         *         </p>
         */
        public int getValue()
        {
            return mValue;
        }

        /**
         * @param value
         */
        public void setValue( int value )
        {
            this.mValue = value;
        }

        private final String mName;
        private int          mValue;
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
        this.mRank  = rank;
        this.mSuit  = suit;
        this.faceUp = false;
    }

    /**
     * @return The Rank of the card.
     */
    public Rank getRank()
    {
        return mRank;
    }

    /**
     * @return The Suit of the card.
     */
    public Suit getSuit()
    {
        return mSuit;
    }

    /**
     * @return The value of the card.
     */
    public int getValue()
    {
        return mRank.getValue();
    }

    /**
     * @return boolean for whether or not the card is an Ace
     */
    public boolean isAce()
    {
        return mRank == Rank.ACE;
    }

    /**
     * @return boolean for whether or not the card is a face card or a 10
     */
    public boolean isFaceCard()
    {
        return mRank.getValue() == 10;
    }

    public boolean getFaceUp()
    {
        return faceUp;
    }

    public void setFaceUp( boolean up )
    {
        faceUp = up;
    }

    /**
     * Turn the card face up
     */
    public void revealCard()
    {
        faceUp = true;
    }

    @Override
    public String toString()
    {
        return mRank.getName() + " of " + mSuit.getName();
    }

    /**
     * @return An List&lt;Card&gt; containing 52 cards as in a standard
     *         deck of playing cards
     */
    public static List<Card> getDeck()
    {
        List<Card> deck = new ArrayList<Card>( 52 );

        for( Suit s : Suit.values() )
        {
            for( Rank r : Rank.values() )
            {
                if( r != Rank.ACE )
                {
                    deck.add( new Card( r, s ) );
                }
                else
                {
                    deck.add( new Ace( s ) );
                }
            }
        }

        return deck;
    }

    /**
     * @param theShoe
     *            A List&lt;Card&gt;
     *            <p>
     *            Appends a deck of cards to the provided List&lt;Card&gt;
     *            </p>
     *            <p>
     *            Used to load a "shoe" with multiple decks of playing cards
     *            </p>
     */
    public static void getDeck( List<Card> theShoe )
    {
        for( Suit s : Suit.values() )
        {
            for( Rank r : Rank.values() )
            {
                if( r != Rank.ACE )
                {
                    theShoe.add( new Card( r, s ) );
                }
                else
                {
                    theShoe.add( new Ace( s ) );
                }
            }
        }
    }


    protected final Suit mSuit;
    protected final Rank mRank;
    protected boolean faceUp;
}
