package app.cbo.tools.horaryo.devs.entities;

import app.cbo.tools.horaryo.projects.entities.Contributes;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
public class HoraryoUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String login;
    public String password;

    public String firstName;
    public String lastName;




    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<Contributes>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
