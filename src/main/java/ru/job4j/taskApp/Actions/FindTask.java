package ru.job4j.taskApp.Actions;

import ru.job4j.taskApp.service.TaskService;

import java.util.Scanner;

public class FindTask implements Action {

    @Override
    public String name() {
        return "Найти задачу по имени";
    }

    @Override
    public void execute(Scanner scanner, TaskService taskService) {
        taskService.searchTask(scanner);
    }
}
