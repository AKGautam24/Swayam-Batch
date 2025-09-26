class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0) return "";

        int maxlength = 0;
        int start=0;
        for(int i=0;i<s.length();i++) {
            for(int j=i;j<s.length();j++) {
                if(isPalindrome(s,i,j)) {
                    if(j-i+1>maxlength) {
                        maxlength=j-i+1;
                        start=i;
                    }
                }

            }
        }
        return s.substring(start,start+maxlength);

        
    }
    public static boolean isPalindrome(String s, int left, int right) {
        while(left<right) {
            if(s.charAt(left)!=s.charAt(right)) {
                return false;

            }
            left++;
            right--;
        }
        return true;
    }
}
