package boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import boot.entity.Country;
import boot.repo.CountryRepo;

@RestController
public class SampleController {

	@Autowired
	CountryRepo repo;

	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public List<Country> listCountries() {
		return (List<Country>) repo.findAll();
	}

	@RequestMapping(value = "/countries", method = RequestMethod.DELETE)
	public void deleteAll() {
		repo.deleteAll();
	}

	@RequestMapping(value = "/countries", method = RequestMethod.POST)
	public ResponseEntity<Country> newCountry(@RequestBody Country c) {
		repo.save(c);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/countries/{id}", method = RequestMethod.GET)
	public Country getCountry(@PathVariable("id") int id) {
		return repo.findOne(id);
	}

	@RequestMapping(value = "/countries/{id}", method = RequestMethod.DELETE)
	public void deleteCountry(@PathVariable("id") int id) {
		repo.delete(id);
	}

	@RequestMapping(value = "/countries/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Country> updateCountry(@PathVariable("id") int id, @RequestBody Country c) {
		Country updating = repo.findOne(id);
		updating.setName(c.getName());
		updating.setPopulation(c.getPopulation());
		repo.save(updating);
		return new ResponseEntity(updating,HttpStatus.OK);
	}

}