
/**
 * simple program to find genes in DNA.
 * in this version, you will define what is the starting codon and ending codon
 * 
 * @author (mrsen) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        
        
        String result = "";
        int startIndex = dna.indexOf(startCodon);
        if(startIndex == -1){
            return "it does not have " + startCodon;
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex+3);
        if(stopIndex == -1){
            return "it does not have " + stopCodon;
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
        String result1 = findSimpleGene(dna1, "ATG", "TAA");
        System.out.println("DNA : " + dna1);
        System.out.println("Result : " + result1);
        
        String dna2 = "ATGAACTATAA";
        String result2 = findSimpleGene(dna2, "ATG", "TAA");
        System.out.println("DNA : " + dna2);
        System.out.println("Result : " + result2);
        
        String dna3 = "AACTGATAA";
        String result3 = findSimpleGene(dna3, "ATG", "TAA");
        System.out.println("DNA : " + dna3);
        System.out.println("Result : " + result3);
        
        String dna4 = "atgaattga";
        String result4 = findSimpleGene(dna4, "atg", "taa");
        System.out.println("DNA : " + dna4);
        System.out.println("Result : " + result4);
        
        String dna5 = "AAATGAACTGATAAGC";
        String result5 = findSimpleGene(dna5, "ATG", "TAA");
        System.out.println("DNA : " + dna5);
        System.out.println("Result : " + result5);
        
    }
    
    public static void main(){
        
        Part2 testGene = new Part2();
        testGene.testSimpleGene();
        
    }

}
