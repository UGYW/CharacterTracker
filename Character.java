package com.charactertracker;

/**
 * Created by Uma Wu on 2016/7/7.
 */

import java.util.ArrayList;

public class Character {
    String name;
    Integer hp;
    String ability;
    ArrayList<String> inventory;
    Integer turn;

    public Character (String inputName, String inputAbility) {
        this.name = inputName;
        this.hp = 20;
        this.ability = inputAbility;
        this.inventory = new ArrayList<String>();
        this.turn = 0;
    }

    public void hit(Integer damage) {
        this.hp = this.hp - damage;
    }

    public void newitem(String itemName) {
        this.inventory.add(itemName);
    }

    public void subitem(String itemName) {

        ArrayList<String> newInventory = new ArrayList<String>();

        for (String item : inventory) {

            if (!itemName.equals(item)) {
                newInventory.add(item);
            } else {
                newInventory = newInventory;
            }
            inventory = newInventory;
        }
    }

    public void addturn() {
        this.turn++;
    }
}
