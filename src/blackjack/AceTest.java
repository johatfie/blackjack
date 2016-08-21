/**
 *
 */
package blackjack;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author jon
 *
 */
public class AceTest extends Ace
{

    /**
     * 
     */
    public AceTest()
    {
        super(Card.Suit.CLUBS);
    }

    /**
     * Test method for {@link blackjack.Ace#increaseAce()}.
     */
    @Test
    public final void testIncreaseAce()
    {
        Ace ace = new Ace( Card.Suit.SPADES );

        ace.getRank().setValue(4);
        assertTrue( ace.getValue() == 4 );
        ace.increaseAce();
        assertTrue( ace.getValue() == 11 );
    }

    /**
     * Test method for {@link blackjack.Ace#reduceAce()}.
     */
    @Test
    public final void testReduceAce()
    {
        Ace ace = new Ace( Card.Suit.DIAMONDS );

        ace.getRank().setValue(4);
        assertTrue( ace.getValue() == 4 );
        ace.reduceAce();
        assertTrue( ace.getValue() == 1 );
    }
}
