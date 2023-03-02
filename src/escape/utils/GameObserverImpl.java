package escape.utils;

import escape.required.GameObserver;

public class GameObserverImpl implements GameObserver {

  public void notify(String message) { System.out.println(message); }

  public void notify(String message, Throwable cause) { System.out.println(message + " " + cause); }

}
