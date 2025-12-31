package delve.model;

/**
 * An object of type DelveCrawler is any being (player, enemy or NPC)
 * within the game. This interface defines behaviors that every
 * DelveCrawler must implement. Every DelveCrawler must be able to move, attack,
 * take damage, and heal.
 */
public interface DelveCrawler {

  /**
   * Will inflict the given amount of damage to this DelveCrawler. DelveCrawlers have a limited
   * amount of health depending on their level. If the amount of damage will make the crawlers's
   * health below 0, then the crawler is dead. The amount of damage given cannot be negative.
   * @param damage the integer amount of health to take away from the crawlers total health.
   */
  void takeDamage(int damage);

  /**
   * Will heal this DelveCrawler for the amount of health that is given. If the amount to heal
   * will exceed the max amount of health this crawler has, then it only heals up to the max.
   * Never does healing exceed the max amount of health.
   * @param amount is the integer amount of health that the crawler will be healed by.
   */
  void heal(int amount);

  /**
   * Will return the current amount of health that this DelveCrawler has. This amount is
   * effected by the damage that the crawler has taken.
   * @return the integer amount of health tied to the crawler.
   */
  int getHealth();

  /**
   * Will return the max amount of health for this DelveCrawler. The amount returned is not
   * effected by the damage taken during the game. This amount can only go up (increased) and
   * can never be decreased.
   * @return the max amount of health for this crawler.
   */
  int getMaxHealth();

  /**
   * Will return the amount of defence points that this crawler has. Defense points are used to
   * nullify the damage taken. As you progress through the game, the damage that the DelveCrawlers
   * inflict will increase so the player will need to increase their max health in order to survive.
   * @return the defense points for this crawler.
   */
  int getDefence();

  /**
   * Will return the attack power that the DelveCrawler has. The attack power is how much default
   * damage the crawler will inflict on its basic attack. Some crawlers will use an item to attack
   * with which that attack power will be added to this crawlers attack power.
   * @return the integer amount of attack power this DelveCrawler has.
   */
  int getAttackPower();

  /**
   * Will return T or F if the given crawler is still alive. A crawler is alive if their health is
   * above 0. If the crawlers health is below 1, then the crawler is dead.
   * @return a boolean T or F if the crawler is alive.
   */
  boolean isAlive();

  /**
   * Will return the name of this crawler. Used for display purposes during the game.
   * @return the name of this crawler.
   */
  String displayName();

  /**
   * Will return the current level of this DelveCrawler. The level of the crawler is how the
   * crawler will scale as the game progresses so that they can impact the game in a reasonable way.
   * @return the level of this DelveCrawler.
   */
  int getLevel();
}
