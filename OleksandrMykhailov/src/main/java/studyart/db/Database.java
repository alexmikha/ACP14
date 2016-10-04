package studyart.db;

import studyart.model.Task;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mi on 04.09.16.
 */
public class Database {

    private static long nextId = 0;

    private Map<Long, Task> taskMap;

    public Database() {
        taskMap = new TreeMap<>();
    }

    public Task add(String title, String path) {
        Task task = new Task(nextId, title, path);
        taskMap.put(nextId, task);
        nextId++;
        return task;
    }

    public Task getTaskById(long id) {
        return taskMap.get(id);
    }

    public Collection<Task> getAll() {
        return taskMap.values();
    }
}
