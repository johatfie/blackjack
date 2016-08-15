/**
 *
 */
package blackjack;

import blackjack.Card.Rank;

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
        // TODO Auto-generated constructor stub
    }

    public int getScore()
    {
        int score = 0;
        int numberOfAces = 0;

        for( Card c : cards )
        {
            score += c.getRank().getValue();

            if( c.getRank() == Rank.ACE )
            {
                ++numberOfAces;
            }
        }

        if( score > 21 )
        {
            for( int i = numberOfAces; i > 0 && score > 21; --i )
            {
                score -= 10;
            }
        }

        return score;
    }

    public Card getCard()
    {

    }

    private Card[] cards;
}
