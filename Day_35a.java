LeetCode Problem 165 : Compare Version Numbers
Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'. The value of the revision is its integer conversion ignoring leading zeros.
To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions, treat the missing revision values as 0.
Return the following:
If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.
 
Example 1:
Input: version1 = "1.2", version2 = "1.10"
Output: -1

Code:
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int i = 0, j = 0;
        while (i < a.length || j < b.length) {
            int x = 0, y = 0;
            if (i < a.length) {
                x = Integer.parseInt(a[i]);
                i++;
            }
            if (j < b.length) {
                y = Integer.parseInt(b[j]);
                j++;
            }
            if (x > y) return 1;
            if (x < y) return -1;
        }
        return 0;
    }
}
