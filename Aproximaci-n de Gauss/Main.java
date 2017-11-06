public class Main {
    public static final String GREATER = "Mayor";
    public static final String LOWER = "Menor";
    public static final String EQUAL = "Igual";
    public static final String END = "0 0";
    
    public static void main(String[] args) {
        int i = 0;
        int m, n;
        String[] inputLine;
        
        while(!args[i].equals(END)){
            inputLine = args[i].split(" ");
            n = Integer.parseInt(inputLine[0]);
            m = Integer.parseInt(inputLine[1]);
            
            if (expression(n) < margin(m)){
                System.out.println(LOWER);
            }else if (expression(n) > margin(m)){
                System.out.println(GREATER);
            }else{
                System.out.println(EQUAL);
            }
            
            i++;
        }
    }
    
    private static double margin (int m){
        return (1/(Math.pow(10, m)));
    }
    
    private static double expression (int n){
        return Math.abs((numOfPrimes(n) / (double) n) - (1.0 / Math.log(n)));
    }
    
    private static int numOfPrimes(int n){
        int counter = 0;
        boolean check;
        int j;
        
        for (int i = 2; i < n; i++) {
            j = 2;
            check = true;
            while ((j < i) && (check)){
                check = !(i % j == 0);
                j++;
            }
            if (check){
                counter ++;
            }
        }
        return counter;
    }
}
