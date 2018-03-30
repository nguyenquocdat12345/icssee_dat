package demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.Service.UserService;

@RestController
public class SampleRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/all-users")
	public String index(Model model) {
		return model.addAttribute("users", userService.findAll()).toString();
	}
	
	@GetMapping("/delete-user")
	public String deleteUser(@RequestParam int id) {
		userService.delete(id);
		return "Account deleted!";
	}
}
