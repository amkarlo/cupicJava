package hr.fer.zemris.java.cstr;

import hr.fer.zemris.java.tecaj.hw3.prob1.SymbolSubLexer;

/**
 * Created by akarlovic on 2.2.2017..
 */
public class Proba {

    public static void main(String[] args){
        char[] array = {'m', 'a', 'r', 'i', 'j', 'a'};

        CString prvi = CString.fromString("ana");
        CString drugi = new CString(array, 0, 6);
        CString sedmi = new CString(drugi);

        System.out.println(prvi.charAt(0));
        System.out.println(drugi.charAt(0));
        System.out.println(sedmi.charAt(0));

        System.out.println(drugi.toString());
        System.out.println(sedmi.toString());
        System.out.println(drugi.replaceAll('a', 'o').toString());


        CString treci = prvi.add(drugi);
        System.out.println(treci.toString());

        CString cetvrti = CString.fromString("ab");
        CString peti = CString.fromString("abab");

        CString sesti = CString.fromString("ababab").replaceAll(cetvrti, peti);
        System.out.println(sesti.toString());

        System.out.println((drugi.left(2)).toString());

    }
}
