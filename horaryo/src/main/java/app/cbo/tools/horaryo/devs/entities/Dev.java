package app.cbo.tools.horaryo.devs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dev {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String login;
    public String password;

    public String firstName;
    public String lastName;

}
