package player;

public enum Qualification {

  WIZ ("Mago"),
  PAL ("Paladino"),
  ROG ("Ladro");

  private final String label;

  Qualification(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }
}
