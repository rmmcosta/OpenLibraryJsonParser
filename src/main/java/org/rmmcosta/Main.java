package org.rmmcosta;

import org.rmmcosta.work.BookDeserialize;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/test-works.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null)
            System.out.println(BookDeserialize.deserialize(line));
    }
}