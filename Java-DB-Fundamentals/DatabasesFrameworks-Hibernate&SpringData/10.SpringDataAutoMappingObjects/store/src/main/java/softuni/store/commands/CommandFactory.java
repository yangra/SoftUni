package softuni.store.commands;


import softuni.store.commands.*;
import softuni.store.services.api.GameService;
import softuni.store.services.api.UserService;

public class CommandFactory {

    private UserService userService;
    private GameService gameService;

    public CommandFactory(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    public Executable getCommand(String command){
        switch(command){
            case "Register":
                return new RegisterCommand(this.userService, this.gameService);
            case "Login":
                return new LoginCommand(this.userService, this.gameService);
            case "Logout":
                return new LogoutCommand(this.userService,this.gameService);
            case "AddGame":
                return new AddGameCommand(this.userService,this.gameService);
            case "AllGames":
                return new AllGamesCommand(this.userService, this.gameService);
            case "EditGame":
                return new EditGameCommand(this.userService, this.gameService);
            case "DeleteGame":
                return new DeleteCommand(this.userService, this.gameService);
            case "GameDetails":
                return new GameDetailsCommand(this.userService, this.gameService);
            case "AddToShoppingCart":
                return new AddToShoppingCartCommand(this.userService, this.gameService);
            case "RemoveFromShoppingCart":
                return new RemoveFromShoppingCartCommand(this.userService,this.gameService);
            case "BuyGames":
                return new BuyGamesCommand(this.userService,this.gameService);
            case "OwnedGames":
                return new OwnedGamesCommand(this.userService,this.gameService);
        }

        return null;
    }
}
