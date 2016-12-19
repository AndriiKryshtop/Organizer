package ua.sumdu.j2se.kryshtop.tasks;

/**
 * This class consist from array of tasks and methods that operate on it.
 * @version 2.1
 * @author Kryshtop Andrii
 * @see Task
 **/
public class ArrayTaskList extends TaskList {
    private Task taskList[] = new Task[10];

    public void add(Task task){
        System.out.println("Trying to add task: " + task.getTitle());
        if (this.size() == this.taskList.length){
            sizeChange(this.size() + (this.size()/4));
        }
        System.out.println("if statement complete");
        this.taskList[this.size()] = task;
        System.out.println("Try: " + taskList[this.size()].getTitle());
        System.out.println("task add, trying size++");
        this.size++;
        System.out.println("size is " + size);
    }

    /**
     * To remove task from the list
     * @param task task to remove
     * @return true if task was in the list or false if it was not
     */
    public boolean remove(Task task){
        int i=0;
        while (i < this.size()) {
            if (this.taskList[i] == task) {
                Task tempArray[] = new Task[this.taskList.length];
                System.arraycopy(this.taskList, 0, tempArray, 0, this.taskList.length);
                System.arraycopy(tempArray, i+1, this.taskList, i, this.taskList.length - (i+1));

                if (this.size() < (this.taskList.length - 10)) {
                    sizeChange(this.size() - (this.size-10));
                }

                size--;
                return true;
            }
            i++;
        }
        return false;
    }

    public Task getTask(int index){
        return this.taskList[index];
    }
    //TODO: make an exception for getTask - going beyond the bounds of the array
    //TODO: make an exception for getTask - taskList[index] can return NULL

    /**
     * To change size of task list
     * @param newSize new size of the task list
     */
    private void sizeChange(int newSize){
        Task tempArray[] = new Task[newSize];
        int numberOfElements;

        if(newSize < this.taskList.length) numberOfElements = newSize;
        else numberOfElements = this.taskList.length;
        System.arraycopy(this.taskList, 0, tempArray, 0, numberOfElements);
        this.taskList = tempArray;
    }
    //TODO: make an exception for arraySizeChange() - going beyond the bounds of the array
    //TODO      (if newSize is smaller then number of tasks in taskList)
}

