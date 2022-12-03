import java.io.IOException;

public class Day2 {


    public static void main() throws IOException {
       String a = FileReader.chooseFile();
       int pointsGesamt = 0;
        for(int i = 0; i < FileReader.countLineBufferedReader(a); i++){
            String line = FileReader.readLine(a,i);
            pointsGesamt = pointsGesamt + pointsForRoundP2(line.charAt(0), line.charAt(2));
        }
        System.out.println(pointsGesamt);
    }

    public static int pointsForRound(char a, char b){
       int points = 0;
       switch (b){
           case 'X': points = points + 1;break;
           case 'Y': points = points + 2; break;
           case 'Z': points = points + 3; break;
       }
       StringBuilder strB = new StringBuilder();
       strB.append(a);
       strB.append(b);
       switch (strB.toString()){
           case "AY", "BZ", "CX": points = points + 6; break;
           case "AX", "BY", "CZ": points = points + 3; break;
       }
       return points;
    }

    public static int pointsForRoundP2(char a, char b){
        int points = 0;
        switch (b){
            case 'X': points = points + 0;break;
            case 'Y': points = points + 3; break;
            case 'Z': points = points + 6; break;
        }
        StringBuilder strB = new StringBuilder();
        strB.append(a);
        strB.append(b);
        switch (strB.toString()){
            case "BX", "AY", "CZ": points = points + 1; break;
            case "CX", "BY", "AZ": points = points + 2; break;
            case "AX", "CY", "BZ": points = points + 3; break;
        }
        return points;
    }
}
