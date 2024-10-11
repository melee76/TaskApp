package ru.job4j.taskApp.repo;

import ru.job4j.taskApp.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public Task addTask(String name, String description) {
        /*код**/
    }

    public Optional<Task> getTaskById(int id) {
        /*код**/
    }

    public List<Task> getAllTasks() {
        /*код**/
    }

    public void deleteTask(Task task) {
        /*код**/
    }

    public List<Task> findByName(String name) {
        /*код**/
    }
}
