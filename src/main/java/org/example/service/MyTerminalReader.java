package org.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyTerminalReader {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine(){
        String terminalLine = "";
        try {
            terminalLine = READER.readLine();
        } catch (IOException e) {
            throw new Error(e);
        }
        return terminalLine;
    }
    public static void closeReader(){
        try {
            READER.close();
        } catch (IOException e) {
            throw new Error(e);
        }
    }
}
