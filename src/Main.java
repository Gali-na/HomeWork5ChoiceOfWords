public class Main {
    public static void main(String[] args) {
        FileService.makeFile("fileOne.txt", "fileTwo.txt");
        FileService.writingToFiles("fileOne.txt", "fileTwo.txt");
        String wordsForWreate = FileService.checkWords("fileOne.txt", "fileTwo.txt");
        FileService.createFile(wordsForWreate, "MatchingWords.txt");
    }
}
