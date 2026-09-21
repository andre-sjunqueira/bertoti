package com.thehecklers.sburrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class SburRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SburRestDemoApplication.class, args);
	}

}

@CrossOrigin(origins = {"http://localhost:8080","http://127.0.0.1:5500"})
@RestController
@RequestMapping("/movies")
class MovieController {
	private final MovieRepository movieRepository;

	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@GetMapping
	Iterable<Movie> getMovies() {
		return movieRepository.findAll();
	}

	@GetMapping("/{id}")
	Optional<Movie> getMovieById(@PathVariable String id) {
		return movieRepository.findById(id);
	}

	@PostMapping
	Movie postMovie(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}

	@PutMapping("/{id}")
	ResponseEntity<Movie> putMovie(@PathVariable String id, @RequestBody Movie movie) {
		return (movieRepository.existsById(id)) ?
				new ResponseEntity<>(movieRepository.save(movie), HttpStatus.OK) :
				new ResponseEntity<>(movieRepository.save(movie), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	void deleteMovie(@PathVariable String id) {
		movieRepository.deleteById(id);
	}
}

interface MovieRepository extends CrudRepository<Movie, String> {}

@Entity
class Movie {
	@Id
	private String id;
	private String name;

	public Movie() {
	}

	public Movie(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Movie(String name) {
		this(UUID.randomUUID().toString(), name);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}