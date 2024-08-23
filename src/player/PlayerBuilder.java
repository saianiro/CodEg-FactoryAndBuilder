package player;

import player.qualification.*;

public class PlayerBuilder {

  private final String name;
  private int strength;
  private int dexterity;
  private int constitution;
  private int intelligence;
  private int wisdom;
  private int charisma;

  private PlayerBuilder(String name) {
    this.name = name;
  }

  public static PlayerBuilder builder(String name) {
    return new PlayerBuilder(name);
  }

  public String getName() {
    return name;
  }

  public int getStrength() {
    return strength;
  }

  public int getDexterity() {
    return dexterity;
  }

  public int getConstitution() {
    return constitution;
  }

  public int getIntelligence() {
    return intelligence;
  }

  public int getWisdom() {
    return wisdom;
  }

  public int getCharisma() {
    return charisma;
  }

  public PlayerBuilder strength(int strength) {
    this.strength = strength;
    return this;
  }

  public PlayerBuilder dexterity(int dexterity) {
    this.dexterity = dexterity;
    return this;
  }

  public PlayerBuilder constitution(int constitution) {
    this.constitution = constitution;
    return this;
  }

  public PlayerBuilder intelligence(int intelligence) {
    this.intelligence = intelligence;
    return this;
  }

  public PlayerBuilder wisdom(int wisdom) {
    this.wisdom = wisdom;
    return this;
  }

  public PlayerBuilder charisma(int charisma) {
    this.charisma = charisma;
    return this;
  }

  public Player buildWizard() {
    return new Wizard(this);
  }

  public Player buildPaladin() {
    return new Paladin(this);
  }

  public Player buildRogue() {
    return new Rogue(this);
  }
}
