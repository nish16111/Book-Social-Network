package com.sirwani.book.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Token {

    @Id
    @GeneratedValue
    private Integer id;
    private String token;
    private LocalDateTime createdAt; //Duplicate Lines with cmd + D
    private LocalDateTime expiresAt;
    private LocalDateTime validatedAt;

    @ManyToOne //Many Tokens to One User (*Important to understand*)
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
