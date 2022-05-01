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

        UserDto newUserDto = mapToDto(save);

        return newUserDto;
    }

    private UserDto mapToDto(User save) {
        UserDto newUserDto = new UserDto();
        newUserDto.setUserId(save.getUserId());
        newUserDto.setName(save.getName());
        newUserDto.setAge(save.getAge());
        newUserDto.setAddress(save.getAddress());

        return newUserDto;
    }

    private User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setAddress(userDto.getAddress());

        return user;
    }
}
