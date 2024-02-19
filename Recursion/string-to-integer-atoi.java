class Solution {
    public int myAtoi(String s) {
        int l=s.length();
        if(l==0)return 0;
        int i=0;
        while(i<l && s.charAt(i)==' '){
            i++;
        }

        if(i==l) return 0;
        char ch=s.charAt(i);
        boolean neg=(ch=='-');
        if(neg || ch=='+'){
            i++;
        }
        int limit=Integer.MAX_VALUE/10;

        int res=0;
        while(i<l && isDigit( ch=s.charAt(i))){
            int d=ch-'0';
            if(res>limit || (res==limit && d>7)){
                return neg? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
            res=res*10 +d;
            i++;
        }

        return neg? -res:res;

    }

    private boolean isDigit(char ch){
        return ch>='0' && ch<='9';
    }
}
