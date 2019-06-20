package app.cbo.tools.horaryo.devs;

import app.cbo.tools.horaryo.devs.entities.Dev;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
@Slf4j
public class DevManager {

    @Autowired
    private DevRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    public long count(){
        return this.repo.count();
    }

    public Dev save(Dev input, String clearPassword){
        input.password = this.encoder.encode(clearPassword);
        return this.repo.save(input);
    }

    public Optional<Dev> checkPassword(String login, String password){

        Optional<Dev> maybe = this.repo.findByLogin(login);

        String fakeHash = encoder.encode("this is a password");

        String hash = maybe.isPresent()?maybe.get().password:fakeHash;

        if(this.encoder.matches(password, hash)){
            return maybe;
        }else{
            return Optional.empty();
        }


    }

    public Optional<Dev> findByLogin(String admin) {

        return this.repo.findByLogin(admin);
    }
}
