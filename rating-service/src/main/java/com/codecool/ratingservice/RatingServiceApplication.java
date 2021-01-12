package com.codecool.ratingservice;

import com.codecool.ratingservice.entity.Rating;
import com.codecool.ratingservice.repository.RatingRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class RatingServiceApplication {

	@Autowired
	RatingRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceApplication.class, args);
	}

	@Bean
	@Profile("production")
	public CommandLineRunner init() {
		return args -> {
			List<Rating> ratings = new ArrayList<>();
			ratings.add(Rating.builder()
					.ratingNumber((long) 123)
					.videoId((long) 1)
					.build());
			ratings.add(Rating.builder()
					.ratingNumber((long) 419)
					.videoId((long) 2)
					.build());
			ratings.add(Rating.builder()
					.ratingNumber((long) 68)
					.videoId((long) 3)
					.build());
			ratings.add(Rating.builder()
					.ratingNumber((long) 910)
					.videoId((long) 4)
					.build());

			repo.saveAll(ratings);
		};
	}

}
