package klausurUebungen.snatChat;

import javax.swing.*;

public class MessageThread extends Thread {

    private int index;
    private String txt;
    private int timeRemaining = 30;
    private SnatChatWindow window;

    public MessageThread(SnatChatWindow snatChatWindow, String txt, int index) {
        this.txt = txt;
        this.index = index;
        this.window = snatChatWindow;
    }

    @Override
    public void run() {
        while (true) {
            if (timeRemaining == 0) {
                window.removeMessage(index);
            } else {
                window.setMessageTime(txt + " [" + timeRemaining + "]", index);

                timeRemaining--;
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
