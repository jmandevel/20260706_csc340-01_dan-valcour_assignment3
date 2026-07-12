package edu.uncg.assignment3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/"})
public class AppUIController {
    @GetMapping
    public String homePage() {
        return "redirect:/characters/";
    }
}
