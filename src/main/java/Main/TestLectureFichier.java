package Main;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Fabienne_2 on 18/11/2015.
 */
public class TestLectureFichier {

    public static void main(String[] args) throws FileNotFoundException {

        Path file = Paths.get("C:\\Users\\Fabienne_2\\Desktop\\HistoriquesT\\dam6.txt");
        Scanner fic = new Scanner(file.toFile());
        do{
            System.out.println(fic.nextLine());
        }while (fic.hasNextLine());
        fic.close();
    }

}
