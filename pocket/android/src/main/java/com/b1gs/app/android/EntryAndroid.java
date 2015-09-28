package com.b1gs.app.android;

import com.toxic.android.PlatfromAndroid;
import com.b1gs.app.core.Entry;


/**
 * <p>Example of executing android application.</p>
 * <br/>
 * @author Strelock
 *
 */
public class EntryAndroid extends PlatfromAndroid {

  @Override
  public void setApplication() {
    this.application = new Entry();
  }

}
