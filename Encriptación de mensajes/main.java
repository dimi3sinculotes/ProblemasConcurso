public class main{

    static final char JOKER = 'p';
    static final char[] VOWELS = {'a','e','i','o','u'};

    public static void main (String[] args){
        String end = "pFIN";
        boolean stop = false;
        String buffer;
        int i = 0;

        do{
            buffer = decoded(args[i]);
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
        char c;
        String decoded = "";

        for (int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if((c <= 'z') && (c >= 'a')){
                if (((char)(s.charAt(i) + code) <= 'z') && ((char)(s.charAt(i) +  code) >= 'a')){
                    decoded += (char)(s.charAt(i) + code);
                }else if((char)(s.charAt(i) + code) <= 'z'){
                    buff = (s.charAt(i) - 'a') - 1;
                    decoded += (char)('z' + (buff + code));
                }else{
                    buff = ('z' - s.charAt(i)) - 1;
                    decoded += (char)('a' + (buff + code));
                }
            }else if ((c <= 'Z') && (c >= 'A')){
                if (((char)(s.charAt(i) + code) <= 'Z') && ((char)(s.charAt(i) +  code) >= 'A')){
                    decoded += (char)(s.charAt(i) + code);
                }else if((char)(s.charAt(i) + code) <= 'Z'){
                    buff = (s.charAt(i) - 'A') - 1;
                    decoded += (char)('Z' + (buff + code));
                }else{
                    buff = ('Z' - s.charAt(i)) - 1;
                    decoded += (char)('A' + (buff + code));
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
            if (isVowel(cp)){
                howMany++;
            }
        }
        return howMany;
    }

    // This method returns the code for the Cesar encryption algorithm
    private static int code(String s){
        char c = s.charAt(0);
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