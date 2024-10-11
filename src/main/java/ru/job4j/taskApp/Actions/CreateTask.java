package ru.job4j.taskApp.Actions;

import ru.job4j.taskApp.service.TaskService;

import java.util.Scanner;

public class CreateTask implements Action {
    @Override
    public String name() {
        return "Добавить задачу";
    }

    @Override
    public void execute(Scanner scanner, TaskService taskService) {
        taskService.addTask(scanner);
    }
}
