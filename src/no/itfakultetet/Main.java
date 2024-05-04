package no.itfakultetet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Bruk: Gi tre argumenter: 1) Antall rader, 2) Tabellnavn, 3) Filnavn");
            System.exit(0);
        }

        int antall = Integer.parseInt(args[0]);
        String tabellNavn = args[1];
        String filNavn = args[2];

        long start = System.currentTimeMillis();
        populate(antall, tabellNavn, filNavn);
        System.out.println(antall + " rader laget på: " + (System.currentTimeMillis() - start) + " millisekunder");
    }

    public static void populate(int rows, String tableName, String fileName) {
        try (BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName))) {
            Random rand = new Random();
            outFile.append("insert into " + tableName + " (id,tall) values \n");
            int i = 0;
            for (i = 1; i < rows; i++) {
                outFile.append("(" + i + "," + rand.nextInt() + "),\n");
            }
            outFile.append("(" + i + "," + rand.nextInt() + ");");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
