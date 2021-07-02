/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assesmentq1;
import java.util.*;
/**
 *
 * @author Momin
 */
public class AssesmentQ1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String exampleString = "ccad";
        int length = exampleString.length();
        
       System.out.println(chooseandswap(exampleString.toCharArray(), length));
        
    }
    
    
    static int MAX = 26;
  
// Function to return the lexicographically
// smallest string after swapping all the
// occurrences of any two characters
static String chooseandswap(char []s, int n)
{
    int i, j = 0;
      
    // To store the first index of
    // every character of str
    int []firstIndex = new int[MAX];
    for (i = 0; i < MAX; i++)
        firstIndex[i] = -1;
  
    // Store the first occurring
    // index every character
    for (i = 0; i < n; i++) 
    {
  
        // If current character is appearing
        // for the first time in str
        if (firstIndex[s[i] - 'a'] == -1)
            firstIndex[s[i] - 'a'] = i;
    }
  
    // Starting from the leftmost character
    for (i = 0; i < n; i++)
    {
        boolean flag = false;
  
        // For every character smaller than str[i]
        for (j = 0; j < s[i] - 'a'; j++) 
        {
  
            // If there is a character in str which is
            // smaller than str[i] and appears after it
            if (firstIndex[j] > firstIndex[s[i] - 'a']) 
            {
                flag = true;
                break;
            }
        }
  
        // If the required character pair is found
        if (flag)
            break;
    }
  
    // If swapping is possible
    if (i < n) 
    {
  
        // Characters to be swapped
        char ch1 = s[i];
        char ch2 = (char) (j + 'a');
  
        // For every character
        for (i = 0; i < n; i++)
        {
  
            // Replace every ch1 with ch2
            // and every ch2 with ch1
            if (s[i] == ch1)
                s[i] = ch2;
  
            else if (s[i] == ch2)
                s[i] = ch1;
        }
    }
  
    return String.valueOf(s);
}
    
}
