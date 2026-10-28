
package com.connectcircle.connectcircle;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connections")
@CrossOrigin
public class ConnectionRequestController {

    private final ConnectionRequestRepository requestRepository;

    public ConnectionRequestController(
            ConnectionRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @PostMapping("/send")
    public ConnectionRequest sendRequest(
            @RequestBody ConnectionRequest request) {

        request.setStatus("PENDING");

        return requestRepository.save(request);
    }

    @GetMapping("/sent/{studentId}")
    public List<ConnectionRequest> getSentRequests(
            @PathVariable Long studentId) {

        return requestRepository.findBySenderId(studentId);
    }

    @GetMapping("/received/{studentId}")
    public List<ConnectionRequest> getReceivedRequests(
            @PathVariable Long studentId) {

        return requestRepository.findByReceiverId(studentId);
    }
    @PutMapping("/{requestId}/status")
public ConnectionRequest updateRequestStatus(
        @PathVariable Long requestId,
        @RequestParam String status) {

    ConnectionRequest request = requestRepository.findById(requestId)
            .orElseThrow(() ->
                    new RuntimeException("Connection request not found"));

    if (!status.equalsIgnoreCase("ACCEPTED")
            && !status.equalsIgnoreCase("REJECTED")) {
        throw new RuntimeException("Invalid request status");
    }

    request.setStatus(status.toUpperCase());

    return requestRepository.save(request);
}
}
