package ua.sumdu.j2se.kryshtop.tasks;

import com.sun.org.apache.xpath.internal.operations.Minus;
import ua.sumdu.j2se.kryshtop.tasks.Exceptions.InvalidTaskIndexException;
import ua.sumdu.j2se.kryshtop.tasks.Exceptions.MinusException;

public class Main {
    public static void main(String[] args) {
        TaskList organizer = new LinkedTaskList();
        TaskList organizer2 = new LinkedTaskList();

        Task run = new Task("Everyday run", 0);
        Task date = new Task("Date with Jane", 4);
        Task test = new Task("Test", 0);

        Task A = new Task("A", 0);
        Task B = new Task("B", 0);
        Task C = new Task("C", 0);
        Task D = new Task("D", 0);
        Task E = new Task("E", 0);

        //organizer.add(new Task("A", 0));

        System.out.println("Add tasks");

        Task[] ts = {A, B, C, D, E};
        for (Task t : ts) {
            System.out.println("Add " + t.getTitle());
            organizer.add(t);
            System.out.println(organizer.size());
        }

        for (Task t : ts) {
            System.out.println("Add " + t.getTitle());
            organizer2.add(t);
            System.out.println(organizer2.size());
        }

        for (Task task: organizer) {
            System.out.println(task.getTitle());
        }
        for (Task task: organizer2) {
            System.out.println(task.getTitle());
        }


        System.out.println(organizer.hashCode());
        System.out.println(organizer2.hashCode());

        System.out.println(organizer.equals(organizer2));
        System.out.println(organizer2.equals(organizer));

        organizer2.add(run);
        organizer2.add(run);
        organizer2.add(date);
        organizer2.remove(date);
        organizer2.remove(D);

        System.out.println(organizer2.getTask(4).getTitle());

        System.out.println(organizer.hashCode());
        System.out.println(organizer2.hashCode());

        System.out.println(organizer.equals(organizer2));
        System.out.println(organizer2.equals(organizer));

        /*
        organizer.add(date);
        organizer.add(test);
        */

        /*
        System.out.println("0");
        organizer.add(run);

        for(int i = 0; i < 29; i++){
            System.out.println(i);
            organizer.add(test);
        }
        */

      /*  for(int i = 0; i < 10; i++){
            System.out.println(i);
            organizer.remove(test);
        }
*/
        for(int i = 0; i < organizer.size(); i++){
            System.out.println("Task " + i + organizer.getTask(i).getTitle());
        }

        while(organizer.size() > 0){
            System.out.println("Remove " + organizer.getTask(organizer.size()-1));
            organizer.remove(organizer.getTask(organizer.size()-1));
            System.out.println("Complete");
        }

        System.out.println("Adding task (Task A, 10)");
        organizer.add(new Task("Task A", 10));


    /*    for(int i = 0; i < organizer2.size(); i++){
            System.out.println("Task " + i + organizer2.getTask(i).getTitle());
        }

        System.out.println(organizer.size());

*/

        /*
        //remove first
        System.out.println("trying to remove " + A.getTitle());
        organizer.remove(A);
        System.out.println(organizer.size());
        for(int i = 0; i < organizer.size(); i++){
            System.out.println("Task " + i + organizer.getTask(i).getTitle());
        }

        //remove last
        System.out.println("trying to remove " + E.getTitle());
        organizer.remove(E);
        System.out.println(organizer.size());
        for(int i = 0; i < organizer.size(); i++){
            System.out.println("Task " + i + organizer.getTask(i).getTitle());
        }

        //remove middle
        System.out.println("trying to remove " + C.getTitle());
        organizer.remove(C);
        System.out.println(organizer.size());
        for(int i = 0; i < organizer.size(); i++){
            System.out.println("Task " + i + organizer.getTask(i).getTitle());
        }

        //remove nonexistent
        System.out.println("trying to remove test");
        if(!organizer.remove(test))
            System.out.println("False");

        System.out.println(organizer.size());
        for(int i = 0; i < organizer.size(); i++){
            System.out.println("Task " + i + organizer.getTask(i).getTitle());
        }

        //System.out.println(organizer.incoming(50, 60).getTask(1).getTitle());

        */
    }
}
