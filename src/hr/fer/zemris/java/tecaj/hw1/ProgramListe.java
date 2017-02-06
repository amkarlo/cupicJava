package hr.fer.zemris.java.tecaj.hw1;

/**
 * Created by akarlovic on 16.1.2017..
 */
class ProgramListe {

    static class CvorListe {
        CvorListe sljedeci;
        String podatak;
    }

    public static void main(String[] args) {
        CvorListe cvor = null;
        cvor = ubaci(cvor, "Jasna");
        cvor = ubaci(cvor, "Ana");
        cvor = ubaci(cvor, "Ivana");
        System.out.println("Ispisujem listu uz originalni poredak:");
        ispisiListu(cvor);
        cvor = sortirajListu(cvor);
        System.out.println("Ispisujem listu nakon sortiranja:");
        ispisiListu(cvor);
        int vel = velicinaListe(cvor);
        System.out.println("Lista sadrzi elemenata: "+vel);
    }

    private static int velicinaListe(CvorListe cvor) {
        int velicina = 1;
        //   CvorListe tmp = cvor;
        while (cvor.sljedeci != null){
            ++velicina;
            cvor = cvor.sljedeci;
        }
        return velicina;
    }
    private static CvorListe ubaci(CvorListe prvi, String podatak) {
        if (prvi == null){
            prvi = new CvorListe();
            prvi.podatak = podatak;
            return prvi;
        }
        else{
            CvorListe tmp = prvi;
            while (tmp.sljedeci != null){
                tmp = tmp.sljedeci;
            }
            CvorListe drugi = new CvorListe();
            drugi.podatak = podatak;
            tmp.sljedeci = drugi;
            return prvi;
        }

    }
    private static void ispisiListu(CvorListe cvor) {
        System.out.println(cvor.podatak);
        while (cvor.sljedeci != null){
            cvor = cvor.sljedeci;
            System.out.println(cvor.podatak);
        }
    }
    private static CvorListe sortirajListu(CvorListe cvor) {
        int duljina = velicinaListe(cvor);
        if (duljina < 2)
            return cvor;
        boolean sortiraj = true;
        while (sortiraj){
            sortiraj = false;
            CvorListe sortCvor = cvor;
            for (int i= 1; i < duljina; i++){
                if (sortCvor.podatak.compareTo(sortCvor.sljedeci.podatak) > 0){
                    String tmp = sortCvor.podatak;
                    sortCvor.podatak = sortCvor.sljedeci.podatak;
                    sortCvor.sljedeci.podatak = tmp;
                    sortiraj = true;
                }
                sortCvor = sortCvor.sljedeci;
            }
        }
        return cvor;
    }
}
