import java.util.Scanner;
import java.util.*;

public class Solution{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String inputS = s.nextLine();
        int input = 0;
        int max = Integer.parseInt(inputS);

        for (int i = 0; i < max; i++) {
            inputS = s.nextLine();
            input = Integer.parseInt(inputS);
            // Notice that input is an integer var with the value of the input taken
            if (input == 6174){
                System.out.println(0);
            }else if (esRepedigits(input)){
                System.out.println(8);
            }else{
                generalCase(input);
            }
        }
            // END
    }
    
    public static void generalCase(int input){
        int count = 0;
        int asc;
        int desc;

        while (input != 6174){
            desc = desc(input);
            asc = asc(input);
            input = desc - asc;
            count++;
        }

        System.out.println(count);
    }
    
    public static int asc(int input){
        String aux1 = Integer.toString(input); 

        if (input < 10){
            aux1 = "000" + aux1;
        }else if (input < 100){
            aux1 = "00" + aux1;
        }else if (input < 1000){    
            aux1 = "0" + aux1;
        }

        int[] aux = toArray(aux1);

        for (int i = 0; i < 3; i++) {
            int min = i;        

            for (int j = i + 1; j < 4; j++) {
                if (aux[j] < aux[min]){
                    min = j;
                }
            }          

            if(min != i){
                int aux2 = aux[i];
                aux[i] = aux[min];
                aux[min] = aux2;
            }
        }

        return aux[3] + 10 * aux[2] + 100 * aux[1] + 1000 * aux[0];
    }
    
    public static int desc(int input){
        String aux1 = Integer.toString(input);

        if (input < 10){
            aux1 = "000" + aux1;
        }else if (input < 100){
            aux1 = "00" + aux1;
        }else if (input < 1000){    
            aux1 = "0" + aux1;
        }

        int[] aux = toArray(aux1);

        for (int i = 0; i < 3; i++) {
            int max = i;       

            for (int j = i + 1; j < 4; j++) {
                if (aux[j] > aux[max]){
                    max = j;
                }
            }          

            if(max != i){
                int aux2 = aux[i];
                aux[i] = aux[max];
                aux[max] = aux2;
            }
        }

        return aux[3] + 10 * aux[2] + 100 * aux[1] + 1000 * aux[0];
    }
    
    public static int[] toArray(String input){
        int[] toRet = new int[4];
        toRet[0] = (int)input.charAt(0);
        toRet[1] = (int)input.charAt(1);
        toRet[2] = (int)input.charAt(2);
        toRet[3] = (int)input.charAt(3);

        return toRet;
    }
    
    public static boolean esRepedigits(int input){
        int[] aux = new int [4];
        String aux1 = Integer.toString(input);

        if (input < 10){
            aux1 = "000" + aux1;
        }else if (input < 100){
            aux1 = "00" + aux1;
        }else if (input < 1000){    
            aux1 = "0" + aux1;
        }

        for (int i = 0; i < 4; i++) {
            aux[i] = (int)(aux1.charAt(i));
        }

        return((aux[0] == aux[1]) && (aux[1] == aux[2]) && (aux[2] == aux[3]));
    }
}
