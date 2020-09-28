package de.dhbwka.java.exercise.threads.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PageLoader extends Thread {

    private String url;
    private String encoding = "UTF-8";

    private boolean loaded = false;
    private String pageContent;

    public String getStringContentFromUrl() {
        StringBuilder buffer = new StringBuilder();
        String line = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), encoding))) {
            while ((line = br.readLine()) != null) {
                buffer.append(line).append(System.lineSeparator());
            }
        } catch (IOException ex) {
        }
        this.loaded = true;
        return buffer.toString();
    }

    public boolean pageLoaded(){
        return loaded;
    }

    public String getPageContent(){
        return this.pageContent;
    }

    public String getUrl(){
        return this.url;
    }

    PageLoader(String url){
        this.url = url;
    }

    public void run(){
        this. pageContent = getStringContentFromUrl();
    }
}
