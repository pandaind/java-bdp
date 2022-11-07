package com.example.demo.observer.events;

import java.io.File;

/**
 * Editor
 */
public class Editor {
    public EventManager events;
    private File file;

    public Editor(){
        this.events = new EventManager("open", "save", "close");
    }

    public void openFile(String filePath){
        this.file = new File(filePath);
        events.notify("open", file);
    }

    public void saveFile() throws Exception{
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }

    public void closeFile() throws Exception{
        if (this.file != null) {
            events.notify("close", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }

}