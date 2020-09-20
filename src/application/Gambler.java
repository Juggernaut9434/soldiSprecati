// Gambler.java [completed]
// the player or NPC at a table game

package application;

import exceptions.GameEndException;

public class Gambler {
	// suspicion is game mechanic in DLC
	// chips is monetary value in game
	// GameIndex and playerIndex are for DLC game mechanics
	private int suspicion, chips, ssGameIndex, playerIndex;
	private String name;
	//public static int guid;	
	//private int uid;
	public static boolean dead;	// game state, if(dead) SSEnds();
	
	/*
	 * + Gambler(int, String)
	 */
	public Gambler(int chips, String name)
	{
		this.chips = chips;
		this.name = name;
		this.suspicion = 0;
		this.ssGameIndex = -1;
		this.playerIndex = -1;
		Gambler.dead = false;	// static call
		//this.uid = guid + 1;
		//this.guid++;
	}
	
	/*
	 * + Gamebler(int)
	 */
	public Gambler(int chips)
	{
		this.chips = chips;
		this.name = null;
		this.suspicion = 0;
		this.ssGameIndex = -1;
		this.playerIndex = -1;
		Gambler.dead = false;	// static call
		//this.uid = guid + 1;
		//this.guid++;
	}
	
	/**************************
	 * Accessors
	 **************************/
	public int getSuspicion() {return this.suspicion;}
	public int getChips() {return this.chips;}
	public boolean getState() {return this.dead;}
	public int getGameIndex() {return this.ssGameIndex;}
	public int getPlayerIndex() {return this.playerIndex;}
	public String getName() {return this.name;}
	
	/**************************
	 * Mutators
	 **************************/
	// set or change name (possible DLC GM
	public void setName(String name) {this.name = name;}
	// change suspicion DLC GM
	/*
	 * + setSuspicion(int): void > GameEndException
	 * @param int: sus, what you want to add/subtract from suspicion state
	 * if 5 or over, end the game.
	 */
	public void setSuspicion(int sus) throws GameEndException 
	{
		this.suspicion += sus; 
		if(this.suspicion>=5)
		{
			Gambler.dead = true;
			endGame();
		}
	}
	
	/*
	 * + setChips(int): void > GameEndException
	 * @param chips: int, chips you want to add or subtract from current stack
	 * if less than or equal to 0, end the game
	 */
	public void setChips(int chips) throws GameEndException
	{
		this.chips += chips;
		if(this.chips<=0)
		{
			Gambler.dead = true;
			endGame();
		}
	}
	
	// if dead, end game
	/*
	 * + _endGame()_: void > GameEndException
	 * checks if the game can end, player is dead
	 * then games game with funny message
	 */
	public static void endGame() throws GameEndException
	{
		if(Gambler.dead)
			throw new GameEndException();	// funny ending messages
	}
}
