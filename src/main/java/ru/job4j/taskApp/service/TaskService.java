package ru.job4j.taskApp.service;

import ru.job4j.taskApp.model.Task;
import ru.job4j.taskApp.repo.TaskRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TaskService {
    private TaskRepository taskRepository = new TaskRepository();

    public void addTask(Scanner scanner) {
        System.out.print("Введите имя задачи: ");
        String name = scanner.nextLine();
        System.out.print("Введите описание задачи: ");
        String description = scanner.nextLine();

        Task task = taskRepository.addTask(name, description);
        System.out.println("Задача добавлена: " + task);
    }

    public void editTask(Scanner scanner) {
        System.out.print("Введите ID задачи для редактирования: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Optional<Task> taskOptional = taskRepository.getTaskById(id);
        if (taskOptional.isPresent()) {
            System.out.print("Введите новое имя задачи: ");
            String newName = scanner.nextLine();
            System.out.print("Введите новое описание задачи: ");
            String newDescription = scanner.nextLine();

            Task task = taskOptional.get();
            task.setName(newName);
            task.setDescription(newDescription);
            System.out.println("Задача обновлена: " + task);
        } else {
            System.out.println("Задача с таким ID не найдена.");
        }
    }

    public void deleteTask(Scanner scanner) {
        System.out.print("Введите ID задачи для удаления: ");
        int id = scanner.nextInt();

        Optional<Task> taskOptional = taskRepository.getTaskById(id);
        if (taskOptional.isPresent()) {
            taskRepository.deleteTask(taskOptional.get());
            System.out.println("Задача удалена.");
        } else {
            System.out.println("Задача с таким ID не найдена.");
        }
    }

    public void listTasks() {
        List<Task> tasks = taskRepository.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("Задач нет.");
        } else {
            System.out.println("Список всех задач:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void searchTask(Scanner scanner) {
        System.out.print("Введите имя задачи для поиска: ");
        String name = scanner.nextLine();

        List<Task> foundTasks = taskRepository.findByName(name);
        if (foundTasks.isEmpty()) {
            System.out.println("Задачи с таким именем не найдены.");
        } else {
            System.out.println("Найденные задачи:");
            for (Task task : foundTasks) {
                System.out.println(task);
            }
        }
    }
}
