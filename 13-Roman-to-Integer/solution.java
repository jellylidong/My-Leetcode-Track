public class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        
        for(int i = 0; i < s.length();){
            char c = s.charAt(i);
            if(c == 'I'){
                if(i+1 < s.length() && s.charAt(i+1) == 'V'){
                    sum += 4;
                    i += 2;
                }
                else if(i+1 < s.length() && s.charAt(i+1) == 'X'){
                    sum += 9;
                    i += 2;
                }
                else{
                    sum += 1;
                    i++;
                }
            }
            
            else if(c == 'V'){
                sum += 5;
                i++;
            }
            
            else if(c == 'X'){
                 if(i+1 < s.length() && s.charAt(i+1) == 'L'){
                    sum += 40;
                    i += 2;
                }
                else if(i+1 < s.length() && s.charAt(i+1) == 'C'){
                    sum += 90;
                    i += 2;
                }
                else{
                    sum += 10;
                    i++;
                }
            }
            
            else if(c == 'L'){
                sum += 50;
                i++;
            }
            
            else if(c == 'C'){
                 if(i+1 < s.length() && s.charAt(i+1) == 'D'){
                    sum += 400;
                    i += 2;
                }
                else if(i+1 < s.length() && s.charAt(i+1) == 'M'){
                    sum += 900;
                    i += 2;
                }
                else{
                    sum += 100;
                    i++;
                }
            }
            
            else if(c == 'D'){
                sum += 500;
                i++;
            }
            else if(c == 'M'){
                sum += 1000;
                i++;
            }
            
            
        }
        
        return sum;
    }
}