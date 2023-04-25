package review;

public class Q1_6 {

    public int solution(int[][] fruit){
        int answer = 0;

        int n = fruit.length;
        int[] ch = new int[n];

        for(int i = 0; i < n - 1; i++) {
            if(ch[i] == 1) continue;
            if(!isMinUnique(fruit[i])) continue;
            for(int j = i + 1; j < n; j++) {
                if(ch[j] == 1) continue;
                if(!isMinUnique(fruit[j])) continue;

                int a = getMinIndex(fruit[i]);
                int b = getMinIndex(fruit[j]);
                if(a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
                    if(fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][a]--;
                        fruit[j][b]++;
                        ch[i] = 1;
                        ch[j] = 1;
                        break;
                    }
                }
            }
        }

        for(int[] x : fruit) {
            answer += getMin(x);
        }

        return answer;
    }

    public int getMin(int[] fruit) {
        int min = Integer.MAX_VALUE;
        for(int x : fruit) {
            min = Math.min(x, min);
        }
        return min;
    }

    public boolean isMinUnique(int[] fruit) {
        int cnt = 0;
        int min = getMin(fruit);
        for(int x : fruit) {
            if(x == min) cnt++;
        }

        return cnt == 1;
    }

    public int getMinIndex(int[] fruit) {
        int min = getMin(fruit);
        for(int i = 0; i < 3; i++) {
            if(fruit[i] == min) return i;
        }
        return 0;
    }

    public static void main(String[] args){
        Q1_6 T = new Q1_6();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
