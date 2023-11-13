package learning.usermanagement.service;

import learning.usermanagement.dtos.UserDto;
import learning.usermanagement.dtos.UserResponseDto;
import learning.usermanagement.entities.UserEntity;
import learning.usermanagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {

    private final UsersRepository userRepository;

    @Autowired
    public UsersService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();

        return userEntities.stream()
                .map(user -> new UserResponseDto( user.getId(), user.getFirstname(), user.getLastname()))
                .collect(Collectors.toList());
    }

    public UserDto saveUser(UserDto user) {
        UserEntity userEntity = userRepository.save(mapUserDtoToUserEntity(user));
        return this.mapUserEntityToDto(userEntity);
    }

    private UserEntity mapUserDtoToUserEntity(UserDto userDto) {

        System.out.println("service usersDto");
        System.out.println(userDto);

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstname(userDto.getFirstName());
        userEntity.setLastname(userDto.getLastName());
        userEntity.setPassword(userDto.getPassword());

        System.out.println("logging user entity");
        System.out.println(userEntity);

        return userEntity;
    }
    private UserDto mapUserEntityToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getFirstname());
        userDto.setLastName(userEntity.getLastname());

        return userDto;
    }

}
