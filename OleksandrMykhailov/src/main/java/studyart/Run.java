package studyart;

import studyart.controller.ITaskController;
import studyart.controller.TaskControllerImpl;
import studyart.db.Database;
import studyart.exception.InvalidTaskPathException;
import studyart.utils.bash.BashImpl;
import studyart.utils.dymanic.core.ExecutionCore;
import studyart.utils.dymanic.core.ExecutionCoreImpl;

/**
 * Created by mi on 04.09.16.
 */
public class Run {

    public static final String TASK_PATH = "/ACP14/resources/alex.mykhailov/Task1.java";
    public static final String PERFORMED_TASK_PATH = "/ACP14/resources/alex.mykhailov/Task1Performed.java";

    public static void main(String[] args) {
        Database database = new Database();
        database.add("title", TASK_PATH);

        ExecutionCore executionCore = new ExecutionCoreImpl(new BashImpl());

        ITaskController taskController = new TaskControllerImpl(database, executionCore);

        try {
            taskController.checkTask(PERFORMED_TASK_PATH);
        } catch (InvalidTaskPathException e) {
            e.printStackTrace();
        }
    }
}
