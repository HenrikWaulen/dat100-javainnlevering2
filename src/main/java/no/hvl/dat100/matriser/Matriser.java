package no.hvl.dat100.matriser;

public class Matriser {

	// a)
	public static void skrivUt(int[][] matrise) {

        for (int []element : matrise){
            for(int elementt:element){
                System.out.print(elementt);
                //har laget mange nestede for løkker men ingen nestede for each løkker
                //håper denne alternative løsningen blir godtatt
            }
            System.out.println();
        }
	}

	// b)
    public static String tilStreng(int[][] matrise) {
        String resultat = "";
        for (int[] element : matrise) {
            resultat += tilStrengHjelper(element);
        }
        return resultat;
    }
    public static String tilStrengHjelper(int[] e) {
        int counter = 0;

        for (int element : e) {
            counter++;
        }
        if(counter==0){return"\n";}
        int[] rekursivArray =new int[counter-1];

        int temp = e[0];
        for( int i=1; i<counter; i++){
            rekursivArray[i-1] =e[i];
        }
        if(counter==1){return temp+tilStrengHjelper(rekursivArray);}
        return temp+" "+tilStrengHjelper(rekursivArray);

    }

		


	// c)
   /* public static int[][] skaler(int tall, int[][] matrise) {
        int i = 0;
        for (int[] rad : matrise) {
            int antallKolonner = 0;
            for (int tallet : rad) {
                antallKolonner++;
            }
            matrise[i] = new int[antallKolonner];
            int j = 0;
            for (int tallet : rad) {
                matrise[i][j] = tallet * tall;
                j++; }
            i++;}
        return matrise;
    }*/
    public static int[][] skaler(int tall, int[][] matrise) {
        int antallRader = 0;
        for (int[] rad : matrise) {
            antallRader++;
        }

        int[][] nyttSkall = new int[antallRader][];

        int i = 0;
        for (int[] rad : matrise) {
            int antallKolonner = 0;
            for (int tallet : rad) {
                antallKolonner++;
            }

            nyttSkall[i] = new int[antallKolonner];

            int j = 0;
            for (int tallet : rad) {
                nyttSkall[i][j] = tallet * tall;
                j++;
            }
            i++;
        }
        return nyttSkall;
    }




	// d)
	public static boolean erLik(int[][] a, int[][] b) {

		return tilStreng(a).equals(tilStreng(b));
	}
	
	// e)
    public static int[][] speile(int[][] matrise) {
        int antallRader = 0;
        int antallKolonner = 0;
        int i=0;
        for (int[] rad : matrise) {
            antallRader++;
            antallKolonner = 0;
            for (int tallet : rad) {
                antallKolonner++;
            }
        }

        int[][] nyttSkall = new int[antallKolonner][antallRader];
        int j=0;
        for (int[] rad : matrise) {

            for (int tallet : rad) {

                nyttSkall[i][j] = tallet;
                i++;
            }
            j++;i=0;
        }
        return nyttSkall;
    }
	


	// f)
    public static int[][] multipliser(int[][] a, int[][] b) {
        int radA=0;
        int radSpeiletB = 0;
        int kolonnerSvar = 0;
        for (int rad[] : b) {
            radSpeiletB++;
        }
        b = speile(b);

        for (int rad[] : a) {
            radA++;
            kolonnerSvar=0;
            for (int element : rad) {
                kolonnerSvar++;
            }
        }
        int[][] svar = new int[radA][kolonnerSvar];
        if (kolonnerSvar != radSpeiletB) {
            throw new IllegalArgumentException("Matrisene kan ikke multipliseres");
        } else {
            int i = 0;int j = 0;int r = 0;
            for (int rad[] : a) {for (int radB[] : b) {
                    for (int element : rad) {
                        svar[r][j] += (b[j][i] * a[r][i]);
                        i++;}
                j++;i=0;
            }j=0;r++;}
        }return svar;
    }
	}

