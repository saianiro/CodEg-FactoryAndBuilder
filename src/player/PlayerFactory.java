package player;

import java.util.Scanner;

public class PlayerFactory {

  private Scanner input = new Scanner(System.in);
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

    // valori scelti dall'utente
    playerBuilder.dexterity(setAttributeValue("destrezza"));
    playerBuilder.constitution(setAttributeValue("costituzione"));
    playerBuilder.charisma(setAttributeValue("carisma"));

    return playerBuilder.buildWizard();
  }

  private Player createPaladin() {

    // valori di default per il paladino
    playerBuilder.strength(18).constitution(15).dexterity(7);

    // valori scelti dall'utente
    playerBuilder.intelligence(setAttributeValue("intelligenza"));
    playerBuilder.wisdom(setAttributeValue("saggezza"));
    playerBuilder.charisma(setAttributeValue("carisma"));

    return playerBuilder.buildPaladin();
  }

  private Player createRogue() {

    // valori di default per il ladro
    playerBuilder.dexterity(18).charisma(15).wisdom(7);

    // valori scelti dall'utente
    playerBuilder.strength(setAttributeValue("forza"));
    playerBuilder.constitution(setAttributeValue("costituzione"));
    playerBuilder.intelligence(setAttributeValue("intelligenza"));

    return playerBuilder.buildRogue();
  }

  private int setAttributeValue(String attribute) {

    boolean isValid = false;
    int value = 0;
    do {
      System.out.print("Scegli un valore di " + attribute + " incluso tra 6 e 20 ");
      try {
        value = Integer.parseInt(input.nextLine());
        if(value < 6 || value > 20) System.out.println("Scelta non valida");
        else {
          System.out.println("Hai inserito il valore " + value);
          isValid = true;
        }
      }
      catch (NumberFormatException e) {
        System.out.println("Input non valido. Inserisci un numero intero.");
      }
    } while(!isValid);

    return value;
  }
}
