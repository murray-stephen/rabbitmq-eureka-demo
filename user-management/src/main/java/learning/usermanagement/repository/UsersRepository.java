package learning.usermanagement.repository;

import learning.usermanagement.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {
}
