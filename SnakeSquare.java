package com.company;

/**
 * Child class of SorLSquare class
 * Snake Square spaces
 * @author Rafid Dewan
 */
public class SnakeSquare  extends SorLSquare
{
    /**
     * Constructor
     * Creates a square space
     * @param number
     * @param endSquare
     */
    public SnakeSquare(int number, int endSquare)
    {
        super(number, endSquare);
        if(number < endSquare) throw new IllegalArgumentException("endSquare must be lower than number itself");

    }

    /**
     * Returns an integer of the space that was landed on
     * @return int
     */
    public int landOn()
    {
        return super.landOn();
    }

    /**
     * Returns the String of the SnakeSquare class variables
     * @return String
     */
    public String toString()
    {
        return getNumber() + "-" + getEndSquare();
    }

    /**
     * Checks to see if the objects are the same class
     * NO OVERRIDE SINCE THERE IS NO UNIQUE IMPLEMENTATION JUST A CALL TO SUPER
     * @param obj
     * @return boolean
     */
    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }
}

