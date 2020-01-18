import kareltherobot.*;

import java.awt.Color;

public class RunBots implements Directions
{

	public static void main(String [] args)
	{
	 	World.reset();
		World.readWorld("ST0242Mundo1.kwld");
		World.setVisible(true);
        ThreadBot karel1 = new ThreadBot(2,2,North,0,Color.PINK,0);
        ThreadBot karel2 = new ThreadBot(2,1,North,0,Color.BLUE,1);
        World.setupThread(karel1);
        World.setupThread(karel2);
        World.showSpeedControl(true);
	}
}