package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        for(Character c : s.toCharArray()) {
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }

        for(Character c : t.toCharArray()) {
            if(mapS.containsKey(c) && mapS.get(c) > 0) {
                mapS.put(c, mapS.get(c) - 1);
            } else {
                return false;
            }
        }

        for(Integer i : mapS.values()) {
            if(i != 0) return false;
        }

        return true;
    }
}
