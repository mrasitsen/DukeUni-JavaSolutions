
/**
 * Write a description of Part1 here.
 * 
 * @author (mrsen) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part3 {
    public static int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = startIndex;
        while(true){
            int stopIndex = dna.indexOf(stopCodon, currIndex);
            if(stopIndex == -1){
                return dna.length();
            }
            else if((startIndex - stopIndex) %3 == 0){
                return stopIndex;
            }
            else{
                currIndex = stopIndex+1;
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
            if(gene.isEmpty()){
                break;
            }
            System.out.println(gene);
            atgIndex = dna.indexOf("ATG", gene.length()+atgIndex);
        }
    }
    
    public static StorageResource getAllGenes(String dna){
        StorageResource store = new StorageResource();
        int atgIndex = dna.indexOf("ATG");
        while(atgIndex != -1){
            String gene = findGene(dna, atgIndex);
            if(gene.isEmpty()){
                break;
            }
            store.add(gene);
            atgIndex = dna.indexOf("ATG", gene.length()+atgIndex);
        }
        return store;
    }
    
    public static float cgRatio(String dna){
        float numOfCG = 0;
        for(int i = 0; i < dna.length(); i++ ){
            if(dna.charAt(i) == 'C' || dna.charAt(i) == 'G'){
                numOfCG++;
            }
        }
        float result = numOfCG / dna.length();
        return result;
    }
    
    public static void processGenes(StorageResource sr){
        int moreThan = 0;
        int count = 0;
        int numberOfCG = 0;
        int length = 0;
        System.out.println("");
        for(String gene : sr.data()){
            if(gene.length() < 9){
                System.out.println("Gene is under 9 : "+gene);
            }
            else{
                System.out.println("Gene is above 9 : "+gene);
            }
   
            if(cgRatio(gene) > 0.35){
                System.out.println("Gene is above 9 : "+gene);
                numberOfCG++;
            }
            
            if(gene.length() > length){
                length = gene.length();
            } 
            
            if(gene.length() > 60){
                moreThan++;
            }
            count++;
        }
        System.out.println("Number of cgRatio genes : " + numberOfCG);
        System.out.println("longest gene length : " + length); 
        System.out.println("Number of the genes : " + count); 
        System.out.println("Number of genes more than 60 letter : " + moreThan); 
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

        String dna1 = "ATGCCTATTGGATCCAAAGAGAGGCCAACATTTTTTGAAATTTTTAAGACACGCTGCAACAAAGCAGATTTAGGACCAATAAGTCTTAA";
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
    
    public static void testGetAllGenes(){
         String dna = "AACATGTAAATGCCATAGAACGTAAATGAAGCCTAACCAATAGAATGATGTAATGATAAAGT";
         StorageResource store = getAllGenes(dna);
         for(String gene : store.data()){
             System.out.println(gene);
         }
    }
    
    public static void testCGRatio(){
        String dna = "AACGGCTAA";
        System.out.println("Ratio : " + cgRatio(dna));
    }
    
    public static void testProcessGenes(){
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        dna = dna.toUpperCase();
        processGenes(getAllGenes(dna));
    }
    
    public static void main(String[] args){
        Part3 var = new Part3();
        var.testProcessGenes();
        System.out.println("------------------END------------------");
    }
}


