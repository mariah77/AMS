
public abstract class DBHandler {

	
	public DBHandler() {
		//i = 0;
	}
	public abstract void addcustomer(String n,String a,String p);
	public abstract void addsavingsaccount(int id, String n, double ir, double z);
	public abstract void addcheckingaccount(int id,String n,int tf, int ta);
}
