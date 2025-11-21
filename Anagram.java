/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
        String pStr1 = preProcess(str1).replace(" ", "");
        String pStr2 = preProcess(str2).replace(" ", "");
        
        if (pStr1.length() != pStr2.length()) {
            return false;
        }
        
        if (pStr1.length() == 0) {
            return true;
        }
        
        char[] arr1 = pStr1.toCharArray();
        char[] arr2 = pStr2.toCharArray();
        
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        
        String sortedStr1 = new String(arr1);
        String sortedStr2 = new String(arr2);
        
        return sortedStr1.equals(sortedStr2);
    }
       
    public static String preProcess(String str) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (c == ' ') {
                sb.append(c);
            }
        }
        
        return sb.toString();
    } 
       
    public static String randomAnagram(String str) {
        java.util.List<Character> characters = new java.util.ArrayList<>();
        
        for (char c : str.toCharArray()) {
            characters.add(c);
        }
        
        java.util.Random random = new java.util.Random();
        StringBuilder sb = new StringBuilder();
        
        while (!characters.isEmpty()) {
            int randomIndex = random.nextInt(characters.size());
            
            sb.append(characters.get(randomIndex));
            
            characters.remove(randomIndex);
        }
        
        return sb.toString();
    }
}
