package za.ac.uct.controllers.security;
/**
 *
 * Author: Lehlohonolo Khoathane
 *
 */

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/superadmin")
@RequiredArgsConstructor
public class SuperadminController {


    //RessourceEndPoint:http://localhost:8087/api/superadmin/hi
    @GetMapping("/hi")
    public String sayHi ()
    { return "Hi" ;}


}
