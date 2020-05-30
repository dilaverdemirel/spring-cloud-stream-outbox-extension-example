package com.dilaverdemirel.stream.payment.endpoint;


import com.dilaverdemirel.spring.outbox.domain.OutboxMessage;
import com.dilaverdemirel.spring.outbox.repository.OutboxMessageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dilaverdemirel
 * @since 4.05.2020
 */
@RestController
@RequestMapping(path = "/outbox-messages")
public class OutboxMessageController {
    private final OutboxMessageRepository outboxMessageRepository;

    public OutboxMessageController(OutboxMessageRepository outboxMessageRepository) {
        this.outboxMessageRepository = outboxMessageRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<OutboxMessage>> getAll() {
        return new ResponseEntity<>(outboxMessageRepository.findAll(), HttpStatus.OK);
    }
}
