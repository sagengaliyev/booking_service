package sagengaliyev.project.booking.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sagengaliyev.project.booking.dto.UserDTO;
import sagengaliyev.project.booking.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    public RegistrationController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping
    public String registrationForm(){
        return "registration";
    }

    @PostMapping
    public String registerUser(@RequestBody UserDTO userDTO){
        userService.register(userDTO);
        return "redirect:/login";
    }
}
