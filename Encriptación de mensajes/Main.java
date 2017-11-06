// If you want to use System.in uncoment the Scanner code, otherwise this will be using argument args[]
// import java.util.Scanner;

public class Main{

    static final char JOKER = 'p';
    static final char[] VOWELS = {'a','e','i','o','u'};

    public static void main (String[] args){
        // Scanner s = new Scanner(System.in);
        String end = "pFIN";
        boolean stop = false;
        String buffer;
        int i = 0;
        
        do{
            // buffer = decoded(s.nextLine());
            buffer = args[i];
            if (!buffer.equals(end)) {
                System.out.println(vowels(buffer));
                i++;
            }else{
                stop = true;
            }
        }while(stop != true);
    }

    // This method returns the decrypted message
    private static String decoded(String s){
        int code = code(s);
        int buff;
        char c, z, a;
        String decoded = "";

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (Character.isLetter(c)) {
                if (((c <= 'z') && (c >= 'a')) || ((c <= 'Z') && (c >= 'A'))) {
                    if ((c <= 'z') && (c >= 'a')) {
                        z = 'z';
                        a = 'a';
                    } else{
                        z = 'Z';
                        a = 'A';
                    }
                    if (((char) (s.charAt(i) + code) <= z) && ((char) (s.charAt(i) + code) >= a)) {
                        decoded += (char) (s.charAt(i) + code);
                    } else if ((char) (s.charAt(i) + code) <= z) {
                        buff = (s.charAt(i) - a) + 1;
                        decoded += (char) (z + (code + buff));
                    } else {
                        buff = (z - s.charAt(i)) + 1;
                        decoded += (char) (a + (code - buff));
                    }
                }
            }
        }

        return decoded;
    }

    // This method returns the number of non-accentued vowels in the decrypted message
    private static int vowels(String s){
        s = s.toLowerCase();
        int howMany = 0;
        char[] cs = s.toCharArray();

        for (char cp: cs){
            if (Main.isVowel(cp)){
                howMany++;
            }
        }
        return howMany;
    }

    // This method returns the code for the Cesar encryption algorithm
    private static int code(String s){
        char c = s.charAt(0);
        Character.toLowerCase(c);
        return JOKER - c;
    }

    // This method returns true when a character is a vowel and returns false otherwise
    private static boolean isVowel(char c){
        boolean isIt = false;
        for (char v: VOWELS){
            if (!isIt){
                isIt = (v == c);
            }
        }
        return isIt;
    }
}
