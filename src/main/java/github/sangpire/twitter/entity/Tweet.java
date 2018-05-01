package github.sangpire.twitter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Tweet {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @NotNull
  private String contents;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContents() {
    return this.contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }

}
