package softuni.store.services.api;


import softuni.store.models.bindingModels.game.AddGame;
import softuni.store.models.bindingModels.game.BoughtGame;
import softuni.store.models.bindingModels.game.ManipulateGame;
import softuni.store.models.bindingModels.game.ShoppingCartGame;
import softuni.store.models.bindingModels.game.edit.*;
import softuni.store.models.viewModels.game.GameDetailsView;
import softuni.store.models.viewModels.game.GameView;
import softuni.store.models.viewModels.game.OwnedGameView;

import java.util.List;

public interface GameService {
    
    void addGame(AddGame addGame);
    
    List<GameView> getAll();
    
    void updateTitle(EditGameTitle editGameTitle, Long id);

    void updatePrice(EditGamePrice editGamePrice, Long id);

    ManipulateGame getManipulateGame(Long gameId);

    void updateSize(EditGameSize editGameSize, Long gameId);

    void updateReleaseDate(EditGameReleaseDate editGameReleaseDate, Long gameId);

    void updateTrailer(EditGameTrailer editGameTrailer, Long gameId);

    void updateThumbnailURL(EditGameThumbnailURL editGameThumbnailURL, Long gameId);

    void updateDescription(EditGameDescription editGameDescription, Long gameId);

    void deleteGame(Long id);

    GameDetailsView getGameDetailsByName(String title);

    ShoppingCartGame getShoppingCartGameByName(String title);
}
