
/**
 * CardShoe class to define the value of cards.
 *  Assigning cards a value.
 */

public class CardShoe
{
    Card[] cardShoe;

        enum Deck
        {   
            ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(1), JACK(1), QUEEN(1), KING(1) ;   
  
            private int value;  
            private Deck(int value)
            {  
                this.value=value;  
            }  
        }  


    public CardShoe()
    {
        cardShoe = new Card[13];
        cardShoe[0] = new Card(Deck.ONE.value);
        cardShoe[1] = new Card(Deck.TWO.value);
        cardShoe[2] = new Card(Deck.THREE.value);
        cardShoe[3] = new Card(Deck.FOUR.value);
        cardShoe[4] = new Card(Deck.FIVE.value);
        cardShoe[5] = new Card(Deck.SIX.value);
        cardShoe[6] = new Card(Deck.SEVEN.value);
        cardShoe[7] = new Card(Deck.EIGHT.value);
        cardShoe[8] = new Card(Deck.NINE.value);
        cardShoe[9] = new Card(Deck.TEN.value);
        cardShoe[10] = new Card(Deck.JACK.value);
        cardShoe[11] = new Card(Deck.QUEEN.value);
        cardShoe[12] = new Card(Deck.KING.value);
    
    }

    public CardShoe(Card[] cardShoe)
    {
        this.cardShoe = cardShoe;
    }

    public void setCardShoe(Card[] cardShoe)
    {
        this.cardShoe = cardShoe;
    }

    public Card[] getCardShoe()
    {
        return cardShoe;
    }

    public void display()
    {
        
    }
}