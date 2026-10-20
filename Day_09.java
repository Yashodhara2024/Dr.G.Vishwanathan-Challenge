Leetcode Problem 438 : Find All Anagrams in a String
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Code:
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length())
            return ans;
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++)
            count[p.charAt(i) - 'a']++;
        int left = 0;
        int right = 0;
        int required = p.length();
        while (right < s.length()) {
            if (count[s.charAt(right) - 'a'] > 0)
                required--;
            count[s.charAt(right) - 'a']--;
            right++;
            if (right - left > p.length()) {
                if (count[s.charAt(left) - 'a'] >= 0)
                    required++;
                count[s.charAt(left) - 'a']++;
                left++;
            }
            if (required == 0)
                ans.add(left);
        }
        return ans;
    }
}
 
