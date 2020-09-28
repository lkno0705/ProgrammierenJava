package klausurUebungen.ui;

import javax.swing.*;

public class EditorSimple {

    private JFrame frame;

    EditorSimple() {

        frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Datei");
        JMenu editMenu = new JMenu("Bearbeiten");

        fileMenu.add(generateFileMenu(fileMenu));
        fileMenu.setMnemonic('d'); // always alt for menu bar and d is the Menu shortcut -> Open file Menu: alt + d
        editMenu.add(generateEditMenu(editMenu));
        editMenu.setMnemonic('b');

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.add(new JScrollPane(new JTextArea()));

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    private JMenu generateFileMenu(JMenu file){
        file.add(new JMenuItem("new"));
        file.add(new JMenuItem("open"));
        file.add(new JMenuItem("close"));
        file.add(new JMenuItem("save"));
        file.add(new JMenuItem("save as"));
        file.add(new JMenuItem("save as webpage"));
        file.add(new JMenuItem("search"));
        file.add(new JMenuItem("print"));
        JMenu send = new JMenu("send to");
        send.setMnemonic('s');
        send.add(new JMenuItem("E-Mail recipient"));
        send.add(new JMenuItem("Exchange-Folder"));
        send.add(new JMenuItem("Microsoft PowerPoint"));
        file.add(send);
        file.add(new JMenuItem("properties"));
        file.add(new JMenuItem("exit"));

        file.insertSeparator(2);
        file.insertSeparator(4);
        file.insertSeparator(9);

        return file;
    }

    private JMenu generateEditMenu(JMenu edit){
        edit.add(new JMenuItem("undo"));
        edit.add(new JMenuItem("redo"));
        edit.add(new JMenuItem("cut"));
        edit.add(new JMenuItem("copy"));
        edit.add(new JMenuItem("save to office-clipoard"));
        edit.add(new JMenuItem("paste"));
        edit.add(new JMenuItem("delete"));
        edit.add(new JMenuItem("select all"));
        edit.add(new JMenuItem("go to..."));
        edit.add(new JMenuItem("replace"));
        return edit;
    }

    public static void main(String[] args) {
        EditorSimple editor = new EditorSimple();
    }

}
