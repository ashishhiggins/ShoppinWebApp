package com.ashishhiggins.shoppinwebapp.repository;

import com.ashishhiggins.shoppinwebapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
