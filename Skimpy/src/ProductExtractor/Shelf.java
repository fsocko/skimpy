package ProductExtractor;

public class Shelf {
	public String url;
	public String name;
	
	public Shelf(String url, String name) {
		this.url = url;
		this.name = name;
	}
	
	public String toString() {
		return this.name + " " + this.url;
	}
}
