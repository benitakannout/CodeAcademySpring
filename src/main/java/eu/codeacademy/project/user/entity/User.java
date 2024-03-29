package eu.codeacademy.project.user.entity;

import eu.codeacademy.project.answers.entity.Answers;
import eu.codeacademy.project.forum.entity.UserComment;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Table(name = "users")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id", referencedColumnName="id")
    private Set<Answers> answersSet;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id", referencedColumnName="id")
    private Set<UserComment> commentsSet;

    private String username;
    private String name;
    private String email;
    private String city;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
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

    @Override
    public String getUsername() {
        return this.email;
    }
}
