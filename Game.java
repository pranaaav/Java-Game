
/**
 * Game class provides main functionality to the Punto Banco game.
 *  Main control of the program.
 * @author Pranav Sharma(29004772)
 * @version (7/01/2019)
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.*;
import java.io.*;
import java.util.Scanner;

public class Game
{
        private Player player;
        private CardShoe cardShoe;
        private int flag;
        private RNG rng;
        Round round;

    public Game()  /** Default constructor */
    {
        round = new Round();    
    }
    
    public Game(Player player, CardShoe cardShoe)
    /**Parameterized const.*/
    {
        this.player = player;
        this.cardShoe = cardShoe;
    }
    
    public void setPlayer(Player player)   /** Mutators */
    {
        this.player = player;
    }
    
    public void setCardShoe(CardShoe cardShoe)
    {
        this.cardShoe = cardShoe;
    }
    
    public Player getPlayer()  /** Accessors */
    {
        return player;
    }
    
    public CardShoe getCardShoe()
    {
        return cardShoe;
    }


    public void register() throws Exception
    {
        InputStreamReader r=new InputStreamReader(System.in);    
        BufferedReader br=new BufferedReader(r);        
        System.out.println("REGISTER");
        flag++;
        player = new Player();
        int kite=0;
            do
            {   
                    System.out.println("Enter Your Name : ");
                    String nam=br.readLine(); 
                    Pattern p = Pattern.compile("^[A-Za-z]{3,25}$");
                    Matcher m = p.matcher(nam);
                    boolean b = m.matches();
                    if(b == true)
                    {
                        kite++;
                        player.setName(nam);
                    }
                    else if(nam.length() < 3 || nam.length() >25)
                        System.out.println("Name Should be between 3-25 characters");
                    else if(nam.matches(".*\\d.*"))
                        System.out.println("Numerics/Digits are not allowed ");
                       else
                           System.out.println("Invalid Name Entry, Please Try Again : ");

                }while(kite != 1);

                int betBalance = 0;
            do
            {
                     System.out.println("Set your Betting Balance : ");
                     String inp = br.readLine(); 
                     Pattern p = Pattern.compile("(^\\d*)$");
                     Matcher m = p.matcher(inp);
                     boolean b = m.matches();
                     if(b==true)
                     {
                     betBalance = Integer.parseInt(inp);
                         if(betBalance <= 0)
                             System.out.println("Add Interger Value more than 0");
                             else
                             {
                                 player.setBal(betBalance);
                                 player.setBal(betBalance);
                             }
                     }
                     else
                            System.out.println("Enter digits only");
            }while(betBalance <= 0);
    
    }
    
       public void play() throws Exception
       {    
                   InputStreamReader r=new InputStreamReader(System.in);    
                   BufferedReader br=new BufferedReader(r);  
                   int betAmount = 0;
                   if(flag == 0)
                   {
                       System.out.println("REGISTER FIRST THEN COME");
                   }
                   else if(player.getBal() <= 0)
                   {
                       System.out.println("Your Balance is Over !!");   
                   }
                   else
                   {
                           if(rou == 0)
                           {
                               System.out.println("Starting  from Round 1");
                           }
                
                           rou++;   

                           if(rou ==11)
                           {
                    rou=0;
                }
                
                    System.out.println("Round : " + rou);               
                
                    int fg = 0;
                    do
                    {
                        System.out.println("Enter your BET Amount : ");
                        String inp=br.readLine(); 
                        Pattern p = Pattern.compile("(^\\d*)$");
                        Matcher m = p.matcher(inp);
                        boolean b = m.matches();

                        if(b == true)
                        {
                         betAmount = Integer.parseInt(inp);
                            if(betAmount > player.getBal())
                                System.out.println("Amount exceeds the Balance");
                                    else if(betAmount <= 0)
                                        System.out.println("Unacceptable, Bet is Less than zero");
                                        else
                                        {
                                            System.out.println("Lets Continue");
                                            round.setBet(betAmount);
                                            player.setBal(player.getBal() - betAmount);
                                            fg++;
                                        }
                        }
                        else
                            System.out.println("Enter digits only");
                    }while(fg != 1);
        
                    int cursor = 0;
                    String side;
                    do
                    {   
                        System.out.println("Please ENTER your BET side : Punto, Banco, Tie");
                        side=br.readLine(); 
                        Pattern p = Pattern.compile("^[A-Za-z]{3,25}$");
                        Matcher m = p.matcher(side);
                        boolean b = m.matches();
                        if(b == true)
                        {
                            if(side.equalsIgnoreCase("Punto") || side.equalsIgnoreCase("Banco")|| side.equalsIgnoreCase("Tie"))
                            {   
                                cursor++;
                               }
                           }
                           else
                                    System.out.println("Please Enter Punto, Banco or Tie");     
                         }while(cursor != 1);

        
                         try
                         {
                             rng = new RNG();
                             round.setSide(side);
                             round.setBet(betAmount);
                             generate();
                            }
                            catch(Exception e)
                            {
                                System.out.println(e);
                            }
                                System.out.println("Remaing balance is : " + player.getBal());
                            }
        
}
    

    int rou;
    public void generate() throws Exception
    {

        ArrayList<Integer> arp  =new ArrayList<>();
        ArrayList<Integer> arb  =new ArrayList<>();
        cardShoe = new CardShoe();
        System.out.println(cardShoe.cardShoe[0].getCardValue());

        rng.setMaximumValue(cardShoe.cardShoe[8].getCardValue());
        rng.setMinimumValue(cardShoe.cardShoe[0].getCardValue());


        Random random = new Random();
        int counter=0;
        while(counter <2)
        {
            int p = random.nextInt(rng.getMaximumValue()) + rng.getMinimumValue();
            System.out.println("Generating card one for PUNTO : " +p);
            arp.add(p);

            int b = random.nextInt(rng.getMaximumValue()) + rng.getMinimumValue();
            System.out.println("Generating card one for BANCO : " +b);
            arb.add(b); 

    
            disp(arp, arb);
            counter++;
        }
        

}

