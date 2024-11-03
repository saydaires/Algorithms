import java.util.List;
import java.util.ArrayList;
public class AnagramGrouping {
    public static List<List<String>> sublistsAnagram(List<String> listOfStrings) {
        List<List<String>> sublistsAnagram = new ArrayList<>();
        for(int i = 0; i < listOfStrings.size(); i++) {
            String currentString = listOfStrings.get(i);
            boolean currentStringAlreadyListed = false;
            
            for(List<String> listAlreadyExistent : sublistsAnagram) {
                for(String stringListed : listAlreadyExistent) 
                    if(stringListed.equals(currentString)) {
                        currentStringAlreadyListed = true;
                        break;
                    }
                if(currentStringAlreadyListed)
                    break;
            }
            
            if(currentStringAlreadyListed)
                continue; // means that the substring currently analyzed is already in one of the sublists 
           
            List<String> currentSublist = new ArrayList<>();
            currentSublist.add(currentString);
            
            for(int j = i + 1; j < listOfStrings.size(); j++) {
                String nextString = listOfStrings.get(j);
                if(nextString.length() != currentString.length())
                    continue; // reiterate the loop, because the strings are not anagrams
                
                int LENGTH_OF_STRINGS = currentString.length();
                int sameWordsCount = 0;
                List<Character> charactersAnalyzed = new ArrayList<>();
                // at this point, it's guaranteed that the strings have the same size
                for(Character currentStringChar : currentString.toCharArray()) {
                    for(Character nextStringChar : nextString.toCharArray())
                        if(currentStringChar.equals(nextStringChar) && !charactersAnalyzed.contains(currentStringChar)) {
                            sameWordsCount++;
                            charactersAnalyzed.add(currentStringChar);
                            break; // iterate for the next char of 'nextString'
                        }
                }
                if(sameWordsCount == LENGTH_OF_STRINGS) // both strings are same anagrams's
                    currentSublist.add(nextString);             
            } // second normal 'for' end
            
            if(currentSublist.size() > 1) // only adds sublists with more than one anagram*/
                sublistsAnagram.add(currentSublist);
        } // first normal 'for' end
        
        return sublistsAnagram;
    }
    
    // main test
    public static void main(String[] args) {
        List<String> StringsList = new ArrayList<>();
        StringsList.add("ABC");
        StringsList.add("DEF");
        StringsList.add("CAB");
        StringsList.add("EDF");
        StringsList.add("ACB");
        StringsList.add("FGH");
        StringsList.add("ABC");
        StringsList.add("CBA");
        StringsList.add("DEF");
        StringsList.add("ACB");
        StringsList.add("HFG");
        StringsList.add("EFD");
        StringsList.add("XYZ"); // it will not be sublisted, because it has no other anagrams
        List<List<String>> generalList = sublistsAnagram(StringsList);

        System.out.println("LIST OF STRINGS: " + StringsList + "\n");
        System.out.println("LIST OF ANAGRAMS SUBLISTS: " + generalList);
    }
}