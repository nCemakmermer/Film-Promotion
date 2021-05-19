package cemakmermer.moviepromotion.business.concrate;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cemakmermer.moviepromotion.business.abstrack.MovieService;
import cemakmermer.moviepromotion.dataAccess.abstrack.MovieDao;
import cemakmermer.moviepromotion.entity.concrate.Movie;

@Service
public class MovieManager implements MovieService {

	@Autowired
	private MovieDao movieDao;
	@Autowired
	private MovieService movieService;

	@Override
	public List<Movie> getAllMovies() {

		return movieDao.findAll();
	}

	@Override
	public void saveMovie(Movie movie) {
		this.movieDao.save(movie);

	}

	@Override
	public Movie getMovieById(Integer id) {
		Optional<Movie> optional = movieDao.findById(id);
		Movie movie = null;
		if (optional.isPresent()) {
			movie = optional.get();
		} else {
			throw new RuntimeException(" Movie not found for id :: " + id);
		}
		return movie;
	}

	@Override
	public void deleteMovieById(Integer id) {
		this.movieDao.deleteById(id);

	}

	@Override
	public Page<Movie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.movieDao.findAll(pageable);
	}

	@Override
	public List<Movie> search(String keyword) {
	
		return movieService.search(keyword);
	}

	
	}


