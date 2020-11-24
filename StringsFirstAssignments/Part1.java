
/**
 * simple program to find gene in a sequence of DNA
 * gene codons start from ATG and ends at TAA
 * 
 * @author (mrsen) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
        
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "it does not have ATG";
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if(stopIndex == -1){
            return "it does not have TAA";
        }
        
        if((stopIndex - startIndex)%3==0){
            result = dna.substring(startIndex, stopIndex+3);
            return result;
        }
        else{
            return "this is not a valid gene";
        }
        
    }
    
    public void testSimpleGene(){
        String dna1 = "ATGAACTGATAA";
        String result1 = findSimpleGene(dna1);
        System.out.println("DNA : " + dna1);
        System.out.println("Result : " + result1);
        
        String dna2 = "ATGAACTATAA";
        String result2 = findSimpleGene(dna2);
        System.out.println("DNA : " + dna2);
        System.out.println("Result : " + result2);
        
        String dna3 = "AACTGATAA";
        String result3 = findSimpleGene(dna3);
        System.out.println("DNA : " + dna3);
        System.out.println("Result : " + result3);
        
        String dna4 = "ATGAACTGA";
        String result4 = findSimpleGene(dna4);
        System.out.println("DNA : " + dna4);
        System.out.println("Result : " + result4);
        
        String dna5 = "AAATGAACTGATAAGC";
        String result5 = findSimpleGene(dna5);
        System.out.println("DNA : " + dna5);
        System.out.println("Result : " + result5);
        
    }
    
    
    
    public static void main(String[] args){
        Part1 testVar = new Part1();
        testVar.testSimpleGene();
    }

}
