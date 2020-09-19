import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.PriorityQueue;

public class OS {
    public static PriorityQueue<TimerTask> timerQueue = new PriorityQueue<>();

    public static void setTimeout(ScriptObjectMirror func, Integer ms) {
        TimerTask task = new TimerTask(func, ms);
        timerQueue.add(task);
    }
}
