class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        if(x==1) return 1;

        long left=1;
        long right =x/2;
        
        while(left<=right) {
            long mid=left+(right-left)/2;
            long squ=mid*mid;
            if(squ==x) {
                return (int)mid ;
            } else if(squ<x) {
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        return  (int)right;

        
    }
}
