package ru.job4j.taskApp;

import ru.job4j.taskApp.service.TaskService;

import java.util.Scanner;

public class TaskManagerApp {
    private static TaskService taskService = new TaskService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            handleUserChoice(choice, scanner);
        } while (choice != 6);
    }

    private static void showMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Редактировать задачу");
        System.out.println("3. Удалить задачу");
        System.out.println("4. Показать все задачи");
        System.out.println("5. Найти задачу по имени");
        System.out.println("6. Выход");
        System.out.print("Выберите пункт меню: ");
    }

    private static void handleUserChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                taskService.addTask(scanner);
                break;
            case 2:
                taskService.editTask(scanner);
                break;
            case 3:
                taskService.deleteTask(scanner);
                break;
            case 4:
                taskService.listTasks();
                break;
            case 5:
                taskService.searchTask(scanner);
                break;
            case 6:
                System.out.println("Выход из программы...");
                break;
            default:
                System.out.println("Неверный пункт меню. Пожалуйста, попробуйте снова.");
        }
    }
}
