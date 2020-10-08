package klausurUebungen.snatChat;

public interface SnatChatFrontend {

    public void receiveMessage(Message msg);

    public void receiveMessage(String txt);

    public Account getAccount();

}
