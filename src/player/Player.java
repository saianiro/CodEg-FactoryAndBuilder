package player;

public abstract class Player {

  protected String name;
  protected Qualification qualification;
  protected int strength;
  protected int dexterity;
  protected int constitution;
  protected int intelligence;
  protected int wisdom;
  protected int charisma;

  public Player(String name) {
    this.name = name;
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
