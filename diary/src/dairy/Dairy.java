/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dairy;

/**
 *
 * @author Julius
 */
//import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
public class Dairy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
				Calendar book=new Calendar();
				addApp(book);
				storeApp(book);
                book=readApp();
				//System.out.println(book.getAppointment("sept",1));
				//book.clearMyMonth("jan");
				book.addAppointment("jan", 12, "We just they code here", 10);
                book.printAllMonth();
                storeApp(book);
                }
            
                public static void storeApp(Calendar testCalendar){
                	 File file=new File("Object.txt");
                     try {
                         System.out.println(file.createNewFile());
                         FileOutputStream outFile=new FileOutputStream(file);
                         ObjectOutputStream outObj=new ObjectOutputStream(outFile);
                         outObj.writeObject(testCalendar);
                         outObj.close();
                     } catch (IOException ex) {
                         Logger.getLogger(Dairy.class.getName()).log(Level.SEVERE, null, ex);
                     }
                	
                }
                
                public static Calendar readApp(){
                	File file=new File("Object.txt");
        	        FileInputStream inFile;
        	        ObjectInputStream inObj;
        	        Calendar sr=new Calendar();
        	        try {
        	            inFile = new FileInputStream(file);
        	            inObj=new ObjectInputStream(inFile);
        	            sr=(Calendar) inObj.readObject();
        	            inObj.close();
        	            
        	            //sr.printAllMonth();
        	            //System.out.println(sr.getAppointment("jan", 6)+" "+sr.getAppointment("jan", 8));
        	        } catch (FileNotFoundException ex) {
        	            Logger.getLogger(ReadSerial.class.getName()).log(Level.SEVERE, null, ex);
        	        } catch (IOException ex) {
        	            Logger.getLogger(ReadSerial.class.getName()).log(Level.SEVERE, null, ex);
        	        } catch (ClassNotFoundException ex) {
        	            Logger.getLogger(ReadSerial.class.getName()).log(Level.SEVERE, null, ex);
        	        }
        	        return sr;
                	
                }
                
                public static void addApp(Calendar testCalendar){
                	System.out.println("Adding Appointments to the Calendar");
                    testCalendar.addAppointment("Jan", 1, "This was a triumph.", 1);
                    testCalendar.addAppointment("Jan", 1, "This was a triumph ok.", 1);
                    testCalendar.addAppointment("Jan", 1, "This was a triumph to me.", 1);
                    testCalendar.addAppointment("Jan", 1, "This was a triumphant victory.", 1);


                    testCalendar.addAppointment("Jan", 2, "I'm making a note here:", 1);


                    testCalendar.addAppointment("Jan", 3, "HUGE SUCCESS.", 1);


                    testCalendar.addAppointment("Jan", 4, "It's hard to overstate my satisfaction.", 1);


                    testCalendar.addAppointment("feb", 5, "Aperture Science", 1);


                    testCalendar.addAppointment("Jan", 6, "We do what we must", 1);


                    testCalendar.addAppointment("Jan", 6, "Because we can.", 1);


                    testCalendar.addAppointment("jAn", 8, "For the good of all of us.", 1);


                    testCalendar.addAppointment("Jan", 14, "Except the ones who are dead.", 1);


                    testCalendar.addAppointment("Feb", 10, "But there is no sense crying over every mistake.", 1);


                    testCalendar.addAppointment("Feb", 11, "You just keep on trying till you run out of cake.", 1);


                    testCalendar.addAppointment("Feb", 12, "And the Science gets done.", 1);


                    testCalendar.addAppointment("feb", 13, "And you make a neat gun.", 1);


                    testCalendar.addAppointment("Feb", 14, "For the people who are still alive.", 1);


                    testCalendar.addAppointment("Mar", 15, "I'm not even angry.", 1);


                    testCalendar.addAppointment("Mar", 16, "I'm being so sincere right now.", 1);


                    //testCalendar.addAppointment("Mar", 17, "Even though you broke my heart.", 1);


                    testCalendar.addAppointment("MAr", 18, "And killed me.", 1);


                    testCalendar.addAppointment("Mar", 19, "And tore me to pieces.", 1);


                    testCalendar.addAppointment("Mar", 20, "And threw every piece into a fire.", 1);


                    testCalendar.addAppointment("Mar", 21, "As they burned it hurt because I was so happy for you!", 1);


                    testCalendar.addAppointment("Apr", 22, "Now the points of data make a beautiful line.", 1);


                    testCalendar.addAppointment("ApR", 23, "And we're out of beta we're releasing on time.", 1);


                    testCalendar.addAppointment("Apr", 24, "So I'm GLaD. I got burned.", 1);


                    testCalendar.addAppointment("Apr", 25, "Think of all the things we learned", 1);


                    testCalendar.addAppointment("Apr", 25, "For the people who are still alive.", 1);

                    testCalendar.addAppointment("MaY", 27, "Go ahead and leave me.", 1);


                    testCalendar.addAppointment("May", 28, "I think I prefer to stay inside.", 1);


                    testCalendar.addAppointment("May", 29, "MAYbe you'll find someone else to help you.", 1);


                    testCalendar.addAppointment("MAY", 30, "MAYbe Black Mesa", 1);


                    testCalendar.addAppointment("May", 1, "THAT WAS A JOKE.", 1);


                    testCalendar.addAppointment("May", 2, "HAHA. FAT CHANCE.", 1);


                    testCalendar.addAppointment("Jun", 3, "Anyway, this cake is great.", 1);


                    testCalendar.addAppointment("Jun", 4, "It's so delicious and moist.", 1);


                    testCalendar.addAppointment("Jul", 5, "But look at me still talking when there's Sciece to do.", 1);


                    testCalendar.addAppointment("Jul", 6, "When I look out there, it makes me GLaD I'm not you.", 1);


                    testCalendar.addAppointment("JuL", 7, "I've experiments to run", 1);


                    testCalendar.addAppointment("Jul", 8, "There is research to be done", 1);


                    testCalendar.addAppointment("Jul", 9, "On the people who are still alive.", 1);


                    testCalendar.addAppointment("Jul", 10, "And believe me I am still alive.", 1);


                    testCalendar.addAppointment("jUL", 11, "I'm doing Science and I'm still alive.", 1);


                    testCalendar.addAppointment("Aug", 12, "I feel FANTASTIC and I'm still alive.", 1);
                    
                    testCalendar.addAppointment("Aug", 12, "I feel FANTASTIC .", 1);
                    
                    testCalendar.addAppointment("Aug", 11, "I feel GREAT and I'm still living.", 1);
                    
                    testCalendar.addAppointment("Aug", 13, "I feel HOT and I'm still cold.", 1);


                    testCalendar.addAppointment("Sept", 11, "While you're dying I'll be still alive.", 1);
                    testCalendar.addAppointment("Sept", 1, "While you're dying I'll be still alive.", 1);

                    testCalendar.addAppointment("Oct", 17, "And when you're dead I will be still alive.", 1);


                    testCalendar.addAppointment("Nov", 15, "STILL ALIVE", 1);
                    testCalendar.addAppointment("dec", 17, "STILL ALIVE and well", 1);
                    testCalendar.addAppointment("Nov", 17, "STILL ALIVE ok", 1);
                    testCalendar.addAppointment("oct", 17, "STILL ALIVE proud", 1);
                    testCalendar.addAppointment("Nov", 17, "STILL ALIVE blessed", 1);


                    testCalendar.addAppointment("Dec", 16, "Date with Rachel", 1);
                    testCalendar.addAppointment("Dec", 16, "STILL ALIVE", 1);
                	
                }
                
                
                
                
                
             
                
                
    }

