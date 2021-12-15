package twoRobotsWar;

import java.util.Random;

public class Robot {
    private String name;
    public String keys = "(QWEASDZXCL)";
    private String alphabet = "QWEASDZXCL";
    private String damageKeys = "";
    private int health = 100;


    public Robot(String name) {
        this.name = name;
        for (int i = 0; i < 5; i++) {
            damageKeys = damageKeys + getRandomKey();

        }

    }
public String getName(){
        return this.name;
    }

    public String getKeys(){
        return this.keys;
    }
    public int getHealth(){
        return this.health;
    }
    public String getDamageKeys(){
        return this.damageKeys;
    }

    public String getAlphabet(){
        return this.alphabet;
    }

  //  public String setDamageKeys(){
        //return this.damageKeys;
   // }

char getRandomKey(){
int randIdx = new Random().nextInt(alphabet.length());
char randChar = alphabet.charAt(randIdx);
alphabet = alphabet.replace(String.valueOf(randChar), "");
return randChar;
   }
}




