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

    @Query("SELECT g FROM Game AS g INNER JOIN g.gameOwners AS o WHERE g.id = :gameId AND o.id = :userId")
    Game findByGameOwnerAndId(@Param("gameId")Long id, @Param("userId") Long userId);

    @Query("SELECT g FROM Game AS g INNER JOIN g.gameBuyers AS b WHERE g.id = :gameId AND b.id = :userId")
    Game findCartGameByIdAndBuyer(@Param("gameId")Long gameId, @Param("userId")Long userId);

    @Query("SELECT g FROM Game AS g INNER JOIN g.gameBuyers AS b WHERE b.id = :userId")
    List<Game> findCartGamesByUserId(@Param("userId") Long userId);

    @Query("SELECT g FROM Game AS g INNER JOIN g.gameOwners AS o WHERE o.id = :userId")
    List<Game> findOwnedGamesByUserId(@Param("userId")Long userId);
}
