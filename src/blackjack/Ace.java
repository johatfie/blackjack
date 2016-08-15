package blackjack;

public class Ace extends Card {

	public Ace(Suit suit)
    {
		super(Rank.ACE, suit);
	}

    /**
     * Set the value of an Ace to 11
     */
    public void increaseAce()
    {
        rank.setValue( 11 );
    }

    /**
     * Set the value of an Ace to 1
     */
    public void reduceAce()
    {
        rank.setValue( 1 );
    }
}
