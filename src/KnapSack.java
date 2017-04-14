import model.Talk;
import util.GeneralUtil;

import java.util.ArrayList;


/**
 * Created by vinicius on 12/04/17.
 */
public abstract class KnapSack {


    public static ArrayList<Talk> solution(ArrayList<Talk> talks, int timeAmount) {
        int N = talks.size(); // Get the total number of items. Could be wt.length or val.length. Doesn't matter
        int[][] V = new int[N + 1][timeAmount + 1]; //Create a matrix. Items are in rows and weight at in columns +1 on each side
        //What if the knapsack's capacity is 0 - Set all columns at row 0 to be 0
        for (int col = 0; col <= timeAmount; col++) {
            V[0][col] = 0;
        }
        //What if there are no items at home.  Fill the first row with 0
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        for (int item = 1; item <= N; item++) {
            //Let's fill the values row by row
            for (int weight = 1; weight <= timeAmount; weight++) {
                //Is the current items weight less than or equal to running weight
                if (talks.get(item - 1).getDuration() <= weight) {
                    //Given a weight, check if the value of the current item + value of the item that we could afford with the remaining weight
                    //is greater than the value without the current item itself
                    V[item][weight] = Math.max(talks.get(item - 1).getDuration() + V[item - 1][weight - talks.get(item - 1).getDuration()], V[item - 1][weight]);
                    //V[item][weight] = Math.max(1 + V[item - 1][weight - talks.get(item - 1).getDuration()], V[item - 1][weight]);
                } else {
                    //If the current item's weight is more than the running weight, just carry forward the value without the current item
                    V[item][weight] = V[item - 1][weight];
                }
            }
        }
        //Printing the matrix
//        for (int[] rows : V) {
//            for (int col : rows) {
//                System.out.format("%5d", col);
//            }
//            System.out.println();
//        }
//        System.out.println("----------------------------------------------");
//
//        for (int row = 1; row < V.length; row++) {
//            int value = V[row][V[row].length - 1];
//            System.out.print(value + " - ");
//            value = (V[row][V[row].length - 1] - (V[row - 1][V[row - 1].length - 1]));
//        }
//        System.out.println("----------------------------------------------");


        //mounting the solution
        ArrayList<Talk> talkArrayListSolution = new ArrayList<>();
        for (int row = 1; row < V.length; row++)
        {
            int value = (V[row][V[row].length - 1] - (V[row - 1][V[row - 1].length - 1]));
            Talk talk = GeneralUtil.getFirstAndDelete(value, talks);
            if (talk != null)
            talkArrayListSolution.add(talk);
        }

        return talkArrayListSolution;
    }

//
//    public static int solution(int times[], int timeAmount) {
//        int N = times.length; // Get the total number of items. Could be wt.length or val.length. Doesn't matter
//        int[][] V = new int[N + 1][timeAmount + 1]; //Create a matrix. Items are in rows and weight at in columns +1 on each side
//        //What if the knapsack's capacity is 0 - Set all columns at row 0 to be 0
//        for (int col = 0; col <= timeAmount; col++) {
//            V[0][col] = 0;
//        }
//        //What if there are no items at home.  Fill the first row with 0
//        for (int row = 0; row <= N; row++) {
//            V[row][0] = 0;
//        }
//        for (int item = 1; item <= N; item++) {
//            //Let's fill the values row by row
//            for (int weight = 1; weight <= timeAmount; weight++) {
//                //Is the current items weight less than or equal to running weight
//                if (times[item - 1] <= weight) {
//                    //Given a weight, check if the value of the current item + value of the item that we could afford with the remaining weight
//                    //is greater than the value without the current item itself
//                    V[item][weight] = Math.max(times[item - 1] + V[item - 1][weight - times[item - 1]], V[item - 1][weight]);
//                } else {
//                    //If the current item's weight is more than the running weight, just carry forward the value without the current item
//                    V[item][weight] = V[item - 1][weight];
//                }
//            }
//        }
//        //Printing the matrix
//        for (int[] rows : V) {
//            for (int col : rows) {
//                System.out.format("%5d", col);
//            }
//            System.out.println();
//        }
//
//        System.out.println("----------------------------------------------");
//        return 0;
//    }
}
