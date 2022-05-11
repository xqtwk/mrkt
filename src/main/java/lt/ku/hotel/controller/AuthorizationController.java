package lt.ku.hotel.controller;

import lt.ku.hotel.entities.Client;
import lt.ku.hotel.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;


@Controller
public class AuthorizationController {
    @Autowired
    ClientService clientService;
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/register")
    public String clientNew(Model model){
        model.addAttribute(model.addAttribute("client", new Client()));
        return "register";
    }
    @PostMapping("/register")
    public String addClient(@Valid @ModelAttribute(value = "client") Client client,
                            BindingResult result,
                            @RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("phone")String phone,
                            @RequestParam("address")String address,
                            @RequestParam("phone") Date birth_date,
                            @RequestParam("username") String username,
                            @RequestParam("password") String password){
        if (result.hasErrors()){
            return "register";
        }else{
            client.setName(name);
            client.setPhone(phone);
            client.setUsername(username);
            client.setPassword(password);
            client.setAddress(address);
            client.setBirth_date(birth_date);
            client.setSurname(surname);
            clientService.addClient(client);
            return "redirect:/login/";}
    }

    @RequestMapping("/login-error")
    public String loginError() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {


        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        if (auth!=null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/";
    }

}
