package app.someapi.someapiproject.service;

import static java.util.Objects.isNull;

import app.someapi.someapiproject.domain.user.ConfirmationToken;
import app.someapi.someapiproject.domain.user.Role;
import app.someapi.someapiproject.domain.user.UserMain;
import app.someapi.someapiproject.infrastructure.request.RegistrationRequest;
import app.someapi.someapiproject.infrastructure.request.VerificationRequest;
import app.someapi.someapiproject.mapper.UserMainMapper;
import app.someapi.someapiproject.repository.ConfirmationTokenRepository;
import app.someapi.someapiproject.repository.RolesRepository;
import app.someapi.someapiproject.repository.UsersRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {


  private final UsersRepository usersRepository;
  private final RolesRepository rolesRepository;
  private final ConfirmationTokenRepository confirmationTokenRepository;
  private final PasswordEncoder passwordEncoder;

  public UserMain registerNewUser(RegistrationRequest request) {
    UserMain userMain = UserMainMapper.INSTANCE.dtoToEntity(request);
    Set<Role> roles = rolesRepository.findRolesByNameIn(request.getRole().stream().map(Role::getName).collect(Collectors.toList()));
    userMain.setRole(roles);

    usersRepository.save(userMain);

    String token = UUID.randomUUID().toString();
    ConfirmationToken confirmationToken = new ConfirmationToken(userMain.getId(), LocalDateTime.now().plusMinutes(15), token);
    confirmationTokenRepository.save(confirmationToken);

    return userMain;
  }

  public UserMain verifyNewUser(VerificationRequest verification) {
    UserMain userMain = usersRepository.findByEmail(verification.getEmail());
    if (!userMain.isEnabled()) {
      throw new IllegalStateException("User not confirmed");
    }
    userMain.setPassword(passwordEncoder.encode(verification.getPassword()));
    return usersRepository.save(userMain);
  }

  public UserMain confirm(String token) {
    ConfirmationToken ct = confirmationTokenRepository.findByToken(token);
    Optional<UserMain> userMain = usersRepository.findById(ct.getUserId());
    userMain.get().setEnabled(true);
    return userMain.get();
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserMain user = findByEmail(email);
    if (isNull(user)) {
      throw new UsernameNotFoundException(email);
    }
    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
    user.getRole().forEach(role -> {
      authorities.add(new SimpleGrantedAuthority(role.getName()));
    });

    return new User(user.getEmail(), user.getPassword(), authorities);
  }

  private UserMain findByEmail(String email) {
    return usersRepository.findTopByEmail(email);
  }
}
