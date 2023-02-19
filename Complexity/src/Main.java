import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Please enter file name (ex. input.txt) :");
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        //file operations
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("./" + in));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
        }
        String row = null;
        try {
            row = reader.readLine();
        } catch (IOException e) {
            System.out.println("File format not correct.");
        }

        //extracting file elements in String array
        String[] elements = new String[0];
        while (row != null) {
            elements = row.split(",");
            try {
                row = reader.readLine();
            } catch (IOException e) {
                System.out.println("File format not correct.");
            }
        }

        //separating input array and threshold value
        int length = elements.length;
        int a[] = new int[0];
        try {
            a = new int[length - 1];
        } catch (Exception e) {
            System.out.println("File empty.");
        }
        for (int i = 0; i < length - 1; i++) {
            a[i] = Integer.parseInt(elements[i]);
            System.out.println(a[i]);
        }
        float t = Float.parseFloat((elements[length - 1]));
        System.out.println("Threshold: " + t);

        int cnt = 0;

        //finding number of critical events
        for(int j = 1; j < length - 1; j++) {
            for(int i = 0; i < j; i++) {
                if (a[i] > (t * a[j])) {
                    cnt++;
                }
            }
        }

        System.out.println("Count of critical events: " + cnt);

        //closing the file
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Problem while closing file.");
        }

    }
}