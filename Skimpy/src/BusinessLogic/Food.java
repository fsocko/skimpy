package BusinessLogic;

import javax.servlet.http.HttpServlet;

/**
 *
 * @author ruaraidh
 * 
 */
/**
 * 
 * A representation of a Food.
 *
 */
public class Food extends HttpServlet{
	/**
	 * Stores all the nutrients of a food, use by dates, prices etc. This will be used as ingredients
	 * for a Meal and will help match to a Person's GDA.
	 */
	private int ID;
	private String name;

	private String units;
	private int amount;
	private double serving;
	private double tescoPrice;
	private double asdaPrice;
	private double[] prices;
	private double tescoprice;
	private double asdaprice;

	private double calories;
	private double protein;
	private double carbs;
	private double sugars;
	private double fat;
	private double saturates;
	private double fibre;
	private double salt;
	//use by date
//	private String roomExp;
//    private String fridgeExp;
//    private String freezerExp;
    //private String record;

    FileAccess fDb = new FileAccess();
    DateMan dates = new DateMan();

    /**
     * Constructs a food with all the necessary attributes.
     * @param key That access the food in the database.
     * @param unts Units of food maybe kgs or litres. TODO: Adapt depending on food.
     * @param amnt Amount of food, example if there is 4 cans of tomatoes then amount is 4.
     * @param pric The price of the food.
     * @param cal The calories in the food.
     * @param prot The protein in the food.
     * @param crbs The carbohydrates in the food.
     * @param sgrs The sugars in the food.
     * @param ft The fat in the food.
     * @param sats The saturated fat in a food.
     * @param fbr The fibre in the food.
     * @param slt The salt in the food.
     */
	public Food(String name, String unts, int amnt, double serving, double tescoPrc, double asdaPrc, double cal, double prot, double crbs, double sgrs, double ft, double sats, double fbr, double slt){

		this.name = name;
		
        units = unts;
        amount = amnt;
        tescoPrice = tescoPrc;
        asdaPrice = asdaPrc;
        calories = cal;
        protein = prot;
        saturates = sats;
		fibre = fbr;
        carbs = crbs;
        sugars = sgrs;
        fat = ft;
		saturates = sats;
		fibre = fbr;
		salt = slt;	

//		int roomD = fDb.getRoomD(record);
//        int fridgeD = fDb.getFridgeD(record);
//        int freezerD = fDb.getFreezerD(record);
//
//        roomExp = dates.getExpDate(roomD);
//        fridgeExp = dates.getExpDate(fridgeD);
//        freezerExp = dates.getExpDate(freezerD);
	}
	/**
	 * Represents the Food as a String.
	 * @return The attributes of the food as a String.
	 */
    public String toString(){
    	String s = "The item's name is: " + name + 
    			"\n" +
    			"\nThe price at Tesco is: £" + tescoPrice +
    			"\nThe price at ASDA is: £" + asdaPrice +
    			"\nThe amount is: " + amount +
    			"\nThe units of item are: " + units +
    			"\nThe serving size is" + serving +
    			"\n " +
    			"\nCalories: " + calories + " kcal" +
    			"\nProtien: " + protein + " g" +
				"\nCarbohydrates: " + carbs + " g" +
				"\nSugars: " + sugars + " g" +
				"\nFat: " + fat + " g" +
				"\nSaturates: " + saturates + " g" +
				"\nFibre: " + fibre + " g" +
				"\nSalt: " + salt +  " g" +
				"\n";
//    			"\nExpiration date in room temp is: " + roomExp +
//    			"\nExpiration date in fridge is: " + fridgeExp +
//				"\nExpiration date in freezer is: " + freezerExp;
		return s;
    }
    /**
     * Get's the name of the food.
     * @return Name of the food.
     */
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	public double getCalories(){
		return this.calories;
	}
	public int getID() {
		return ID;
	}
	public String getUnits() {
		return units;
	}
	public int getAmount() {
		return amount;
	}
	public double getServing() {
		return serving;
	}
	public double getTescoPrice() {
		return tescoPrice;
	}
	public double getAsdaPrice() {
		return asdaPrice;
	}
	public double[] getPrices() {
		return prices;
	}
	public double getTPrice() {
		return tescoprice;
	}
	public double getAPrice() {
		return asdaprice;
	}
	public double getProtein() {
		return protein;
	}
	public double getCarbs() {
		return carbs;
	}
	public double getSugars() {
		return sugars;
	}
	public double getFat() {
		return fat;
	}
	public double getSaturates() {
		return saturates;
	}
	public double getFibre() {
		return fibre;
	}
	public double getSalt() {
		return salt;
	}
	public FileAccess getfDb() {
		return fDb;
	}
	public DateMan getDates() {
		return dates;
	}
}