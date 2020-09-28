package de.dhbwka.java.exercise.threads.search;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;

public class SearchEngine {

    private static File file = new File("urls.txt");
    private int maxThreads;

    public void search() throws IOException, InterruptedException {

        ArrayList<PageLoader> runningPageLoaders = new ArrayList<>();
        LinkedList<PageLoader> waitingLoaders = new LinkedList<>();

        ArrayList<String> urls = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));

        String st;
        while ((st = reader.readLine()) != null) {
            urls.add(st.strip());
        }


        for (int i = 0; i < urls.size(); i++) {
            PageLoader newLoader = new PageLoader(urls.get(i));
            if (this.maxThreads >= runningPageLoaders.size()) {
                System.out.println("added: " + newLoader.getUrl() + " to running Loaders");
                runningPageLoaders.add(newLoader);
                runningPageLoaders.get(i).start();
            } else {
                waitingLoaders.add(newLoader);
            }
        }
        while (!runningPageLoaders.isEmpty()) {
            for (int i = 0; i< runningPageLoaders.size(); i++) {
                PageLoader loader = runningPageLoaders.get(i);
                if (loader.pageLoaded()) {
                    loader.join();
                    System.out.println("Loader for: " + loader.getUrl() + " has finished");
                    writeFile(loader);
                    runningPageLoaders.remove(loader);
                    if (!waitingLoaders.isEmpty()) {
                        PageLoader firstWaitingLoader = waitingLoaders.pop();
                        firstWaitingLoader.start();
                        System.out.println("new Loader: " + firstWaitingLoader.getUrl() + " Has been started");
                        runningPageLoaders.add(firstWaitingLoader);
                        i = i != 0 ? i - 1 : 0;
                    }
                }
            }
        }
    }

    private void writeFile(PageLoader loader) {
        File dir = new File("downloadedContents");
        dir.mkdir();
        File f = new File(dir.getAbsolutePath()+ "/" + loader.getUrl().replaceAll("/", "_").replaceAll(":","") + ".txt");
        try {
            FileWriter fileWriter = new FileWriter(f.getAbsolutePath());
            fileWriter.write(loader.getPageContent());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SearchEngine(int maxThreads) {
        this.maxThreads = maxThreads;
    }
}
