import java.util.*;

class main{

    public static void main (String[] args){
        String end = "pFIN";
        int i = 0;
        char joker = 'p';
        char[] vowels = {a,e,i,o,u};

        while(!decoded(args[i]).equals(end)){
            System.out.println(vowels(decoded(args[i])));
            i++;
        }
    }

    // This method returns the decrypted message
    private static String decoded(String s){
        int code = code(s);
        String decoded = "";

        for (int i = 0; i < s.length)
    }

    // This method returns the number of non-accentued vowels in the decrypted message
    private static int vowels(String s){
        s = s.toLowerCase();
        int howMany = 0;
        char[] cs = s.toCharArray();

        for (char cp: cs){
            if (isVowel(cp)){
                howMany++;
            }
        }
        return howMany;
    }

    // This method returns the code for the Cesar encryption algorithm
    private static int code(String s){
        char c = s.charAt(0);

    }

    // This method returns true when a character is a vowel and returns false otherwise
    private static boolean isVowel(char c){
        boolean isIt = false;
        for (char v: vowels){
            if (!isIt){
                isIt = (v == c)
            }
        }
        return isIt;
    }
}