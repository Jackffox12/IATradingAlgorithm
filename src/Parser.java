import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Parser {
    public Scanner scanner;
    public Parser(File file){
        try{
            scanner = new Scanner(file);
        }catch (FileNotFoundException e){
            System.out.println("file was not found");
            e.printStackTrace();
        }
    }
    //For testing
    public void readData() {
        while (scanner.hasNext()){
            scanner.useDelimiter(",");
            System.out.println(scanner.next());

        }
        scanner.close();
    }

    public String[] seperateOneMinData() {
        String[] nextLine = scanner.next().split(",");
        return nextLine;
    }

}
