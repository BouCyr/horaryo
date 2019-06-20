package app.cbo.tools.horaryo.services;

import app.cbo.tools.horaryo.devs.DevManager;
import app.cbo.tools.horaryo.devs.entities.Dev;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
@Slf4j
public class Init {

    @Autowired
    private DevManager devs;

    @PostConstruct
    public void init(){
        if(devs.count() == 0){
            log.warn("No accounts found ; creating admin account.");
            Dev admin = new Dev();
            admin.login="ADMIN";
            admin.firstName="admin";
            admin.lastName="admin";

            this.devs.save(admin, "ADMIN");

            Optional<Dev> autehnticationTest = devs.checkPassword("ADMIN", admin.password);
            log.warn("Admin password check : "+autehnticationTest.isPresent());
        }

        Dev admin = this.devs.findByLogin("ADMIN");

    }
}
