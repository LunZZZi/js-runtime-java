package org.bohao.nashorn;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class EventLoop {
    public PriorityQueue<TimerTask> timerQueue = new PriorityQueue<>();
    public Deque<SimpleTask> taskQueue = new LinkedList<>();

    public void setTimeout(ScriptObjectMirror func, Integer ms) {
        TimerTask task = new TimerTask(func, ms);
        timerQueue.add(task);
    }

    public void addTask(SimpleTask task) {
        taskQueue.addLast(task);
    }

    public void run() throws InterruptedException {
        while (!this.taskQueue.isEmpty() || !this.timerQueue.isEmpty()) {
            if (!this.taskQueue.isEmpty()) {
                SimpleTask job = this.taskQueue.poll();
                job.cb.call(null, job.data);
            }

            if (!this.timerQueue.isEmpty()) {
                TimerTask task = this.timerQueue.poll();
                long currentTime = System.currentTimeMillis();
                if (currentTime < task.getTime()) {
                    Thread.sleep(task.getTime() - currentTime);
                }
                task.getFunc().call(null);
            }
        }
    }
}
