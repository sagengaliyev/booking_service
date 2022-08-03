package sagengaliyev.project.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/dasboard")
    public String dashboardPage(){
        return "you are in the dashboard page!";
    }

    @GetMapping("/home")
    public String homePage(){
        return "You are in the home page!";
    }
}
