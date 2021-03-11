package instrument_financiar;


import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class InstrumentFinanciar {
    public static void main(String[] args) {
        Instrument instr1 = new Instrument("BRD",
                "Banca Romana pentru Dezvoltare", 12.78, Status.TRANZACTIONABIL);
        Instrument instr2= new Instrument("TLV",
                "Banca Transilvania", 7.34, Status.TRANZACTIONABIL);
        Instrument instr3 = new Instrument("BVB",
                "Bursa de Valori Bucuresti", 24.6, Status.NETRANZACTIONABIL);

        ArrayList<Instrument> lista = new ArrayList<Instrument>();
        lista.add(instr1);
        lista.add(instr2);
        lista.add(instr3);

        FileWriter outFile = null;
        BufferedWriter writer = null;

        try {
            outFile = new FileWriter("instrumenteFinanciare.csv", false);
            writer = new BufferedWriter(outFile);

            for (Instrument i:lista) {
                System.out.println(i.toString());
                writer.write(i.toString());
                writer.newLine(); // writer.write("\r\n");
            }

            writer.close();
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayDeque<Instrument> coada = new ArrayDeque<Instrument>();

        FileReader inFile = null;
        BufferedReader reader = null;

        try {
            inFile = new FileReader("instrumenteFinanciare.csv");
            reader = new BufferedReader(inFile);

            Scanner fileScanner = new Scanner(reader);
            while(fileScanner.hasNext()) {
                String linie = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(linie);
                lineScanner.useDelimiter(",");

                Instrument local = new Instrument();
                local.setSimbol(lineScanner.next());
                local.setNume(lineScanner.next());

//                String temp = lineScanner.next();
//                local.setPret(Double.valueOf(temp));

                local.setPret(lineScanner.nextDouble());
                local.setStare(Status.valueOf(lineScanner.next()));

                coada.offerLast(local);

                reader.close();
                inFile.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Instrument iter = null;
        while(!coada.isEmpty()) {
            iter = coada.pollFirst();
            System.out.println(iter.toString());
        }
    }
}
