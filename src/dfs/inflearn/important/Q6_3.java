package dfs.inflearn.important;
// 조합 경우의 수
public class Q6_3 {

    int[] ch;
    int answer;

    public int solution(int[][] cans){

        answer = Integer.MAX_VALUE;

        ch = new int[cans.length];
        DFS(cans, 0, 0);

        return answer;
    }

    public void DFS(int[][] cans, int L, int s) {

        if(L == cans.length / 2) {
            int wSum = 0;
            int bSum = 0;
            for(int i = 0; i < cans.length; i++) {
                if(ch[i] == 0) wSum += cans[i][0];
                else bSum += cans[i][1];
            }

            int dif = Math.abs(wSum - bSum);
            answer = Math.min(answer, dif);
        } else {
            for(int i = s; i < cans.length; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    DFS(cans, L + 1 , s + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        Q6_3 T = new Q6_3();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
