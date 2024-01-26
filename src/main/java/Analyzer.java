import java.util.Scanner;

public class Analyzer {
    public static void main(String[] args) {
        int positivewords = 0;
        int negativewords = 0;
        ReadFile.Readfile reader = new ReadFile.Readfile();
        reader.readFile();
        MyLinkedList positiveList = reader.positiveList;
        MyLinkedList negativelist=reader.negativeList;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a sentence or a word: ");
        String sentence = scan.nextLine();
        String regex = "[^a-zA-Z ]";
        sentence = sentence.replaceAll(regex, "").toLowerCase();

        String[] sentenceArray = sentence.split(" ");

        for(int i =0; i<sentenceArray.length;i++){
            String word = sentenceArray[i];
            int index = Search.binarySearch(positiveList, word);
            if (index != -1) {
                positivewords++;
                sentenceArray=removeElement(sentenceArray,i);
                i=i-1;
            }
        }
        for(int i =0; i<sentenceArray.length;i++){

            String word = sentenceArray[i];
            int index = Search.binarySearch(negativelist, word);//should conve
            if (index != -1) {
                negativewords++;
                sentenceArray=removeElement(sentenceArray,i);
                i=i-1;
            }

        }


        if(positivewords>negativewords){
            System.out.println("The sentence is positive. :)");
        }
        else if(positivewords<negativewords){
            System.out.println("The sentence is negative. :(");
        }
        else {
            System.out.println("The sentence is neutral. :| ");
        }
    }





    public static String[] removeElement(String[] array, int index) {
        if (index < 0 || index >= array.length) {
            // Invalid index, return the original array
            return array;
        }
        else {
            String[] newArray = new String[array.length - 1];
            int newArrayIndex = 0;

            for (int i = 0; i < array.length; i++) {
                if (i != index) {
                    newArray[newArrayIndex] = array[i];
                    newArrayIndex++;
                }
            }

            return newArray;
        }
    }

}





