package org.bohao.nashorn;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.PriorityQueue;

public class EventLoop {
    public PriorityQueue<TimerTask> timerQueue = new PriorityQueue<>();

    public void setTimeout(ScriptObjectMirror func, Integer ms) {
        TimerTask task = new TimerTask(func, ms);
        timerQueue.add(task);
    }

    public void run() throws InterruptedException {
        while (!this.timerQueue.isEmpty()) {
            TimerTask task = this.timerQueue.poll();
            long currentTime = System.currentTimeMillis();
            if (currentTime < task.getTime()) {
                Thread.sleep(task.getTime() - currentTime);
            }
            task.getFunc().call(null);
        }
    }
}
