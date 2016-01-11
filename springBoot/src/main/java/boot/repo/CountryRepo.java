package boot.repo;

import org.springframework.data.repository.CrudRepository;

import boot.entity.Country;

public interface CountryRepo extends CrudRepository<Country, Integer> {

	
}
