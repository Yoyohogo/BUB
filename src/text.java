
import static jdk.nashorn.internal.objects.NativeString.indexOf;
public class text {
    //declare variables
    int pos;
    String text;

    /**
     * this is the constructor
     * pre: iText, iHtmlText 
     * post: constructed text
     */
    public text(String iText, String iHtmlText) {
        //set variables
        text = iText;
        String htmlText = iHtmlText;
        //find position 
        pos = getPosition(text, htmlText);
    }

    /**
     * this method finds the position of the text relative to the entire html code
     * pre: text, htmlText
     * post: position 
     */
    public int getPosition(String text, String htmlText) {
        int position = indexOf(htmlText, text); //set the position to the index of the text in the html code
        return position;
    }

    /**
     * this method sets the position to the number inputed
     * pre: position 
     * post: new position
     */
    public void setPosition(int position) {
        pos = position;
    }

    /**
     * this method returns the text
     * post: returns text 
     */
    public String returnText() {
        return text;
    }

    /**
     * this method returns the position of the text relative to the entire html code
     * post: returns pos 
     */
    public int returnPosition() {
        System.out.println("POS = "+pos);
        return pos;
    }
}
