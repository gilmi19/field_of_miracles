package org.javaacadmey.field_of_miracles.player;

import java.util.Scanner;

public class PlayerAnswer {
    private String wordType;
    private String letterType;
    private String answer;

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    public String getLetterType() {
        return letterType;
    }

    public void setLetterType(String letterType) {
        this.letterType = letterType;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
//4. Создать класс PlayerAnswer (ответ игрока), содержащий два поля - тип ответа(слово или буква) и сам ответ.
//5. Игрок умеет ходить.
// Вывод на экран: "Ход игрока имя, город"
// Для этого в консоле печатается: "Если хотите букву нажмите 'б' и enter, если хотите слово нажмите 'c' и enter".
// После ввода типа ответа, вызываются соответствующие методы.
// Введенные данные внести в PlayerAnswer и вернуть как результат работы метода.
// В случае неверного ввода, вывести "Некорректное значение, введите 'б' или 'с'", и снова запросить значение.