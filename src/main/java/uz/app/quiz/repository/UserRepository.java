package uz.app.quiz.repository;



import uz.app.quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface UserRepository extends JpaRepository<User, UUID> {
//    Optional<User> findByPhoneNumber(String phoneNumber);
//    Optional<User> findByUserName(String userName);
//    Optional<User> findByEmail(String email);

    void deleteById(UUID uuid);

    Optional<User> findByPhoneNumber(String paycom);

    Optional<User> findByIdAndEnabled(UUID id, boolean b);
}
