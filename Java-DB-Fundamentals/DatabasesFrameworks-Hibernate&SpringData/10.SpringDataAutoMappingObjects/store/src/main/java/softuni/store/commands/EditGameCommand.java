package softuni.store.commands;


import org.springframework.transaction.annotation.Transactional;
import softuni.store.Utils.DataValidator;
import softuni.store.Utils.Session;
import softuni.store.entities.enums.Role;
import softuni.store.models.bindingModels.game.ManipulateGame;
import softuni.store.models.bindingModels.game.edit.*;
import softuni.store.services.api.GameService;
import softuni.store.services.api.UserService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Transactional
public class EditGameCommand extends Command {
    public EditGameCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        if (Session.getLoggedInUser() == null) {
            return "No user logged in.";
        }
        if (Session.getLoggedInUser().getRole() != Role.ADMIN) {
            return "Only admins can edit games.";
        }
        Long gameId = Long.parseLong(params[0]);
        ManipulateGame manipulateGame = super.getGameService().getManipulateGame(gameId);
        if(manipulateGame == null){
            return "Cannot edit game. Invalid game id.";
        }
        for (int i = 1; i < params.length; i++) {
            String[] args = params[i].split("=");
            switch (args[0]) {
                case "title":
                    EditGameTitle editGameTitle = new EditGameTitle(args[1]);
                    if (!DataValidator.checkIsValid(editGameTitle)) {
                        return DataValidator.getInvalidParameterMessage(editGameTitle);
                    }
                    super.getGameService().updateTitle(editGameTitle,gameId);
                    break;
                case "price":
                    EditGamePrice editGamePrice = new EditGamePrice(new BigDecimal(args[1]));
                    if (!DataValidator.checkIsValid(editGamePrice)) {
                        return DataValidator.getInvalidParameterMessage(editGamePrice);
                    }
                    super.getGameService().updatePrice(editGamePrice,gameId);
                    break;
                case "size":
                    EditGameSize editGameSize = new EditGameSize(Double.parseDouble(args[1]));
                    if (!DataValidator.checkIsValid(editGameSize)) {
                        return DataValidator.getInvalidParameterMessage(editGameSize);
                    }
                    super.getGameService().updateSize(editGameSize,gameId);
                    break;
                case "trailer":
                    EditGameTrailer editGameTrailer = new EditGameTrailer(args[1]);
                    if (!DataValidator.checkIsValid(editGameTrailer)) {
                        return DataValidator.getInvalidParameterMessage(editGameTrailer);
                    }
                    super.getGameService().updateTrailer(editGameTrailer,gameId);
                    break;
                case "thumbnailURL":
                    EditGameThumbnailURL editGameThumbnailURL = new EditGameThumbnailURL(args[1]);
                    if (!DataValidator.checkIsValid(editGameThumbnailURL)) {
                        return DataValidator.getInvalidParameterMessage(editGameThumbnailURL);
                    }
                    super.getGameService().updateThumbnailURL(editGameThumbnailURL,gameId);
                    break;
                case "description":
                    EditGameDescription editGameDescription = new EditGameDescription(args[1]);
                    if (!DataValidator.checkIsValid(editGameDescription)) {
                        return DataValidator.getInvalidParameterMessage(editGameDescription);
                    }
                    super.getGameService().updateDescription(editGameDescription,gameId);
                    break;
                case "releaseDate":
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    EditGameReleaseDate editGameReleaseDate = null;
                    try {
                        editGameReleaseDate = new EditGameReleaseDate(simpleDateFormat.parse(args[1]));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (!DataValidator.checkIsValid(editGameReleaseDate)) {
                        return DataValidator.getInvalidParameterMessage(editGameReleaseDate);
                    }
                    super.getGameService().updateReleaseDate(editGameReleaseDate,gameId);
                    break;
            }
        }

        return String.format("Edited %s", manipulateGame.getTitle());
    }
}
