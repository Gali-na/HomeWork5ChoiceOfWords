import java.io.*;

public class FileService {
    public static void makeFile(String fileOne, String fileTwo) {
        File newFileOne = new File(fileOne);
        File newFileTwo = new File(fileTwo);
        try {
            newFileOne.createNewFile();
            newFileTwo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writingToFiles(String fileOne, String fileTwo) {
        try (PrintWriter printWriterOne = new PrintWriter(fileOne);
             PrintWriter printWriterTwo = new PrintWriter(fileTwo);) {
            printWriterOne.print(" Great" + " " + "weather" + " " + "today");
            printWriterTwo.print(" Great" + " " + "weather" + " " + "today" + " " + "in" + " " + "Kryvyi" + " " + "Rih");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String checkWords(String fileOne, String fileTwo) {
        String wordsForFileOne = "";
        String wordsForFileTwo = "";
        try (BufferedReader fileOneRead = new BufferedReader(new FileReader(fileOne));
             BufferedReader fileTwoRead = new BufferedReader(new FileReader(fileTwo))) {

            while (fileOneRead.read() != -1) {
                wordsForFileOne = wordsForFileOne + fileOneRead.readLine();
            }

            while (fileTwoRead.read() != -1) {
                wordsForFileTwo = wordsForFileTwo + fileTwoRead.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arryWordsForFileOne = wordsForFileOne.split(" ");
        String[] arryWordsForFileTwo = wordsForFileTwo.split(" ");
        String wordsForNewFile = "";
        for (int i = 0; i < arryWordsForFileOne.length; i++) {
            for (int j = 0; j < arryWordsForFileTwo.length; j++) {
                if (arryWordsForFileOne[i].equals(arryWordsForFileTwo[j])) {
                    wordsForNewFile = wordsForNewFile + arryWordsForFileOne[i] + " ";
                }
            }
        }
        return wordsForNewFile;
    }

    public static void createFile(String matchedWords, String newfileName) {
        File file = new File(newfileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter printWriterTwo = new PrintWriter(newfileName)) {

            printWriterTwo.print(matchedWords);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
