package com.company;

/**
 *  Parent class of SorLSquare
 *  Square objects of the Snakes and Ladders board
 * @author Rafid Dewan
 */
public class SnLSquare
{
    private int number; //Space number on Snakes and Ladders board

    /**
     * Constructor
     * Makes a space for the snakes and ladders board
     * @param number
     */
    public SnLSquare(int number)
    {
        this.number = number;
    }

    /**
     * Return instance class variable nuber
     * @return number
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * Returns an integer of the space that was landed on
     * @return int
     */
    public int landOn()
    {
        return getNumber();
    }

    /**
     * Returns a string of the SnlSquare class variable
     * @return String
     */
    public String toString()
    {
        return Integer.toString(getNumber());
    }

    /**
     * Checks to see if the objects are the same class
     * @param obj
     * @return boolean
     */
    public boolean equals(Object obj)
    {
        if(obj.getClass() != this.getClass()) return false;
        SnLSquare snLSquare = (SnLSquare) obj;
        return snLSquare.number == this.number;
    }
}
