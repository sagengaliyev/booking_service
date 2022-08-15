package sagengaliyev.project.booking.controller;

import org.springframework.aop.scope.ScopedProxyFactoryBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import sagengaliyev.project.booking.dto.UserDTO;
import sagengaliyev.project.booking.model.Item;
import sagengaliyev.project.booking.model.User;
import sagengaliyev.project.booking.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/show")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO){
        userService.register(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/info")
    public String daoTestPage(Principal principal) {
        User user = userService.findByEmail(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return "authenticated user with name: " + user.getName() + " email: " + user.getEmail() + " id: "  + user.getId();

    }

//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new User());
//        return "signup_form";
//    }

    @GetMapping("/office")
    public ResponseEntity<List<Item>> officePage(Principal principal){
//        User user = userService.findByEmail(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
//        Long userId = user.getId();
        List<Item> ans = userService.getItems(principal);
        return new ResponseEntity<>(ans,HttpStatus.OK);
    }


}
