package twoRobotsWar;

import java.util.ArrayList;
import java.util.Locale;

public class MainClass {
    public static void main(String[] args) {
        String robotName;
        String enteredLetter;


        Console.EnterRobotName.printEnterRobotName();
        robotName = Console.getSymbolsFromConsole();
        String letterForExit = "L";

        Robot robot1 = new Robot(robotName);
        int robot1Health = robot1.getHealth();
        String demageKeysForRobot1 =  robot1.getDamageKeys();

        System.out.println(robotName);
        System.out.println(robot1.getDamageKeys());
        System.out.println(robot1.getAlphabet());

        Console.EnterRobotName.printEnterRobotName();
        robotName = Console.getSymbolsFromConsole();

        Robot robot2 = new Robot(robotName);
        int robot2Health = robot2.getHealth();
        String demageKeysForRobot2 =  robot2.getDamageKeys();
        System.out.println(robotName);
        ArrayList<Robot> robots = new ArrayList<Robot>();
        robots.add(0, robot1);
        robots.add(1, robot2);


        do {
           Console.BattleMenu.printBattleMenu(robot2);
          enteredLetter = Console.getSymbolsFromConsole();
           System.out.println(enteredLetter);
           if (demageKeysForRobot1.contains(enteredLetter.toUpperCase(Locale.ROOT))){
              robot2Health = robot2Health - 20;
              demageKeysForRobot1 = demageKeysForRobot1.replaceAll(enteredLetter.toUpperCase(), " ");
               System.out.println(demageKeysForRobot1);
              System.out.println(robot2Health);
              System.out.println("Good shot! ");
               System.out.println("-------");
               System.out.println(robot1.getName() + ", " + robot1Health);
               System.out.println(robot2.getName() + ", " + robot2Health);
               System.out.println("-------");
              } else if (robot1.getAlphabet().contains(enteredLetter.toUpperCase(Locale.ROOT))){
               System.out.println("-------");
               System.out.println("You missed!");
               System.out.println("-------");
           } else if (!robot1.getKeys().contains(enteredLetter.toUpperCase(Locale.ROOT))){
               System.out.println("-------");
               System.out.println("This letter can't be used");
               System.out.println("-------");
           } else if (robot2Health==0) {
               System.out.println(robot2.getName() + " was killed");
               System.out.println(robot1.getName() + " won!");
               break;

           }
     } while (!enteredLetter.equalsIgnoreCase(letterForExit));




    }
}
