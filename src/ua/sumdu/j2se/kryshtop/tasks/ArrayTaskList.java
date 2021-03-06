package ua.sumdu.j2se.kryshtop.tasks;

import ua.sumdu.j2se.kryshtop.tasks.Exceptions.InvalidTaskIndexException;
import ua.sumdu.j2se.kryshtop.tasks.Exceptions.NullTaskException;

import java.util.Iterator;

/**
 * This class consist from array of tasks and methods that operate on it.
 * @version 2.1
 * @author Kryshtop Andrii
 * @see Task
 **/
public class ArrayTaskList extends TaskList {
    private Task taskList[] = new Task[20];

    public void add(Task task) throws NullTaskException {
        if(task == null) throw new NullTaskException("Task == null");

        if (size() == taskList.length){
            sizeChange(size() + (size()/4));
        }
        taskList[size()] = task;
        size++;
    }

    /**
     * To remove task from the list
     * @param task task to remove
     * @return true if task was in the list or false if it was not
     */
    public boolean remove(Task task){
        int i=0;
        while (i < size()) {
            if (taskList[i] == task) {
                Task tempArray[] = new Task[taskList.length];
                System.arraycopy(taskList, 0, tempArray, 0, taskList.length);
                System.arraycopy(tempArray, i+1, taskList, i, taskList.length - (i+1));

                if (size() < (taskList.length - (taskList.length / 4)) && taskList.length > 20) {
                    sizeChange(size() - (size() / 4));
                }

                size--;
                return true;
            }
            i++;
        }
        return false;
    }

    public Task getTask(int index)throws InvalidTaskIndexException {
        if((index < 0) || (index > (size-1))) throw new InvalidTaskIndexException("Wrong index");

        return taskList[index];
    }

    /**
     * To change size of task list
     * @param newSize new size of the task list
     */
    private void sizeChange(int newSize){
        Task tempArray[] = new Task[newSize];
        int numberOfElements;

        if(newSize < taskList.length) numberOfElements = newSize;
        else numberOfElements = taskList.length;
        System.arraycopy(taskList, 0, tempArray, 0, numberOfElements);
        taskList = tempArray;
    }

    @Override
    public Iterator<Task> iterator() {
        return new Iterator<Task>() {
            int marker = 0;

            @Override
            public boolean hasNext() { return size() > marker; }

            @Override
            public Task next() {
                if(!hasNext()) throw new IllegalStateException();
                return getTask(marker++);
            }

            @Override
            public void remove() {
                if(marker == 0) throw new IllegalStateException();
                ArrayTaskList.this.remove(taskList[--marker]);
            }
        };
    }

    @Override
    public ArrayTaskList clone(){
        ArrayTaskList outputTaskList = new ArrayTaskList();

        for(Task task : this){
            outputTaskList.add(task);
        }

        return outputTaskList;
    }

    @Override
    public String toString() {
        String result = "ArrayTaskList{ size=" + size() + ", taskList=";
        for(Task task : this) {
            result += task.toString();
            result += " ";
        }
        result += '}';

        return result;
    }
}

