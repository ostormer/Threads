import java.io.*;
import java.util.*;

class Sort{
    static Monitor moni = null;
    static int antOrd = 0;
    static String utFilNavn;
    public static void main(String[] args) throws FileNotFoundException{

        int antTraader = 0;
        File innFil = null;
        try{
            antTraader = Integer.parseInt(args[0]);
            innFil = new File(args[1]);
            utFilNavn = args[2];
        }
        catch(NumberFormatException e){
            System.out.println("Det foerste argumentet er ikke et tall");
            System.exit(0);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Ikke nok argumenter");
            System.exit(0);
        }
        Scanner sc = new Scanner(innFil);

        antOrd = Integer.parseInt(sc.nextLine());
        moni = new Monitor(antOrd);
        String[] ordliste = new String[antOrd];
        try{
            for(int i = 0; i < antOrd; i++){
                ordliste[i] = sc.nextLine();
            }
        }
        catch(NoSuchElementException e){
            System.out.println("Det er for faa ord i Filen");
        }
        if(sc.hasNextLine()){
            System.out.println("Det er for mange ord i filen");
        }

        int ordMinste = (antOrd / antTraader);
        int ordStoerste = (ordMinste + 1);
        int antStoerste = (antOrd % antTraader);
        int antMinste = (antTraader - antStoerste);

        for(int i = 0; i < antStoerste*ordStoerste; i+= ordStoerste){
            String[] temp = new String[ordStoerste];                         //lager array
            for(int u = 0; u < ordStoerste; u++){
                temp[u] = ordliste[u+i];                                        //putter ord i array
            }
            SortTrad trad = new SortTrad(temp, moni);
            trad.start();
            //sende arrayen til tråd
        }

        for(int i = ordStoerste*antStoerste; i < antOrd; i+= ordMinste){
            String[] temp = new String[ordMinste];                         //lager array
            for(int u = 0; u < ordMinste; u++){
                temp[u] = ordliste[u+i];                                        //putter ord i array
            }
            SortTrad trad = new SortTrad(temp, moni);
            trad.start();                                                                  //sende arrayen til tråd
        }
    }

    public static void gjoerResten(String[] arr){
        if(arr.length != antOrd){
            System.out.println("Den ferdig sorterte ordlisten har feil lengde: " + arr.length + " != " + antOrd);
            System.exit(0);
        }
        else if(arr[antOrd-1] == null){
            System.out.println("Det siste objektet i listen er et null-objekt");
            System.exit(0);
        }
        boolean erSortert = true;
        for(int i = 0; i < antOrd - 1; i++){
            if(arr[i].compareTo(arr[i+1]) > 0){
                erSortert = false;
                break;
            }
        }
        if(!erSortert){
            System.out.println("Listen ble ikke sortert som den skulle");
            System.exit(0);
        }

        PrintWriter skriver = null;
        try{
            skriver = new PrintWriter(utFilNavn);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();            //Dette burde uansett ikke kunne skje
            System.exit(0);
        }
        skriver.println(antOrd);
        for(String s : arr){
            skriver.println(s);
        }
        skriver.close();

        System.out.println("ferdig da");
    }
}
