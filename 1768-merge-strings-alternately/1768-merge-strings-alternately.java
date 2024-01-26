class Solution {
    public String mergeAlternately(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        StringBuilder result = new StringBuilder();

        int  i  = 0;

        for(i = 0;i < n; i++)
        {
            result.append(word1.charAt(i));
            if(i < m)
            result.append(word2.charAt(i));
        }

        if(m > n)
        {
            for(int j=i; j <m;j++)
            result.append(word2.charAt(j));
        }

        return result.toString();
        
    }
}