/**
 * Round class is used to provide information 
 *  of all the rounds that have been played.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Round
{
    Card[] banco;
    Card[] punto;
    private String side;
    private int bet;
    
    public Round() /** Default constructor */
    {
    }

    public Round(int bet, Card[] banco, Card[] punto) /** Parameterized constructor  */
    {
        this.bet = bet;
        this.banco = banco;
        this.punto = punto;
    }

    public void setBet(int bet) /** Mutators */
    {
        this.bet = bet;
    }

    public void setBanco(Card[] banco)
    {
        this.banco = banco;
    }

    public void setPunto(Card[] punto)
    {
        this.punto = punto;
    }
    
    public void setSide(String side)
    {
        this.side = side;
    }

    public int getBet()/** Accessors */
    {
        return bet;
    }

    public Card[] getBanco()
    {
        return banco;
    }

    public Card[] getPunto()
    {   
        return punto;
    }

    public String getSide()
    {
        return side;
    }

    Card[][] arrayBanco = new Card[10][];
    Card[][] arrayPunto = new Card[10][];
    int [] tPunto = new int[10];
    int [] tBanco = new int[10];
    int roundNum=0;

    public void display(Card [] p, Card [] b, int totalp, int totalb)   /**Display function  */
    {
        punto = p;
        banco = b;
        if(roundNum == 10)
        {
            roundNum =0;
        }
    
        arrayPunto[roundNum] =punto;
        tPunto[roundNum] = totalp;

        arrayBanco[roundNum]=banco;
        tBanco[roundNum]=totalb;

        roundNum++;
    
}


public void roundInfo(int round)    /** Round information */
{
    System.out.println("ROUND INFORMATION");

        for (int i=0; i< round ; i++) 
        { 
            System.out.println("Round : " + (i+1));
            System.out.println("PUNTO");
            
            for (int j=0; j < arrayPunto[i].length ; j++) 
            {   
                System.out.print(arrayPunto[i][j].getCardValue() + " "); 
            }
            
            System.out.println("=" + tPunto[i]);
            System.out.println("BANCO");
            
            for (int j=0; j < arrayBanco[i].length ; j++) 
            {
             System.out.print(arrayBanco[i][j].getCardValue() + " "); 
            }
            
            System.out.println("=" + tBanco[i]);
            System.out.println(); 
        } 
            System.out.println("\nPress Enter key to continue...");
                try
                {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    br.readLine();
                }
                catch(Exception e)
                {
                }       
}





}