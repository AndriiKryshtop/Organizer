package ua.sumdu.j2se.kryshtop.tasks;


public class LinkedTaskList extends TaskList{
    private Node first;
    private Node last;

    private static class Node {
        private Task value;
        private Node previous;
        private Node next;

        Node(Task value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    @Override
    public void add(Task task) throws NullTaskException {
        if(task == null) throw new NullTaskException("Task == null");

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
    public Task getTask(int index)throws InvalidTaskIndexException{
        Node buffer = first;
        for(int i=0; i < size; i++){
            if(i == index){
                return buffer.value;
            }
            buffer = buffer.next;
        }
        throw new InvalidTaskIndexException("Wrong index");
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

    private boolean isEmpty() {
        return first == null;
    }
}