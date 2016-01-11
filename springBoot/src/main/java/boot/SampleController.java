package boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.entity.Country;
import boot.repo.CountryRepo;

@RestController
public class SampleController {
	
	@Autowired
	CountryRepo repo;

	@RequestMapping("/country")
	public List<Country> listCountries() {
		return (List<Country>) repo.findAll();
	}

	@RequestMapping("/country/{id}")
	public Country getCountry(@PathVariable("id") int id) {
		return repo.findOne(id);
	}
	
}