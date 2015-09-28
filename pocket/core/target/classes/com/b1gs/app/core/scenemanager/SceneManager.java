/**
 * 
 */
package com.b1gs.app.core.scenemanager;

import com.b1gs.app.core.scene.MainScene;
import com.toxic.core.engine.DataProvider;
import com.toxic.core.engine.base.IScene;

/**
 * @author oleksandr.volkovskyi
 *
 */
public class SceneManager {
	
	private MainScene mainScene;
	
	public SceneManager(){
		mainScene = new MainScene();
	}
	
	public void start(){
		mainScene.init();
	}
}
