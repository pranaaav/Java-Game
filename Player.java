
/**
 * Player class is to set Name and 
 *  balances of the player.
 */


public class Player
{
    private String name;
    private int bal;


    public Player() /** Default constructor */
    {
        
    }
    
    public Player(String name, int bal) /** Parameterized constructor  */
    {
        this.name = name;
        this.bal = bal;
    }
    
    public void setBal(int bal) /** Mutators */
    {
        this.bal = bal;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public int getBal() /** Accessors */
    {
        return bal;
    }
    
    public String getName()
    {
        return name;
    }

    public void display()   /** Display function */
    {

    }
}