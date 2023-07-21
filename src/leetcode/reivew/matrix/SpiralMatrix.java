package leetcode.reivew.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    final int RIGHT = 0;
    final int DOWN = 1;
    final int LEFT = 2;
    final int UP = 3;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();

        if(matrix == null || matrix.length == 0) return answer;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while(left <= right && top <= bottom) {
            for(int i = left; i <= right; i++) {
                answer.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++) {
                answer.add(matrix[i][right]);
            }
            right--;

            for(int i = right; i >= left; i--) {
                answer.add(matrix[bottom][i]);
            }
            bottom--;

            for(int i = bottom; i >= top; i--) {
                answer.add(matrix[i][left]);
            }
            left++;
        }

        return answer;
    }

    public static void main(String[] args) {
        SpiralMatrix m = new SpiralMatrix();
        List<Integer> integers = m.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
