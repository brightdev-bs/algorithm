package leetcode.reivew.string;

import java.util.*;

public class GroupAnagram {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<>();

            Map<String, List<String>> map = new HashMap<>();
            for(String s : strs) {
                char[] arr = s.toCharArray();
                Arrays.sort(arr);
                String str = new String(arr);

                map.putIfAbsent(str, new ArrayList<>());
                map.get(str).add(s);
            }

            for(List<String> list : map.values()) {
                res.add(list);
            }

            return res;
        }
    }
}
