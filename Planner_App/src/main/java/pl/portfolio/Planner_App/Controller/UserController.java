package pl.portfolio.Planner_App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.portfolio.Planner_App.Model.Dto.AuthenticationRequest;
import pl.portfolio.Planner_App.Model.Dto.AuthenticationResponse;
import pl.portfolio.Planner_App.Model.Dto.RegisterRequest;
import pl.portfolio.Planner_App.Service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register
    (@RequestBody RegisterRequest request) {
        userService.register(request);
        return ResponseEntity.ok(new AuthenticationResponse("User registered successfully"));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate
            (@RequestBody AuthenticationRequest request) throws Exception {
        userService.authenticate(request);
        return ResponseEntity.ok(new AuthenticationResponse("User authenticated successfully"));
    }
}
