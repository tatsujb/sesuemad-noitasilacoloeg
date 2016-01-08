package Poubelle;
/**
 * Created by Fabienne_2 on 16/11/2015.
 */
public class MainGenerateurDeMessage {

    public static void main(String[] args) throws InterruptedException {
        GenerateurDeMessage g = new GenerateurDeMessage();
        int i = 0;
        do {
            System.out.println(g.genereMessage());
            Thread.sleep(1000);
            i++;
        }while (i<10);
    }
}
