package kr.pe.sangpire.twitter.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.pe.sangpire.twitter.entity.Tweet;
import reactor.core.publisher.Mono;

@RestController
public class MainController {

    @GetMapping("/tweet")
    Mono<Tweet> getTweet() {
        Tweet tweet = new Tweet();
        tweet.setId(1L);
        tweet.setContents("Spring WebFlux");
		return Mono.just(tweet);
    }

    @GetMapping("/error")
    Mono<Tweet> error() {
        Tweet tweet = new Tweet();
        tweet.setId(1L);
        tweet.setContents("Spring WebFlux");

        if(true) {
            throw new RuntimeException("런타임 익셉션!!");
        }
        
		return Mono.just(tweet);
    }
}
