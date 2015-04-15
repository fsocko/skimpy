package DatabaseAuto;

public class Main {

	public static void main(String[] args) 
	{
		AutoDB atb = new AutoDB();
		//System.out.println(atb.SkimpyExists());
		atb.initialiseDB("skimpy_test2", "skimpy_T.sql");
		
	}

}
