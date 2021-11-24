package boot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity (name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String role;

    @Override
    public String getAuthority() {
        return getRole();
    }

    public Role (String roleName) {
        this.role = roleName;
    }

    @Override
    public String toString() {
        return role;
    }
}
