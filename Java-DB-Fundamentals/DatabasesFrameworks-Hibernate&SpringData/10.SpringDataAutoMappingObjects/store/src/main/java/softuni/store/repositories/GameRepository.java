package softuni.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.store.entities.Game;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
    Game findByTitle(String name);
}
