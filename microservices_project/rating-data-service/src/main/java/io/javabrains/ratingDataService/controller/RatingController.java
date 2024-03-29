package io.javabrains.ratingDataService.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ratingDataService.model.Rating;
import io.javabrains.ratingDataService.model.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingController {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId")String movieId) {
		return new Rating(movieId, 4);
	}
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings= Arrays.asList(
				new Rating("1234", 4),
				new Rating("5678", 5)
				);
		
		UserRating userRating=new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}
}
