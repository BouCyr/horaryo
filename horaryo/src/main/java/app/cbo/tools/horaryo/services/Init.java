package app.cbo.tools.horaryo.services;

import app.cbo.tools.horaryo.devs.UserManager;
import app.cbo.tools.horaryo.devs.entities.HoraryoUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
@Slf4j
public class Init {

    @Autowired
    private UserManager devs;

    @PostConstruct
    public void init(){
        if(devs.count() == 0){
            log.warn("No accounts found ; creating admin account.");
            HoraryoUser admin = new HoraryoUser();
            admin.login="ADMIN";
            admin.firstName="admin";
            admin.lastName="admin";

            this.devs.save(admin, "ADMIN");

            Optional<HoraryoUser> autehnticationTest = devs.checkPassword("ADMIN", admin.password);
            log.warn("Admin password check : "+autehnticationTest.isPresent());
        }

        Optional<HoraryoUser> admin = this.devs.findByLogin("ADMIN");

        if(admin.isPresent() /*&& projects.count == 0*/){
            //full init
        }

    }
}
