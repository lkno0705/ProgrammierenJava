package klausurUebungen.snatChat;

import de.dhbwka.java.exercise.arrays.Fibonacci;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SnatChatRoom {

    private String roomName;
    private List<SnatChatFrontend> frontends = new ArrayList<>();

    public SnatChatRoom(String string) {
        this.roomName = string;
    }

    public void register(SnatChatFrontend s) {
        frontends.add(s);
        String log = readLog();
        if(log != null) {
            String[] messages = log.split("\n");
            for (String msg: messages
                 ) {
                s.receiveMessage(Message.rot13(msg));
            }
        }
    }

    public void unregister(SnatChatFrontend s){
        frontends.remove(s);
    }

    public void sendMessage(Message msg){
        for (SnatChatFrontend frontend: frontends
             ) {
            frontend.receiveMessage(msg);
        }
        log(msg.getTxt());
    }

    public void sendMessage(String txt){
        for (SnatChatFrontend frontend: frontends
        ) {
            frontend.receiveMessage(txt);
        }
        log(txt);
    }

    public String getRoomName() {
        return roomName;
    }

    private String readLog(){
        StringBuilder content = new StringBuilder();
        File file = new File(this.roomName);
        if(!file.exists()) return null;
        else {
            int counter = 0;
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
                String st;
                while ((st = bufferedReader.readLine()) != null & counter <= 10) {
                    content.append(st).append("\n");
                    counter++;
                }
                return content.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private void log(String txt){
        txt = Message.rot13(txt);
        File file = new File(this.roomName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsolutePath(), true));
            bufferedWriter.write(txt + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
