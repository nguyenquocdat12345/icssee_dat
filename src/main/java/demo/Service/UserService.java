package demo.Service;

import java.util.List;

import demo.domain.User;

public interface UserService {

Iterable<User> findAll();
	
	List<User> search(String q);
	
	User findOne(int id);
	
	void save(User account);
	
	void delete(int id);
}
