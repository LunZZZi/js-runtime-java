package org.bohao.nashorn;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class TimerTask implements Comparable<TimerTask> {
    private final ScriptObjectMirror func;
    private final long time;

    public TimerTask(ScriptObjectMirror func, long ms) {
        this.func = func;
        this.time = ms + System.currentTimeMillis();
    }

    @Override
    public int compareTo(TimerTask o) {
        return (int)(this.time - o.time);
    }

    public ScriptObjectMirror getFunc() {
        return this.func;
    }

    public long getTime() {
        return this.time;
    }
}
