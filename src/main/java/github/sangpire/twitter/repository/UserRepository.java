package github.sangpire.twitter.repository;

import github.sangpire.twitter.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
