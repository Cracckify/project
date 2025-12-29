package com.crackify.ecommerce.service;


import com.crackify.ecommerce.DTOs.LoginRequestDto;
import com.crackify.ecommerce.DTOs.UserRequestDto;
import com.crackify.ecommerce.DTOs.UserResponseDto;
import com.crackify.ecommerce.config.JwtUtil;
import com.crackify.ecommerce.entitties.User;
import com.crackify.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final JwtUtil jwtUtil;

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {
        userRepository.findByEmail(dto.getEmail()).ifPresent(u -> { throw new IllegalArgumentException("Username already exists"); });


        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        // Hash password properly
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());

        User saved = userRepository.save(user);

        return new UserResponseDto(saved.getId(), saved.getName(), saved.getEmail());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        // Re-hash password if updated
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        User updated = userRepository.save(user);

        return new UserResponseDto(updated.getId(), updated.getName(), updated.getEmail());
    }

    @Override
    public boolean deleteUser(Long id) {
        if (!userRepository.existsById(id)) return false;

        userRepository.deleteById(id);
        return true;
    }

    @Override
    public String login(LoginRequestDto dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        // Check hashed password
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        System.out.println(passwordEncoder.encode(dto.getPassword()).equals(user.getPassword()));
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(),dto.getPassword()));


        UserDetails principal = (UserDetails) authentication.getPrincipal();
        assert principal != null;
        return jwtUtil.generateToken(
                principal.getUsername(),
                principal.getAuthorities()
        );


    }
}
