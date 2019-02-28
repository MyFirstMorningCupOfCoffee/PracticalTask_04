package vowelcheck;

import static io.OutputWorker.emptyLine;
import static io.OutputWorker.printlnToConsole;
import static io.OutputWorker.printToConsole;
import static io.OutputWorker.printToConsoleTwoRowsTable;
import static io.InputWorker.readStringFromConsole;

import java.util.HashSet;

public class VowelCheck 
{
    
    public static void main(String[] args)
    {
        showBriefing();
        
        printToConsole("Please, enter the letter you want to check: ");
        char myChar = readStringFromConsole().charAt(0);
        
        printlnToConsole("So, let us check if your letter is vowel");
        printToConsoleTwoRowsTable(
                "using String.contents method: ", isVowel__StringContents(myChar) + "",
                "using Array: ", isVowel__Array(myChar) + "",
                "using HashSet: ", isVowel__HashSet(myChar) + "");
    }
    
    
    private static void showBriefing()
    {
        printlnToConsole(
            "Greetings!", 
            "This application checks if the letter you enter is a vowel one." 
                    + " In various ways.");

            emptyLine();
    }
    
    private static boolean isVowel__StringContents(char ch)
    {
        String letter = (ch + "").toUpperCase();
        String vowels = "AEIOUY";
        
        return vowels.contains(letter);
    }
    
    private static boolean isVowel__Array(char ch)
    {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        
        ch = Character.toLowerCase(ch);
        
        for(char c : vowels)
        {
            if (c == ch)
            {
                return true;
            }
        }
        
        return false;
    }
    
    private static boolean isVowel__HashSet(char ch)
    {
        
        // init out HashSet
        HashSet<Character> vowelsHS = new HashSet<>();
        char[] vowelsArray = "AEIOUY".toCharArray();
        
        for(char c : vowelsArray)
        {
            vowelsHS.add(c);
        }
        
        // and using it...
        ch = Character.toUpperCase(ch);
        return !vowelsHS.add(ch);

    }
}
