import java.util.*;

public class Main {

    public static List<Integer> finale = new LinkedList<Integer>();

    public static void main(String args[]){
        int n, max;
        int[] coins, buf;
        String[] line1, line2;
        int numCases = Integer.parseInt(args[0]) * 2;

        for (int i = 1; i <= numCases; i+=2){
            finale.clear();

            line1 = args[i].split(" ");
            line2 = args[i+1].split(" ");

            n = Integer.parseInt(line1[0]);
            max = Integer.parseInt(line1[1]);

            coins = new int[n + 1];
            coins[0] = 0;

            for (int j = 0; j < line2.length; j++){
                coins[j] = Integer.parseInt(line2[j]);
            }

            buf = new int[max];

            recursive(coins, buf, 0);

            System.out.println(finale.size() - 1);
        }
    }

    private static void recursive(int[] input, int[] buf, int count){
        if (count < buf.length){
            for (int i = 0; i < input.length; i++) {
                buf[count] = input[i];
                recursive(input, buf, count+1);
            }
        }else{
            condition(buf);
        }
    }

    private static void condition(int[] item) {
        int count = 0;
        for (int i : item) {
            count += i;
        }
        if (!finale.contains(count)) {
            finale.add(count);
        }
    }
}