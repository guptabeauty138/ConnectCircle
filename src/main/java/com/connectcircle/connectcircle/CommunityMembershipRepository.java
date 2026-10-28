package com.connectcircle.connectcircle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityMembershipRepository
        extends JpaRepository<CommunityMembership, Long> {

    List<CommunityMembership> findByStudentId(Long studentId);

    List<CommunityMembership> findByCommunityName(String communityName);
}