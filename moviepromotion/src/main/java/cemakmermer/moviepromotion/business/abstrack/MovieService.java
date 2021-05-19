package cemakmermer.moviepromotion.business.abstrack;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import cemakmermer.moviepromotion.entity.concrate.Movie;

public interface MovieService {
	
	List<Movie> getAllMovies();
	void saveMovie(Movie movie);

	Movie getMovieById(Integer id);

	void deleteMovieById(Integer id);
	
	@Query(value = "SELECT * FROM movies WHERE"+"MATCH(name,type,director,description,date)"+"AGAINST (?!)")
	public List<Movie> search(String keyword);
	

	Page<Movie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
