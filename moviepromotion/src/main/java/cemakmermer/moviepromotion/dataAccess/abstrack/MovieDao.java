package cemakmermer.moviepromotion.dataAccess.abstrack;




import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import cemakmermer.moviepromotion.entity.concrate.Movie;


@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {
	
	
	
}
