package cemakmermer.moviepromotion.dataAccess.abstrack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cemakmermer.moviepromotion.entity.concrate.User;

public interface UserDao extends JpaRepository<User, Long> {
	 @Query("SELECT u FROM User u WHERE u.email = ?1")
	  public User findByEmail(String email);
	
}
