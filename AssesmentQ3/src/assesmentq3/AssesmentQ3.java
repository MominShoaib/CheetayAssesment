/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assesmentq3;

/**
 *
 * @author Momin
 */
public class AssesmentQ3 {

    
    public static void main(String[] args) {
        //Solution that I thought up was having a much larger
        //Time complexity of around O(n^2)
        //Had to search online to find Manachers Algo
        //Using it with references from internet 
        //to complete this question
        
        String exampleString = "aaabbaa";
        findLongestPalindromeString(exampleString);
        
        
    }
    
    
    static String findLongestPalindromeString(String s)
    {
        int length = s.length();
        
        if(length == 0)
            return "-1";
        length = 2 * length + 1; //to count position
        int[]longestPalindrome = new int[length +1]; //LPS Length arr
        longestPalindrome[0] = 0;
        longestPalindrome[1] = 1;
        int centerPosition =1;
        int centerRightPosition =2;
        int currentRightPosition =0;
        int currentLeftPosition;
        int maxPalindromeLength = 0;
        int maxPalindromeCenterPosition = 0;
        int start = -1;
        int end  = -1;
        int difference = -1;
        
        for(currentRightPosition =2; currentRightPosition < length ; currentRightPosition++ )
        {
            currentLeftPosition = 2*centerPosition -currentRightPosition;
            longestPalindrome[currentRightPosition]=0;
            difference = centerRightPosition - currentRightPosition;
            
            
            if(difference > 0)
            {
                longestPalindrome[currentRightPosition]= Math.min(longestPalindrome[currentLeftPosition], difference);
            }
            
            while(((currentRightPosition + longestPalindrome[currentRightPosition]+1 < length ) 
                    &&(currentRightPosition - longestPalindrome[currentRightPosition]>0)
                    && (((currentRightPosition+longestPalindrome[currentRightPosition]+1)%2 == 0)
                    || (s.charAt((currentRightPosition+longestPalindrome[currentRightPosition]+1)/2)
                    == s.charAt((currentRightPosition - longestPalindrome[currentRightPosition]-1)/2)))))
                    {
                        longestPalindrome[currentRightPosition]++;
                    }
            
            if(longestPalindrome[currentRightPosition] > maxPalindromeLength)
            {
                maxPalindromeLength = longestPalindrome[currentRightPosition];
                maxPalindromeCenterPosition = currentRightPosition;
            }
        
            if(currentRightPosition + longestPalindrome[currentRightPosition] > centerRightPosition )
            {
                centerPosition = currentRightPosition;
                centerRightPosition = currentRightPosition + longestPalindrome[currentRightPosition];
            }
            
            start = (maxPalindromeCenterPosition - maxPalindromeLength)/2;
            end = start + maxPalindromeLength - 1;
            
            for(currentRightPosition = start;currentRightPosition<=end;currentRightPosition++)
                System.out.print(s.charAt(currentRightPosition));
        
        }
        
        return s;
   }
    
}
