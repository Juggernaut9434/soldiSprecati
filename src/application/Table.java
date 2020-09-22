// Table.java [completed]
// abstract and will be directly associated with a game (blackjack, etc)

package application;

import java.util.ArrayList;

import exceptions.InvalidLogicException;

public abstract class Table {
	protected int MAXPLAYERS, GAMEINDEX;
	protected ArrayList<Gambler> players;
	protected int ante;
	protected String dealer;

	public static final String[] SSGAMES = {"blackjack", "poker", "slots"};
	
	/***************
	 * + Table(int, int, int, String), constructor
	 * @param gameIndex: int, game index of the game/table
	 * @param maxPlayers: int, set a max of how many people can play, DLC content
	 * @param ante: int, buy-in to play the round of the game
	 * @param dealer: String, every table/game needs a card dealer
	 ****************/
	public Table(int gameIndex, int maxPlayers, int ante, String dealer)
	{
		this.GAMEINDEX = gameIndex;
		this.MAXPLAYERS = maxPlayers;
		this.players = new ArrayList<Gambler>();
		this.ante = ante;
		this.dealer = dealer;
	}
	
	/***************
	 * Getters
	 ***************/
	public int getGameIndex() {return this.GAMEINDEX;}
	public int getMaxPlayers() {return this.MAXPLAYERS;}
	public ArrayList<Gambler> getPlayers() {return this.players;}
	public int getAnte() {return this.ante;}
	public String getDealer() {return this.dealer;}
	
	/***************
	 * Setters
	 ***************/
	public void setDealer(String dealer) {this.dealer = dealer;}
	// do not add player if table is full
	public void addPlayer(Gambler player) throws InvalidLogicException
	{
		int numOfPlayers = this.players.size();
		if(numOfPlayers==this.MAXPLAYERS)
			throw new InvalidLogicException("Table.addPlayer(Gambler): player cannot join table"
					+ "\nMAXPLAYERS: " + this.MAXPLAYERS + "\tCurrentTableSize: " + numOfPlayers);
		this.players.add(player);
		player.setGameIndex(this.GAMEINDEX);
		player.setPlayerIndex(this.players.size()-1);	// set the index to save time, 
		
	}
	public void removePlayer(Gambler player) throws InvalidLogicException
	{
		if(!this.players.contains(player))
		{
			throw new InvalidLogicException("Table.removePlayer(Gambler): player is not part of table, therefore cannot leave the table"
					+ "\nGamber: " + player.getName());
		}
		this.players.remove(player.getPlayerIndex());	// remove the player from the list of players at the table
		player.setGameIndex(-1);
	}
	
	public String toString()
	{
		return String.format("Table: %d\tMax: %d\tDealer: %s\n", this.GAMEINDEX, this.MAXPLAYERS, this.dealer);
	}
	
	
}
