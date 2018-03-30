package demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import demo.domain.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	List<User> findBytendangnhapContaining(String q);
}
