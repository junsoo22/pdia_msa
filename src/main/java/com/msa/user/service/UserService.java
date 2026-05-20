package com.msa.user.service;


import com.msa.user.dto.UserMapper;
import com.msa.user.dto.request.UserDTO;
import com.msa.user.dto.request.UserRegisterDTO;
import com.msa.user.entity.User;
import com.msa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO register(UserRegisterDTO dto) {
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(dto)));
    }

    public UserDTO getUser(Long id) {
        User user=userRepository.findById(id).orElseThrow();

        return userMapper.toDTO(user);
    }
}
