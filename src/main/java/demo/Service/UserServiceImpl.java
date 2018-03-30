package demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.User;
import demo.Repository.UserRepository;
import demo.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<User> search(String q) {
		return userRepository.findBytendangnhapContaining(q);
	}

	@Override
	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public void save(User account) {
		userRepository.save(account);
	}

	@Override
	public void delete(int id) {
		userRepository.delete(id);
	}
}
