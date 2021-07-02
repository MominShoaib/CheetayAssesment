/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheetayassesment;
import java.util.*;

/**
 *
 * @author Momin
 */

public class CheetayAssesment {

   

   
  

    /**
     * @param args the command line arguments
     */
    
       
     static class meetingTimePair
        {
                    int start; int end; int position;
        public meetingTimePair(int start, int end, int pos)
        {
            this.start = start;
            this.end = end;
            position = pos;
        }
    }
        
        
         private static class MyComparator implements Comparator<meetingTimePair> {

        public MyComparator() {
        }
        
        
        @Override
            public int compare(meetingTimePair m1, meetingTimePair m2)
            {
                    if(m1.end < m2.end)
                        return -1;
                    else if(m1.end > m2.end)
                        return 1;
                    
                 return 0;   
            }
    }

        
            
        
        public static int maxMeetingCalculator(ArrayList<meetingTimePair>meetingList, int size)
        {
            
            ArrayList<Integer> numberOfMeetings = new ArrayList<>();
            int timeLimit = 0;
            MyComparator mc = new MyComparator();
            Collections.sort(meetingList, mc);  //sorting meeting times acording to ending time 
          
            numberOfMeetings.add(meetingList.get(0).position);
            timeLimit = meetingList.get(0).end;
            
            for(int i =1; i < meetingList.size(); i++)
            {
                if(meetingList.get(i).start > timeLimit)
                {
                    numberOfMeetings.add(meetingList.get(i).position);
                    timeLimit = meetingList.get(i).end;
                }
            }
            
            
            return numberOfMeetings.size();
        }
        
        
        
    public static void main(String[] args) {
    //scheduling algorithm of shortest job first can be applied here 
    // we need to sort meeting end times by first to finish, compare that with the start time of next meeting
    

        
        int startingTimes[] = {1,4,2,5,8,5};
        int endingTimes[]= {2,4,6,7,9,9};


        
        //Now we need to pair these start and end times together and store in an array list
        
        ArrayList<meetingTimePair> pairs = new ArrayList<>();
     
        for(int i = 0; i < startingTimes.length; i++)
        {
            
          pairs.add(new meetingTimePair(startingTimes[i],endingTimes[i],i));
        }
        
        System.out.print(maxMeetingCalculator(pairs, pairs.size())); // although not needed, thi still prints max number of meetings possible onto console.
    }


    
}
