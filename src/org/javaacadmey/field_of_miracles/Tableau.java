package org.javaacadmey.field_of_miracles;

import java.util.Arrays;

public class Tableau {
    private String answer;
    private String[] letters;
    private final String unguessedLetter = "_";

    public void init(String correctAnswer) {
        this.answer = correctAnswer;
        this.letters = new String[correctAnswer.length()];
    }

    public void displayLetter() {
        StringBuilder tableua = new StringBuilder("ТАБЛО: ");
        for (String letter : letters) {
            tableua.append(check() ? "_" : letter.toUpperCase());
        }
    }

    public void openLetter(String letter) {
        String[] answerByArray = answer.split("");
        for (int i = 0; i < answerByArray.length; i++) {
            if (answerByArray[i].equals(letter)) {
                letters[i] = letter;
            }
        }
    }

    public void openWord() {
        letters = answer.split("");
    }

    private boolean check() {
        for (String letter : letters) {
            if (letter == null) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTableauFill() {
        for (String letter : letters) {
            if (letter != null) {
                return true;
            }
        }
        return false;
    }
}
