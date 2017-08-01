package softuni.store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.store.Utils.ModelParser;
import softuni.store.entities.Game;
import softuni.store.entities.User;
import softuni.store.models.bindingModels.game.AddGame;
import softuni.store.models.bindingModels.game.BoughtGame;
import softuni.store.models.bindingModels.game.ManipulateGame;
import softuni.store.models.bindingModels.game.ShoppingCartGame;
import softuni.store.models.bindingModels.game.edit.*;
import softuni.store.models.viewModels.game.GameDetailsView;
import softuni.store.models.viewModels.game.GameView;
import softuni.store.models.viewModels.game.OwnedGameView;
import softuni.store.repositories.GameRepository;
import softuni.store.repositories.UserRepository;
import softuni.store.services.api.GameService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void addGame(AddGame addGame) {
        Game game = ModelParser.getInstance().map(addGame, Game.class);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public List<GameView> getAll() {
        List<Game> games = this.gameRepository.findAll();
        List<GameView> gameViews = new ArrayList<>();
        for (Game game : games) {
            GameView gameView = ModelParser.getInstance().map(game, GameView.class);
            gameViews.add(gameView);
        }
        return gameViews;
    }

    @Override
    public void updateTitle(EditGameTitle editGameTitle, Long id) {
        Game game = this.gameRepository.findOne(id);
        ModelParser.getInstance().map(editGameTitle, game);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public void updatePrice(EditGamePrice editGamePrice, Long id) {
        Game game = this.gameRepository.findOne(id);
        ModelParser.getInstance().map(editGamePrice, game);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public ManipulateGame getManipulateGame(Long gameId) {
        Game game = this.gameRepository.findOne(gameId);
        if (game == null) {
            return null;
        }
        return ModelParser.getInstance().map(game, ManipulateGame.class);

    }

    @Override
    public void updateSize(EditGameSize editGameSize, Long id) {
        Game game = this.gameRepository.findOne(id);
        ModelParser.getInstance().map(editGameSize, game);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public void updateReleaseDate(EditGameReleaseDate editGameReleaseDate, Long id) {
        Game game = this.gameRepository.findOne(id);
        ModelParser.getInstance().map(editGameReleaseDate, game);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public void updateTrailer(EditGameTrailer editGameTrailer, Long id) {
        Game game = this.gameRepository.findOne(id);
        ModelParser.getInstance().map(editGameTrailer, game);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public void updateThumbnailURL(EditGameThumbnailURL editGameThumbnailURL, Long id) {
        Game game = this.gameRepository.findOne(id);
        ModelParser.getInstance().map(editGameThumbnailURL, game);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public void updateDescription(EditGameDescription editGameDescription, Long id) {
        Game game = this.gameRepository.findOne(id);
        ModelParser.getInstance().map(editGameDescription, game);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public void deleteGame(Long id) {
        Game game = this.gameRepository.findOne(id);
        this.gameRepository.delete(game);
    }

    @Override
    public GameDetailsView getGameDetailsByName(String title) {
        Game game = this.gameRepository.findByTitle(title);
        if(game == null){
            return null;
        }
        return ModelParser.getInstance().map(game,GameDetailsView.class);
    }

    @Override
    public ShoppingCartGame getShoppingCartGameByName(String title) {
        Game game = this.gameRepository.findByTitle(title);
        if(game == null){
            return null;
        }
        return ModelParser.getInstance().map(game,ShoppingCartGame.class);
    }

}
