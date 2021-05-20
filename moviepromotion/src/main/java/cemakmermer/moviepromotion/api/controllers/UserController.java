package cemakmermer.moviepromotion.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cemakmermer.moviepromotion.business.abstrack.MovieService;
import cemakmermer.moviepromotion.dataAccess.abstrack.UserDao;
import cemakmermer.moviepromotion.entity.concrate.Movie;
import cemakmermer.moviepromotion.entity.concrate.User;

import cemakmermer.moviepromotion.dataAccess.abstrack.MovieDao;
import java.util.*;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private MovieService movieService;
	@Autowired
	private MovieDao movieDao;

	@GetMapping("/users")
	public String viewUserList(Model model) {
		List<User> listUser = userDao.findAll();
		model.addAttribute("listUsers", listUser);
		List<Movie> listMovie = movieDao.findAll();
		model.addAttribute("listMovies", listMovie);
		return "users";
	}
	@GetMapping("/showNewMovieForm")
	public String showNewMovieForm(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "new_movie";
	}

	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie movie) {

		movieService.saveMovie(movie);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") Integer id, Model model) {

		Movie movie = movieService.getMovieById(id);

		model.addAttribute("movie", movie);
		return "update_movie";
	}

	@GetMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable(value = "id") Integer id) {

		this.movieService.deleteMovieById(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Movie> page = movieService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Movie> listMovies = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listMovies", listMovies);
		return "index";
	}
}

