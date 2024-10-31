import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstSingleWord {
    public static String firstSingleWord(String sentence) {
        Map<String, Integer> wordsMap = new LinkedHashMap<>();
        String[] words  = sentence.toLowerCase().replaceAll("[^0-9a-zA-Z\\s]", "").split("\\s+");
        
        for(String currentWord : words) {
            if(wordsMap.containsKey(currentWord)) {
                int newWordFrequency = wordsMap.get(currentWord) + 1;
                wordsMap.put(currentWord, newWordFrequency);
            }
            else {
                wordsMap.put(currentWord, 1);
            }
        }
        
        // removing all words that occur more than once
        wordsMap.entrySet().removeIf(currentKVPair -> currentKVPair.getValue() > 1);
        
        // returning the first single word in the argument sentence
        if(wordsMap.isEmpty())
            return null; // indicating that there are no single words in the sentence
        
        // acessing the first key-value pair in the Linked HashMap
        return wordsMap.entrySet().iterator().next().getKey();
    }
    
    // main test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an sentence: ");
        String firstSingleWord = firstSingleWord(scanner.nextLine());
        
        if(firstSingleWord == null) {
            System.out.println("There are no single words in the sentence.");
        }
        else {
            System.out.printf("First Single Word: \"%s\"", firstSingleWord);
        }
    }
}