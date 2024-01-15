import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class ReadFile {
    private static HashSet<String> read(){
        HashSet<String> fileText = new HashSet<>();
        try {
            File file = new File("src/main/java/questions.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                if (!scanner.nextLine().equals("\n")){
                    fileText.add(scanner.nextLine().strip());
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
        System.out.println(fileText);
        return fileText;
    }

//    private static HashSet<String> formatDecode(){
//
//    }
}
