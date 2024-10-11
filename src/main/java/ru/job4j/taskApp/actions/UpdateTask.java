package ru.job4j.taskApp.actions;

import ru.job4j.taskApp.service.TaskService;

import java.util.Scanner;

public class UpdateTask implements Action {

    @Override
    public String name() {
        return "Редактировать задачу";
    }

    @Override
    public void execute(Scanner scanner, TaskService taskService) {
        taskService.editTask(scanner);
    }
}
