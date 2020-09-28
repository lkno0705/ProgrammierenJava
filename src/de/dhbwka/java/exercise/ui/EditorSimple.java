package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;

public class EditorSimple extends JFrame {

    EditorSimple(){
        setTitle("Editor");
        setSize(600, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar topMenu = new JMenuBar();
        setJMenuBar(topMenu);
        JMenu file = new JMenu("file");
        JMenu edit = new JMenu("edit");

        topMenu.add(generateFileMenu(file));
        topMenu.add(generateEditMenu(edit));
        add(new JScrollPane(new TextArea()));
        setVisible(true);

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
        send.add(new JMenuItem("E-Mail recipient"));
        send.add(new JMenuItem("Exchange-Folder"));
        send.add(new JMenuItem("Microsoft PowerPoint"));
        file.add(send);
        file.add(new JMenuItem("properties"));
        file.add(new JMenuItem("exit"));
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
        new EditorSimple();
    }
}
