package homeworks.hw3;

import java.util.Scanner;

public class CountChars {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string, plz");
        String str = scanner.nextLine();
        System.out.println("What symbol are you looking for?");
        char symbol = scanner.nextLine().charAt(0);
        System.out.println("Symbols " + symbol + " in string - " + countCharsRecursive(str, symbol));
        System.out.println("Symbols " + symbol + " in string - " + countCharsIterative(str, symbol));

    }
        public static int countCharsRecursive(String str, char symbol) {
            if (str.isEmpty()) {
                return 0;
            }
            int counter = (str.charAt(0) == symbol) ? 1 : 0;
            int counterRecursive = countCharsRecursive(str.substring(1), symbol);
            return counter + counterRecursive;
        }

        public static int countCharsIterative(String str, char symbol){
            int counter = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == symbol){
                    counter++;
                }
            }
            return counter;
        }
    }


