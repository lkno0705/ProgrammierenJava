package klausurUebungen.snatChat;

import java.util.Arrays;

public class Message {

    private String txt;
    private Account acc;

    public Message(String txt, Account acc) {
        this.txt = txt;
        this.acc = acc;
    }

    public String getTxt() {
        return txt;
    }

    public Account getAcc() {
        return acc;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public static String rot13(String message){
        char[] charArray = message.toCharArray();
        for (int i=0; i < charArray.length; i++
             ) {
            if ((charArray[i] >= 'A' || charArray[i] >= 'a')) {
                if (charArray[i] < 'N' || (charArray[i] < 'n' && charArray[i] >= 'a')) {
                    charArray[i] = (char) (charArray[i] + 13);
                    System.out.println("kleiner n");
                }
                else charArray[i] = (char) (charArray[i] - 13);
            }
        }
        StringBuilder s = new StringBuilder();
        for (char character: charArray
             ) {
            s.append(character);
        }
        return s.toString();
    }
}
