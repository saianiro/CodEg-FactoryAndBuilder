package player;

import player.qualification.Qualification;

public abstract class Player {

  protected String name;
  protected Qualification qualification;
  protected int strength;
  protected int dexterity;
  protected int constitution;
  protected int intelligence;
  protected int wisdom;
  protected int charisma;

  public Player(PlayerBuilder playerBuilder) {
    this.name = playerBuilder.getName();
    this.strength = playerBuilder.getStrength();
    this.dexterity = playerBuilder.getDexterity();
    this.constitution = playerBuilder.getConstitution();
    this.intelligence = playerBuilder.getIntelligence();
    this.wisdom = playerBuilder.getWisdom();
    this.charisma = playerBuilder.getCharisma();
  }

  @Override
  public String toString() {
    return name + " {" +
            "qualification = " + qualification.getLabel() +
            ", strength = " + strength +
            ", dexterity = " + dexterity +
            ", constitution = " + constitution +
            ", intelligence = " + intelligence +
            ", wisdom = " + wisdom +
            ", charisma = " + charisma +
            '}';
  }
}
