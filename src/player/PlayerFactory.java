package player;

import player.qualification.*;

public class PlayerFactory {

  public Player createPlayer(String qualification, String name) {

    switch (qualification.toLowerCase()) {
      case "mago":
        return new Wizard(name);
      case "paladino":
        return new Paladin(name);
      case "ladro":
        return new Rogue(name);
      default:
        System.out.println("scelta non valida: " + qualification);
        return null;
    }
  }
}
