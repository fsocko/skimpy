package initialiseDatabase;

public class runAutoDB {

    public static void main(String[] args)
    {
	AutoDB atb = new AutoDB();
	atb.initDB();// initialise DB using contents from default init file.
	atb.initTable('a'); //initialise Asda table.
	atb.initTable('s'); //sainsbury's
	atb.initTable('t'); //tesco
	atb.initTable('u'); //user_info

	atb.pushToDB('a'); //push asda scraper data
	atb.pushToDB('s'); //push sains scraper data
	atb.pushToDB('t'); //push Tesco scraper data
    }
    
}
