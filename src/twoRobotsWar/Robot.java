package twoRobotsWar;

import java.util.Random;

public class Robot {
    private String name;
    public String keys = "(QWEASDZXC)";
    private String alphabet = "QWEASDZXC";
    private String damageKeys = "";
    private int health = 100;

    public void damageAction(String getFirstSymbol) {
        health = health - 20;
        damageKeys = damageKeys.replaceAll(getFirstSymbol.toUpperCase(), "");
    }


    public Robot(String name) {
        this.name = name;
        for (int i = 0; i < 5; i++) {
            damageKeys = damageKeys + getRandomKey();
        }
    }

    public String getName() {
        return this.name;
    }

    public String getKeys() {
        return this.keys;
    }

    public int getHealth() {
        return this.health;
    }

    public String getDamageKeys() {
        return this.damageKeys;
    }

    char getRandomKey() {
        int randIdx = new Random().nextInt(alphabet.length());
        char randChar = alphabet.charAt(randIdx);
        alphabet = alphabet.replace(String.valueOf(randChar), "");
        return randChar;
    }
}




