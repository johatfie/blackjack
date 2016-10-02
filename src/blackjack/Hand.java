/**
 *
 */
package blackjack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Jon Hatfield
 *
 */
public class Hand
{

    /**
     *
     */
    public Hand()
    {
        mCards = new ArrayList<Card>(21);
    }

    /**
     * @return
     */
    public int getScore()
    {
        int score = 0;

        for( Card c : mCards )
        {
            score += c.getValue();
        }

        for( Iterator<Card> cIter = mCards.iterator(); cIter.hasNext() && score > 21; )
        {
            Card c = cIter.next();

            if( c.isAce() && c.getValue() == 11 )
            {
                ( (Ace) c ).reduceAce();
                score -= 10;
            }
        }

        return score;
    }

    public Card getCard()
    {
        return null;

    }

    private List<Card> mCards;
}
