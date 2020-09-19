package org.bohao.nashorn;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FS {
    private final EventLoop eventLoop;

    public FS(EventLoop eventLoop) {
        this.eventLoop = eventLoop;
    }

    public void readFile(String path, ScriptObjectMirror cb) throws IOException {
        String data = new String(Files.readAllBytes(Path.of(path)));
        SimpleTask simpleTask = new SimpleTask(cb, data);
        this.eventLoop.addTask(simpleTask);
    }
}
