import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountWordOccurrences {
    public static Map<String, Integer> CountWordOccurrences(String sentence) {
        Map<String, Integer> wordsMap = new HashMap<>();
        
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
        return wordsMap;
    } 

    // main test
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter an sentence: ");
      System.out.println("Occurrences Number of each word\n" +CountWordOccurrences(scanner.nextLine()));
    }
}