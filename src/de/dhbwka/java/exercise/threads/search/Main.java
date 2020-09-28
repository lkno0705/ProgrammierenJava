package de.dhbwka.java.exercise.threads.search;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        SearchEngine searchEngine = new SearchEngine(2);
        searchEngine.search();
    }
}
