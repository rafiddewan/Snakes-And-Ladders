package com.company;

/**
 * Child class of SorLSquare class
 * Ladder spaces
 * @author Rafid Dewan
 */
public class LadderSquare extends SorLSquare
{

    /**
     * Constructor
     * Creates a ladder space
     * @param number
     * @param endSquare
     */
    public LadderSquare(int number, int endSquare)
    {
        super(number, endSquare);
        if(number > endSquare) throw new IllegalArgumentException("endSquare must be higher than number itself");
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
     * Returns the String of the LadderSquare class variables
     * @return String
     */
     @Override
    public String toString()
    {
        return getNumber() + "+" + getEndSquare();
    }

    /**
     * Checks to see if the objects are the same class
     * NO OVERRIDE SINCE THERE IS NO UNIQUE IMPLEMENTATION JUST A CALL TO SUPER
     * @param obj
     * @return boolean
     */
     /*
    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }*/
}

