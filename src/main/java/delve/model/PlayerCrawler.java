package delve.model;

/**
 * PlayerCrawler is the specific crawler that the player will be controlling during
 * the progression of the game. The player has the ability to move around with arrow keys,
 * pick up items, drop items, attack, take damage, level up, and more.
 *
 * <p>Stat Scaling:</p>
 * The PlayerCrawler has balanced stat growth designed for steady progression throughout
 * the game. Stats scale with level as follows:
 * <ul>
 *   <li><b>Max Health:</b> Increases by 15 HP per level, providing survivability as the
 *       player progresses through harder dungeons</li>
 *   <li><b>Attack Power:</b> Increases by 5 points per level, allowing the player to deal
 *       more damage with basic attacks and scale with stronger weapons</li>
 *   <li><b>Defense Points:</b> Increases by 2 points per level, providing percentage-based
 *       damage reduction (capped at 75%) to mitigate incoming damage</li>
 * </ul>
 *
 * <p>When the player levels up, their current health is restored to the new maximum,
 * effectively giving them a full heal upon leveling.</p>
 *
 * <p>The player starts at a moderate power level and relies on both stat growth and
 * equipped items (weapons, armor) to become stronger and face tougher enemies in deeper
 * dungeon levels.</p>
 */
public class PlayerCrawler extends AbstractDelveCrawler {

  public PlayerCrawler(String name, int maxHealth, int defencePoints,
                       int level, int attackPoints) {
    super(name, maxHealth, defencePoints, level, attackPoints);
  }
  @Override
  void inflictDamage(int damage, DelveCrawler crawler) {

  }

  @Override
  void levelUp() {

  }
}
