package zerowka16_1;

import java.math.BigDecimal;
/*
Napisać funkcję przetwarzającą tablicę łańcuchów, tablicę typu BigDecimal oraz 
znak(przekazane jako parametry) wyliczając średnią arytmetyczną elementów
zapisanych w poszczególnych wierszach drugiej tablicy i dodając do niej liczbę
znaków, przekaznych trzecim parametrem, zawartych w odpowiednich łańcuchach 
tablicy danej pierwszym parametrem. Funkcja zwraca nową tablicę, poszerzoną
o kolumny zawierające długości łańcuchów oraz wyliczone średnie.
*/
public class Zerowka16_1 {

    static BigDecimal[][] Tablice(String[] tabS, BigDecimal[][] tabB, char znak) {
        BigDecimal[][] tabWyn = new BigDecimal[tabB.length][];

        for (int nrW = 0; nrW < tabB.length; nrW++) {
            int dłW = tabB[nrW].length;
            tabWyn[nrW] = new BigDecimal[dłW + 2];

            tabWyn[nrW][0] = new BigDecimal(tabS[nrW].length());

            int lZnak = 0;
            String ł = tabS[nrW];
            for (int nrZn = 0; nrZn < ł.length(); nrZn++) {
                if (ł.charAt(nrZn) == znak) {
                    lZnak++;
                }
            }
            tabWyn[nrW][1] = new BigDecimal(lZnak);

            if (dłW > 0) {
                BigDecimal suma = tabB[nrW][0];
                for (int nrL = 1; nrL < dłW; nrL++) {
                    suma = suma.add(tabB[nrW][nrL]);
                }
                tabWyn[nrW][1] = tabWyn[nrW][1].add(suma.divide(new BigDecimal(dłW)));

                for (int nrL = 0; nrL < dłW; nrL++) {
                    tabWyn[nrW][nrL + 2] = tabB[nrW][nrL];
                }
            }
        }

        return tabWyn;
    }

    public static void main(String[] args) {
        String tS[] = {"Ala ma kota", "Ola ma psa", "Ela ma króliki"};
        BigDecimal[][] tB = {{new BigDecimal(10)}, {new BigDecimal(20), new BigDecimal(40)}, {}};

        BigDecimal[][] tabWyn = Tablice(tS, tB, 'a');
        for (int nrW = 0; nrW < tabWyn.length; nrW++) {
            for (int nrEl = 0; nrEl < tabWyn[nrW].length; nrEl++) {
                System.out.print(tabWyn[nrW][nrEl] + "  ");
            }
            System.out.println();
        }
    }

}
