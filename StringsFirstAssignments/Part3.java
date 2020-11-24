
/**
 * a simple program that have 2 methods
 * first one is checking if a string is seen in another string two times or not.
 * it returns true if it is, false otherwise
 * 
 * second program find a string in another string, it prints string after 
 * found one. if it cant find, it prints whole string. 
 * 
 * @author (mrsen) 
 * @version (a version number or a date)
 */
import java.util.*;

public class Part3 {
    public static boolean twoOccurences(String stringA, String stringB){
        boolean result = false;
        int count = 0;
        int lastPos = 0;
        while(count < 2){
            int index = stringB.indexOf(stringA, lastPos);
            if(index == -1){
                break;
            }
            lastPos = index+stringA.length();
            count++;
        }
        if(count >= 2){
            result = true;
        }
        return result;
    }
    
    public static String lastPart(String stringA, String stringB){
        String result = "";
        int index = stringB.indexOf(stringA);
        if(index == -1){
            return stringB;
        }
        result = stringB.substring(index+stringA.length());
        return result;
    }
    
    public static void testTwoOccurences(){
        List<String> stringFirst = new ArrayList<String>();
        List<String> stringSecond = new ArrayList<String>();
        stringFirst.add("damn");
        stringFirst.add("a");
        stringFirst.add("x");
        stringFirst.add("rasit");
        stringFirst.add("asim");
        stringFirst.add("melodi");
        stringFirst.add("ss");
        stringFirst.add("abc");
        stringFirst.add("qwer");
        stringFirst.add("qwert");
        
        stringSecond.add("banana");
        stringSecond.add("damn");
        stringSecond.add("xxolumxx");
        stringSecond.add("merhalar aq");
        stringSecond.add("");
        stringSecond.add("melodi lojistik ins tur teks");
        stringSecond.add("ssxssss");
        stringSecond.add("acbads");
        stringSecond.add("qwer");
        stringSecond.add("qwertqwert");
        
        for(int i = 0;i < 10; i++){
            String stringA = stringFirst.get(i);
            String stringB = stringSecond.get(i);
            //activate if you want to test first algorithm
            //if(twoOccurences(stringA, stringB)){ 
            //  System.out.println(stringA +" is 2 times in " + stringB);
            //}
            //else{
            //  System.out.println(stringA +" is not in " + stringB);
            //}
            String result = "";
            result = lastPart(stringA, stringB);
            System.out.println("StringA : "+stringA+" stringB : "+stringB);
            System.out.println("result : "+result);
        }
        
        
    }
    
    
    public static void main(String[] args){
        Part3 testPart3 = new Part3();
        testPart3.testTwoOccurences();
    }
}
