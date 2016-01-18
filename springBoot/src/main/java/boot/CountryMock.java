package boot;

import java.util.ArrayList;
import java.util.List;

import boot.entity.Country;

public class CountryMock {

	private static List<Country> mockList;
	
	static
	{
		mockList = new ArrayList<Country>();
		Country c1 = new Country();
		c1.setId(1);
		c1.setName("ESPAÑA");
		c1.setPopulation(50000000);
		Country c2 = new Country();
		c2.setId(2);
		c2.setName("ALEMANIA");
		c2.setPopulation(80000000);
		mockList.add(c1);
		mockList.add(c2);
	}
	
	public static List<Country> getMock(){
		
		return mockList;
	}
	
	
}
