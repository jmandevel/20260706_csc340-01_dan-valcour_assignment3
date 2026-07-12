package edu.uncg.assignment3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/characters")
@AllArgsConstructor
public class CharacterUIController {

    @GetMapping({"/about", "/about/"})
    public String about() {
        return "about";
    }
}
