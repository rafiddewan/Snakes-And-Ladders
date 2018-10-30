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
     * Returns the end of the ladder/snake square
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
        return getEndSquare();
    }

    /**
     * Returns the String of the SorLSquare class variables
     * @return String
     */
     @Override
    public String toString()
    {
        return getNumber() + ":" + getEndSquare();
    }

    /**
     * Checks to see if the objects are the same class
     * @param obj
     * @return boolean
     */
     @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null)return false;
        if(obj.getClass() != this.getClass()) return false;
        SorLSquare sorLSquare = (SorLSquare) obj; //If object is of this class cast it to the SorLSquare object
        return sorLSquare.endSquare == this.endSquare && sorLSquare.getNumber() == getNumber(); //Check if the values of the SorLSquare object are the same or not
    }
}

