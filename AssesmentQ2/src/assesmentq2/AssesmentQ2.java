/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assesmentq2;
import java.util.*;
/**
 *
 * @author Momin
 */
public class AssesmentQ2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //  eg, 4, 320, 2, simple sorting would give
      // 32042 as answer, which is wrong, so we need comparison sort
      // comparing 4320 and 3204, if 4320 > 3204.. put 4 first and so on
      
      Vector<String> numberList;
      numberList = new Vector<>();
      numberList.add("4");
      numberList.add("320");
      numberList.add("2");
      numberList.add("878");
      numberList.add("630");
      
      PrintLargest(numberList);
    
      
      
    }
    
   
   static void PrintLargest(Vector<String> nList)
    {
        Collections.sort(nList, new Comparator<String>()
                {
                    @Override public int compare(String X, String Y)
                    {
                        String XY = X + Y; // concatenating X and Y
                        String YX = Y + X; //Concatenating Y and X
                        
                        return XY.compareTo(YX) > 0 ? -1:1;  
                        
                    }
                });
        
        Iterator count = nList.iterator();
        
        while(count.hasNext())
        {
            System.out.print(count.next());
        }
        
    }
    
}
  

