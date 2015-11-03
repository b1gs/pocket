package com.b1gs.app.core;

import playn.core.Font.Style;
import playn.core.PlayN;
import playn.core.TextFormat.Alignment;
import tripleplay.util.Interpolator;

import com.b1gs.app.core.scenemanager.SceneManager;
import com.toxic.core.engine.DataProvider;
import com.toxic.core.engine.animation.CustomAnimation;
import com.toxic.core.engine.base.Background;
import com.toxic.core.engine.base.IApplication;
import com.toxic.core.engine.base.IElement;
import com.toxic.core.engine.base.IScene;
import com.toxic.core.engine.events.ActionEvent;
import com.toxic.core.engine.handlers.CancelHandler;
import com.toxic.core.engine.handlers.HoldHandler;
import com.toxic.core.engine.handlers.MoveHandler;
import com.toxic.core.engine.handlers.SelectHandler;
import com.toxic.core.engine.resources.ITextFormat;

/**
 * <p>
 * The application logic example.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public class Entry implements IApplication {

  private static final float WIDTH = 50;
  private static final float HEIGHT = 50;

  /**
   * <p>
   * Default constructor.
   * </p>
   * <br/>
   */
  public Entry() {
    // NOOP
  }

  @Override
  public void init() {
	  SceneManager manager = new SceneManager();
	  manager.start();
     final IScene main = DataProvider.createScene();
    main.setBackGround(new Background(0x0F00FF00));
    main.setId("main");
    main.setBackGround(new Background("images/background.jpg"));
//    
//    
//    ITextFormat format = DataProvider.createTextFormat(DataProvider.createFont("italic48", Style.ITALIC, 48),
//      Alignment.CENTER);
//    
//    
//    main.activate();
  }

  @Override
  public void update(int delta) {
    // empty block
  }

}
