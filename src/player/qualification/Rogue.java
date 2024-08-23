package player.qualification;

import player.*;

public class Rogue extends Player {

  public Rogue(PlayerBuilder playerBuilder) {
    super(playerBuilder);
    this.qualification = Qualification.ROG;
  }
}
