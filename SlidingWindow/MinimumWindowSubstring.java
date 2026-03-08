class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) {
            return "";
        }
        int[] need = new int[128];
        //count characteres we need        
        for(int i=0;i<t.length();i++){
          need[t.charAt(i)]++;
        }
        int l=0;
        int missing = t.length();
        int minLen = Integer.MAX_VALUE;
        int start=0;
         // Rule 2: expand window
        for(int r=0; r<s.length();r++){
            char current=s.charAt(r);
             if(need[current]>0) {
                missing--;
             }
             need[current]--;
              // Rule 3 & 4: window valid → shrink
             while(missing==0) {
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    start=l;
                }
                char leftChar = s.charAt(l);
                need[leftChar]++;

                if(need[leftChar]>0) {
                    missing++;
                }
                l++;
             }
           
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
        
    }
}
