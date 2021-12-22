package twoRobotsWar;

import java.util.ArrayList;
import java.util.Locale;

public class MainClass {
    public static void main(String[] args) {
        String robotName;
        String enteredLetter;
        String letterForExit = "L";
        boolean exitGame = false;

        Console.EnterRobotName.printEnterRobotName();
        robotName = Console.getSymbolsFromConsole();
        Robot robot1 = new Robot(robotName);

        Console.EnterRobotName.printEnterRobotName();
        robotName = Console.getSymbolsFromConsole();
        Robot robot2 = new Robot(robotName);

        ArrayList<Robot> robots = new ArrayList<Robot>();
        robots.add(0, robot1);
        robots.add(1, robot2);

        do {
            Robot workingRobot;
            for (int i = 0; i < robots.size(); i++) {
                workingRobot = robots.get(i);
                Console.BattleMenu.printBattleMenu(workingRobot);
                enteredLetter = Console.getSymbolsFromConsole();
                String getFirstSymbol = enteredLetter.substring(0, 1);

                if (getFirstSymbol.equalsIgnoreCase(letterForExit)) {
                    exitGame = false;
                    break;

                } else if (workingRobot.getDamageKeys().contains(getFirstSymbol.toUpperCase())) {
                    workingRobot.damageAction(getFirstSymbol);
                    System.out.println("Good shot! ");
                    System.out.println("-------");
                    System.out.println(robot1.getName() + ", " + robot1.getHealth());
                    System.out.println(robot2.getName() + ", " + robot2.getHealth());
                    System.out.println("-------");

                } else if (workingRobot.getKeys().contains(getFirstSymbol.toUpperCase(Locale.ROOT))) {
                    System.out.println("-------");
                    System.out.println("You missed!");
                    System.out.println("-------");

                } else if (!workingRobot.getKeys().contains(getFirstSymbol.toUpperCase(Locale.ROOT))) {
                    System.out.println("-------");
                    System.out.println("This letter can't be used");
                    System.out.println("-------");
                }

                if (robot1.getHealth() == 0) {
                    System.out.println(robot1.getName() + " was killed.");
                    System.out.println(robot2.getName() + " won!");
                    exitGame = false;
                    break;
                }

                if (robot2.getHealth() == 0) {
                    System.out.println(robot2.getName() + " was killed.");
                    System.out.println(robot1.getName() + " won!");
                    exitGame = false;
                    break;
                }
                exitGame = (!getFirstSymbol.equalsIgnoreCase(letterForExit));
            }
        } while (exitGame);
    }
}


