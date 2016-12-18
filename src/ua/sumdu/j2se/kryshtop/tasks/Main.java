package ua.sumdu.j2se.kryshtop.tasks;

public class Main {
    public static void main(String[] args) {
        TaskList organizer = new ArrayTaskList();
        Task run = new Task("Everyday run", 0);
        Task date = new Task("Date with Jane", 4);
        Task test = new Task("Test", 0);

        Task A = new Task("A", 0);
        Task B = new Task("B", 0);
        Task C = new Task("C", 0);
        Task D = new Task("D", 0);
        Task E = new Task("E", 0);


        System.out.println("Add tasks");
        int j = 0;

        Task[] ts = {A, B, C, D, E};
        for (Task t : ts) {
            System.out.println("Add t: ");
            System.out.println(t.getTitle());
            organizer.add(t);
            System.out.println(organizer.size());
            j++;
        }
        /*
        organizer.add(run);
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

        System.out.println(organizer.size());

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
    }
}
