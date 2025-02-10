package org.javaacadmey.field_of_miracles;

import org.javaacadmey.field_of_miracles.player.Player;

import java.io.PrintStream;
import java.util.Scanner;

import static org.javaacadmey.field_of_miracles.Round.*;

public class Yakubovich {
    private static final String DIVIDE_PATTERN = ", ";

    public void start() {
        System.out.println("Здравствуйте, уважаемые дамы и господа! Пятница! В эфире капитал-шоу «Поле чудес»!");
    }

    public void end() {
        System.out.println("Мы прощаемся с вами ровно на одну неделю! Здоровья вам, до встречи!");
    }

    public void invitePlayers(Player[] players, int roundNumber) {
        if (roundNumber < FINAL_ROUND_INDEX.value) {
            greetingPlayers(players, roundNumber);
        } else if (FINAL_ROUND_INDEX.value == roundNumber) {
            finalGreetingPlayers(players);
        }
    }

    public void sayQuestion(String question) {
        System.out.printf("Внимание вопрос!\n %s", question);
    }

    public void winSpeak(Player player, boolean isFinalRound) {
        PrintStream printStream = isFinalRound ? finalWinText(player) : defaultWinText(player);
    }

    public void checkUserLetter(String userAnswer, String correctAnswer, Tableau tableau){
        if (correctAnswer.contains(userAnswer))  {
            System.out.println("Якубович: Есть такая буква, откройте ее!");
            tableau.openLetter(userAnswer);
        }
        else {
            System.out.println("Якубович: Нет такой буквы! Следующий игрок, крутите барабан!");
            System.out.println("__________________________________");
        }
        }

    private PrintStream defaultWinText(Player player) {
        return System.out.printf("Молодец! %s из %s проходит в финал!", player.getName(), player.getCity());
    }

    private PrintStream finalWinText(Player player) {
        return System.out.printf("""
                Якубович: И перед нами победитель Капитал шоу поле чудес! Это %s из %s"
                %n
                """, player.getName(), player.getCity());
    }

    private void greetingPlayers(Player[] players, int roundNumber) {
        String userNames = getUserNames(players);
        greetingPlayersHelper(roundNumber, userNames);
    }

    private void finalGreetingPlayers(Player[] players) {
        String userNames = getUserNames(players);
        finalPlayersGreetingHelper(userNames);
    }

    private void finalPlayersGreetingHelper(String userNames) {
        System.out.printf("Якубович: приглашаю победителей групповых этапов: %s через запятую", userNames);
    }

    private void greetingPlayersHelper(int roundNumber, String userNames) {
        System.out.printf("Якубович: приглашаю %s тройку игроков: %s", roundNumber, userNames);
    }

    private String getUserNames(Player[] players) {
        StringBuilder playersNames = new StringBuilder();
        for (Player player : players) {
            playersNames.append(player.getName().formatted(DIVIDE_PATTERN));
        }
        return playersNames.toString();
    }
}

