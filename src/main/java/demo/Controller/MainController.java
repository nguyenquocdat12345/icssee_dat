package demo.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import demo.Service.NewsService;
import demo.Service.UserService;
import demo.domain.News;
import demo.domain.User;


@Controller
public class MainController {

	@Autowired
	private UserService userService;
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/admin")
	public String index(Model model) {
		model.addAttribute("users", userService.findAll());
		return "admin";
	}
	
	@GetMapping("/admin/create")
	public String create(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}
	
	@PostMapping("/admin/save")
	public String save(@Valid User user, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form";
		}
		userService.save(user);
		redirect.addFlashAttribute("success", "Saved account successfully!");
		return "redirect:/admin";
	}
	
	@PostMapping("/login")
	public String login(@Valid User user, BindingResult result, RedirectAttributes redirect) {
		redirect.addFlashAttribute("success", "Login successfully!");
		return "redirect:/admin";
	}
	
	@GetMapping("/user/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("user", userService.findOne(id));
		return "form";
	}
	
	@GetMapping("/user/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		userService.delete(id);
		redirect.addFlashAttribute("success", "Deleted account successfully!");
		return "redirect:/admin";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	
	@GetMapping("/addNews")
	public String add(Model model) {
		model.addAttribute("news",newsService.findAll());
		return "addNews";
	}
	
	@GetMapping("/addNews/createNews")
	public String createNews(Model model) {
		model.addAttribute("news", new News());
		return "formAddNews";
	}
	
	@PostMapping("/news/save")
	public String saveNews(@Valid News news, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "formAddNews";
		}
		newsService.save(news);
		redirect.addFlashAttribute("success", "Saved news successfully!");
		return "redirect:/addNews";
	}
	
	@GetMapping("/news/{id}/edit")
	public String editNews(@PathVariable int id, Model model) {
		model.addAttribute("news", newsService.findOne(id));
		return "formAddNews";
	}
	
	@GetMapping("/news/{id}/delete")
	public String deleteNews(@PathVariable int id, RedirectAttributes redirect) {
		newsService.delete(id);
		redirect.addFlashAttribute("success", "Deleted news successfully!");
		return "redirect:/addNews";
	}
	
}
