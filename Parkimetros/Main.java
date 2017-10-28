import java.io.IOException;
import java.util.*;

    public class Main {
    // At the moment get TimeLimit exception by the online judge. will be updated
    
        static List<Integer> finale = new LinkedList<Integer>();

        public static void main(String[] args) throws IOException {
            Scanner s = new Scanner(System.in);
            String currLine = "";
            String[] numsLine;
            String inputs = s.nextLine();
            int cases = Integer.parseInt(inputs);
            int[] input;
            int max;

            for (int i = 0; i < cases; i++) {
                currLine = s.nextLine();
                numsLine = currLine.split(" ");

                max = Integer.parseInt(numsLine[1]);


                input = new int[Integer.parseInt(numsLine[0]) + 1];
                input[0] = 0;
                for (int k = 1; k < Integer.parseInt(numsLine[0]) + 1; k++){
                    input[k] = s.nextInt();
                }

                s.nextLine();

                int[] item = new int[max];

                recursive(input, item, 0);

                // We will print the size of the list with the sums of each possible combination, -1 because the mayor don't want free parkings
                System.out.println(finale.size() - 1);
                finale.clear();
            }
        }

        private static void recursive(int[] input, int[] item, int count){
            if (count < item.length){
                for (int i = 0; i < input.length; i++) {
                    item[count] = input[i];
                    recursive(input, item, count+1);
                }
            }else{
                condition(item);
            }
        }

        private static void condition(int[] item){
            int count = 0;
            for (int i: item){
                count += i;
            }
            if (!finale.contains(count)){
                finale.add(count);
            }
        }
    }
