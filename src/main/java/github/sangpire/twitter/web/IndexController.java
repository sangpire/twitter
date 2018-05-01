package github.sangpire.twitter.web;

import github.sangpire.twitter.entity.Tweet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

  @GetMapping()
  String index(Model model) {
    Tweet tweet = new Tweet();
    tweet.setId(1L);
    tweet.setContents("Spring WebFlux");
    model.addAttribute("tweet", tweet);
    return "index";
  }
}
