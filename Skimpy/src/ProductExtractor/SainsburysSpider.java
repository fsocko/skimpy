package ProductExtractor;

import java.util.List;

public class SainsburysSpider extends WebSpider
{
	public SainsburysSpider()
	{
		this.rootPageURL = "http://www.sainsburys.co.uk/shop/gb/groceries";
	}
	
	public List<Department> listDepartments()
	{
		return null;
	}
}
