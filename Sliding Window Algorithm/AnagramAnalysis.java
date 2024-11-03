import java.util.ArrayList;
import java.util.List;

public class AnagramAnalysis {
    public static List<Integer> slidingWindow(String str1, String str2) {
        int str1_LENGTH = str1.length();
        int str2_LENGTH = str2.length();
        List<Integer> startIndexAnagrams  = new ArrayList<>();
        
        for(int i = 0; i <= str1_LENGTH - str2_LENGTH; i++) {
            String currentSubstring = str1.substring(i, i + str2_LENGTH);
            int sameWords = 0;
            List<Character> charactersAnalyzed = new ArrayList<>();
            
            for(int j = 0; j < currentSubstring.length(); j++) // traverses the current subset of str1
                for(int k = 0; k < str2_LENGTH; k++) // traverses the str2
                    if(currentSubstring.charAt(j) == (str2.charAt(k)) && !charactersAnalyzed.contains(currentSubstring.charAt(j))) {
                    sameWords++;
                    charactersAnalyzed.add(currentSubstring.charAt(j));
                    }
            
            if(sameWords == str2_LENGTH) 
                startIndexAnagrams.add(i);
        } // end of first 'for' loop

        return startIndexAnagrams;
    } // end of method

    // main test	    
    public static void main(String[] args) {
        String strTest = "ABCDEBCACB";
        String strAnagram = "ABC";
        List<Integer> indexOcurrences = slidingWindow(strTest, strAnagram);
        System.out.println(indexOcurrences);
    }
}