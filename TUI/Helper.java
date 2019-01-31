package TUI;

import java.util.Scanner;
public final class Helper {
    
    public static String readInput(String question) {
        System.out.print(question + ": ");
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
    
    public static int readInt(String question) {
        System.out.print(question + ": ");
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
}
