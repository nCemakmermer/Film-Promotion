package cemakmermer.moviepromotion.business.concrate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cemakmermer.moviepromotion.dataAccess.abstrack.UserDao;
import cemakmermer.moviepromotion.entity.concrate.User;

public class UserDetailManager implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userDao.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found !");
		}
		return new UserManager(user);
	}

}
