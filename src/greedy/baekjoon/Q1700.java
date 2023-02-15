package greedy.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1700 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[k];
        for(int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] use = new boolean[101];
        int put = 0;
        int cnt = 0;
        for(int i = 0; i < k; i++) {
            int cur = arr[i];
            if(!use[cur]) {
                if(put < n) { // 콘센트에 꽂을 공간이 있는 경우
                    use[cur] = true;
                    put++;
                } else { // 꽂을 공간이 없는 경우

                    // 1 ) 이후에 사용되는지 확인한다.
                    List<Integer> list = new ArrayList<>();
                    for(int j = i; j < k; j++) {

                        // 현재 꽂혀 있는 장치를 이후에 사용하면 list에 저장한다.
                        if (use[arr[j]] && !list.contains(arr[j])) {
                            list.add(arr[j]);
                        }
                    }

                    if(list.size() != n) { // 나중에 사용하지 않는 장치가 있는 경우
                        for(int j = 0; j < use.length; j++) {
                            if (use[j] && !list.contains(j)) {
                                use[j] = false;
                                break;
                            }
                        }
                    } else { // 모든 장치를 사용해서 마지막 사용될 콘센트를 제거하는 경우
                        int remove = list.get(list.size() - 1);
                        use[remove] = false;
                    }

                    use[cur] = true;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
