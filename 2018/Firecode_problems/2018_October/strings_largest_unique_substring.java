// Find largest unique substring

import java.util.*;
import java.util.streams.*;

public static int longestNRSubstringLen(String input) {
    if (input.length() <= 1) { return input.length(); }
    
    // Maps character to last index it was seen
    HashMap<Character, Integer> seenCharacters = new HashMap<>();
    
    int currMaxLength = 0;
    int lastIndexStringBrokenAt = 0;

    char c;
    int index;
    for (int i = 0; i < input.length(); i++) {
        c = input.charAt(i);
        
        // If we've seen this character before, calculate substring len
        if (seenCharacters.containsKey(c)) {
            index = seenCharacters.get(c);
            lastIndexStringBrokenAt = i;
            currMaxLength = Math.max(currMaxLength, i - index);
        }
        seenCharacters.put(c, i);
    }
    
    return Math.max(input.length() - lastIndexStringBrokenAt, currMaxLength);
}