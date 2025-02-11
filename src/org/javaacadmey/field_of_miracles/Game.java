package org.javaacadmey.field_of_miracles;

import org.javaacadmey.field_of_miracles.player.Player;

import java.util.Scanner;

public class Game {
    private static final int COUNT_PLAYERS = 3;
    private Round round;
    private static final Scanner scanner = new Scanner(System.in);
    private final String[] questions = new String[3];
    private final String[] answers = new String[3];
    private static final String initText = "Запуск игры Поле Чудес - подготовка к игре. Вам нужно ввести вопросы и ответы для игры";
    private static final String QUESTION_TEMPLATE = "Введите вопрос #%s\n";
    private static final String ANSWER_TEMPLATE = "Введите ответ на вопрос #%s\n";
    private Tableau tableau;
    private Yakubovich yakubovich;
    private Player[] winners;

    // TODO: //Внимание: на этапе написания приложения нужно будет неоднократно запускать приложение. Для того чтобы при запуске не вводить эти данные, можно после корректной реализации закомментировать метод из 5 пункта, и написать реализацию с уже созданными вопросами и ответами (зашитыми в коде).
    public void init() throws InterruptedException {
        System.out.println(initText);
        createQuestionsAndAnswers();
        System.out.println("Инициализация закончена, игра начнется через 5 секунд");
        Thread.sleep(5000);
        System.out.println("".repeat(50));
        this.yakubovich = new Yakubovich();

    }

    private void createQuestionsAndAnswers() {
        for (int i = 1; i <= 4; i++) {
            System.out.printf(QUESTION_TEMPLATE, i);
            fill(questions, scanner.nextLine());
            System.out.printf(ANSWER_TEMPLATE, i);
            fill(answers, scanner.nextLine());
        }
    }

    private void fill(String[] arrayType, String value) {
        for (int i = 0; i < arrayType.length; i++) {
            if (questions[i] == null) {
                questions[i] = value;
            }
        }
    }

    public Player[] createPlayers(Scanner scanner) {
        System.out.println("Инициализация игроков..");
        Player[] players = new Player[COUNT_PLAYERS];
        for (int i = 0; i < COUNT_PLAYERS; i++) {
            System.out.printf("Игрок №%s Введите своё имя и город :", i + 1);
            String[] split = scanner.nextLine().split(",");
            Player player = new Player(split[0], split[1]);
            players[i] = player;
        }
        return players;
    }

    private String[] getPlayersNames(Player[] players) {
        String[] names = new String[COUNT_PLAYERS];
        for (Player player : players) {
            String name = player.getName();
            for (int i = 0; i < names.length; i++) {
                names[i] = name;
            }
        }
        return names;
    }

    private boolean isWin() {
        return tableau.checkTableauFill();
    }

    public boolean playerTurn(Scanner question, Player player) {
        if (isWin()) {
            String playerAnswer = player.turn(scanner);
            tableau.openLetter(playerAnswer);
            tableau.displayLetter();
            return true;
        } else {
            return false;
        }
    }


    //
//5) Этап: Создание логики игры
//1. Создать поле winners - победители первых трех раундов.
//            2. Создать метод который создает игроков. В Консоль выводится: "Игрок №1 представьтесь: имя,город. Например: Иван,Москва".
//    Считываете ответ из консоли и создаете игрока. В результате создается массив из трех игроков, который возвращается.
//            3. Создать метод который вытащит все имена игроков в массив.
//4. Создать метод проверки табло: если табло полностью заполнено, тогда возвращать истину. По сути это означает, что игрок победил.
//            5. Создать метод хода игрока (на вход вопрос и игрок), на выход булево:
//    игрок ходит до тех пор, пока он либо не выиграл (возвращается истина), либо не ошибся (возвращается ложь).
//    Если игрок отгадал букву, то должно появится обновленное табло.
//            6. Создать метод "сыграть раунд": игроки ходят по очереди и пытаются отгадать вопрос, до победы одно из игроков. Если игрок победил в не финальном раунде, то заносится в массив победителей. Когда победитель найден, якубович кричит о победе.
//            7. создать метод "сыграть все групповые раунды":
//    Играются три раунда.
//    В каждом раунде создаются игроки.
//    На табло добавляется ответ.
//    Якубович приглашает игроков.
//    Якубович спрашивает вопрос.
//    Появляется табло.
//    Играется групповой раунд.
//8. Создать метод "сыграй финальный раунд"
//    На табло добавляется ответ.
//    Якубович приглашает победителей.
//    Якубович спрашивает вопрос.
//    Появляется табло.
//    Играется финальный раунд.
}
