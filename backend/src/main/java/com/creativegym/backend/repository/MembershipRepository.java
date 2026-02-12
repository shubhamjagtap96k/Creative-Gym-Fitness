package com.creativegym.backend.repository;

import com.creativegym.backend.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    Optional<Membership> findByUserIdAndStatus(Long userId, String status); // Need to handle Enum properly or use
                                                                            // @Query if needed, but Spring Data JPA
                                                                            // usually handles Enums fine if naming
                                                                            // matches.
    // Better to use list for history

    List<Membership> findByUserId(Long userId);
}
