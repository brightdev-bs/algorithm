package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();
        Set<List<Integer>> set2 = new HashSet<>();

        set.add(List.of(1, 2, 3));
        set.add(List.of(2, 1, 3));
        set2.add(List.of(2, 1, 3));


        for (List<Integer> integers : set) {
            System.out.println(integers);
        }
    }
}
