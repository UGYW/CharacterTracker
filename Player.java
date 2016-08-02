// DND TRACKER: Player Class
// 05/07/16

package DNDTracker;
import java.util.ArrayList;

class Player {

	String name;
	Integer health;
	ArrayList<String> inventory;
	String nature;
	String ability;
	Integer turn;

	public Player(String playerName, String playerNature, String playerAbility) {

		name = playerName;
		int health = 20;
		ArrayList<String> inventory = new ArrayList<String>();
		nature = playerNature;
		ability = playerAbility;
		turn = 1;

	}

	public void hit(Integer damage) {
		health = health - damage;
	}

	public void additem(String item) {
		inventory.add(item);
	}

	public void takeitem(String item) {

		ArrayList<String> newInv = new ArrayList<String>();

		for (String used : inventory) {
			if (item != used) {
				newInv.add(used);

			} else {
				newInv = newInv;

			}
		}

		inventory = newInv;
	}

	public void newturn() {
		turn++;
	}

}