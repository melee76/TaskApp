package ru.job4j.taskApp.actions;

import ru.job4j.taskApp.service.TaskService;

import java.util.Scanner;

public class DeleteTask implements Action{

    @Override
    public String name() {
        return "Удалить задачу";
    }

    @Override
    public void execute(Scanner scanner, TaskService taskService) {
        taskService.deleteTask(scanner);
    }
}
