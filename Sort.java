import java.io.*;
import java.util.*;

class Sort{
  Monitor moni = null;
  public static void main(String[] args) throws FileNotFoundException{
    moni = new Monitor();
    File innFil = new File(args[1]);
    Scanner sc = new Scanner(innFil);
    int antTraader = 0;
    try{
      antTraader= Integer.parseInt(args[0]);
    }
    catch(NumberFormatException e){
      System.out.println("Det foerste argumentet er ikke et tall");
      System.exit(0);
    }
    int antOrd = 0;
    antOrd = Integer.parseInt(sc.nextLine());

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
      SortTrad trad = new SortTrad(temp);
      trad.start();
                                                                        //sende arrayen til tråd
    }

    for(int i = ordStoerste*antStoerste; i < antOrd; i+= ordMinste){
      String[] temp = new String[ordMinste];                         //lager array
      for(int u = 0; u < ordMinste; u++){
        temp[u] = ordliste[u+i];                                        //putter ord i array
      }
      SortTrad trad = new SortTrad(temp);
      trad.start();                                                                  //sende arrayen til tråd
    }
  }
  public static Monitor hentMonitor(){
    return moni;
  }
}
