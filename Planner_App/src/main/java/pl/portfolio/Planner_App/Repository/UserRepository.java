package pl.portfolio.Planner_App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.portfolio.Planner_App.Model.Base.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
