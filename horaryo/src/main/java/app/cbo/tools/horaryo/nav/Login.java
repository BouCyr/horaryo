package app.cbo.tools.horaryo.nav;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {

    @GetMapping("/login")
    public ModelAndView loginPage(){

        ModelAndView mav = new ModelAndView("login");
        mav.addObject("pageTitle","Welcome");
        return mav;
    }
}
