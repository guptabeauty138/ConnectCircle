
package com.connectcircle.connectcircle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConnectionRequestRepository
        extends JpaRepository<ConnectionRequest, Long> {

    List<ConnectionRequest> findBySenderId(Long senderId);

    List<ConnectionRequest> findByReceiverId(Long receiverId);
List<ConnectionRequest> findByReceiverIdAndStatus(
        Long receiverId, String status);

boolean existsBySenderIdAndReceiverId(
        Long senderId, Long receiverId);
}
