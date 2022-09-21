package com.interview.server.api;

import com.interview.server.model.TestUser;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

/**
 * @author bkaaron
 * @created 21/09/2022
 * @project pivot_int
 */
@RestController
@RequestMapping("/api/v1")
public class ServerApi {

    private final Bucket bucket;

    public ServerApi() {
        Bandwidth limit = Bandwidth.classic(20, Refill.greedy(20, Duration.ofMinutes(1)));
        this.bucket = Bucket4j.builder()
                .addLimit(limit)
                .build();
    }

    @GetMapping(path = "/test")
    public ResponseEntity<Object> getTestUser() {

        if (bucket.tryConsume(1)) {
            return ResponseEntity.ok(List.of(
                    new TestUser("ab","new",4),
                    new TestUser("ad","new",4),
                    new TestUser("af","new",4),
                    new TestUser("ac","new",4)));
            //return ResponseEntity.ok("ndfgfghf");
        }

        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();

    }
}
