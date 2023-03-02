package escape.utils;

import escape.required.Rule;

public class RuleImpl implements Rule {

  /**
   * @return the RuleID
   */
  @Override
  public RuleID getId() {
    return null;
  }

  /**
   * @return If this is a rule with a value (e.g. TURN_LIMIT), then this returns that value.
   *     If it is has no value (e.g. REMOVE), return 0
   */
  @Override
  public int getIntValue() {
    return 0;
  }

}
