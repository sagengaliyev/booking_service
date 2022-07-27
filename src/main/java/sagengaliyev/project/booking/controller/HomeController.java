package sagengaliyev.project.booking.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sagengaliyev.project.booking.dto.UserDTO;

@Controller
@RequestMapping("/home")
public class HomeController {
    
    @GetMapping("/index")
    public String index(@AuthenticationPrincipal UserDTO userDTO, Model model){
        if(userDTO!=null){
            model.addAttribute("user", userDTO.getEmail());
            return "index";
        }
        model.addAttribute("user", "anonymous");
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PreAuthorize(value = "hasAuthority('ADMIN') or hasAuthority('USER')")
    @GetMapping("/foruser")
    public String forUser(){
        return "fourUser";
    }
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @GetMapping("/foradmin")
    public String forAdmin(){
        return "fourAdmin";
    }
}
