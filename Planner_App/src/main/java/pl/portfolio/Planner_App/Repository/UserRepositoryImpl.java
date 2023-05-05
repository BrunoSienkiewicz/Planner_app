package pl.portfolio.Planner_App.Repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import pl.portfolio.Planner_App.Model.Base.User;

public abstract class UserRepositoryImpl implements UserRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public User findByUsername(String username) {
        return entityManager.find(User.class, username);
    }
}
