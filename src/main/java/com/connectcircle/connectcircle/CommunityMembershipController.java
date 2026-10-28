package com.connectcircle.connectcircle;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/communities")
@CrossOrigin
public class CommunityMembershipController {

    private final CommunityMembershipRepository membershipRepository;

    public CommunityMembershipController(
            CommunityMembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @PostMapping("/join")
    public String joinCommunity(@RequestBody CommunityMembership membership) {

        List<CommunityMembership> existingMemberships =
                membershipRepository.findByStudentId(membership.getStudentId());

        for (CommunityMembership existing : existingMemberships) {
            if (existing.getCommunityName()
                    .equalsIgnoreCase(membership.getCommunityName())) {
                return "You have already joined this community.";
            }
        }

        membershipRepository.save(membership);
        return "Successfully joined " + membership.getCommunityName() + "!";
    }

    @GetMapping("/student/{studentId}")
    public List<CommunityMembership> getStudentCommunities(
            @PathVariable Long studentId) {
        return membershipRepository.findByStudentId(studentId);
    }
}