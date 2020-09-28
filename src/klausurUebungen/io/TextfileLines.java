package klausurUebungen.io;

import java.io.*;

public class TextfileLines {

    public static void main(String[] args) throws IOException {
        File f = new File("beispiel.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f.getAbsolutePath()));
        String str;
        int i = 0;
        while ((str = bufferedReader.readLine()) != null && i<=4){
            if (!(i<1)){
                System.out.println(str);
            }
            i++;
        }
    }

}
