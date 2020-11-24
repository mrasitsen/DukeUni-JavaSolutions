
/**
 * a simple program to print out all "youtube.com" links in an URL
 * 
 * @author (mrsen) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part4 {
    public void findLinks(String url){
        int position = 0;
        URLResource ur = new URLResource(url);
        String content = ur.asString();
        while(true){
            int indexOfKey = content.indexOf("youtube.com", position);
            if(indexOfKey != -1){
                int indexStartQuote = content.lastIndexOf("\"",indexOfKey);
                int indexStopQuote = content.indexOf("\"",indexOfKey+10);
                String link = content.substring(indexStartQuote, indexStopQuote+1);
                System.out.println(link);
                position = indexOfKey+10;
            }
            else{
                System.out.println("end of an era");
                break;
            }
        }
        
    }
    
    public void testFunction(){
        String text = "https://www.dukelearntoprogram.com//course2/data/manylinks.html";
        findLinks(text);
    }
    
    
    public static void main(){
        Part4 var = new Part4();
        var.testFunction();
        
    }
}
