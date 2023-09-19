import java.util.ArrayList;
import java.util.Arrays;

public class Pascal{
    public static void main(String[] args) {
        System.out.println(pascalTriangle(15));
    }

    public static ArrayList<ArrayList<Integer>> pascalTriangle(int depth) {
        ArrayList<Integer> firstRow = new ArrayList<Integer>(Arrays.asList(1));
        ArrayList<Integer> secondRow = new ArrayList<Integer>(Arrays.asList(1,1));
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        matrix.add(firstRow);
        matrix.add(secondRow);
        int currDepth = 2; //rows
        int manipAmt = 1; //how many nums we're adding (exclude first and last)
        while(matrix.size() != depth) {
            ArrayList<Integer> newRow = new ArrayList<Integer>();
            newRow.add(1);
            for(int i=0; i<manipAmt; i++) { //building each index
                newRow.add(matrix.get(currDepth-1).get(i) + matrix.get(currDepth-1).get(i+1));
            }
            newRow.add(1);
            matrix.add(newRow);
            manipAmt++;
            currDepth++;

        }

        
        return matrix;

    }
}