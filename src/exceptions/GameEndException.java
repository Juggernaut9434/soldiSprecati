// GameEndException.java
// in the case player GM is dead, then end game
package exceptions;

public class GameEndException extends Exception {
	
	public static String[] GameEndMsg = 
		{
			"You were taken into the back room and never seen again",
			"An asteroid came out of the sky and crashed through the casino.\n Luckly the Soldi Sprecati had insurance; unfortunately, you didn't.",
			"Jerry, the regular loser came back in with a gun and shot wildly, you didn't make it.",
			"You died",
			"Game Over",
			"The Italians lost too much money tonight, you were found face down in the local river.",
			"The person you just beat in the last hand got angry and called their Dad in tears, "
			+ "\n the last thing you see is your hand and a black bag over your head",
			"You hear your morning alarm telling you to get ready for CSE 205 at 8:35",
			"All that sweaty playing stunk up the whole casino, Big Papa doesn't like smelly casinos."
			+ "\nYou were asked to leave. You started your car but never made it home"
		};
	public static String errorMsg = GameEndMsg[(int)(Math.random()*GameEndMsg.length)];
	
	// funny endings
	public GameEndException()
	{
		
		super(errorMsg);
	}
	// constructor that utilizes super()
	public GameEndException(String errorMessage)
	{
		super(errorMessage);
	}
	
	public GameEndException(String errorMessage, Throwable err)
	{
		super(errorMessage, err);
	}
}
