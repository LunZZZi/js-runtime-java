import org.bohao.nashorn.JSRuntime;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        JSRuntime runtime = new JSRuntime(engine);
        runtime.addPredefinedObject();
        runtime.eval(new FileReader("assets/script.js"));
        runtime.runEventLoop();

        JSRuntime runtime2 = new JSRuntime(engine);
        runtime2.addPredefinedObject();
        runtime2.eval(new FileReader("assets/script2.js"));
        runtime2.runEventLoop();
    }
}
