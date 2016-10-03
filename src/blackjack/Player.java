/**
 *
 */
package blackjack;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jon Hatfield
 *
 */
public class Player
{

    /**
     *
     */
    public Player()
    {
        bankMutex = new ReentrantLock();
    }

    /**
     * @param dollars
     */
    public void makeBet( final int dollars )
    {
        bankMutex.lock();

        try
        {
            bank -= dollars;
        }
        finally
        {
            bankMutex.unlock();
        }
    }

    /**
     * @param dollars
     */
    public void collectWinnings( final int dollars )
    {
        bankMutex.lock();

        try
        {
            bank += dollars;
        }
        finally
        {
            bankMutex.unlock();
        }
    }


    private void addToBank( final int dollars )
    {
        bankMutex.lock();

        try
        {
            bank += dollars;
        }
        finally
        {
            bankMutex.unlock();
        }
    }

    private int cashOutBank()
    {
        int remaining;
        bankMutex.lock();

        try
        {
            remaining = bank;
            bank = 0;
        }
        finally
        {
            bankMutex.unlock();
        }

        return remaining;
    }

    private void startNewHand()
    {
    }

    private int bank;
    private Hand hand;
    private Lock bankMutex;
}
