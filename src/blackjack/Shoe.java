/**
 *
 */
package blackjack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author Jon Hatfield
 *
 */
public class Shoe
{

    private static Shoe instance;

    /**
     * @return A reference to the shoe singleton instance
     */
    public static Shoe getInstance()
    {
        return getInstance( 6 );
    }

    /**
     * @param numberOfDecks
     *            The number of decks to load into the shoe
     * @return A reference to the shoe singleton instance
     */
    public static Shoe getInstance( int numberOfDecks )
    {
        if( instance == null )
        {
            synchronized( Shoe.class )
            {
                if( instance == null )
                {
                    Shoe.instance = new Shoe( numberOfDecks );
                }
            }
        }

        return instance;
    }


    private final int        mNumberOfDecks;
    private final int        mNumberOfCards;
    private final Lock       shoeMutex;
    private final List<Card> mTheShoe;


    /**
     * @param numberOfDecks
     *            The number of decks to load into the shoe
     */
    private Shoe( int numberOfDecks )
    {
        // TODO: throw numberOfDecks exception for <1 deck
        mNumberOfDecks = numberOfDecks;
        mNumberOfCards = numberOfDecks * 52;
        mTheShoe = new ArrayList<Card>( mNumberOfCards );
        shoeMutex = new ReentrantLock();

        reloadShoe();
    }


    /**
     * @return The next card from the front of the shoe
     */
    public Card dealCard()
    {
        Card card;
        shoeMutex.lock();

        try
        {
            if( mTheShoe.isEmpty() )
            {
                reloadShoe();
            }

            card = mTheShoe.get( 0 );
        }
        finally
        {
            shoeMutex.unlock();
        }

        return card;
    }

    /**
     * @return A double between 0.0 and 1.0 representing the fraction of the
     *         cards remaining in the shoe
     */
    public double fractionOfCardsRemaining()
    {
        return (double) numberOfCardsRemaining() / mNumberOfCards;
    }

    /**
     * @return The number of cards left in the shoe
     */
    public int numberOfCardsRemaining()
    {
        int size = mNumberOfCards;

        if( shoeMutex.tryLock() )
        {
            try
            {
                size = mTheShoe.size();
            }
            finally
            {
                shoeMutex.unlock();
            }
        }

        return size;
    }


    private boolean empty()
    {
        return mTheShoe.isEmpty();
    }

    private void reloadShoe()
    {
        shoeMutex.lock();

        try
        {
            mTheShoe.clear();

            for( int i = 0; i < mNumberOfDecks; ++i )
            {
                mTheShoe.addAll( Card.getDeck() );
            }

            Collections.shuffle( mTheShoe );
        }
        finally
        {
            shoeMutex.unlock();
        }
    }

    private void shuffle()
    {
        Collections.shuffle( mTheShoe );
    }
}
