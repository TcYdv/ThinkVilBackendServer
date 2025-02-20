package com.Twitter.Jarvis.Repository;


import com.Twitter.Jarvis.Model.UserConfigurationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserConfigurationModel, Long> {
    @Query("FROM UserConfigurationModel u WHERE u.email = :email")
    public UserConfigurationModel findByEmail(@Param("email") String email);

    @Query("SELECT DISTINCT u FROM UserConfigurationModel u WHERE u.fullName LIKE %:query% OR u.email LIKE %:query%")
    List<UserConfigurationModel> searchUser(@Param("query") String query);
}
