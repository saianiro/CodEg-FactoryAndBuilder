package player.qualification;

import player.*;

public class Paladin extends Player {

  public Paladin(PlayerBuilder playerBuilder) {
    super(playerBuilder);
    this.qualification = Qualification.PAL;
  }
}
