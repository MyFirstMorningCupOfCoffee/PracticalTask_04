package io;

import java.util.Scanner;
import java.util.Locale;


public class InputWorker 
{
    
    private InputWorker()
    { }
   
    
    public static String readStringFromConsole()
    {
        return new Scanner(System.in).nextLine();
    }
    
    
    public static Double readDoubleFromConsole()
    {
        String src = readStringFromConsole();
        
        /// bypass delimeter locales problems
        src = src.replaceFirst(",", ".");
        Scanner sc = new Scanner(src);
        sc.useLocale(Locale.UK);
        /// /// /// /// /// /// /// ///
        
        return sc.nextDouble();  
    }
    
    public static int readIntFromConsole()
    {
        String src = readStringFromConsole();
        Scanner sc = new Scanner(src);
        return sc.nextInt();  
    }
    
}