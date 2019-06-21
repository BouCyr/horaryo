package app.cbo.tools.horaryo.devs;

import app.cbo.tools.horaryo.devs.entities.HoraryoUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserManager implements UserDetailsService /*, UserDetailsPasswordService */{

    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder encoder;

    public long count(){
        return this.repo.count();
    }

    public HoraryoUser save(HoraryoUser input, String clearPassword){
        input.password = this.encoder.encode(clearPassword);
        return this.repo.save(input);
    }

    public Optional<HoraryoUser> checkPassword(String login, String password){

        Optional<HoraryoUser> maybe = this.repo.findByLogin(login);

        String fakeHash = encoder.encode("this is a password");

        String hash = maybe.isPresent()?maybe.get().password:fakeHash;

        if(this.encoder.matches(password, hash)){
            return maybe;
        }else{
            return Optional.empty();
        }


    }

    public Optional<HoraryoUser> findByLogin(String admin) {

        return this.repo.findByLogin(admin);
    }

    @Override
    //this one is used by spring security => also give him its project links
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<HoraryoUser> maybe = this.findByLogin(s);
        if(!maybe.isPresent()){
            throw new UsernameNotFoundException(s);
        }
        HoraryoUser user = maybe.get();


        return user;
    }
}
