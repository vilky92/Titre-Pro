package cjSecurity.repository.user;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cjSecurity.model.user.User;

public interface IUserRepository extends JpaRepository<User, Long> {


	User findByLogin(String login);

	List <User> findByActifFalseOrderByLoginAsc();

	boolean existsByLogin(String login);


}
