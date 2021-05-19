package cemakmermer.moviepromotion.core.utilities;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "12345";
		String enconderPassword = encoder.encode(rawPassword);
		System.out.println(enconderPassword);

	}

}