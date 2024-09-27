package br.com.ruan_dev.cadastro.repostirories;

import br.com.ruan_dev.cadastro.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {

}
