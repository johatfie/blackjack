/**
 *
 */
package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jon
 *
 */
public class Table
{

    /**
     *
     */
    public Table()
    {
        players = new ArrayList<Player>();
        playersMutex = new ReentrantLock();
    }

    /**
     * @param player
     *
     * @return
     */
    public boolean addPlayer( final Player player )
    {
        boolean result;
        playersMutex.lock();

        try
        {
            if( emptySeats() > 0 )
            {
                players.add( player );
                result = true;
            }
            else
            {
                result = false;
            }
        }
        finally
        {
            playersMutex.unlock();
        }

        return result;
    }

    /**
     * @param player
     */
    public void removePlayer( final Player player )
    {
        playersMutex.lock();

        try
        {
        }
        finally
        {
            playersMutex.unlock();
        }
    }

    /**
     * @return the players
     */
    public final List<Player> getPlayers()
    {
        final List<Player> currentPlayers;
        playersMutex.lock();

        try
        {
            currentPlayers = players;
        }
        finally
        {
            playersMutex.unlock();
        }

        return currentPlayers;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers( final List<Player> players )
    {
        this.players = players;
    }

    /**
     * @return
     */
    public int emptySeats()
    {
        int count;
        playersMutex.lock();

        try
        {
            count = maxPlayers - players.size();
        }
        finally
        {
            playersMutex.unlock();
        }

        return count;
    }


    /**
     * @return the maxBet
     */
    public int getMaxBet()
    {
        return maxBet;
    }

    /**
     * @param maxBet the maxBet to set
     */
    public void setMaxBet( int maxBet )
    {
        this.maxBet = maxBet;
    }


    private List<Player> players;
    private Lock playersMutex;
    private int maxBet;
    private int maxPlayers;
}
