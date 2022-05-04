package com.example.springbootrestapitest.service.user;

import com.example.springbootrestapitest.dto.user.UserDto;
import com.example.springbootrestapitest.entity.User;
import com.example.springbootrestapitest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto create(UserDto userDto) {

        User user = mapToEntity(userDto);

        User save = userRepository.save(user);

        UserDto signUpUserDto = mapToDto(save);

        return signUpUserDto;
    }

    private UserDto mapToDto(User save) {
        UserDto signUpUserDto = new UserDto();
        signUpUserDto.setUserId(save.getUserId());
        signUpUserDto.setPassword(save.getPassword());
        signUpUserDto.setName(save.getName());
        signUpUserDto.setAge(save.getAge());
        signUpUserDto.setAddress(save.getAddress());

        return signUpUserDto;
    }

    private User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setAddress(userDto.getAddress());

        return user;
    }
}
