package player;

public class PlayerFactory {

  PlayerBuilder playerBuilder;

  public Player createPlayer(String qualification, String name) {

    playerBuilder = PlayerBuilder.builder(name);

    switch (qualification.toLowerCase()) {
      case "mago":
        return createWizard();
      case "paladino":
        return createPaladin();
      case "ladro":
        return createRogue();
      default:
        System.out.println("scelta non valida: " + qualification);
        return null;
    }
  }

  private Player createWizard() {

    // valori di default per il mago
    playerBuilder.wisdom(18).intelligence(15).strength(7);

    // todo implementare scelta altri valori
    return playerBuilder.buildWizard();
  }

  private Player createPaladin() {

    // valori di default per il paladino
    playerBuilder.strength(18).constitution(15).dexterity(7);

    // todo implementare scelta altri valori
    return playerBuilder.buildPaladin();
  }

  private Player createRogue() {

    // valori di default per il ladro
    playerBuilder.dexterity(18).charisma(15).wisdom(7);

    // todo implementare scelta altri valori
    return playerBuilder.buildRogue();
  }
}
