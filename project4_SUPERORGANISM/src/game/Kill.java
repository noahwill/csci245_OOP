package game;

/**
 * Models the killing of a creature.
 * @author SUOERORGANISM
 *
 */
public class Kill extends Command {
	
	/**
	 * Tracks how many time a player attacks with no creature there. 
	 */
	private static int gladio = 0;
	
	/**
	 * Kills the creature in the room.
	 */
	public void execute(Player p,String secondhalf) {
		Room room = p.getCurrentRoom();
		Game game = Game.getInstance();
		Creature c = room.getCreature();
		Room roomToAdd = room.getBlocked();
		
		if (c != null) {
			
			String dirToAdd = room.getCreature().getDirBlocked();
			System.out.println("\n\tThe route is cleared!\n\n");
			room.addDir(dirToAdd, roomToAdd);
			if (c.getLoot()!=null)
				room.setItem(c.getLoot());
			room.setCreature(null);
		}
		
		//Nothing to kill
		else {
			if (gladio>2)
				game.finishGame("careless swordwaving");
			else {
			System.out.println("\n\tgladio vivere, gladio perire..."
					+ "\n\n\tThere's nothing to kill here...");
			gladio++;
			}
		}
	}
}