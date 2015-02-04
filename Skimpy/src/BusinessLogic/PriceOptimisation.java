package BusinessLogic;
/**
 * @author Lee
 */

/**
 * A class which optimises a shopping list based on price
 */
//NOT USED
public class PriceOptimisation {
	
	/**
	 *  Will return the shop where your shopping list will be cheapest.
	 *  @param pricePerKg The price per unit of each of the food items.
	 *  @return The value of the position of the shop in the array.
	 */
	public static int cheapestShop(Food[] food) {
		
		// Creating an array to keep track of total price
		double[] totalPrice = {0,0};
		
		// Looping through the prices adding them to the total price
		for (int i = 0; i < food.length; i++) {
			for (int j = 0; j < totalPrice.length; j++) {
				totalPrice[j] += food[i].getPrices()[j];
			}
		}
		
		// Finding the minimum price
		int min = findMinimum(totalPrice);
		
		return min;
	}
	
	/**
	 *  Will return what to buy from each shop, such that you spend the absolute minimum.
	 *  @param shops A String array of the different shops
	 *  @param names A String array of the names of foods
	 *  @param pricePerKg The price per unit of each of the food items.
	 *  @return The list of items to buy from each shop
	 */
	public static String[] minimumBudget(String[] shops, Food[] food) {
		
		// Creating a array of strings to keep track of what you'll need to buy from each shop
		String[] lists = {shops[0] + ": ", shops[1] + ": "};
		
		// Looping through all the prices, and finding the minimum price of each item,
		// and adding that item to the correct list
		for (int i = 0; i < food.length; i++) {
			int min = findMinimum(food[i].getPrices());
			lists[min] += food[i].getName() + ", ";
		}
		return lists;
	}
	
	/**
	 *  Returns the total price for the shop, such that you spend the absolute minimum
	 *  @param pricePerKg The price per unit of each of the food items.
	 *  @return The total price you'll spend
	 */
	public static double minimumBudget(Food[] food) {
		double totalPrice = 0;
		for (int i = 0; i < food.length; i++) {
			int min = findMinimum(food[i].getPrices());
			totalPrice += food[i].getPrices()[min];
		}
		return totalPrice;
	}
	
	/**
	 *	Returns the shops you'll visit based on how many you want to visit, such that you'll
	 *	pay the absolute minimum
	 *	@param number How many shops you want to visit
	 *	@param shops The string array of the different shops.
	 *	@param pricePerKg The price per unit of each of the food items.
	 *	@return The shops you'll visit based on how many you want to visit, such that you'll pay the absolute minimum
	 */ 
//	public static String maxNumberOfShops(int number, String[] shops, int[][] pricePerKg) {
//		
//		if (number == 1) {
//			// if you only want to visit 1 shop, just return the cheapest shop
//			return shops[cheapestShop(pricePerKg)];
//		} else if (number > 1) {
//			// calculating the number of different combinations of shops there are
//			int n = shops.length;
//			int r = number;
//			int noCombinations = factorial(n) / (factorial(n - r) * factorial(r));
//			
//			// setting up a combinations variable to keep track of all of the different combinations of shops
//			// and setting up an array to keep track of the current position when iterating through the combinations 
//			int[][] combinations = new int[noCombinations][];
//			int[] currentPlace = new int[number];
//			for (int i = 0; i < number; i++) {
//				currentPlace[i] = i;
//			}
//			
//			// iterating through the combinations to work out all the different combinations of shops
//			for (int i = 0; i < noCombinations; i++) {
//				combinations[i] = currentPlace.clone();
//				currentPlace[number - 1]++;
//				for (int j = number - 1; j >= 0; j--) {
//					if (currentPlace[j] >= n) {
//						currentPlace[j - 1]++;
//						currentPlace[j] = currentPlace[j - 1] + 1;
//					}
//				}
//			}
//			
//			// going through the combinations and calculating the total price for each combination
//			int[] totalPrices = new int[combinations.length];
//			for (int i = 0; i < combinations.length; i++) {
//				// creating a temporary array to hold price, so I can remove the prices for shops I don't need
//				int[][] tempPricePerKg = new int[pricePerKg.length][];
//				for (int j = 0; j < pricePerKg.length; j++) {
//					tempPricePerKg[j] = new int[combinations[i].length];
//					int currentPos = 0;
//					for (int h = 0; h < pricePerKg[i].length; h++) {
//						if (contains(combinations[i], h)) {
//							tempPricePerKg[j][currentPos] = pricePerKg[j][h];
//							currentPos++;
//						}
//					}
//				}
//				totalPrices[i] = minimumBudget(tempPricePerKg);
//			}
//			
//			// finding the minimum of the total prices
//			int min = findMinimum(totalPrices);
//			
//			// getting the shops' names of the combination that produces the lowest price
//			String output = "";
//			for (int i = 0; i < combinations[min].length; i++) {
//				output += shops[combinations[min][i]] + ", ";
//			}
//			return output;
//		} else {
//			return "";
//		}
//	}
	/**
	 *  Finds minimum
	 *  @param ds The array of integers that you want to find the minimum of.
	 *  @return The minimum integer;
	 */
	public static int findMinimum(double[] ds) {
		int min = 0;
		for (int i = 1; i < ds.length; i++) {
			if (ds[i] < ds[min]) {
				min = i;
			}
		}
		return min;
	}
	
	/**
	 * Check if an array contains a certain value
	 * @param array The array of integers that you want to check.
	 * @param value The value you want to check.
	 * @return True if it does, false if it doesn't.
	 */
	public static boolean contains(int[] array, int value) {
		for (int i: array) {
			if (i == value) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * To calculate the factorial
	 * @param n The number you want to calculate the factorial of.
	 * @return The value of the calculation.
	 */
	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

}