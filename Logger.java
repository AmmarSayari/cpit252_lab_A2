package org.example;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Logger {

    private static Logger ins;

    DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
    String currentDateTimeString = LocalDateTime.now().format(myFormatter);
    private final String logFile = currentDateTimeString + ".txt";
    private PrintWriter writer;

    private Logger() {
        try {
            FileWriter fw = new FileWriter(logFile);
            writer = new PrintWriter(fw, true);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void info (String message) {
        writer.println("INFO: " + message);
    }
    public void error (String message) {
        writer.println("Error: " + message);
    }

    public static Logger getInstance(){
        if(ins == null)
            ins = new Logger();
        return ins;

    }

}