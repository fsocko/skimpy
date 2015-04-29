package initialiseDatabase;

import BusinessLogic.SpiderToDB;

public class runAutoDB {

    public static void main(String[] args)
    {
	AutoDB atb = new AutoDB();
	SpiderToDB std = new SpiderToDB();
	//atb.initDB();// initialise DB using contents from default init file.
	//atb.initTable('a'); //initialise Asda table.
	atb.initTable('s'); //sainsbury's
	//atb.initTable('t'); //tesco
	//atb.initTable('u'); //user_info

	//atb.pushToDB('a'); //push asda scraper data
	atb.pushToDB('s'); //push sains scraper data
	//atb.pushToDB('t'); //push Tesco scraper data
	
	//initialise skimpy with an SQL file
	//atb.initDB("skimpy", "SQLFiles/database/skimpy - 28.04.15 - sains url fix .sql");
    }
    
}
