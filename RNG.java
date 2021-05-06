/**
 * Random number generator class.
 *
 */

public class RNG
{
    private int minimumValue;
    private int maximumValue;

    public RNG()    /** Default constructor */
    {
    
    }

    public RNG(int minimumValue, int maximumValue)  /** Parameterised constructor */
    {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }
    
    public void setMinimumValue(int minimumValue)   /** Mutators */
    {
        this.minimumValue = minimumValue;
    }

    public void setMaximumValue(int maximumValue)
    {
        this.maximumValue = maximumValue;
    }

    public int getMinimumValue()    /** Accessors */
    {
        return minimumValue;
    }

    public int getMaximumValue()
    {
        return maximumValue;
    }
    
    public void display()   /** Display function */
    {
        
    }

}