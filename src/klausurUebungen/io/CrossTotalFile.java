package klausurUebungen.io;

import java.io.*;
import java.util.Scanner;

public class CrossTotalFile {

    private static final Scanner scanner = new Scanner(System.in);

    static int getCrossTotal(){
        String str = scanner.nextLine();
        char[] splitted = str.toCharArray();
        int result = 0;
        for (char val:splitted) result += Character.getNumericValue(val);
        return result;
    }

    public static void main(String[] args) throws IOException {
        File f = new File("I_HOAB_KRASSE_QUERSUMME_UF_DA_STRINGS.txt");
        int crossTotal = getCrossTotal();
        if (!f.exists()){
            f.createNewFile();
            System.exit(1);
        }
        else{
            String fContent = "";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f.getAbsolutePath()));
            String st;
            while ((st = bufferedReader.readLine()) != null){
                fContent += st + "\n";
            }
            FileWriter fileWriter = new FileWriter(f.getAbsolutePath());
            fileWriter.write(fContent + "\n" + crossTotal);
            fileWriter.close();
        }
    }
}
