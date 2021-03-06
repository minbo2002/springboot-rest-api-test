package com.example.springbootrestapitest.service.user;

import com.example.springbootrestapitest.dto.user.UserDto;
import com.example.springbootrestapitest.entity.User;
import com.example.springbootrestapitest.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto create(UserDto userDto) {

        // dto -> entity
        User user = mapToEntity(userDto);

        // DB 저장
        User save = userRepository.save(user);

        // entity -> dto
        UserDto signUpUserDto = mapToDto(save);

        return signUpUserDto;
    }

    private UserDto mapToDto(User save) {
        UserDto signUpUserDto = new UserDto();
        signUpUserDto.setUserId(save.getId());
        signUpUserDto.setPassword(save.getPassword());
        signUpUserDto.setName(save.getName());
        signUpUserDto.setAge(save.getAge());
        signUpUserDto.setAddress(save.getAddress());

        return signUpUserDto;
    }

    private User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getUserId());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setAddress(userDto.getAddress());

        return user;
    }
}
