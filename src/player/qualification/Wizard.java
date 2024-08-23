package player.qualification;

import player.*;

public class Wizard extends Player {

  public Wizard(PlayerBuilder playerBuilder) {
    super(playerBuilder);
    this.qualification = Qualification.WIZ;
  }
}
