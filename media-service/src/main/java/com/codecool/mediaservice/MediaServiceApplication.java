package com.codecool.mediaservice;

import com.codecool.mediaservice.entity.Media;
import com.codecool.mediaservice.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MediaServiceApplication {
    @Autowired
    private MediaRepository mediaRepository;

    public static void main(String[] args) {
        SpringApplication.run(MediaServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            Media laughingFox = Media.builder()
                    .title("Laughing foxes")
                    .url("https://www.youtube.com/watch?v=fQVhppRP4Wo")
                    .build();

            Media newToy = Media.builder()
                    .title("New toy")
                    .url("https://www.youtube.com/watch?v=FuraQCCsKgE")
                    .build();

            Media dontWoof = Media.builder()
                    .title("Don't woof")
                    .url("https://www.youtube.com/watch?v=83m261lAlrs")
                    .build();

            Media dogVsHairClips = Media.builder()
                    .title("Doggo vs hair clips")
                    .url("https://www.youtube.com/watch?v=Zm1rxbgnBBQ")
                    .build();

            Media staircaseCat = Media.builder()
                    .title("Staircase Cat")
                    .url("https://www.youtube.com/watch?v=_2380DCuLeE")
                    .build();

            Media highFive = Media.builder()
                    .title("High five!")
                    .url("https://www.youtube.com/watch?v=lFtB06GZykw")
                    .build();

            Media talkingParrot = Media.builder()
                    .title("Talking parrot")
                    .url("https://www.youtube.com/watch?v=WQ_wO0r16ww")
                    .build();

            Media arcticFox = Media.builder()
                    .title("Baby Arctic Fox Steals Mans Fish")
                    .url("https://www.youtube.com/watch?v=0OaxZXizA0M")
                    .build();

            mediaRepository.save(laughingFox);
            mediaRepository.save(newToy);
            mediaRepository.save(dontWoof);
            mediaRepository.save(dogVsHairClips);
            mediaRepository.save(staircaseCat);
            mediaRepository.save(highFive);
            mediaRepository.save(talkingParrot);
            mediaRepository.save(arcticFox);
        };
    }
}
