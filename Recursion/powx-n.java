class Solution {
    public double myPow(double x, int n) {
        
        // if n is even  ans=x*x  if odd then aans=ans*x
        //example if n=10
        // 2^10= (2*2)^5  == (x*x)^n/2
        // 4^5--> odd= 4*4^4;== 4*256--> final ans;
        // 4^4-->even=(4*4)^2 
        // 16^2=(16*16)=256
        // n=0 break;

        double ans=1.0;
        long m=n;
        if(m<0) m=-1*m;
        while(m>0){
            if(m%2==1){
                //odd;
                ans=ans*x;
                m=m-1;
            }
            else{
                x=x*x;
                m=m/2;
            }
        }
        if(n<0) ans=(double)(1.0)/ (double) (ans);
        return ans;

    }
}
