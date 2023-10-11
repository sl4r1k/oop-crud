package ru.rsue.slarionov.oopcrud;

import ru.rsue.slarionov.oopcrud.controller.CommandLineController;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        CommandLineController clc = new CommandLineController();
        while (true) {
            System.out.println("\nКоманды:\n" +
                "1: Добавить ученика\n" +
                "2: Прочитать ученика по id\n" +
                "3: Прочитать всех учеников\n" +
                "4: Удалить ученика по id\n" +
                "5: Добавить учителя\n" +
                "6: Прочитать учителя по id\n" +
                "7: Прочитать всех учителей\n" +
                "8: Удалить учителя по id\n" +
                "9: Добавить занятие\n" +
                "10: Прочитать занятие по id\n" +
                "11: Получить все занятия\n" +
                "12: Загрузить занятия из json файла");
            clc.accept(scanner.nextLine());
        }
    }
}
