LeetCode Problem 242 : Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Code:
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
