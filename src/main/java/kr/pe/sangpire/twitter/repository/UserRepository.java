package kr.pe.sangpire.twitter.repository;

import kr.pe.sangpire.twitter.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
