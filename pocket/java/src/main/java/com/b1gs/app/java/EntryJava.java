package com.b1gs.app.java;

import com.toxic.core.engine.base.IApplication;
import com.b1gs.app.core.Entry;
import com.toxic.java.PlatfromJava;

/**
 * <p>
 *  Test Java application.
 * </p>
 * <br/>
 * @author Strelock
 *
 */
public class EntryJava extends PlatfromJava {

  /**
   * <p>
   *  Default constructor of java platform.
   * </p> 
   * <br/>
   * @param app instance of application
   */
  public EntryJava(IApplication app) {
    super(app);
  }

  public static void main(String[] args) {
    (new EntryJava(new Entry())).start();
  }

}
