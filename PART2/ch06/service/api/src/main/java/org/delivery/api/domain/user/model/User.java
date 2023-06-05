package org.delivery.api.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.db.user.enums.UserStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;

    private String name;

    private String email;

    private String password;

    private UserStatus status;

    private String address;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime lastLoginAt;
}
