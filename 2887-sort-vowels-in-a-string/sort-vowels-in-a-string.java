import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        char[] result = s.toCharArray();
        
        for (char c : result) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        
        Collections.sort(vowels);
        
        int vowelIndex = 0;
        for (int i = 0; i < result.length; i++) {
            if (isVowel(result[i])) {
                result[i] = vowels.get(vowelIndex);
                vowelIndex++;
            }
        }
        
        return new String(result);
    }
    
    private boolean isVowel(char c) {
        char lowerC = Character.toLowerCase(c);
        return lowerC == 'a' || lowerC == 'e' || lowerC == 'i' || lowerC == 'o' || lowerC == 'u';
    }
}