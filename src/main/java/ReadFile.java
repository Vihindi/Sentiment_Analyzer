import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static class Readfile {

        // Define the file paths for the positive and negative word files
        String positiveFilePath = "Positive_wordsR.txt";
        String negativeFilePath = "Negative_wordsR.txt";

        // Create two instances of the MyLinkedList class to store positive and negative words.
        MyLinkedList positiveList = new MyLinkedList();
        MyLinkedList negativeList = new MyLinkedList();

        // Method to read the files and populate the positiveList and negativeList.
        public void readFile() {
            try {
                // Create File objects for the positive and negative word files.
                File positiveFile = new File(positiveFilePath);
                File negativeFile = new File(negativeFilePath);
                Scanner scan1 = new Scanner(positiveFile);
                Scanner scan2 = new Scanner(negativeFile);

                // Read lines from the positive file and insert them into the positiveList.
                while (scan1.hasNextLine()){
                    String Pline = scan1.nextLine();
                    positiveList.insert(positiveList,Pline);
                }
                scan1.close();

                // Read lines from the negative file and insert them into the negativeList.
                while (scan2.hasNextLine()){
                    String Nline = scan2.nextLine();
                    negativeList.insert(negativeList,Nline);
                }
                scan2.close();


                // Continue reading and processing the file...
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        }
    }
}
