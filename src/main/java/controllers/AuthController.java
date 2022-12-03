package controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.LoginRequest;
import security.SignupRequest;
import services.AuthService;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signIn")
    @Operation(summary = "Авторизация по username password из БД, при успешной авторизации генерирует токен")
    public ResponseEntity<?> authUser(@RequestBody LoginRequest loginRequest) {
        return authService.signIn(loginRequest);
    }


    @PostMapping("/signUp")
    @Operation(summary = "Регистрация нового User, требуется: username, email, password, roles")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        return authService.signUp(signupRequest);
    }
}
