package io.javabrains.movieCatalogService.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.movieCatalogService.model.CatalogItem;
import io.javabrains.movieCatalogService.model.Movie;
import io.javabrains.movieCatalogService.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		RestTemplate restTemplate = new RestTemplate();
		//Movie m = restTemplate.getForObject("http://localhost:8089/movies/12", Movie.class);
		// Get the resource and unmarshal it into object. It takes two arguments: url of other microservice/API , the class it unmarshal to. It take the payload and return the object.
		//get all rated movie ID
		List<Rating> ratings =Arrays.asList(
				new Rating("1234",  4),
				new Rating("24234", 5)
		);
		return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8089/movies/"+rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), "Desc", rating.getRating());
											})
				.collect(Collectors.toList());
		
		//for each movie Id, call movie info service and get details
		
		//put them all together.
		
		//return Collections.singletonList(new CatalogItem("Avenger", "Test", 4));
	}
}
