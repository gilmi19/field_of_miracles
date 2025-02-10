package org.javaacadmey.field_of_miracles;

import org.javaacadmey.field_of_miracles.exception.UserInputException;
import org.javaacadmey.field_of_miracles.player.Player;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//
//        for (int i = 1; i <= 4; i++) {
//            System.out.printf("Введите вопрос #%s\n", i);
//            System.out.println(scanner.nextLine());
//            System.out.printf("Введите ответ на вопрос #%s\n", i);
//            System.out.println(scanner.nextLine());
//        }
//        String s = "answer";
//        String substring = s.substring(1);
//        String substring1 = s.substring(0, 1);
//        System.out.println(substring);
//        System.out.println(substring1);
//
//        for (int i = 0; i < s.length(); i++) {
//            char[] charArray = s.substring(i, i + 1).toCharArray();
//            System.out.println(Arrays.toString(charArray));
//
//
//        }
//        System.out.println("Если хотите букву нажмите \'б\' и enter, если хотите слово нажмите \'c\' и enter");
//        System.out.println("Введите букву:");
//        System.out.println("Ваша буква: " + shoutLetter(scanner));
        Player player = new Player("Vasily", "Moscow");
         player.turn(scanner);
//        String word = "Карандаш";
//        String formatted = "Игрок %s: %s".formatted(player.getName(), word);
//        String subStringPlayerWord = subStringPlayerWord(formatted, player);
//        System.out.println(subStringPlayerWord);
    }

    public static String subStringPlayerWord(String word, Player player) {
        return word.substring(word.indexOf(":") + 2);
    }

    private static String shoutLetter(Scanner scanner) {
        while (true) {
            try {
                String letter = scanner.next();
                if (letter.length() > 1) {
                    throw new UserInputException("Ошибка! это не русская буква, введите русскую букву!");
                } else {
                    return letter;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


}

