package kr.pe.sangpire.twitter.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

  @Id
  private String name;

  @NotNull
  private String encodedPassword;

}
