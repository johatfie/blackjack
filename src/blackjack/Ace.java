package blackjack;

/**
 * @author jhatfield
 *
 */
public class Ace extends Card
{

    /**
     * @param suit
     */
    public Ace(Suit suit)
    {
        super(Rank.ACE, suit);
    }

    /**
     * Set the value of an Ace to 11
     */
    public void increaseAce()
    {
        mRank.setValue( 11 );
    }

    /**
     * Set the value of an Ace to 1
     */
    public void reduceAce()
    {
        mRank.setValue( 1 );
    }
}
