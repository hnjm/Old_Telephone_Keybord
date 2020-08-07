package com.OldKeybord;
import java.util.Scanner;

public class converter {
    private static final String[] letters = {
            "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"
    };

    private static char getChar(int digit, int count) {
        while (count > letters[digit].length()) {
            count -= letters[digit].length();
        }

        return letters[digit].charAt(count - 1);
    }

    private static String getString(String input) {
        int lastDigit = 0, count = 1;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = input.charAt(i) - '0';
            if (currentDigit >= 2 && currentDigit <= 9) {
                if (lastDigit == 0) {
                    lastDigit = currentDigit;
                } else if (currentDigit == lastDigit) {
                    count++;
                } else {
                    result.append(getChar(lastDigit, count));

                    lastDigit = currentDigit;
                    count = 1;
                }
            }
        }

        return result.toString() + getChar(lastDigit, count);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Write something");
            System.out.println(getString(scanner.nextLine()));
        }
    }
}
