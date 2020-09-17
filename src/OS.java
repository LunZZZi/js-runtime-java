import jdk.nashorn.api.scripting.ScriptObjectMirror;

public class OS {
    public static void setTimeout(ScriptObjectMirror func, Integer ms) {
        System.out.println("wait for " + ms + "ms");
        func.call(null);
    }
}
