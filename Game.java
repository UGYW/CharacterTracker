// DND TRACKER: Main
// 03/07/16

package DNDTracker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
	
public class Game{ 

	public static void main(String[] args) {

			HashMap<Integer, Player> roster = new HashMap<Integer, Player>();

			// Player Initialization

			System.out.println("Please enter the size of your party.");

			Scanner inSize = new Scanner(System.in);
			Integer partySize = inSize.nextInt();

			for (Integer partyMem = 1; partyMem <= partySize; partyMem++) {

				System.out.println("Please enter the name of Player " + partyMem + ".");

				Scanner inName = new Scanner(System.in);
				String newName = inName.nextLine();

				System.out.println("Please enter the nature of Player " + partyMem + ".");

				Scanner inNature = new Scanner(System.in);
				String newNature = inNature.nextLine();

				System.out.println("Please enter the ability of Player " + partyMem + ".");

				Scanner inAbility = new Scanner(System.in);
				String newAbility = inAbility.nextLine();

				DNDTracker.Player newMember =  new DNDTracker.Player(newName, newNature, newAbility);

				roster.put(partyMem, newMember);

				System.out.println(newName + " has been added to the roster.");

			}

			// Game Start

			System.out.println("The game begins now.");

			Boolean ongoing = true;
			Integer round = 1;

			while (ongoing) {

				System.out.println("Round " + round);
				Integer liveMembers = 0;

				for (Integer playerNum : roster.keySet()) {

					Player player = roster.get(playerNum);

					if (player.health > 0) {

						liveMembers++;
						player.newturn();

						System.out.println(player.name + "'s turn.");
						System.out.println(player.name + "'s HP: " + player.health);
						System.out.println(player.name + "'s Nature: " + player.nature);
						System.out.println(player.name + "'s Ability: " + player.ability);
						System.out.println(player.name + "'s Inventory: ");
						for (String item : player.inventory) {
							System.out.println(item);
						}

						System.out.println("Item used this round: ");
						Scanner inUsedItem = new Scanner(System.in);
						String usedItem = inUsedItem.nextLine();
						player.takeitem(usedItem);

						System.out.println("Damage taken this round: ");
						Scanner damageInput = new Scanner(System.in);
						Integer damage = damageInput.nextInt();
						player.hit(damage);

					} else {

						liveMembers = liveMembers;

					}
				}

				System.out.println("MasterOnly: Input Q if concluded.");
				Scanner inGameover = new Scanner(System.in);
				String gameover = inGameover.nextLine();

				if (gameover.equals("Q") || liveMembers == 0) {
					ongoing = false;
				} else {
					ongoing = true;
				}

			}

			// Game Complete


			System.out.println("Here are the results of your game.");

			for (Integer player : roster.keySet()) {

				System.out.println(roster.get(player).name + "'s turn.");
				System.out.println(roster.get(player).name + "'s HP: " + roster.get(player).health);
				System.out.println(roster.get(player).name + "'s Nature: " + roster.get(player).nature);
				System.out.println(roster.get(player).name + "'s Ability: " + roster.get(player).ability);
				System.out.println(roster.get(player).name + "'s Inventory: ");
				for (String item : roster.get(player).inventory) {
					System.out.println(item);	
				}
				System.out.println(roster.get(player).name + " survived " + roster.get(player).turn + " turns.");
			}


			System.out.println("Congratulations on your completion. See you soon!");

	}
}
