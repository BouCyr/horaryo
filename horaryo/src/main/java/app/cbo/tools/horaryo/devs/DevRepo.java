package app.cbo.tools.horaryo.devs;

import app.cbo.tools.horaryo.devs.entities.Dev;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface DevRepo extends JpaRepository<Dev, Long> {

    public Optional<Dev> findByLogin(String login);
}
