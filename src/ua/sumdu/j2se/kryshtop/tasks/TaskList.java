package ua.sumdu.j2se.kryshtop.tasks;

/**
 * Created by user on 08.12.2016.
 */
public abstract class TaskList {
    protected int size;

    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract Task getTask(int index);

    /**
     * To get number of records in the task list
     * @return number of records in this task list
     */
    public int size(){
        return this.size;
    }

    /**
     * To find tasks that is going to be executed at least one time in established time distance
     * @param from start of a time distance
     * @param to end of a time distance
     * @return subset of tasks that are planed for performance in established time distance at least one time
     */
    public ArrayTaskList incoming(int from, int to){
        ArrayTaskList incomingTaskList = new ArrayTaskList();
        for (int i=0; i < this.size(); i++) {
            if (this.getTask(i).nextTimeAfter(from) != -1 && this.getTask(i).nextTimeAfter(from) <= to ){
                incomingTaskList.add(this.getTask(i));
            }
        }
        return incomingTaskList;
    }
    //TODO: make an exception for incoming() - return NULL (if incomingTaskList is NULL)

 }
