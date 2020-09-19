package org.bohao.nashorn;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSRuntime {
    private final ScriptEngine engine;

    public JSRuntime(ScriptEngine engine) {
        this.engine = engine;
        ScriptContext context = new SimpleScriptContext();
        context.setBindings(this.engine.createBindings(), ScriptContext.ENGINE_SCOPE);
        this.engine.setContext(context);
    }

    public void eval(FileReader fileReader) throws ScriptException {
        this.engine.eval(fileReader);
    }

    public void addPredefinedObject() throws FileNotFoundException, ScriptException {
        this.engine.put("os", new OS());
        this.engine.eval(new FileReader("assets/lib.js"));
    }

    public void runEventLoop() throws InterruptedException {
        OS os = (OS) this.engine.get("os");
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
