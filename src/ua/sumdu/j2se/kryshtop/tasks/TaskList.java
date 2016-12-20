package ua.sumdu.j2se.kryshtop.tasks;


public abstract class TaskList {
    protected int size;

    public abstract void add(Task task) throws NullTaskException;

    public abstract boolean remove(Task task);

    public abstract Task getTask(int index) throws InvalidTaskIndexException;

    /**
     * To get number of records in the task list
     * @return number of records in this task list
     */
    public int size(){
        return size;
    }

    /**
     * To find tasks that is going to be executed at least one time in established time distance
     * @param from start of a time distance
     * @param to end of a time distance
     * @return subset of tasks that are planed for performance in established time distance at least one time
     */
    public ArrayTaskList incoming(int from, int to){
        ArrayTaskList incomingTaskList = new ArrayTaskList();
        for (int i=0; i < size(); i++) {
            if (getTask(i).nextTimeAfter(from) != -1 && getTask(i).nextTimeAfter(from) <= to ){
                incomingTaskList.add(getTask(i));
            }
        }
        return incomingTaskList;
    }
 }
