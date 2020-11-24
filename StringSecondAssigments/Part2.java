
/**
 * Write a description of Part1 here.
 * 
 * @author (mrsen) 
 * @version (a version number or a date)
 */


public class Part2 {
    public static int countOccurances(String stringA, String stringB){
        int count = 0;
        int stopIndex = 0;  
        while(true){
            int startIndex = stringB.indexOf(stringA, stopIndex);
            if(startIndex == -1){
                break;
            }
            stopIndex = startIndex+stringA.length();
            count++;
        }
        return count;
    }

    public static void testCountOccurances(){
        String stringA = "AA";
        String stringB = "BAABAAAA";
        System.out.println("Number of occurances : " + countOccurances(stringA, stringB));
    }
    
    public static void main(String[] args){
        Part2 var = new Part2();
        var.testCountOccurances();
    }
}
