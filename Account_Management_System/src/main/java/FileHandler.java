import java.io.FileWriter;
import java.io.IOException;

public class FileHandler extends DBHandler {

	protected static int i;
	protected static int x;
	protected static int y;
	public FileHandler() {
	i = 0;	
	x = 0;
	y = 0;
	}
	@Override
	public void addcustomer(String n, String a, String p) {
		// TODO Auto-generated method stub
		i++;
		try {
		      
		      FileWriter f = new FileWriter("ah.txt",true);
		      f.append(i + ") ");
		      f.write(n + "  "+a+"  "+p+"\n");			   
			   
			  f.close();
			  System.out.println("Account Holder information Written to file ");
		    } catch (IOException e) {
		    	
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

	@Override
	public void addsavingsaccount(int id, String n, double ir, double z) {
		// TODO Auto-generated method stub
		x++;
		try {
		      
		      FileWriter f = new FileWriter("sa.txt",true);
		      f.append(x + ") ");
		      f.append(id + "  "+n+"  "+ir+"  "+z+"\n");			   
			   
			  f.close();
			  System.out.println("Savings Account information Written to file ");
		    } catch (IOException e) {
		    	
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}

	@Override
	public void addcheckingaccount(int id, String n, int tf, int ta) {
		// TODO Auto-generated method stub
		y++;
		x++;
		try {
		      
		      FileWriter f = new FileWriter("ca.txt",true);
		      f.append(y + ") ");
		      f.append(id + "  "+n+"  "+tf+"  "+ta+"\n");			   
			   
			  f.close();
			  System.out.println("Checking Account information Written to file ");
		    } catch (IOException e) {
		    	
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}

}
