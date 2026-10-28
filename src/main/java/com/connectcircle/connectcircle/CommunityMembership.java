package com.connectcircle.connectcircle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "community_memberships")
public class CommunityMembership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String communityName;

    public CommunityMembership() {
    }

    public CommunityMembership(Long studentId, String communityName) {
        this.studentId = studentId;
        this.communityName = communityName;
    }

    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
}