int ctr=0;
public void disp(ArrayList<Integer> arp, ArrayList<Integer> arb)
{
    Card p[] = new Card[arp.size()];
    Card b[] = new Card[arb.size()];
    int incr=0;
    int decr=0;


    if(incr == 10 && decr == 10)
    {
        incr=0;
        decr=0;
        }

    int totalp=0, totalb=0;
    System.out.print("Punto Cards :  ");
    for(Integer i : arp)
    {
        System.out.print(i + " ");
        p[incr] = new Card();
        p[incr].setCardValue(i);
        totalp=totalp+i;
        incr++;
    }

    while(totalp >= 10)
    {
        totalp = totalp%10;
    } 
    System.out.print(" = " +totalp + "\n");

    System.out.print("Banco Cards :  ");
    for(Integer i : arb)
    {
        System.out.print(i + " ");
        b[decr] = new Card();
        b[decr].setCardValue(i);
        totalb=totalb+i;
        decr++;
    }

    while(totalb >= 10)
    {
        totalb = totalb%10;
    }

    System.out.print(" = " + totalb + "\n");
    
    System.out.println("\nPress Enter key to continue...");
             try
             {
                 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 br.readLine();
             }
              catch(Exception e)
             {
             }

    if(arp.size() >= 2 && arb.size() >= 2 && ctr == 1)
    {
        ctr=0;
        round.display(p, b, totalp, totalb);
        winner(totalp, totalb); 
    }

    if(arp.size() == 2 && arb.size() == 2 && ctr == 0)
    {
        if(wins(totalp, totalb) == 0)
        {
            ctr++;
            thirdCard(totalp, totalb, arp, arb);
        }
        else 
        {
            round.display(p, b, totalp, totalb);        
            winner(totalp, totalb);
        }
    }
    
}


public void thirdCard(int totalp, int totalb, ArrayList<Integer> arp, ArrayList<Integer> arb)
{
    rng.setMaximumValue(cardShoe.cardShoe[6].getCardValue());
    rng.setMinimumValue(cardShoe.cardShoe[0].getCardValue());
    Random random = new Random();
    int b1=0;
       if(totalp >=0 && totalp <=5)
       {
           System.out.println("PUNTO will draw third card");
           int p1 = random.nextInt(rng.getMaximumValue()) + rng.getMinimumValue();
           System.out.println("Generating card one for PUNTO : " +p1);
           arp.add(p1);
           if((p1 >= 0 && p1<=7 ) && (totalb >=0 && totalb <=2))
        {
            b1 = random.nextInt(rng.getMaximumValue()) + rng.getMinimumValue();
            System.out.println("Generating card one for BANCO: " +b1);
            arb.add(b1);
        }
        else if((p1 >= 0 && p1<=7 )&& totalb ==3)
        {
            b1 = random.nextInt(rng.getMaximumValue()) + rng.getMinimumValue();
            System.out.println("Generating card one for BANCO: " +b1);
            arb.add(b1);
        }
        else if((p1 >= 2 && p1<=7 )&& totalb ==4)
        {
            b1 = random.nextInt(rng.getMaximumValue()) + rng.getMinimumValue();
            System.out.println("Generating card one for BANCO: " +b1);
            arb.add(b1);
        }
        else if((p1 >= 4 && p1<=7 )&& totalb ==5)
        {
            b1 = random.nextInt(rng.getMaximumValue()) + rng.getMinimumValue();
            System.out.println("Generating card one for BANCO: " +b1);
            arb.add(b1);
        }
        else if((p1 >= 6 && p1<=7 )&& totalb ==6)
        {
            b1 = random.nextInt(rng.getMaximumValue()) + rng.getMinimumValue();
            System.out.println("Generating card one for BANCO: " +b1);
            arb.add(b1);
        }
        else if((p1 >= 0 && p1<=7 )&& totalb ==7)
        {
            System.out.println("BANCO will STAND");
        }


                }
                        else if(totalp >=6 && totalp <=7)
                        {
                            System.out.println("Stand by PUNTO");
                            if(totalb >=0 && totalb <=5)
                            {
                                b1 = random.nextInt(rng.getMaximumValue()) + rng.getMinimumValue();
                                System.out.println("Generating card one for BANCO: " +b1);
                                arb.add(b1);
                            }
                            else
                            {
                                System.out.println("Banco stand");
                            }
                        }
                            else
                            {
                                System.out.println("Nobody will draw");
                            }
    
    
    disp(arp , arb);    
    
}


