// Time Complexity : O(S+P) where S is the length of the string s and P is the length of the pattern
// Space Complexity : O(S+P) arr (O(S)) and map (O(P))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I used HashMap to map characters in the pattern to words in the string.
// I checked if the character is already mapped to a different word or if the word is already
// mapped to a different character. If both conditions are satisfied, I return false.
// Edge case is if the length of arr and pattern are not equal, I return false.

import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        if(pattern == null || s == null) return false;
        HashMap<Character, String> map = new HashMap<>();
        String [] arr = s.split(" "); // O(s)
        if(arr.length!=pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++){ // O(pattern)
            if(!map.containsKey(pattern.charAt(i))){
                if(!map.containsValue(arr[i])) map.put(pattern.charAt(i), arr[i]);
                else return false;
            }
            else if(!map.get(pattern.charAt(i)).equals(arr[i])) return false;
        }
        return true;
    }
}