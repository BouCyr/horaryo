package app.cbo.tools.horaryo.projects;

import app.cbo.tools.horaryo.projects.entities.Contributes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContributesRepo extends JpaRepository<Contributes, Long> {
}
