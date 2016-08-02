package com.charactertracker;

/**
 * Created by Uma Wu on 2016/7/7.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CharacterTracker {

    private static HashMap<Integer, Character> BuildRoster(Integer partySize) {

        Scanner custom = new Scanner(System.in);

        String inputName;
        String inputAbility;
        Character newChara;
        HashMap<Integer, Character> roster;

        roster = new HashMap<>();

        for (Integer count = 1; count <= partySize; count++) {
            System.out.println("Please enter the name of Player " + count + ".");
            inputName = custom.nextLine();

            System.out.println("Please enter the ability of Player " + count + ".");
            inputAbility = custom.nextLine();

            newChara = new Character(inputName, inputAbility);
            roster.put(count, newChara);

            System.out.println(inputName + " has been added to the roster.");
        }

        return roster;
    }

    public static void main(String[] args) {

        Integer partySize;
        HashMap<Integer, Character> roster;
        Boolean ongoing;
        Integer round;

        Scanner console = new Scanner(System.in);

        System.out.println("Please enter the size of your party.");

        partySize = console.nextInt();
        roster = BuildRoster(partySize);

        System.out.println("Game Start!");

        ongoing = true;
        round = 1;

        while (ongoing) {

            System.out.println("Round " + round);
            Integer liveMembers = 0;

            for (Integer playerNum : roster.keySet()) {

                Character player = roster.get(playerNum);

                if (player.hp > 0) {

                    liveMembers++;
                    player.addturn();

                    System.out.println(player.name + "'s turn.");
                    System.out.println(player.name + "'s HP: " + player.hp);
                    System.out.println(player.name + "'s Ability: " + player.ability);
                    System.out.println(player.name + "'s Inventory: ");
                    for (String item : player.inventory) {
                        System.out.println(item);
                    }

                    System.out.println("Item used this turn: ");
                    String usedItem = console.nextLine();
                    player.subitem(usedItem);

                    System.out.println("Item gained this turn: ");
                    String gainedItem = console.nextLine();
                    player.newitem(gainedItem);

                    System.out.println("Damage taken this turn: ");
                    Integer strike = console.nextInt();
                    player.hit(strike);

                } else {

                    liveMembers = liveMembers;

                }
            }

            System.out.println("MasterOnly: Input Q if concluded.");
            String gameover = console.nextLine();

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
            System.out.println(roster.get(player).name + "'s HP: " + roster.get(player).hp);
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
