package ua.sumdu.j2se.kryshtop.tasks;

/**
 * This class describes task.
 * @version 1.0
 * @author Kryshtop Andrii
 **/
public class Task {
    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    private boolean repeat;

    /**
     * To initialize an inactive task that is performed at the set time,
     * without repeating and with the established name.
     * @param title title of the task
     * @param time a time when the task performed
     */
    public Task(String title, int time) {
        this.title = title;
        this.time = time;
    }

    /**
     * To initialize an inactive task that is performed in set distance of time,
     * with the established interval and established title.
     * @param title title of the task
     * @param start start of the distance
     * @param end end of the distance
     * @param interval interval of task performance
     */
    public Task(String title, int start, int end, int interval) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.repeat = true;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * To get time of performance for tasks, that do not repeat.
     * @return time of performance (if task repeats - return start time of repetition)
     */
    public int getTime() {
        if (this.repeat) return this.start;
        else return this.time;
    }

    /**
     * To set time for not repeatable tasks.
     * If task is repeatable - will make it not repeatable.
     * @param time time of performance
     */
    public void setTime(int time) {
        if (this.repeat) this.repeat = false;
        this.time = time;
    }

    /**
     * To get start time.
     * @return start time (if task is not repeatable - return time of performance)
     */
    public int getStartTime() {
        if (!this.repeat) return this.time;
        else return this.start;
    }

    /**
     * To get end time.
     * @return end time (if task is not repeatable - return time of performance)
     */
    public int getEndTime() {
        if (!this.repeat) return this.time;
        else return this.end;
    }

    /**
     * To get repeat interval.
     * @return interval (if task is not repeatable - return 0)
     */
    public int getRepeatInterval() {
        if (!this.repeat) return 0;
        else return this.interval;
    }

    /**
     * To set time for repeatable tasks.
     * If task is not repeatable - will make it repeatable.
     * @param start start time
     * @param end start time
     * @param interval repeat interval
     */
    public void setTime(int start, int end, int interval) {
        if (!this.repeat) this.repeat = true;
        else {
            this.start = start;
            this.end = end;
            this.interval = interval;
        }
    }

    public boolean isRepeated() {
        return this.repeat;
    }

    /**
     * To get next time of task performance after established time.
     * @param current current time
     * @return nest time of task performance
     * (if task is not performed after established time - return -1)
     */
    public int nextTimeAfter(int current) {
        if (!this.active) {
            return -1;
        }

        if (!this.repeat) {
            if (this.time <= current) {
                return -1;
            } else return this.time;
        }
        else {
            if (current >= this.end) {
                return -1;
            }
            else {
                int time = this.start;
                while (time <= current) {
                    time += this.interval;
                }
                if (time > this.end)  return -1;
                return time;
            }

        }

    }
}
