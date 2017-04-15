import model.Talk;
import util.GeneralUtil;

import java.util.ArrayList;


/**
 * Created by vinicius on 14/04/17.
 */
public abstract class KnapSack {


    /**
     * This is a basic solution for KnapSack algorithm
     *
     * @param talks      all talks
     * @param timeAmount the amount of time available
     * @return
     */
    public static ArrayList<Talk> solution(ArrayList<Talk> talks, int timeAmount) {
        int size = talks.size();
        int[][] matrix = new int[size + 1][timeAmount + 1]; //Create a matrix. Items are in rows and weight at in columns +1 on each side
        for (int col = 0; col <= timeAmount; col++) {
            matrix[0][col] = 0;
        }
        for (int row = 0; row <= size; row++) {
            matrix[row][0] = 0;
        }
        for (int item = 1; item <= size; item++) {
            for (int weight = 1; weight <= timeAmount; weight++) {
                if (talks.get(item - 1).getDuration() <= weight) {
                    matrix[item][weight] = Math.max(talks.get(item - 1).getDuration() + matrix[item - 1][weight - talks.get(item - 1).getDuration()], matrix[item - 1][weight]);
                } else {
                    matrix[item][weight] = matrix[item - 1][weight];
                }
            }
        }

        //Let it here for debug
        //Printing the matrix
//        for (int[] rows : matrix) {
//            for (int col : rows) {
//                System.out.format("%5d", col);
//            }
//            System.out.println();
//        }
//        System.out.println("----------------------------------------------");
//

        //mounting the solution
        ArrayList<Talk> talkArrayListSolution = new ArrayList<>();
        for (int row = 1; row < matrix.length; row++) {
            int value = (matrix[row][matrix[row].length - 1] - (matrix[row - 1][matrix[row - 1].length - 1]));
            Talk talk = GeneralUtil.getFirstAndDelete(value, talks);
            if (talk != null)
                talkArrayListSolution.add(talk);
        }

        return talkArrayListSolution;
    }
}
