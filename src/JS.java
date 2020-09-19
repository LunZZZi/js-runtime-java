import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JS {
    public static void addPredefinedObject(ScriptEngine engine) throws FileNotFoundException, ScriptException {
        engine.eval(new FileReader("assets/lib.js"));
    }

    public static void runEventLoop(ScriptEngine engine) throws InterruptedException {
        while (!OS.timerQueue.isEmpty()) {
            TimerTask task = OS.timerQueue.poll();
            long currentTime = System.currentTimeMillis();
            if (currentTime < task.getTime()) {
                Thread.sleep(task.getTime() - currentTime);
            }
            task.getFunc().call(null);
        }
    }
}
