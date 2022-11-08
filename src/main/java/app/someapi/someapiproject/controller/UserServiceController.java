package app.someapi.someapiproject.controller;

import app.someapi.someapiproject.domain.user.UserMain;
import app.someapi.someapiproject.infrastructure.request.RegistrationRequest;
import app.someapi.someapiproject.infrastructure.request.VerificationRequest;
import app.someapi.someapiproject.infrastructure.request.ConfirmationRequest;
import app.someapi.someapiproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/public")
@RequiredArgsConstructor
public class UserServiceController {

  private final UserService userService;

  @PostMapping(path = "/register", consumes = "application/json")
  public ResponseEntity<UserMain> register(@RequestBody RegistrationRequest registration) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerNewUser(registration));
  }

  @PostMapping(path = "/verify", consumes = "application/json")
  public ResponseEntity<UserMain> verify(@RequestBody VerificationRequest verification) {
    return ResponseEntity.ok().body(userService.verifyNewUser(verification));
  }

  @PostMapping(path = "/confirm", consumes = "application/json")
  public ResponseEntity<UserMain> confirm(@RequestBody ConfirmationRequest confirmation) {
    return ResponseEntity.ok().body(userService.confirm(confirmation.getToken()));
  }
}
