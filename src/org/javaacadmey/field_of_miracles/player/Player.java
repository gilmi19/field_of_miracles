package org.javaacadmey.field_of_miracles.player;

import org.javaacadmey.field_of_miracles.exception.UserInputException;

import java.util.Scanner;

public class Player {
    private final String name;
    private final String city;
    private PlayerAnswer playerAnswer = new PlayerAnswer();

    public Player(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String turn(Scanner scanner) {
        displayInfo();
        while (true) {
            switch (scanner.next()) {
                case "б" -> {
                    return addLetterHelper(scanner);
                }
                case "с" -> {
                    addWordHelper(scanner);
                }
                default -> {
                    uncorrectChoiceMessage();
                }
            }
        }
    }

    private void uncorrectChoiceMessage() {
        System.out.println("Некорректное значение, введите \'б\' или \'с\'");
    }

    private String addWordHelper(Scanner scanner) {
        while (true) {
            System.out.println("Введите слово:");
            return addWord(scanner);
        }
    }

    private String addLetterHelper(Scanner scanner) {
        while (true) {
            System.out.println("Введите букву:");
            try {
                return addLetter(scanner);
            } catch (UserInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String addWord(Scanner scanner) {
        String word = sayWord(scanner);
        String subStringPlayerWord = subStringPlayerWord(word);
        playerAnswer.setWordType(subStringPlayerWord);
        return word;
    }

    private String addLetter(Scanner scanner) throws UserInputException {
        while (true) {
            String letter = sayLetter(scanner);
            playerAnswer.setLetterType(letter);
            return letter;
        }
    }

    private void displayInfo() {
        System.out.printf("Ход игрока %s, %s", name, city);
        System.out.println("\nЕсли хотите букву нажмите \'б\' и enter, если хотите слово нажмите \'c\' и enter");
    }

    private String sayLetter(Scanner userInput) throws UserInputException {
        while (true) {
            String letter = userInput.next();
            if (letter.length() > 1) {
                throw new UserInputException("Ошибка! это не русская буква, введите русскую букву!");
            } else {
                return letter;
            }
        }
    }

    private String sayWord(Scanner userInput) {
        return "Игрок %s: %s".formatted(name, userInput.next());
    }

    private String subStringPlayerWord(String word) {
        return word.substring(word.indexOf(":") + 2);
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public PlayerAnswer getPlayerAnswer() {
        return playerAnswer;
    }

    public void setPlayerAnswer(PlayerAnswer playerAnswer) {
        this.playerAnswer = playerAnswer;
    }
}