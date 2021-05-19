package cemakmermer.moviepromotion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;
import cemakmermer.moviepromotion.dataAccess.abstrack.UserDao;
import cemakmermer.moviepromotion.entity.concrate.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserDaoTests {

	@Autowired
	private UserDao userDao;
	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testCreateuser() {
		User user = new User();
		user.setEmail("ahmetlekesiz@gmail.com");
		user.setPassword("12345");
		user.setFirstName("Ahmet");
		user.setLastName("Lekesiz");

		User saveUser = userDao.save(user);
		User exixstUser = entityManager.find(User.class, saveUser.getId());

		assertThat(exixstUser.getEmail()).isEqualTo(user.getEmail());
	}

	@Test
	public void testFindUserByEmail() {
		String email = "cemakmermer20015@gmail.com";
		User user = userDao.findByEmail(email);

		assertThat(user).isNotNull();
	}
}
