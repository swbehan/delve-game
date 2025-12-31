package delve.model;

/**
 * An abstract DelveCrawler that will implement the basic behavior that every DelveCrawler
 * must implement. Methods that are up to the implementation of the specific DelveCrawler will
 * be left abstract to be defined within that specific class.
 */
abstract class AbstractDelveCrawler implements DelveCrawler {
  protected int maxHealth;
  protected int defencePoints;
  protected int attackPoints;
  protected int currentHealth;
  protected int level;
  private final String name;

  public AbstractDelveCrawler(String name, int maxHealth, int defencePoints,
                              int level, int attackPoints) throws IllegalArgumentException {
    if (maxHealth <= 0) {
      throw new IllegalArgumentException("Max health must be greater than 0");
    }
    if (defencePoints < 0) {
      throw new IllegalArgumentException("Defence points must be positive");
    }
    if (attackPoints < 0) {
      throw new IllegalArgumentException("Attack points must be positive");
    }
    if (level < 0) {
      throw new IllegalArgumentException("Level must be positive");
    }
    if (name == null) {
      throw new IllegalArgumentException("Name must not be null");
    }
    this.maxHealth = maxHealth;
    this.defencePoints = defencePoints;
    this.currentHealth = maxHealth;
    this.level = level;
    this.name = name;
    this.attackPoints = attackPoints;
  }

  @Override
  public void takeDamage(int damage) {
    if (this.currentHealth < 1) {
      throw new IllegalStateException("Crawler is already dead");
    }
    if (damage < 0) {
      throw new IllegalArgumentException("Damage must be positive");
    }

    // Subtract defense from damage (armor will add to this later)
    int actualDamage = Math.max(1, damage - this.defencePoints);

    this.currentHealth = Math.max(0, this.currentHealth - actualDamage);
  }

  /**
   * Will inflict the given amount of damage to the given DelveCrawler. If the the amount
   * of damage inflicted to the crawler will have its health equal or go below 0, then the
   * given crawler is dead.
   * @param damage amount of damage to inflict to the crawler.
   * @param crawler the specific crawler to inflict damage to.
   */
  abstract void inflictDamage(int damage, DelveCrawler crawler);

  /**
   * Will increase the level of the DelveCrawler by 1. By increasing the level of the crawler,
   * the defense points, attack points and max health will be increased. The amount that those
   * fields increase by will depend on the type of crawler. Additionally, when the crawler
   * levels up, their current health is set to the new max.
   */
  abstract void levelUp();

  @Override
  public void heal(int amount) {
    if (amount < 1) {
      throw new IllegalArgumentException("Amount must be greater than 0");
    }
    int newHealth = this.currentHealth + amount;
    this.currentHealth = Math.min(newHealth, this.maxHealth);
  }

  @Override
  public int getHealth() {
    return this.currentHealth;
  }

  @Override
  public int getMaxHealth() {
    return this.maxHealth;
  }

  @Override
  public int getDefence() {
    return this.defencePoints;
  }

  @Override
  public int getAttackPower() {
    return this.attackPoints;
  }

  @Override
  public boolean isAlive() {
    return this.currentHealth > 0;
  }

  @Override
  public String displayName() {
    return this.name;
  }

  @Override
  public int getLevel() {
    return this.level;
  }
}
