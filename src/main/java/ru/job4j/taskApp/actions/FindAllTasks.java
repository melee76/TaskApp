package ru.job4j.taskApp.actions;

import ru.job4j.taskApp.service.TaskService;

import java.util.Scanner;

public class FindAllTasks implements Action {

    @Override
    public String name() {
        return "Показать все задачи";
    }

    @Override
    public void execute(Scanner scanner, TaskService taskService) {
        taskService.listTasks();
    }
}
