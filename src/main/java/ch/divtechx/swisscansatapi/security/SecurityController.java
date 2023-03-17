package ch.divtechx.swisscansatapi.security;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "security")
public class SecurityController {

    @GetMapping(path = "test")
    public boolean test() {
        return true;
    }
}
