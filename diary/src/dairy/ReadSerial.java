package dairy;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ReadSerial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        File file=new File("C:\\Users\\epxs\\Documents\\files\\Object.txt");
	        FileInputStream inFile;
	        ObjectInputStream inObj;
	        Calendar sr;
	        try {
	            inFile = new FileInputStream(file);
	            inObj=new ObjectInputStream(inFile);
	            sr=(Calendar) inObj.readObject();
	            inObj.close();
	            sr.clearMyMonth("jan");
	            System.out.println(sr.getAppointment("jan", 6)+" "+sr.getAppointment("jan", 8));
	            Dairy.storeApp(sr);
	        } catch (FileNotFoundException ex) {
	            Logger.getLogger(ReadSerial.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IOException ex) {
	            Logger.getLogger(ReadSerial.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(ReadSerial.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}
	}	


