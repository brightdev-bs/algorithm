package implementation.inflearn;

public class Q1_6 {

    public int getMin(int[][] fruit, int row) {
        int min = Integer.MAX_VALUE;
        for (int i : fruit[row]) {
            min = Math.min(i, min);
        }

        return min;
    }

    public boolean isUniqueCount(int[][] fruit, int row) {
        int min = getMin(fruit, row);
        int count = 0;
        for (int i : fruit[row]) {
            if(i == min) count++;
        }
        return count == 1;
    }

    public int getMinIndex(int[][] fruit, int row) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < 3; i++) {
            if(fruit[row][i] < min) {
                min = fruit[row][i];
                index = i;
            }
        }

        return index;
    }

    public int solution(int[][] fruit){
        int answer = 0;

        int n = fruit.length;

        boolean[] changed = new boolean[n];

        for(int i = 0; i < n; i++) {

            if(changed[i]) continue;
            if(!isUniqueCount(fruit, i)) continue;

            int type1 = getMinIndex(fruit, i);

            for(int j = i + 1; j < n; j++) {
                if(!isUniqueCount(fruit, j)) continue;
                if(changed[j]) continue;

                int type2 = getMinIndex(fruit, j);

                if(type1 == type2) continue;

                if(fruit[i][type1] + 1 <= fruit[i][type2] - 1 && fruit[i][type2] > 0
                    && fruit[j][type2] + 1 <= fruit[j][type1] - 1 && fruit[j][type1] > 0) {
                    fruit[i][type1]++;
                    fruit[i][type2]--;
                    fruit[j][type2]++;
                    fruit[j][type1]--;
                    changed[i] = true;
                    changed[j] = true;
                    break;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            answer += getMin(fruit, i);
        }

        return answer;
    }

    public static void main(String[] args){
        Q1_6 T = new Q1_6();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
