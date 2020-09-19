package org.bohao.nashorn;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSRuntime {
    private final ScriptEngine engine;
    private final EventLoop eventLoop;

    public JSRuntime(ScriptEngine engine) {
        this.engine = engine;
        this.eventLoop = new EventLoop();
        ScriptContext context = new SimpleScriptContext();
        context.setBindings(this.engine.createBindings(), ScriptContext.ENGINE_SCOPE);
        this.engine.setContext(context);
    }

    public void eval(FileReader fileReader) throws ScriptException {
        this.engine.eval(fileReader);
    }

    public void addPredefinedObject() throws FileNotFoundException, ScriptException {
        this.engine.put("eventLoop", this.eventLoop);
        this.engine.eval(new FileReader("assets/lib.js"));
    }

    public void runEventLoop() throws InterruptedException {
        this.eventLoop.run();
    }
}
