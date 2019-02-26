package trianglebycoordinates;

import static io.OutputWorker.emptyLine;
import static io.OutputWorker.printlnToConsole;
import static io.OutputWorker.printToConsole;
import static io.InputWorker.readDoubleFromConsole;

public class TriangleByCoordinates 
{
    public static void main(String[] args)
    {
        showBriefing();
        
        double x1, y1, x2, y2, x3, y3;
        printlnToConsole("Please, input 3 pairs of coordinates");
        printToConsole("x1: "); x1 = readDoubleFromConsole();
        printToConsole("y1: "); y1 = readDoubleFromConsole();
        printToConsole("x2: "); x2 = readDoubleFromConsole();
        printToConsole("y2: "); y2 = readDoubleFromConsole();
        printToConsole("x3: "); x3 = readDoubleFromConsole();
        printToConsole("y3: "); y3 = readDoubleFromConsole();
        
        double side1, side2, side3;
        side1 = getDistanceFromCoords(x1, y1, x2, y2);
        side2 = getDistanceFromCoords(x1, y1, x3, y3);
        side3 = getDistanceFromCoords(x2, y2, x3, y3);
        
        boolean trueTriangle = isTriangle(side1, side2, side3);
        printlnToConsole("The points you entered can create triangle: " + trueTriangle);
        if(trueTriangle)
        {
            // broken method call
            // boolean isRectangleTriangle = isRectangleTriangle(side1, side2, side3);
            
            boolean isRectangleTriangle = isRectangleTriangle(x1, y1, x2, y2, x3, y3);
            printlnToConsole("This triangle is a rectangle one: " + isRectangleTriangle);
        }
        
    }
    
    private static boolean isTriangle(double side1, double side2, double side3)
    {
        return  side1 < side2 + side3 &&
                side2 < side1 + side3 &&
                side3 < side1 + side2;
    }
    
    // broken due to double numbers limitation
    private static boolean isRectangleTriangle(double side1, double side2, double side3)
    {
        System.out.println(side1 + " | " + side2 + " | " + side3);
        return  side1 * side1 == side2 * side2 + side3 * side3 ||
                side2 * side2 == side1 * side1 + side3 * side3 ||
                side3 * side3 == side1 * side1 + side2 * side2;
    }
    
    // works with sides already powered by 2. No errors due to sqrt
    private static boolean isRectangleTriangle(double x1, double y1, double x2, double y2, double x3, double y3)
    {
        double side1p2, side2p2, side3p2;
        side1p2 = Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2);
        side2p2 = Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2);
        side3p2 = Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2);
        
        return  side1p2 == side2p2 + side3p2 ||
                side2p2 == side1p2 + side3p2 ||
                side3p2 == side1p2 + side2p2;
    }
    
    private static double getDistanceFromCoords(double x1, double y1, double x2, double y2)
    {
        double distance = Math.sqrt(  Math.pow((x2 - x1), 2) 
                                    + Math.pow((y2 - y1), 2) );
        
        return distance;
    }
    
    
    private static void showBriefing()
    {
        printlnToConsole(
            "Greetings!", 
            "This application checks if 3 points on plane given by coordinates is a" 
                    + " triangle. And in case if it is - if it is a rectangular one.");

            emptyLine();
    }
}
