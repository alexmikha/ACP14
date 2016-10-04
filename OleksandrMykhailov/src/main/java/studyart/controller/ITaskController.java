package studyart.controller;

import studyart.exception.AppException;
import studyart.exception.InvalidTaskPathException;
import studyart.exception.TaskNotFoundException;
import studyart.model.Task;

/**
 * Created by mi on 04.09.16.
 */
public interface ITaskController {

    Task addTask(String title, String taskPath) throws AppException;

    Task getTaskById(long taskId) throws TaskNotFoundException;

    boolean checkTask(String path) throws InvalidTaskPathException;


}
