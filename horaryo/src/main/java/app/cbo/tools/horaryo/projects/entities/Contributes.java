package app.cbo.tools.horaryo.projects.entities;

import app.cbo.tools.horaryo.devs.entities.HoraryoUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Contributes implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private HoraryoUser user;

    @ManyToOne
    private Project project;

    @Enumerated
    private Role roleInProject;


    @Override
    @Transient
    public String getAuthority() {
        return roleInProject.toString()+"@"+project.getId();
    }
}
