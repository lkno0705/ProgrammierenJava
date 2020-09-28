package klausurUebungen.io;

import java.io.File;
import java.io.IOException;

public class Files {
    public static void main(String[] args) throws IOException {
        File dir = new File("ik_bin_a_directory");
        dir.mkdir();
        File[] Filearray = new File[3];
        for (int i = 0; i<3; i++){
            File ikBinAFile = new File(dir.getAbsolutePath() + "/ikBinAFile" + Integer.toString(i));
            ikBinAFile.createNewFile();
            Filearray[i] = ikBinAFile;
            System.out.println(ikBinAFile.getAbsolutePath());
        }
        for (int i = 0; i < Filearray.length; i++){
            System.out.print(Filearray[i].getAbsolutePath());
            Filearray[i].delete();
            System.out.print(" got deleted! \n");
        }
        dir.delete();
    }
}
