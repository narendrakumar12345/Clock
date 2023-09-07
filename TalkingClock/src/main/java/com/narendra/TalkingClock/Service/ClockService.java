package com.narendra.TalkingClock.Service;

import org.springframework.stereotype.Service;

@Service
public class ClockService {

	public String printWords(int h, int m)
    {
        String nums[] = { "zero", "one", "two", "three", "four",
                            "five", "six", "seven", "eight", "nine",
                            "ten", "eleven", "twelve", "thirteen",
                            "fourteen", "fifteen", "sixteen", "seventeen",
                            "eighteen", "nineteen", "twenty", "twenty one",
                            "twenty two", "twenty three", "twenty four",
                            "twenty five", "twenty six", "twenty seven",
                            "twenty eight", "twenty nine",
                        };
      String s="";
        if (m == 0 && h==12)
            s=nums[h] + " o'clock ";
        
        else if (m == 0)
            s=nums[h%12] + " o'clock ";
      
        else if (m == 1 && h==12)
            s="One past " +nums[h];
        
        else if (m == 1)
            s="One past " +nums[h%12];
      
        else if (m == 59)
            s="One to " + nums[(h % 12) + 1];
      
        else if (m == 15 && h==12)
            s="Quarter past " + nums[h];
        
        else if (m == 15)
           s="Quarter past " + nums[h%12];
      
        else if (m == 30 && h==12)
            s="Half past " + nums[h];
        
        else if (m == 30)
            s="Half past " + nums[h%12];
      
        else if (m == 45)
            s="Quarter to " +  nums[(h % 12) + 1];
      
        else if (m <= 30 && h==12)
            s= nums[m] + " past " + nums[h];
        
        else if (m <= 30)
            s= nums[m] + " past " + nums[h%12];
      
        else if (m > 30)
            s= nums[60 - m] + " to " + nums[(h % 12) + 1];
        
        s=s.toLowerCase();
		s=s.substring(0,1).toUpperCase().concat(s.substring(1));
		return s;
    }
}
