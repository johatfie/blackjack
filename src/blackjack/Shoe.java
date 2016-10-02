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
 * @author jon
 *
 */
public class Shoe
{

    private static Shoe instance;

    public static Shoe getInstance()
    {
        return getInstance( 6 );
    }

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


    private final int mNumberOfDecks;
    private final int mNumberOfCards;

    private List<Card> mTheShoe;

    private final Lock shoeMutex;


    /**
     *
     */
    private Shoe( int numberOfDecks )
    {
        // TODO: throw numberOfDecks exception for <1 deck
        mNumberOfDecks = numberOfDecks;
        mNumberOfCards = numberOfDecks * 52;
        mTheShoe       = new ArrayList<Card>( mNumberOfCards );
        shoeMutex      = new ReentrantLock();

        reloadShoe();
    }


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

            card = mTheShoe.get(0);
        }
        finally
        {
            shoeMutex.unlock();
        }

        return card;
    }

    public double fractionOfCardsRemaining()
    {
        return (double) numberOfCardsRemaining() / mNumberOfCards;
    }

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
