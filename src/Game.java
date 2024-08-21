import player.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

  Scanner input = new Scanner(System.in);
  PlayerFactory factory = new PlayerFactory();
  Player character;
  ArrayList<Qualification> qualifications = new ArrayList<>(List.of(Qualification.values()));

  public Game() {
    generateCharacter();
  }

  private void generateCharacter() {

    System.out.print("Scegli il nome del tuo personaggio ");
    String playerName = input.nextLine();

    boolean isValid = false;
    do {
      System.out.println("Scegli la sua qualifica: ");
      for(Qualification q : qualifications) {
        System.out.println(" - " + q.getLabel());
      }

      String sel = input.nextLine();
      character = factory.createPlayer(sel, playerName);

      if(character != null) isValid = true;

    } while(!isValid);

    System.out.println(character);
  }

}
