package game;

import java.util.ArrayList;
import java.util.HashMap;

public class Battle {
	
	private Game g = Game.getInstance();
    private Player p;
	private Room room;
    private HashMap<String, Command> map = g.getCommands();
    private HashMap<String, ArrayList<Bout>> bouts = ReadBattles.getBattles();
    private ArrayList<Bout> boutlist = null;
    private Bout currentbout;
    private Creature c;
    private int boutint;
    
	public Battle(Player p) {
		this.p = p;
		room = p.getCurrentRoom();
		c = room.getCreature();
		boutint = 0;
	}
    
	public void prepareBout() {

		boutint++;

		currentbout = bouts.get(c.getName()).get(boutint);
		
		String dirBlocked = c.getDirBlocked();
		System.out.printf("\n\tThere is a %s in this room. Act fast!\n",c.getName());
		if (room.getBlocked() == null) {
			room.setBlocked(p);
			room.rmDir(dirBlocked);
		}
		boutlist = bouts.get(c.getName());
	}
	
	public void executeBout(String command,String rest,long time) {
	
		    //Too slow
		if ((time>currentbout.getTimetorespond() ||
			    			
			//Wrong command or don't have yet
			!command.equals(currentbout.getRequiredaction())) ||
			!map.keySet().contains(currentbout.getRequiredaction()))
			
			Game.getInstance().finishGame(room.getCreature().getName());
		else  {
			System.out.println(currentbout.getSuccessstring());
			if (boutlist.indexOf(currentbout)+1>=boutlist.size())
				map.get(command).execute(p,rest);
		}
	}
}
	

