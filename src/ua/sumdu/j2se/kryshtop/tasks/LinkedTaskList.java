package ua.sumdu.j2se.kryshtop.tasks;

import java.util.NoSuchElementException;

public class LinkedTaskList extends TaskList{
    private Node first;
    private Node last;

    private int size;
/*    public LinkedTaskList() {
        size = 0;
        first = null;
        last = null;
    }
*/

    private static class Node {
        private Task value;
        private Node previous;
        private Node next;

        public Node(Task value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    @Override
    public void add(Task task) {
        if(isEmpty()){
            first = new Node(task, null, null);
            last = first;
        }
        else {
            Node buffer = last;
            last = new Node(task, buffer, null);
            buffer.next = last;
        }

        size++;
    }

    @Override
    public Task getTask(int index){
        Node buffer = first;
        for(int i=0; i < size; i++){
            if(i == index){
                return buffer.value;
            }
            buffer = buffer.next;
        }
        throw new NoSuchElementException("No such element in the list");

    }

    @Override
    public boolean remove(Task task){
        if(isEmpty()){
            return false;
        }
        if(size == 1){
            first = null;
            last = null;
            return true;
        }
        Node buffer = first;
        for(int i=1; i <= size; i++){
            if(buffer.value == task) {
                if(i == 1){
                    buffer.next.previous = null;
                    first = buffer.next;
                }
                else if(i == size){
                    buffer.previous.next = null;
                    last = buffer.previous;
                }
                else{
                    buffer.previous.next = buffer.next;
                    buffer.next.previous = buffer.previous;
                }
                size--;
                return true;
            }
            buffer = buffer.next;
        }
        return false;
    }

    /**
     * To get number of records in the task list
     * @return number of records in this task list
     */
    public int size(){
        return this.size;
    }


    public boolean isEmpty() {
        return first == null;
    }
}