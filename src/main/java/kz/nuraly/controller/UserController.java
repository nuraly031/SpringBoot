package kz.nuraly.controller;
import kz.nuraly.service.UserService;
import kz.nuraly.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("users", userService.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String indexCount(@PathVariable ("id") int id,Model model) {
        model.addAttribute("user",userService.indexCount(id));
        return "users/indexCount";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user",new User());
        return "users/NewUser";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("user")User user){
        userService.save(user);
        return "redirect:/users/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.indexCount(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,@PathVariable("id") int id){
        userService.update(id,user);
        return "redirect:/users/index";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users/index";
    }

}
