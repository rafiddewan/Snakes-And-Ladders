package com.company;

/**
 * Child class of SnLSquare class
 * Parent class of SnakeSquare and LadderSquare
 * @author Rafid Dewan
 */
public class SorLSquare extends SnLSquare
{
    private int endSquare; //Where the new position of the player is ending up

    /**
     * Constructor for Snake or Ladder class
     * @param number
     * @param endSquare
     */
    public SorLSquare(int number, int endSquare)
    {
        super(number);
        if(number == endSquare) throw new IllegalArgumentException("Cannot be the same square");
        this.endSquare = endSquare;
    }

    /**
     *
     * @return int
     */
    public int getEndSquare()
    {
        return endSquare;
    }

    /**
     * Returns an integer of the new place after landing on the snake or ladder square
     * @return int
     */
    public int landOn() {
        return endSquare;
    }

    /**
     * Returns the String of the SorLSquare class variables
     * @return String
     */
    public String toString()
    {
        return getNumber() + ":" + getEndSquare();
    }

    /**
     * Checks to see if the objects are the same class
     * @param obj
     * @return boolean
     */
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != this.getClass()) return false; //Check if object is null or is of the same class
        SorLSquare sorLSquare = (SorLSquare) obj; //If object is of this class cast it to the SorLSquare object
        return sorLSquare.endSquare == this.endSquare && sorLSquare.getNumber() == getNumber(); //Check if the values of the SorLSquare object are the same or not
    }
}
