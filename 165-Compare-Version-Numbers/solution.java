public class Solution {
    
    
    //!!!!!!!!!!!!!!
    /*note
    there are 12 characters with special meanings: the backslash \, the caret ^, the dollar sign $, the period or dot ., the vertical bar or pipe symbol |, the question mark ?, the asterisk or star *, the plus sign +, the opening parenthesis (, the closing parenthesis ), and the opening square bracket [, the opening curly brace {, These special characters are often called "metacharacters".
So, if you want to split on e.g. period/dot . which means "any character" in regex, use either backslash \ to escape the individual special character like so split("\\."), or use character class [] to represent literal character(s) like so split("[.]"), or use Pattern#quote() to escape the entire string like so split(Pattern.quote(".")).

http://stackoverflow.com/questions/3481828/how-to-split-a-string-in-java
    */
    
    public int compareVersion(String version1, String version2) {
        String[] v1 = (version1+".0").split("[.]");
        String[] v2 = (version2+".0").split("[.]");
        
        // System.out.println(v1.length);
        
        int i = 0;
        while(i < v1.length && i < v2.length){
            int curV1 = Integer.valueOf(v1[i]);
            int curV2 = Integer.valueOf(v2[i]);
            
            if(curV1 > curV2)
                return 1;
            if(curV1 < curV2)
                return -1;
            i++;
        }
        
        if(i == v1.length && i == v2.length)
            return 0;
        else if(i == v1.length){
            while(i < v2.length){
                if(Integer.valueOf(v2[i]) != 0)
                    return -1;
                i++;
            }
            return 0;
        }
        else{
            while(i < v1.length){
                if(Integer.valueOf(v1[i]) != 0)
                    return 1;
                i++;
            }
            return 0;
        }
    }
}

/*"1.2"
"1.10"

"1.0.1"
"1"
*/
