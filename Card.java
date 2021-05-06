
/**
 * Card class is to store and
 *  Retrieve the value of card in each round.
 */

public class Card
{
    private int cardValue;

        public Card()   /** Default constructor */
        {

        }
        
        public Card(int cardValue)  /** Parameterized constructor */
        {
            this.cardValue = cardValue;
        }

        public void setCardValue(int cardValue) /** Mutators */
        {
            this.cardValue = cardValue;
        }

        public int getCardValue()   /** Accessors */
        {
            return cardValue;
        }

        public void display()   /** Display function */
        {

        }
}