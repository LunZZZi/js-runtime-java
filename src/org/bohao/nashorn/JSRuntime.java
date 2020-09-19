package org.bohao.nashorn;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSRuntime {
    private final ScriptEngine engine;
    private final Bindings binding;

    public JSRuntime(ScriptEngine engine) {
        this.engine = engine;
        this.binding = this.engine.createBindings();
    }

    public void eval(FileReader fileReader) throws ScriptException {
        this.engine.eval(fileReader, this.binding);
    }

    public void addPredefinedObject() throws FileNotFoundException, ScriptException {
        this.binding.put("os", new OS());
        this.engine.eval(new FileReader("assets/lib.js"), this.binding);
    }

    public void runEventLoop() throws InterruptedException {
        OS os = (OS) this.binding.get("os");
        while (!os.timerQueue.isEmpty()) {
            TimerTask task = os.timerQueue.poll();
            long currentTime = System.currentTimeMillis();
            if (currentTime < task.getTime()) {
                Thread.sleep(task.getTime() - currentTime);
            }
            task.getFunc().call(null);
        }
    }
}
