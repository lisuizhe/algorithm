package Q0050_Pow_x_n;

class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long absN = n > 0 ? (long)n : -((long)n);
        while(absN > 0) {
            if ((absN & 1) ==1) {
                ans *= x;
            } 
            absN >>= 1;
            x *= x;
        }
        return n < 0 ?  1/ans : ans;
    }
}