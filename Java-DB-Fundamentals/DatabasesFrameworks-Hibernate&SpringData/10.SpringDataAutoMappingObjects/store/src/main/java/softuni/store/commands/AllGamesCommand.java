package softuni.store.commands;


import softuni.store.models.viewModels.game.GameView;
import softuni.store.services.api.GameService;
import softuni.store.services.api.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class AllGamesCommand extends Command {
    public AllGamesCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        List<GameView> gameViews = super.getGameService().getAll();
        return gameViews.stream()
                .map(GameView::toString)
                .collect(Collectors.joining("\n"));
    }
}
