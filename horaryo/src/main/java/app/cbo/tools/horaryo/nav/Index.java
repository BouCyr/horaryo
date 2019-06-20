package app.cbo.tools.horaryo.nav;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class Index {

    @GetMapping({"/","/index"})
    public ModelAndView index(Principal user){
        ModelAndView mav = new ModelAndView("index");

        mav.addObject("login", user.getName());
        mav.addObject("pageTitle","Your projects");


        return mav;
    }
}
