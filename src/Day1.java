import java.io.IOException;

public class Day1 {
    public static void main() throws IOException {
        String a = FileReader.chooseFile();
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        int temp = 0;
        for (int i = 0; i < FileReader.countLineBufferedReader(a); i++) {
            String str = FileReader.readLine(a, i);
            if (!str.equals("")) {
                temp = temp + Integer.parseInt(str);
            } else {
                if (temp > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = temp;
                } else if (temp > max2) {
                    max3 = max2;
                    max2 = temp;
                } else if (temp > max3) {
                    max3 = temp;
                }
                temp = 0;
            }
        }
        System.out.println(max1 + max2 + max3);
    }
}