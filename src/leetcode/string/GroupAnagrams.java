package leetcode.string;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        int[] ch = new int[26];
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            String signature = getSignature(s);
            map.putIfAbsent(signature, new ArrayList<>());
            map.get(signature).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String getSignature(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(count[i] != 0) {
                sb.append((char) ('a' + i)).append(count[i]);
            }
        }

        return sb.toString();
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);

            map.putIfAbsent(str, new ArrayList<>());
            map.get(str).add(s);
        }

        return new ArrayList<>(map.values());

    }
}
