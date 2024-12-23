package tech.toshitworks.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.toshitworks.music.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
