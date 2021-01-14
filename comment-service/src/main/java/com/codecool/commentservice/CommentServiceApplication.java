package com.codecool.commentservice;

import com.codecool.commentservice.entity.Comment;
import com.codecool.commentservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
public class CommentServiceApplication {

    @Autowired
    CommentRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(CommentServiceApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            Comment foxCom1 = Comment.builder()
                    .comment("Nobody:\n" +
                            "Not even Michael Jackson:\n" +
                            "Foxes: HEHE")
                    .mediaId((long) 1)
                    .build();

            Comment foxCom2 = Comment.builder()
                    .comment("Dying of laughter and cuteness")
                    .mediaId((long) 1)
                    .build();

            Comment foxCom3 = Comment.builder()
                    .comment("These foxes are adorable, even if they laugh like killer clowns.")
                    .mediaId((long) 1)
                    .build();

            repository.saveAll(Arrays.asList(foxCom1, foxCom2, foxCom3));

            Comment shibaCom1 = Comment.builder()
                    .comment("Can’t tell if that was a 'yes' or 'MOM, STOP INTERRUPTING ME.'")
                    .mediaId((long) 2)
                    .build();

            Comment shibaCom2 = Comment.builder()
                    .comment("Я играю на гармошке У прохожих на виду К сожаленью, день рожденья Только раз в году.")
                    .mediaId((long) 2)
                    .build();

            repository.saveAll(Arrays.asList(shibaCom1, shibaCom2));

            Comment woofCom1 = Comment.builder()
                    .comment("Who voice acted this dog")
                    .mediaId((long) 3)
                    .build();

            Comment woofCom2 = Comment.builder()
                    .comment("If this wasn’t recorded nobody would believe it")
                    .mediaId((long) 3)
                    .build();

            Comment woofCom3 = Comment.builder()
                    .comment("This dog learned english just to spite that man.")
                    .mediaId((long) 3)
                    .build();

            Comment woofCom4 = Comment.builder()
                    .comment("That was the most meticulously sarcastic grammatical correction I’ve ever seen on the internet.")
                    .mediaId((long) 3)
                    .build();

            repository.saveAll(Arrays.asList(woofCom1, woofCom2, woofCom3, woofCom4));

            Comment clipsCom1 = Comment.builder()
                    .comment("You don’t want to see what my dog does with my wife’s stuff")
                    .mediaId((long) 4)
                    .build();

            Comment clipsCom2 = Comment.builder()
                    .comment("Saving the world from evil hairclips what a hero for humanity")
                    .mediaId((long) 4)
                    .build();

            repository.saveAll(Arrays.asList(clipsCom1, clipsCom2));

            Comment catCom1 = Comment.builder()
                    .comment("Here it comes, this is going into everyone’s recommended, I can feel it!")
                    .mediaId((long) 5)
                    .build();

            Comment catCom2 = Comment.builder()
                    .comment("This should have more views")
                    .mediaId((long) 5)
                    .build();

            Comment catCom3 = Comment.builder()
                    .comment("Requesting seamless loop gif")
                    .mediaId((long) 5)
                    .build();

            repository.saveAll(Arrays.asList(catCom1, catCom2, catCom3));

            Comment fiveCom1 = Comment.builder()
                    .comment("The first cat is a lil gangster.")
                    .mediaId((long) 6)
                    .build();

            Comment fiveCom2 = Comment.builder()
                    .comment("Oh no I just.... Can't stop smiling")
                    .mediaId((long) 6)
                    .build();

            Comment fiveCom3 = Comment.builder()
                    .comment("second cat be like \"psh, whatever dude\".")
                    .mediaId((long) 6)
                    .build();

            repository.saveAll(Arrays.asList(fiveCom1, fiveCom2, fiveCom3));

            Comment parrotCom1 = Comment.builder()
                    .comment("This parrot is more talented than the tik tok community.")
                    .mediaId((long) 7)
                    .build();

            Comment parrotCom2 = Comment.builder()
                    .comment("Plot Twist: He's actually Albert Einstein reincarnated as Parrot")
                    .mediaId((long) 7)
                    .build();

            Comment parrotCom3 = Comment.builder()
                    .comment("Never mind robots taking over the world this parrot will!")
                    .mediaId((long) 7)
                    .build();

            repository.saveAll(Arrays.asList(parrotCom1, parrotCom2, parrotCom3));

            Comment arcticFoxCom1 = Comment.builder()
                    .comment("He stole his fish AND our hearts!")
                    .mediaId((long) 8)
                    .build();

            Comment arcticFoxCom2 = Comment.builder()
                    .comment("Translation:\n" +
                            "-Don't touch it! Don't eat it! Don't even think about it! How dare you! Wooo my well! My fish! My fish! \n" +
                            "-starts to dig\n" +
                            "-quiet laughter Okay okay, just look at you. Take it, for your trick with digging)")
                    .mediaId((long) 8)
                    .build();

            Comment arcticFoxCom3 = Comment.builder()
                    .comment("I'm cute!...just give me the damn fish!")
                    .mediaId((long) 8)
                    .build();

            repository.saveAll(Arrays.asList(arcticFoxCom1, arcticFoxCom2, arcticFoxCom3));

        };
    }
}
