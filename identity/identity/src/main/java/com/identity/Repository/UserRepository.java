package com.identity.Repository;

import com.identity.Model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserCredential, Long> {

}
