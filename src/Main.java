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
    }
}
