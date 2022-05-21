package com.example.elnazfaghihitestassignment.repository;

import com.example.elnazfaghihitestassignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByName(String name);

    Optional<User> findUserByNameAndFirstName(String name, String firstName);

    @Query(" select distinct u from User u join Borrowed b on u.id=b.userId ")
    List<User> getUserListsWithAtLeastOneBorrowedBook();

    @Query("select u from User u left join Borrowed b on u.id=b.userId where b.userId is null and u.memberTill>= current_date")
    List<User> getUsersWhoseMembershipHasExpiredWithNoBooksBorrowing();

    @Query("select distinct u from User u join Borrowed b on u.id=b.userId where b.borrowedFrom= :date group by b.userId having count(u.id)=1")
    List<User> getUsersByBorrowingOneBook(Date date);
}
