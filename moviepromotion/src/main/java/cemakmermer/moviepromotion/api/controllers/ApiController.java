package cemakmermer.moviepromotion.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cemakmermer.moviepromotion.dataAccess.abstrack.MovieDao;
import cemakmermer.moviepromotion.entity.concrate.Movie;

@Controller
public class ApiController {
	@Autowired
	private MovieDao movieDao;
	@GetMapping("")
	public String viewHomePage(Model model) {
		List<Movie> listMovie = movieDao.findAll();
		model.addAttribute("listMovies", listMovie);
		return "index";
	}

}
