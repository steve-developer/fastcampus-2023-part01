package org.delivery.storeadmin.domain.authorization.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.db.storeuser.enums.StoreUserRole;
import org.delivery.db.storeuser.enums.StoreUserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSession implements UserDetails {

    // user
    private Long userId;

    private String email;

    private String password;

    private StoreUserStatus status;

    private StoreUserRole role;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime lastLoginAt;

    // store
    private Long storeId;
    private String storeName;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.toString()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.status == StoreUserStatus.REGISTERED;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.status == StoreUserStatus.REGISTERED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.status == StoreUserStatus.REGISTERED;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
