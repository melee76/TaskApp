package ru.job4j.taskApp.repo;

import ru.job4j.taskApp.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public Task addTask(String name, String description) {
        Task task = new Task(nextId++, name, description);
        tasks.add(task);
        return task;
    }

    public Optional<Task> getTaskById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst();
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> findByName(String name) {
        List<Task> foundTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getName().equalsIgnoreCase(name)) {
                foundTasks.add(task);
            }
        }
        return foundTasks;
    }
}
