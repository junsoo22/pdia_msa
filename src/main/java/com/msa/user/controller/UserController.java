package com.msa.user.controller;

import com.msa.user.dto.request.UserDTO;
import com.msa.user.dto.request.UserRegisterDTO;
import com.msa.user.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    UserDTO register(@RequestBody @Validated UserRegisterDTO dto) {

        return userService.register(dto);
    }

    @GetMapping("{id}")
    UserDTO getuser(@PathVariable Long id){
        return userService.getUser(id);
    }


}