public int wins(int totalp, int totalb)
{
    int flag=0;
    if(totalp >=8 || totalb >=8)
    {
        System.out.println("Round Ends");
        flag++;
    }
    return flag;
}   


public void winner(int totalp, int totalb)
{

            if(totalp > totalb)
            {
            System.out.println("PUNTO WINS");
            }
            else if(totalb > totalp)
            {
            System.out.println("BANCO WINS");
            }
            else
            {
            System.out.println("TIE");
            }

            if(totalp == totalb && round.getSide().equalsIgnoreCase("Tie"))
            {
                //System.out.println("Here is a TIE");
                System.out.println("Your Bet was : " + round.getBet());
                System.out.println("Winning Amount : " + 7*round.getBet());
             }
             else if(totalp > totalb && round.getSide().equalsIgnoreCase("Punto") )
             {
                 System.out.println("You WIN");
                 System.out.println("Your Bet was : " + round.getBet());
                 System.out.println("Winning Amount : " + 1*round.getBet());
             }
             else if(totalb > totalp && round.getSide().equalsIgnoreCase("Banco"))
             {
                 System.out.println("You WIN");
                 System.out.println("Your Bet was : " + round.getBet());
                 System.out.println("Winning Amount : " + 1*round.getBet());
             }  
             else
             {
                 System.out.println("You LOSE");
                 System.out.println("Your Bet was : " + round.getBet());
                 System.out.println("Lose Amount : " + (-1*round.getBet()));
             }

}
    
    public void welcome() throws Exception
    {
        int opt = 0;
        do 
        {
            System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
            System.out.println("Welcome to Punto Banco - A Game of Chance");
            System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
            System.out.println("Please Select 1 to Register a Player" + "\n" +
                "Please Select 2 to Play a Round"+ "\n"+
                "Please Select 3 to View Round Information " +"\n"+
                "Please Select 4 to Get Help"+ "\n"+
                "Please Select 5 to Exit" );
                InputStreamReader r=new InputStreamReader(System.in);    
                BufferedReader br=new BufferedReader(r); 
                String inp=br.readLine(); 
                Pattern p = Pattern.compile("(^\\d*)$");
                Matcher m = p.matcher(inp);
                boolean b = m.matches();
        if(b ==true)
        opt = Integer.parseInt(inp);
        else
        {
        System.out.println("Enter digits only");
        continue;
        }
                
                    switch(opt)
                    {
                        case 1: try
                        {
                            register();  
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        break;
                        case 2:
                        try
                        {
                            play();  
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }       
                        break;
                        case 3: round.roundInfo(rou);
                        break;
                        case 4: System.out.println("HELP");
                                                System.out.println("This is a game called Punto Banco" + "\n" + 
                                                "In Which a player use multiple decks of card and place a bet against the computer"+"\n" + 
                                                "To see who scores the highest value from 2-3 cards based on a set of defined rules" +"\n" + 
                                                "The system will allow the player to play a single round each time" + "\n" + 
                                                "Betting a set amount from the Available balance"+ "\n" + 
                                                "The system will also maintain a history of each round"+"\n" +  
                                                "Player with a maximum of 10 rounds only" +"\n" + 
                                                "In this Game simulation,Only Player PUNTO is required" + "\n" +  
                                                "The opponent, or banker is the computer BANCO. ");
                                               
                                                    System.out.println("Select OPTION 1 TO REGISTER AND SET A NEW PLAYER" + "\n" + 
                                                                "Select OPTION 2 TO START THE ROUND" + "\n" + 
                                                                "Select OPTION 3 TO ATTAIN ROUND INFORMATION");
                                                                System.out.println("\nPress Enter key to continue...");
                                                                      try
                                                                      {
                                                                          BufferedReader sr = new BufferedReader(new InputStreamReader(System.in));
                                                                          br.readLine();
                                                                      }catch(Exception e)
                                                                      {
                                                                      }
                                                                break;
                        case 5: System.out.println("EXIT");
                        break;
                        default: System.out.println("WRONG INPUT, SELECT FROM 1/2/3/4/5");
                        break;
                    }
                }while(opt !=5);
}

    
    public static void main(String [] args)
    {
        Game game = new Game();
        try
        {
            game.welcome();
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
        
    }
}