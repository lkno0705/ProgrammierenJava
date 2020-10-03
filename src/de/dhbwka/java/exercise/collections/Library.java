package de.dhbwka.java.exercise.collections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Library extends JFrame {

    private final String[] buttonNames = {"Title", "Author", "Year", "Publisher"};

    enum SORTINGOPERATIONS {

        TITLE, AUTHOR, YEAR, PUBLISHER

    }

    private class Book implements Comparable<Book> {
        private String title, author, year, publisher;

        public Book(String title, String author, String year, String publisher) {
            this.title = title;
            this.author = author;
            this.year = year;
            this.publisher = publisher;
        }

        @Override
        public String toString() {
            return "" + title + ",\n" +
                    author + ",\n" +
                    year + ",\n" +
                    publisher + ";\n";
        }

        private int compareString(String s1, String s2){

            char[] thisbook = s1.toCharArray();
            char[] otherBook = s2.toCharArray();

            for (int i=0; i<thisbook.length; i++) {

                try {
                    if (thisbook[i] < otherBook[i]) return -1;
                    if (thisbook[i] > otherBook[i]) return 1;
                }catch (Exception e){
                    return thisbook.length - otherBook.length;
                }
            }
            return 0;

        }

        @Override
        public int compareTo(Book o) {
            switch (key){
                case YEAR: return Integer.parseInt(this.year) - Integer.parseInt(o.year);
                case TITLE: return compareString(this.title, o.title) ;
                case AUTHOR: return compareString(this.author, o.author);
                case PUBLISHER: return compareString(this.publisher, this.publisher);
                default: return 0;
            }
        }
    }


    private JTextField tftitle = new JTextField();
    private JTextField tfauthor = new JTextField();
    private JTextField tfyear = new JTextField();
    private JTextField tfpublisher = new JTextField();
    private SORTINGOPERATIONS key;


    public Library() {
        buidUI();
    }


    private void buidUI() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 175);
        this.setLayout(new BorderLayout());

        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new GridLayout(4, 2, 2, 2));

        JLabel ltitle = new JLabel("Title");
        JLabel lauthor = new JLabel("Author");
        JLabel lYear = new JLabel("Year");
        JLabel lPublisher = new JLabel("Publisher");

        textFieldPanel.add(ltitle);
        textFieldPanel.add(tftitle);
        textFieldPanel.add(lauthor);
        textFieldPanel.add(tfauthor);
        textFieldPanel.add(lYear);
        textFieldPanel.add(tfyear);
        textFieldPanel.add(lPublisher);
        textFieldPanel.add(tfpublisher);

        this.add(textFieldPanel, BorderLayout.NORTH);

        JButton save = new JButton("Save Entry");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Book book = new Book(
                        tftitle.getText(),
                        tfauthor.getText(),
                        tfyear.getText(),
                        tfpublisher.getText()
                );
                addEntry(book);
            }
        });
        this.add(save, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JLabel("Ordered Output: "));
        for (String buttonName : buttonNames
        ) {
            JButton button = new JButton(buttonName);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sort(SORTINGOPERATIONS.valueOf(buttonName.toUpperCase()));
                }
            });
            buttonPanel.add(button);
        }

        this.add(buttonPanel, BorderLayout.SOUTH);
        this.setVisible(true);


    }

    private void sort(SORTINGOPERATIONS key) {
        List<Book> library = readFile();
        if (library == null) {
            JOptionPane.showMessageDialog(null,
                    "Library File could not be read (library = null)",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        else{
            this.key = key;
            Collections.sort(library);
            StringBuilder out = new StringBuilder();
            for (Book book: library
                 ) {
                out.append(book.toString().replaceAll("\n", "")).append("\n");
            }
            JOptionPane.showMessageDialog(null,
                    out.toString(),
                    "Books ordered by " + key,
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void addEntry(Book book){

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("library.txt", true));
            bufferedWriter.write(book.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private java.util.List readFile(){

        try {
            StringBuilder content = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("library.txt"));
            String st;
            while ((st = bufferedReader.readLine())!= null){
                content.append(st);
            }
            String[] books = content.toString().split(";");
            List<Book> libray = new LinkedList<>();
            for (String book : books) {
                String[] parameters = book.split(",");
                libray.add(new Book(parameters[0], parameters[1], parameters[2], parameters[3]));
            }
            return libray;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Library a = new Library();
    }

}
