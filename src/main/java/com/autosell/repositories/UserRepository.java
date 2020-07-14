package com.autosell.repositories;

import com.autosell.domains.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(String email);
    User findByUserName(String username);

//    User saveBillingAddressByID(long id);
    @Modifying
    @Query("update User u set u.adminVerification = ?1 where u.id = ?2")
    Integer changeStatus(Short status, Long id);

    @Modifying
    @Query("update User u set u.points = u.points + ?2 where u.id = ?1")
    void addPointsById(Long id, Long points);
}
