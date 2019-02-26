package nextdaydate;

import static io.OutputWorker.emptyLine;
import static io.OutputWorker.printlnToConsole;
import static io.OutputWorker.printToConsole;
import static io.InputWorker.readIntFromConsole;

public class NextDayDate 
{
    public static void main(String[] args)
    {
        showBriefing();
        
        int day, month, year;
        printlnToConsole("Please, input your date");
        printToConsole("day of month: "); day = readIntFromConsole();
        printToConsole("       month: "); month = readIntFromConsole();
        printToConsole("        year: "); year = readIntFromConsole();
        
        int daysInCurrMonth = daysInMonth(month);
        if(isLeapYear(year) && (month == 2))
        {
            daysInCurrMonth++;
        }
        
        if(day < daysInCurrMonth)
        {
            day++;
            printNextDayDate(day, month, year);
        }
        else if(month != 12)
        {
            day = 1;
            month++;
            printNextDayDate(day, month, year);
        }
        else
        {
            day = 1;
            month = 1;
            year++;
            printNextDayDate(day, month, year);
        }
        
        
    }
    
    private static void printNextDayDate(int day, int month, int year)
    {
        printlnToConsole("next day date is " + day + "/" + month + "/" + year);
    }
    
    private static int daysInMonth(int month)
    {
        switch(month)
        {
            case(1): return 31;
            case(2): return 28;
            case(3): return 31;
            case(4): return 30;
            case(5): return 31;
            case(6): return 30;
            case(7): return 31;
            case(8): return 31;
            case(9): return 30;
            case(10): return 31;
            case(11): return 30;
            case(12): return 31;
            default: return -1;
            
        }
    }
    
    private static boolean isLeapYear(int year)
    {
        boolean responce = false;
        
        if(year % 4 == 0)
        {
            if(year % 100 != 0)
            {
                responce = true;
            }
            else if(year % 400 == 0)
            {
                responce = true;
            }
        }
        
        return responce;
        
    }
    
    private static void showBriefing()
    {
        printlnToConsole(
            "Greetings!", 
            "This application calculates next date after the date you enter");

            emptyLine();
    }
}
