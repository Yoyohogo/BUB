//imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.indexOf;

public class Splash extends javax.swing.JFrame {

    static String title; //global String to store the title
    File url = new File ("C:\\lastURL.txt");
    public Splash() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        urlInput = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        lastViewed = new javax.swing.JButton();
        test = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(400, 300));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/A little bit bigger.png"))); // NOI18N

        urlInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlInputActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        lastViewed.setText("Display Last Viewed Page");
        lastViewed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastViewedActionPerformed(evt);
            }
        });

        test.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lastViewed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(test, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(urlInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(urlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lastViewed)
                .addGap(18, 18, 18)
                .addComponent(test)
                .addContainerGap(222, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lastViewedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastViewedActionPerformed
        //try-catch for error handling if file cannot be read
        try {
            FileReader out = new FileReader(url); //opens output stream
            BufferedReader readFile = new BufferedReader(out);
            String line;
            
            while ((line = readFile.readLine()) != null ) { //retrieve URL from file and use to search
            search(line);
            }
            
            readFile.close(); //close the output stream
            out.close();
            
            
        
            
        } catch (IOException e) {
            test.setText("Error: No previous URL on record.");
        }
        

    }//GEN-LAST:event_lastViewedActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        //try-catch for error handling if invalid URL is entered
        try {
            test.setText(""); //clear error field
            search(urlInput.getText()); //call search method with inputted url
            
            FileWriter in = new FileWriter(url); //opens input stream
            BufferedWriter writeFile = new BufferedWriter(in);
            writeFile.write(""+urlInput.getText()); //store the URL into the file for later use
            writeFile.close(); //close input stream
            in.close();
            
        } catch (IOException e) {
            test.setText("Please provide a valid URL.");
        }


    }//GEN-LAST:event_searchButtonActionPerformed

    private void urlInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlInputActionPerformed
        //try-catch for invalid URL input
        try {
            search(urlInput.getText());
            
            FileWriter in = new FileWriter(url); //opens input stream
            BufferedWriter writeFile = new BufferedWriter(in);
            writeFile.write(""+urlInput.getText()); //store the URL into the file for later use
            writeFile.close(); //close input stream
            in.close();
            
        } catch (IOException e) {
            test.setText("Please provide a valid URL.");
        }
    }//GEN-LAST:event_urlInputActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash().setVisible(true);
            }
        });
    }
    
    /**
     * this method connects to a website, stores all of its html code and then calls methods to organize the html code
     * pre: url
     * post: calls methods to search and sort html code
     */
    public void search(String url) throws IOException {
        //declare variable
        String htmlText; 
        
        //connect to website
        URLConnection connection;
        connection = new URL(url).openConnection();
        Scanner kb = new Scanner(connection.getInputStream());
        kb.useDelimiter("\\Z");
        
        //organize information 
        htmlText = kb.next(); //store html code in String
        System.out.println(htmlText);
        titleFind(htmlText); //find the title of the website
        ArrayList<text> paragraphs = bodyFind(htmlText); //find the paragraphs of the website
        ArrayList<text> headers = headerFind(htmlText); //find the headers of the website
        ArrayList<text> bolds = boldFind(htmlText); //find the headers of the website
        ArrayList<text> unders = underFind(htmlText); //find the headers of the website
        ArrayList<text> breaks = breakFind(htmlText); //find the headers of the website
        sort(paragraphs, headers, bolds, unders, breaks); //order headers and paragraphs into the order in which they appear
    }

    /**
     * this method finds and records the title of the website
     * pre: htmlText 
     * post: sets the title 
     */
    public void titleFind(String htmlText) {
        int indexOfStart = indexOf(htmlText, "<title>") + 7; //find the start of the title
        int indexOfEnd = indexOf(htmlText, "</title>"); //find the end of the title
        title = htmlText.substring(indexOfStart, indexOfEnd); //create a substring containing the title 
    }
    
    /**
     * This method returns the title 
     * post: returns title
     */
    public static String titleGet() {
        return title; 
    }

    /**
     * This method converts all paragraphs into paragraph objects and then stores them in an ArrayList
     * pre: htmlText
     * post: paragraphs 
     */
    public static ArrayList<text> bodyFind(String htmlText) {
        //declare variables
        String htmlTextRemain = htmlText;
        int indexOfStart = 0;
        int indexOfEnd = 0;
        ArrayList<text> paragraphs = new ArrayList<text>();
        
        //find and store all paragraphs in a String ArrayList
        while (htmlTextRemain.contains("<p>")) { //keep searching if paragraphs remain
            indexOfStart = indexOf(htmlTextRemain, "<p>"); //find the start of the paragraph
            indexOfEnd = indexOf(htmlTextRemain, "</p>"); //find the end of the paragraph          
            if (indexOfStart < indexOfEnd) { //If statement to catch errors   
                paragraphs.add(new text(htmlTextRemain.substring(indexOfStart, indexOfEnd), htmlText)); //create paragraph object and add paragraph to the ArrayList
            }
            htmlTextRemain = htmlTextRemain.substring(indexOfEnd + 4, htmlTextRemain.length()); //Remove the html code already searched
        }
        
        return paragraphs;
    }

    /**
     * This method converts all headers into header objects and then stores them in an ArrayList
     * pre: htmlText
     * post: headers 
     */
    public static ArrayList<text> headerFind(String htmlText) {
        //declare variables
        String htmlTextRemain = htmlText;
        int indexOfStart = 0;
        int indexOfEnd = 0;
        ArrayList<text> headers = new ArrayList<text>();
        
        //find and store all headers in a String ArrayList
        while (htmlTextRemain.contains("<h")) { //keep searching if headers remain
            String i = htmlTextRemain.substring(indexOf(htmlTextRemain, "<h") + 2, indexOf(htmlTextRemain, "<h") + 3); //obtain the character after h
            if ("1".equals(i) || "2".equals(i) || "3".equals(i) || "4".equals(i) || "5".equals(i) || "6".equals(i)) { //check if the character after h is a size (numbers 1-6)
                indexOfStart = indexOf(htmlTextRemain, "<h" + i); //find the start of the header
                indexOfEnd = indexOf(htmlTextRemain, "</h" + i + ">") + 4; //find the end of the header                          
                if (indexOfStart < indexOfEnd) { //If statement to catch errors   
                    headers.add(new text(htmlTextRemain.substring(indexOfStart, indexOfEnd), htmlText)); //create header object and add header to the ArrayList
                }
            } else {
                indexOfEnd = indexOf(htmlTextRemain, "<h"); //if the character after h is not a size set the end to the h selected to signal that it has already been searched
            }
            htmlTextRemain = htmlTextRemain.substring(indexOfEnd + 4, htmlTextRemain.length()); //Remove the html code already searched
        }
        
        return headers;
    }
    
     /**
     * This method converts all bold text into bolded objects and then stores them in an ArrayList
     * pre: htmlText
     * post: bolds
     */
    public static ArrayList<text> boldFind(String htmlText) {
        //declare variables
        String htmlTextRemain = htmlText;
        int indexOfStart = 0;
        int indexOfEnd = 0;
        ArrayList<text> bolds = new ArrayList<text>();
        
        //find and store all bold text in a String ArrayList
        while (htmlTextRemain.contains("<b>")) { //keep searching if bolded text remain
            indexOfStart = indexOf(htmlTextRemain, "<b>"); //find the start of the bold
            indexOfEnd = indexOf(htmlTextRemain, "</b>") + 4; //find the end of the bold          
            if (indexOfStart < indexOfEnd) { //If statement to catch errors   
                System.out.println("BOLD TEXT:"+htmlTextRemain.substring(indexOfStart, indexOfEnd));
                bolds.add(new text(htmlTextRemain.substring(indexOfStart, indexOfEnd), htmlText)); //create bold object and add them to the ArrayList
            }
            htmlTextRemain = htmlTextRemain.substring(indexOfEnd + 4, htmlTextRemain.length()); //Remove the html code already searched
        }
        
        return bolds;
    }
    
    /**
     * This method converts all underlined text into under objects and then stores them in an ArrayList
     * pre: htmlText
     * post: unders
     */
        public static ArrayList<text> underFind(String htmlText) {
        //declare variables
        String htmlTextRemain = htmlText;
        int indexOfStart = 0;
        int indexOfEnd = 0;
        ArrayList<text> unders = new ArrayList<text>();
        
        //find and store all underlined text in a String ArrayList
        while (htmlTextRemain.contains("<u>")) { //keep searching if underlined text remain
            indexOfStart = indexOf(htmlTextRemain, "<u>"); //find the start of the under
            indexOfEnd = indexOf(htmlTextRemain, "</u>") + 4; //find the end of the under          
            if (indexOfStart < indexOfEnd) { //If statement to catch errors   
                System.out.println("UNDER TEXCT:"+htmlTextRemain.substring(indexOfStart, indexOfEnd));
                unders.add(new text(htmlTextRemain.substring(indexOfStart, indexOfEnd), htmlText)); //create under object and them to the ArrayList
            }
            htmlTextRemain = htmlTextRemain.substring(indexOfEnd + 4, htmlTextRemain.length()); //Remove the html code already searched
        }
        
        return unders;
    }
    
    /**
     * This method converts all breaks into break objects and then stores them in an ArrayList
     * pre: htmlText
     * post: breaks
     */
    public static ArrayList<text> breakFind(String htmlText) {
        //declare variables
        String htmlTextRemain = htmlText;
        int indexOfStart = 0;
        int indexOfEnd = 0;
        ArrayList<text> breaks = new ArrayList<text>();
        
        //find and store all breaks in a String ArrayList
        while (htmlTextRemain.contains("<BR>")) { //keep searching if breaks remain
            indexOfStart = indexOf(htmlTextRemain, "<BR>"); //find the start of the break
            indexOfEnd = indexOf(htmlTextRemain, "<BR>") + 4; //find the end of the break         
            System.out.println("BREAK TEXCT:"+htmlTextRemain.substring(indexOfStart, indexOfEnd));
            breaks.add(new text(htmlTextRemain.substring(indexOfStart, indexOfEnd), htmlText)); //create break object and add breaks to the ArrayList
            htmlTextRemain = htmlTextRemain.substring(indexOfEnd + 4, htmlTextRemain.length());
        }
        
        return breaks;
    }    

    /**
     * this method orders the texts into the order in which they appeared
     * pre: paragraphs, headers, bolds, unders, breaks
     * post: output 
     */
    public static void sort(ArrayList<text> paragraphs, ArrayList<text> headers, ArrayList<text> bolds, ArrayList<text> unders, ArrayList<text> breaks) {
        //declare variables
        String output = "";
        int indexP = 0;
        int indexH = 0;
        int indexB = 0;
        int indexU = 0;
        int indexBR = 0;
        int lowestPos = 0;
        
        for (int i = 0; i < paragraphs.size() + headers.size() + bolds.size() + unders.size() + breaks.size(); i++) { //run the following code as many times as there are texts      
                lowestPos=1000000000; //Set the lowest position to the highest possible
                if(paragraphs.size()>0 && paragraphs.get(paragraphs.size()-1).returnPosition() != -1){ //Ensure there are paragraphs that remain unplaced
                    if(lowestPos>paragraphs.get(indexP).returnPosition()){ //If selected paragraph comes before lowest text, assign as new lowest text                    
                        lowestPos=paragraphs.get(indexP).returnPosition();
                    }
                }    
                if(headers.size()>0 && headers.get(headers.size()-1).returnPosition() != -1){ //Ensure there are headers that remain unplaced
                    if(lowestPos>headers.get(indexH).returnPosition()){ //If selected header comes before lowest text, assign as new lowest text 
                        lowestPos=headers.get(indexH).returnPosition();
                    }
                }
                if(bolds.size()>0 && bolds.get(bolds.size()-1).returnPosition() != -1){ //Ensure there are bolds that remain unplaced
                    if(lowestPos>bolds.get(indexB).returnPosition()){ //If selected bold comes before lowest text, assign as new lowest text 
                        lowestPos=bolds.get(indexB).returnPosition();
                    }
                }
                if(unders.size()>0 && unders.get(unders.size()-1).returnPosition() != -1){ //Ensure there are unders that remain unplaced
                    if(lowestPos>unders.get(indexU).returnPosition()){ //If selected under comes before lowest text, assign as new lowest text 
                        lowestPos=unders.get(indexU).returnPosition();
                    }
                }
                if(breaks.size()>0 && breaks.get(breaks.size()-1).returnPosition() != -1){ //Ensure there are breaks that remain unplaced
                    if(lowestPos>breaks.get(indexBR).returnPosition()){ //If selected break comes before lowest text, assign as new lowest text 
                    lowestPos=breaks.get(indexBR).returnPosition();
                    }
                } 
                
            if (paragraphs.get(indexP).returnPosition() == lowestPos) { //check if the selected paragraph comes before all other text
                output = output + paragraphs.get(indexP).returnText() + "\n"; //add the selected paragraph to output
                if (indexP < paragraphs.size() - 1) { //check if there is still more paragraphs not added to output
                    indexP++; //select the next paragraph
                } else {
                    paragraphs.get(indexP).setPosition(-1); //set the paragraph location to after everything
                }
            }
            
            if(headers.size()>0){
                if (headers.get(indexH).returnPosition() == lowestPos) { //check if the selected header comes before all other text
                    output = output + headers.get(indexH).returnText() + "\n"; //add the selected header to output
                    if (indexH < headers.size() - 1) { //check if there is still more headers not added to output
                        indexH++; //select the next header
                    } else {
                        headers.get(indexH).setPosition(-1); //set the header location to after everything
                    }
                }
            }
            
            if(bolds.size()>0){
                if (bolds.get(indexB).returnPosition() == lowestPos) { //check if the selected bold comes before all other text
                    output = output + bolds.get(indexB).returnText() + "\n"; //add the selected bold to output
                    if (indexB < bolds.size() - 1) { //check if there is still more bolds not added to output
                        indexB++; //select the next bold
                    } else {
                        bolds.get(indexB).setPosition(-1); //set the bold location to after everything
                    }
                }
            }
            
            if(unders.size()>0){
                if (unders.get(indexU).returnPosition() == lowestPos) { //check if the selected underligne comes before all other text
                    output = output + unders.get(indexU).returnText() + "\n"; //add the selected underligne to output
                    if (indexU < unders.size() - 1) { //check if there is still more underlignes not added to output
                        indexU++; //select the next underligne
                    } else {
                        unders.get(indexU).setPosition(-1); //set the underligne location to after everything
                    }
                }
            }
            
            if(breaks.size()>0){
                if (breaks.get(indexBR).returnPosition() == lowestPos) { //check if the selected break comes before all other text
                    output = output + breaks.get(indexBR).returnText() + "\n"; //add the selected break to output
                    if (indexBR < breaks.size() - 1) { //check if there is still more breaks not added to output
                        indexBR++; //select the next break
                    } else {
                        breaks.get(indexBR).setPosition(-1); //set the break location to after everything
                    }
                }
            }
        }
        
        //Create a new page object to display the output
        Page s = new Page();
        s.setVisible(true);
        s.displayBody(output);
        System.out.println(output);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton lastViewed;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel test;
    private javax.swing.JTextField urlInput;
    // End of variables declaration//GEN-END:variables
}
