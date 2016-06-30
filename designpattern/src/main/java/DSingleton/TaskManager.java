package DSingleton;

/**
 * @ClassName: TaskManager
 * @Description: 
 * @author ZXY
 * @date 2016/5/17 13:32
 */
class TaskManager {

    private TaskManager taskManager = null;

    TaskManager getInstance(){
        if(taskManager == null){
            taskManager = new TaskManager();
        }
        return taskManager;
    }
}
