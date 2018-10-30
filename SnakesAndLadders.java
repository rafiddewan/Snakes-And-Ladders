package com.company;

/**
 * Game Engine
 * Game Client
 * @author Rafid Dewan
 */
public class SnakesAndLadders
{
    public  static int NUM_PLAYERS;
    public static final int NUM_SQUARES = 100;
    private SnLSquare [] board;
    private int players [];
    private Dice dice;

    /**
     * Default constructor
     *  Starts the game with 2 players only
     */
    public SnakesAndLadders()
    {
        this(2);
    }

    /**
     * Constructor
     * Creates the board and players
     * Starts the game
     * @param nPlayers
     */
    public SnakesAndLadders(int nPlayers)
    {
        NUM_PLAYERS = nPlayers;
        this.players = new int[NUM_PLAYERS]; // Creates the number of players
        //Puts all the players in their starting points
        for(int i = 0; i < NUM_PLAYERS; i++){
            this.players[i] = 1; //All players start at the first square
        }
        this.board = new SnLSquare[NUM_SQUARES]; //Create the board of 100 spaces
        int space = 1;
        for(int i = 0; i < NUM_SQUARES; i++)
        {
            switch(space) //Making all the regular spaces, snakes spaces, and ladder spaces
            {
                case 4:
                    this.board[i] = new LadderSquare(4, 14);
                    break;
                case 9:
                    this.board[i] = new LadderSquare(9,31);
                    break;
                case 17:
                    this.board[i] = new SnakeSquare(17,7);
                    break;
                case 20:
                    this.board[i] = new LadderSquare(20,38);
                    break;
                case 28:
                    this.board[i] = new LadderSquare(28,84);
                    break;
                case 40:
                    this.board[i] = new LadderSquare(40,59);
                    break;
                case 54:
                    this.board[i] = new SnakeSquare(54,34);
                    break;
                case  62:
                    this.board[i] = new SnakeSquare(62,18);
                    break;
                case 63:
                    this.board[i] = new LadderSquare(63,81);
                    break;
                case 64:
                    this.board[i] = new SnakeSquare(64,60);
                    break;
                case 71:
                    this.board[i] = new LadderSquare(71,91);
                    break;
                case 87:
                    this.board[i] = new SnakeSquare(87,24);
                    break;
                case 93:
                    this.board[i] = new SnakeSquare(93,73);
                    break;
                case 96:
                    this.board[i] = new SnakeSquare(96,75);
                    break;
                case 99:
                    this.board[i] = new SnakeSquare(99,78);
                    break;
                 default:
                     this.board[i] = new SnLSquare(space);
                     break;
            }
            space++;
        }
        this.dice = new Dice(2); //Creating pair of dice
    }

    /**
     *
     * @param player
     * @return boolean
     */
    public boolean takeTurn(int player)
    {
        int roll = dice.roll(); //roll number
        players[player] += roll; //Move the player according to the roll number
        System.out.println("Player " + player + " rolled " + roll);
        int space = getPlayerPosition(player); //Gets the position of the player

        /*These are just placeholders to check if the space the player landed on is a snake square or a ladder square*/
        SnakeSquare snake = new SnakeSquare(0,-1);
        LadderSquare ladder = new LadderSquare(-1,0);

        // If the roll is too large,the player must move backwards, in excess amount
        if(space > 100)
        {
            players[player] = 100 - (space - 100);  /*Get the difference between the space and the max space to get the excess
             * Subtract 100 by the excess to get the correct space*/
            space = players[player];
        }

        //If the player lands on a snake/ladder space transfer them to a new place
        if(board[space - 1].getClass() == ladder.getClass())
        {
            players[player] = board[space - 1].landOn();
        }
        else if(board[space - 1].getClass() == snake.getClass())
        {
            players[player] =  board[space - 1].landOn();
            System.out.println("Oh no!"); // Only if landed on snake squares
        }

        return dice.hasDoubles(); // If you roll a double you role again, the player's turn is terminated
    }

    /**
     * Checks if the player has successfully landed on the 100th square
     * @param player
     * @return boolean
     */
    public boolean isPlayerWinner(int player)
    {
        return players[player] == 100;
    }

    /**
     * Returns which player won the game
     * If no one wins the game it returns -1
     * @return int
     */
    public int getWinner()
    {
        //Loops to get the winner
        for(int i = 0; i < NUM_PLAYERS; i++){
            if(isPlayerWinner(i)) return i; //This player is a winner
        }
        return -1; //no one is a winner so far
    }

    /**
     * Gets the current position of a player in the form of a int
     * @param player
     * @return int
     */
    public int getPlayerPosition(int player)
    {
        return players[player];
    }

    /**
     * Returns a String of the snakes and ladders board
     * @return String
     */
    public String toString()
    {
        String boardString = "";
        int space  = 1;
        for(int i = 0; i < NUM_SQUARES; i++)
        {
            boardString += "| " + board[i].toString() + " | ";
            //Make a new line every 10 squares
            if(space == 10 || space == 20 || space == 30 || space == 40 || space == 50 || space == 60 || space == 70 || space == 80 || space == 90) boardString += "\n";
            space++;
        }
        return boardString;
    }

    /**
     * Returns a String of the player(s)' current position
     * @return String
     */
    public String toStringCurrentPositions() {
        String playerPosition = "";
        int count =  0;
        while(count < NUM_PLAYERS){
            playerPosition +=  count + ":" + getPlayerPosition(count) +" ";
            count++;
        }
        return playerPosition;
    }

    /**
     * Game Client
     * @param args
     */
    public static void main(String args[])
    {
        SnakesAndLadders game = new SnakesAndLadders(5); //Create the game
        System.out.println(game.toString()); //Print the board
        int player = 0; //Set Player 0 as starting player
        boolean check; //See if the player has/hasn't finished their turn
        /*Loop until game is won*/
        while(game.getWinner() == -1)
        {
            check = game.takeTurn(player); //Player takes their turn
            System.out.println(game.toStringCurrentPositions()); // Print the current position of the player
            /*Keep looping as long as there are doubles*/
            while (check)
            {
                check = game.takeTurn(player);
                System.out.println(game.toStringCurrentPositions());
            }
            /*Change players turn once their turn has ended*/
            if(game.getWinner() == player) System.out.println("Player " + player +  " wins.");
            player++;
            if(player == NUM_PLAYERS) player = 0; //If the last player goes then the first player goes back to doing it again
        }
    }
}

