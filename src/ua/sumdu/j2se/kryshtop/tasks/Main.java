package ua.sumdu.j2se.kryshtop.tasks;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        TaskList organizer = new ArrayTaskList();
        TaskList organizer2 = new ArrayTaskList();
        TaskList organizer3 = new ArrayTaskList();

        Task run = new Task("Everyday run", new Date(45747));
        Task date = new Task("This is \"awesome\" task", new Date(123314));
        Task test = new Task("Test", new Date(4357736));

        int hour = 3600;
        Date today = new Date();
        Date tomorow = new Date(new Date().getTime() + 86400000);
        Date yesterday = new Date(new Date().getTime() - 86400000);

        long currentTimeLong = new Date().getTime();

        /*
        Task A = new Task("Daily", yesterday, tomorow, 86400);
        Task B = new Task("Hourly", today, tomorow, hour);
        Task C = new Task("Every 3 hours", new Date(new Date().getTime() - hour), tomorow, hour * 3);
        Task D = new Task("Anrepeated1", new Date());
        Task E = new Task("This is \"awesome\" task", new Date());
        E.setActive(true);
        */


        Task A = new Task("A", today);
        Task B = new Task("B", today, tomorow, hour);
        Task C = new Task("C", today);
        Task D = new Task("B \"awesome\" task!", today, tomorow, hour);
        C.setActive(true);
        D.setActive(true);

        Task[] ts = {A, B, C, D};
        for (Task t : ts) {
            organizer.add(t);
        }

        File writeFile = new File("write.txt");
        File writeTextFile = new File("writeText.txt");

        Writer writer = new FileWriter(writeFile);
        TaskIO.write(organizer, writer);
        writer.close();

        Reader reader = new FileReader(writeFile);
        TaskIO.read(organizer3, reader);

        reader.close();

        TaskIO.writeText(organizer, writeTextFile);
        TaskIO.readText(organizer2, writeTextFile);

        System.out.println(organizer.getTask(0).toString());


        System.out.println("ArrayTaskList{ size=4, taskList=Task{title='A', time=Sat Dec 31 03:07:13 EET 2016, start=null, end=null, interval=0, active=false, repeat=false} " +
                "Task{title='B', time=null, start=Sat Dec 31 03:07:13 EET 2016, end=Sun Jan 01 03:07:13 EET 2017, interval=3600, active=false, repeat=true} " +
                "Task{title='C', time=Sat Dec 31 03:07:13 EET 2016, start=null, end=null, interval=0, active=true, repeat=false} " +
                "Task{title='B', time=null, start=Sat Dec 31 03:07:13 EET 2016, end=Sun Jan 01 03:07:13 EET 2017, interval=3600, active=true, repeat=true} " + "},");

        System.out.println(organizer);
        System.out.println(organizer2);
        System.out.println(organizer3);
    }
}
