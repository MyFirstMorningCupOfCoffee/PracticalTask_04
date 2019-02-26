package dragonparts;

import static io.OutputWorker.emptyLine;
import static io.OutputWorker.printlnToConsole;
import static io.OutputWorker.printToConsole;
import static io.InputWorker.readIntFromConsole;

public class DragonBodyPartsCalculator 
{
    
    private static final int INITIAL_HEADS_QUANTITY = 3;
    private static final int STAGE_ONE_MAX_AGE = 200;
    private static final int STAGE_TWO_MAX_AGE = 300;
    private static final int STAGE_ONE_GROWTH = 3;
    private static final int STAGE_TWO_GROWTH = 2;
    private static final int STAGE_THREE_GROWTH = 1;
    private static final int EYES_PER_HEAD = 2;
    
    public static void main(String[] args)
    {
        showBriefing();
        
        printToConsole("Please, input you dragon age: ");
        int age = readIntFromConsole();
        
        int heads = getDragonHeadsQuantity(age);
        int eyes = getDragonEyesQuantity(heads);
        
        emptyLine();
        
        printlnToConsole("You dragon should have " + heads + " heads and " 
                            + eyes + " eyes.",
                        "If this quantity differs greatly, please, visit local " 
                            + "vet clinic.");
        
    }
    
    private static int getDragonHeadsQuantity(int age)
    {
        int headsQuantity = INITIAL_HEADS_QUANTITY;
        
        if(age <= STAGE_ONE_MAX_AGE)
        {
            headsQuantity += age * STAGE_ONE_GROWTH;
        }
        else if (age <= STAGE_TWO_MAX_AGE)
        {
            headsQuantity += STAGE_ONE_MAX_AGE * STAGE_ONE_GROWTH
                    + (age - STAGE_ONE_MAX_AGE) * STAGE_TWO_GROWTH;
        }
        else
        {
            headsQuantity += STAGE_ONE_MAX_AGE * STAGE_ONE_GROWTH
                    + STAGE_TWO_MAX_AGE * STAGE_TWO_GROWTH
                    + (age - STAGE_ONE_MAX_AGE - STAGE_TWO_MAX_AGE) * STAGE_THREE_GROWTH;
        }
        
        return headsQuantity;
    }
    
    private static int getDragonEyesQuantity(int heads)
    {
        return heads * EYES_PER_HEAD;
    }
    
    private static void showBriefing()
    {
        printlnToConsole(
            "Greetings!", 
            "This application helps in calculating heads and eyes of dragon with" 
                    + " peculiar properties. Quantity of heads and eyes depends"
                    + " on dragon's age.");

            emptyLine();
    }
}
