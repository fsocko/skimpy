package ProductExtractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScraperMainInterface {

	public static void main(String[] args) {
		try {
			InputStreamReader cin = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(cin);
			System.out.println("Which website would you like to scrape?");
			System.out.println("[t = tesco, s = sainsburys, a = asda]");
			char userInput = br.readLine().toLowerCase().charAt(0);
			switch (userInput) {
			case 't':
				TescoScraper.main(new String[0]);
				break;
			case 's':
				System.out.println("How many threads would you like to run?");
				System.out.println("Default is 15");
				int noThreads;
				try {
					noThreads = Integer.parseInt(br.readLine().trim());
				} catch (Exception e) {
					noThreads = 15;
				}
				SainsburysScraper.runScraper(noThreads, true);
				break;
			case 'a':
				System.out.println("How many threads would you like to run?");
				System.out.println("Default is 5");
				int noAThreads;
				try {
					noAThreads = Integer.parseInt(br.readLine().trim());
				} catch (Exception e) {
					noAThreads = 5;
				}
				AsdaScraper.runScraper(noAThreads);
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
