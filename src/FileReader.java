import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public static String chooseFile(){
        System.out.println("Bitte Datei auswählen:");
        JFileChooser chooser = new JFileChooser(); //Datei-Explorer
        chooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
        chooser.setMultiSelectionEnabled(false);
        int returnVal = chooser.showSaveDialog(null);
        File f = chooser.getSelectedFile();
        return f.getAbsolutePath();
    }
    public static String readLine(String fileLoc, int lin) throws IOException { //Hilfsmethode zum Dateilesen
        String line = Files.readAllLines(Paths.get(fileLoc)).get(lin);
        return line;
    }

    public static long countLineBufferedReader(String fileName) {

        long lines = 0;
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            while (reader.readLine() != null) lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;

    }
}
