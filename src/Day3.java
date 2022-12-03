import java.io.IOException;

public class Day3 {

    public static void main() throws IOException {
        String a = FileReader.chooseFile();
        int pointsGesamt = 0;
        int pG = 0;
        long max = FileReader.countLineBufferedReader(a);
        for(int z = 0; z < max ; z++){
            String lineP = FileReader.readLine(a,z);
            pointsGesamt = pointsGesamt + newPoints(lineP);
        }
        for(int i = 0; i < max; i++){
            String line1 = FileReader.readLine(a,i); i++;
            String line2 = FileReader.readLine(a,i); i++;
            String line3 = FileReader.readLine(a,i);
            pG = pG + groups(line1, line2, line3);
        }
        System.out.println("Punkte Gesamt: " + pointsGesamt);
        System.out.println("Gruppenpunkte: " + pG);
    }

    public static int groups(String str1, String str2, String str3){
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char same = '*';
        for(int i = 0; i < str1.length(); i++){
            for(int j = 0; j < str2.length(); j++){
                for(int t = 0; t < str3.length(); t++){
                    if(str1.charAt(i) == str2.charAt(j) &&  str2.charAt(j) == str3.charAt(t)){
                        same =  str1.charAt(i);
                        return alphabet.indexOf(same) + 1;
                    }
                }
            }
        }
        return 0;
    }
    public static int newPoints(String str){
        int poi = 0;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int mid = str.length() / 2; //get the middle of the String
        String[] parts = {str.substring(0, mid),str.substring(mid)};
        char same = '*';
        for(int i = 0; i < parts[0].length(); i++){
            for(int j = 0; j < parts[1].length(); j++){
                if(parts[0].charAt(i) == parts[1].charAt(j)){
                   same =  parts[0].charAt(i);
                   return alphabet.indexOf(same) + 1;
                }
            }
        }
        return poi;
    }
}
