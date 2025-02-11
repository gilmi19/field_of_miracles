package org.javaacadmey.field_of_miracles.player;

import org.javaacadmey.field_of_miracles.exception.UserInputException;

import java.util.Scanner;

public class Player {
    private final String name;
    private final String city;
    private PlayerAnswer playerAnswer = new PlayerAnswer();
    private final static String RUSSIAN_ALPHABET = "йцукенгшщзхъфывапролджэячсмитьбюё";

    public Player(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String turn(Scanner scanner) {
        displayInfo();
        while (true) {
            switch (scanner.next()) {
                case "б" -> {
                    while (true) {
                        System.out.println("Введите букву:");
                        try {
                            String letter = sayLetter(scanner);
                            return addLetter(letter);
                        } catch (UserInputException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                case "с" -> {
                    System.out.println("Введите слово:");
                    String word = sayWord(scanner);
                    return addWord(word);
                }
                default -> {
                    uncorrectChoiceMessage();
                }
            }
        }
    }

    private String sayLetter(Scanner userInput) throws UserInputException {
        while (true) {
            String letter = userInput.next();
            checkLetterInput(letter);
            return letter;
        }
    }

    private String sayWord(Scanner userInput) {
        System.out.printf("Игрок %s: %s", name, userInput.next());
        return userInput.nextLine();
    }

    private String addLetter(String letter) throws UserInputException {
        playerAnswer.setLetterType(letter);
        return letter;
    }

    private String addWord(String word) {
        playerAnswer.setWordType(word);
        return word;
    }

    private void displayInfo() {
        System.out.printf("Ход игрока %s, %s", name, city);
        System.out.println("\nЕсли хотите букву нажмите \'б\' и enter, если хотите слово нажмите \'c\' и enter");
    }

    private void uncorrectChoiceMessage() {
        System.out.println("Некорректное значение, введите \'б\' или \'с\'");
    }

    private void checkLetterInput(String letter) throws UserInputException {
        if (letter.length() > 1 || !RUSSIAN_ALPHABET.contains(letter)) {
            throw new UserInputException("Ошибка! это не русская буква, введите русскую букву!");
        }
    }

    //getters

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}