package se.callistaenterprise.callistacrac.blog;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

  private final BlogRepository blogRepository;

  public BlogController(BlogRepository blogRepository) {
    this.blogRepository = blogRepository;
  }

  @GetMapping
  List<BlogEntity> getBlogs() {
    return (List<BlogEntity>) blogRepository.findAll();
  }
}
