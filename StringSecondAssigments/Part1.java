
/**
 * Write a description of Part1 here.
 * 
 * @author (mrsen) 
 * @version (a version number or a date)
 */


public class Part1 {
    public static int findStopCodon(String dna, int startIndex, String stopCodon){
        while(true){
            int stopIndex = dna.indexOf(stopCodon, startIndex);
            if(stopIndex == -1){
                return dna.length();
            }
            else if((startIndex - stopIndex) %3 == 0){
                return stopIndex;
            }
            else{
                startIndex = stopIndex+1;
            }
        }
    }
    
    public static String findGene(String dna, int atgIndex){
        String result = "";
        if(atgIndex == -1){
            return result;
        }
        int taaIndex = findStopCodon(dna, atgIndex, "TAA");
        int tagIndex = findStopCodon(dna, atgIndex, "TAG");
        int tgaIndex = findStopCodon(dna, atgIndex, "TGA");
        int temp = Math.min(taaIndex, tagIndex);
        int minIndex = Math.min(tgaIndex, temp);
        if(minIndex == dna.length()){
            return result;
        }
        result = dna.substring(atgIndex, minIndex+3);
        return result;
    }
    
    public static void findAllGenes(String dna){
        int atgIndex = dna.indexOf("ATG");
        while(atgIndex != -1){
            String gene = findGene(dna, atgIndex);
            if(gene.length() == 0){
                break;
            }
            System.out.println(gene);
            atgIndex = dna.indexOf("ATG", gene.length()+atgIndex);
        }
    }

    public static void testFindStopCodon(){
        int startIndex = 0;
        String stopCodon = "TAA";
        
        String dna1 = "ATGCAAGAATGAGTATAA";
        int loc1 = findStopCodon(dna1, startIndex, stopCodon);
        System.out.println("location of stop codon : " + loc1);
        
        String dna2 = "ATGCAAGAATGAGTACATAA";
        int loc2 = findStopCodon(dna2, startIndex, stopCodon);
        System.out.println("location of stop codon : " + loc2);
        
        String dna3 = "ATGCAAGAATGAGTA";
        int loc3 = findStopCodon(dna3, startIndex, stopCodon);
        System.out.println("location of stop codon : " + loc3);
        
        String dna4 = "AAATGCAAGAATGAGTATAACA";
        int loc4 = findStopCodon(dna4, startIndex, stopCodon);
        System.out.println("location of stop codon : " + loc4);
        
        String dna5 = "CAAGAATAAGTATAA";
        int loc5 = findStopCodon(dna5, startIndex, stopCodon);
        System.out.println("location of stop codon : " + loc5);
    }
    
    public static void testFindGene(){

        String dna1 = "ATGTAA";
        String result1 = findGene(dna1, 0);
        System.out.println("Gene 1 in dna " + dna1+ " is "+result1);
        
        String dna2 = "ATGCAAGAATGAGTATAA";
        String result2 = findGene(dna2, 0);
        System.out.println("Gene 2 in dna " + dna2+ " is "+result2);
        
        String dna3 = "ATGCAAAATGAGTATAA";
        String result3 = findGene(dna3, 0);
        System.out.println("Gene 3 in dna " + dna3+ " is "+result3);
        
        String dna4 = "ATGCAAGAAGTATAAxx";
        String result4 = findGene(dna4, 0);
        System.out.println("Gene 4 in dna " + dna4+ " is "+result4);
        
        String dna5 = "ATGCAAGAxxxyATGAGTATAA";
        String result5 = findGene(dna5, 0);
        System.out.println("Gene 5 in dna " + dna5+ " is "+result5);
        
    }
    
    public static void testFindAllGenes(){
        String dna = "AACATGTAAATGCCATAGAACGTAAATGAAGCCTAACCAATAGAATGATGTAATGATAAAGT";
        findAllGenes(dna);             
    }
    
    public static void main(String[] args){
        Part1 var = new Part1();
        var.testFindAllGenes();
    }
}
