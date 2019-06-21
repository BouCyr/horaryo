package app.cbo.tools.horaryo.projects;

import app.cbo.tools.horaryo.projects.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
}
