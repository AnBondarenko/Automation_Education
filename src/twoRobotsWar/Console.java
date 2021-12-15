package twoRobotsWar;

import java.util.Scanner;

public class Console {
    public static String getSymbolsFromConsole() {
        Scanner scanner = new Scanner(System.in);
return scanner.next();
}

public static class EnterRobotName extends Console {
    public static void printEnterRobotName() {
        System.out.println("Enter robot name:");

    }
}
    public static class BattleMenu extends Console {
        public static void printBattleMenu(Robot workWithRobot) {
            System.out.println("Exit game enter: L");
            System.out.println("Shot at robot: " + workWithRobot.getName());
            System.out.println("Your step: press key " + workWithRobot.getKeys());

        }
    }
}