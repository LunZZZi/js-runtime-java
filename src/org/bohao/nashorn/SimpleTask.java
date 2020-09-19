package org.bohao.nashorn;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class SimpleTask {
    public final ScriptObjectMirror cb;
    public final Object data;

    public SimpleTask(ScriptObjectMirror cb, Object data) {
        this.cb = cb;
        this.data = data;
    }
}
