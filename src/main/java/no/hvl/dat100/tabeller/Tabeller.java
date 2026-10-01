package no.hvl.dat100.tabeller;

public class Tabeller {

	// a)
	public static void skrivUt(int[] tabell) {

        for (int element : tabell){
            System.out.print(element);
        }

	}

	// b)
	public static String tilStreng(int[] tabell) {
        return "["+tilStrengHjelper(tabell)+"]";
        }


    public static String tilStrengHjelper(int[] e) {
        int counter = 0;

        for (int element : e) {
            counter++;
        }
        if(counter==0){return"";}
        int[] rekursivArray =new int[counter-1];

        int temp = e[0];
        for( int i=1; i<counter; i++){
            rekursivArray[i-1] =e[i];
        }
        //gav litt opp her på å finne en "gøy" løsning, så la bare in ==1 for å fikse ekstra "," problem
        if(counter==1){return temp+tilStrengHjelper(rekursivArray);}
        return temp+","+tilStrengHjelper(rekursivArray);
    }

	// c)
	public static int summer(int[] tabell) {
      int  summen=0;
        for (int element : tabell){
            summen += element;}
return summen;

	}

	// d)
	public static boolean finnesTall(int[] tabell, int tall) {
        for (int element : tabell){
            if(element==tall){return true;}}
        return false;
	}

	// e)
	public static int posisjonTall(int[] tabell, int tall) {
        int posisjon=-1;
        for (int element : tabell){
            posisjon++;
            if(element==tall){return posisjon;}}
        return posisjon*0-1;
	}

	// f)
	public static int[] reverser(int[] tabell) {
        int counter = 0;

        for (int element : tabell) {
            counter++;}
        int[]reversert = new int[counter];

        for (int element : tabell){
          reversert[counter-1]=element;
        counter--;}
        return reversert;
	}

	// g)
	public static boolean erSortert(int[] tabell) {
        int temp=Integer.MIN_VALUE;
        for (int element : tabell){
            if(temp>element){return false;}
            temp = element;
        }
            return true;


	}

	// h)
	public static int[] settSammen(int[] tabell1, int[] tabell2) {
        int i =0;
        for (int element : tabell1) {i++;}
            for (int element : tabell2) {i++;}

        int[] resultat = new int[i];


        i = 0;

        for (int element : tabell1) { resultat[i++] = element; }
        for (int element : tabell2) { resultat[i++] = element; }

        return resultat;

	}
}
