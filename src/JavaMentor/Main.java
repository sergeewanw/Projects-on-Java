package JavaMentor;

import java.util.HashSet;
import  java.util.Scanner;
class Main {

    static HashSet <String> RomanS (HashSet <String> RomanSet) {
        RomanSet = new HashSet<String>();
        RomanSet.add ("I");
        RomanSet.add ("II");
        RomanSet.add ("III");
        RomanSet.add ("IV");
        RomanSet.add ("V");
        RomanSet.add ("VI");
        RomanSet.add ("VII");
        RomanSet.add ("VIII");
        RomanSet.add ("IX");
        RomanSet.add ("X");
        return RomanSet;
    }

    static HashSet <String> ArabS (HashSet <String> ArabSet) {
        ArabSet = new HashSet<String>();
        ArabSet.add ("1");
        ArabSet.add ("2");
        ArabSet.add ("3");
        ArabSet.add ("4");
        ArabSet.add ("5");
        ArabSet.add ("6");
        ArabSet.add ("7");
        ArabSet.add ("8");
        ArabSet.add ("9");
        ArabSet.add ("0");
        ArabSet.add ("10");
        return ArabSet;
    }

    static HashSet <String> MarkS (HashSet <String> MarkSet) {
        MarkSet = new HashSet<String>();
        MarkSet.add ("+");
        MarkSet.add ("-");
        MarkSet.add ("*");
        MarkSet.add ("/");
        return MarkSet;
    }

    static byte RomanToArab (String a) {
        byte result;
        switch (a) {
            case "I": result = 1; break;
            case "II": result = 2; break;
            case "III": result = 3; break;
            case "IV": result = 4; break;
            case "V": result = 5; break;
            case "VI": result = 6; break;
            case "VII": result = 7; break;
            case "VIII": result = 8; break;
            case "IX": result = 9; break;
            case "X": result = 10; break;
            default: result = 0;
        }
        return result;
    }

    static String ArabToRoman (byte a) {
        String result;
        switch (a) {
            case 1: result = "I"; break;
            case 2: result = "II"; break;
            case 3: result = "III"; break;
            case 4: result = "IV"; break;
            case 5: result = "V"; break;
            case 6: result = "VI"; break;
            case 7: result = "VII"; break;
            case 8: result = "VIII"; break;
            case 9: result = "IX"; break;
            case 10: result = "X"; break;
            case 11: result = "XI"; break;
            case 12: result = "XII"; break;
            case 13: result = "XIII"; break;
            case 14: result = "XIV"; break;
            case 15: result = "XV"; break;
            case 16: result = "XVI"; break;
            case 17: result = "XVII"; break;
            case 18: result = "XVIII"; break;
            case 19: result = "XIX"; break;
            case 20: result = "XX"; break;
            case 21: result = "XXI"; break;
            case 24: result = "XXIV"; break;
            case 25: result = "XXV"; break;
            case 27: result = "XXVII"; break;
            case 28: result = "XXVIII"; break;
            case 30: result = "XXX"; break;
            case 32: result = "XXXII"; break;
            case 35: result = "XXXV"; break;
            case 36: result = "XXXVI"; break;
            case 40: result = "XL"; break;
            case 42: result = "XLII"; break;
            case 45: result = "XLV"; break;
            case 48: result = "XLVIII"; break;
            case 49: result = "XLIX"; break;
            case 50: result = "L"; break;
            case 54: result = "LIV"; break;
            case 56: result = "LVI"; break;
            case 60: result = "LX"; break;
            case 63: result = "LXIII"; break;
            case 64: result = "LXIV"; break;
            case 70: result = "LXX"; break;
            case 72: result = "LXXII"; break;
            case 73: result = "LXXIII"; break;
            case 80: result = "LXXX"; break;
            case 81: result = "LXXXI"; break;
            case 90: result = "XC"; break;
            case 100: result = "C"; break;
            default: result = "";
        }
        return result;
    }

    public static void main (String[] args) {
        HashSet <String> ArabSet = new HashSet<>();
        HashSet <String> RomanSet = new HashSet<>();
        HashSet <String> MarkSet = new HashSet<>();

        RomanSet = RomanS (RomanSet);
        ArabSet = ArabS (ArabSet);
        MarkSet = MarkS (MarkSet);

        String a = "", b = "", mark = "";
        byte a1, b1, buf;
        byte indexMark;
        String result = "0";

        Calculator expression;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String Inupt = in.nextLine();

        Inupt = Inupt.replaceAll("\\s","");

        if (Inupt.length() >= 3) {
            String [] InputArray = Inupt.split("");
            indexMark = 1;
            for (byte i = 0; i < Inupt.length(); i++) {
                if ((ArabSet.contains(InputArray[i]) == true || RomanSet.contains(InputArray[i]) == true) && (i < indexMark)) {
                    a = a.concat(InputArray[i]);
                    if (MarkSet.contains(InputArray[i+2]) == true) {
                        indexMark = 2;
                    }
                } else if ((ArabSet.contains(InputArray[i]) == true || RomanSet.contains(InputArray[i]) == true) && (i > indexMark)) {
                    b = b.concat(InputArray[i]);
                } else if (MarkSet.contains(InputArray[i]) == true) {
                    mark = InputArray[i];
                    indexMark = i;
                } else if ((ArabSet.contains(InputArray[i]) && RomanSet.contains(InputArray[i]) && MarkSet.contains(InputArray[i])) == false) {
                    throw new IllegalArgumentException ("Введена неверная строка.");
                }
            }
        } else {
            throw new IllegalArgumentException ("Введена неверная строка.");
        }

        if (!(ArabSet.contains(a) && ArabSet.contains(b) || RomanSet.contains(a) && RomanSet.contains(b)) && !(MarkSet.contains(mark))) {
            throw new IllegalArgumentException ("Введена неверная строка.");
        }

        if (ArabSet.contains(a)) {
            a1 = Byte.valueOf(a);
            b1 = Byte.valueOf(b);
            expression = new Calculator(a1, b1, mark);
            result = String.valueOf(expression.calculate());
        } else {
            a1 = RomanToArab(a);
            b1 = RomanToArab(b);
            expression = new Calculator(a1, b1, mark);
            if (expression.calculate() < 0) {
                result = "-" + ArabToRoman(expression.calculate());
            } else if (expression.calculate() == 0) {
                result = "0";
            } else {
                result = ArabToRoman(expression.calculate());
            }

        }
        System.out.println(result);

        in.close();
    }
}
