package studyart.controller;

import studyart.db.Database;
import studyart.exception.AppException;
import studyart.exception.InvalidTaskPathException;
import studyart.exception.TaskNotFoundException;
import studyart.model.Task;
import studyart.utils.dymanic.core.ExecutionCommandException;
import studyart.utils.dymanic.core.ExecutionCore;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by mi on 04.09.16.
 */
public class TaskControllerImpl implements ITaskController {

    private Database database;
    private ExecutionCore executionCore;

    public TaskControllerImpl(Database database, ExecutionCore core) {
        this.database = database;
        this.executionCore = core;
    }

    @Override
    public Task addTask(String title, String taskPath) throws AppException {
        if (!Files.exists(Paths.get(taskPath))) {
            throw new InvalidTaskPathException("no task with path " + taskPath);
        }

        Task created = database.add(title, taskPath);

        return created;
    }

    @Override
    public Task getTaskById(long taskId) throws TaskNotFoundException {
        Task task = database.getTaskById(taskId);

        if (task == null) {
            throw new TaskNotFoundException("No task with id " + taskId);
        }

        return task;
    }

    @Override
    public boolean checkTask(String path) throws InvalidTaskPathException {

        if (!Files.exists(Paths.get(path))) {
            throw new InvalidTaskPathException("no task with path " + path);
        }

        String compiledPath = executionCore.compile(path);
        try {
            String result = executionCore.execute(compiledPath);
            return true;
        } catch (ExecutionCommandException e) {
            e.printStackTrace();
        }

        return false;
    }
}
