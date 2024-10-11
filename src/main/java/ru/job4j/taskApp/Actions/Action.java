package ru.job4j.taskApp.Actions;

import ru.job4j.taskApp.service.TaskService;

import java.util.Scanner;

public interface Action {
    String name();
    void execute(Scanner scanner, TaskService taskService);
}
