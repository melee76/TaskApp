package ru.job4j.taskApp;

import ru.job4j.taskApp.actions.*;
import ru.job4j.taskApp.repo.TaskRepository;
import ru.job4j.taskApp.service.TaskService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskManagerApp {

    private final TaskService taskService;
    private final List<Action> actions;

    public TaskManagerApp(TaskService taskService, List<Action> actions) {
        this.taskService = taskService;
        this.actions = actions;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice > 0 && choice <= actions.size()) {
                actions.get(choice - 1).execute(scanner, taskService);
            } else if (choice != 6) {
                System.out.println("Неверный пункт меню. Пожалуйста, попробуйте снова.");
            }
        } while (choice != 6);

        System.out.println("Выход из программы...");
    }

    private void showMenu() {
        System.out.println("\nМеню:");
        for (int i = 0; i < actions.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, actions.get(i).name());
        }
        System.out.println("6. Выход");
        System.out.print("Выберите пункт меню: ");
    }

    public static void main(String[] args) {
        TaskService taskService = new TaskService(new TaskRepository());
        List<Action> actions = Arrays.asList(
                new CreateTask(),
                new UpdateTask(),
                new DeleteTask(),
                new FindAllTasks(),
                new FindTask()
        );

        TaskManagerApp app = new TaskManagerApp(taskService, actions);
        app.run();
    }
}
