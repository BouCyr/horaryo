package app.cbo.tools.horaryo.devs;

import app.cbo.tools.horaryo.devs.entities.HoraryoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface UserRepo extends JpaRepository<HoraryoUser, Long> {

    public Optional<HoraryoUser> findByLogin(String login);
}
