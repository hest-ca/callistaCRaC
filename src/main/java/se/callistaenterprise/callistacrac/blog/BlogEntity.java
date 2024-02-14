package se.callistaenterprise.callistacrac.blog;


import jakarta.persistence.*;

@Entity
@Table(name = "blogs")
public class BlogEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String content;


  public BlogEntity(String name, String content) {
      this.name = name;
      this.content = content;
  }

  public BlogEntity() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "Blog{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + content + '\'' +
            '}';
  }
}
