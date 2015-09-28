/**
 * 
 */
package com.b1gs.app.core.scene;

import playn.core.Font.Style;
import playn.core.TextFormat.Alignment;

import com.b1gs.app.core.constants.DisplayConstants;
import com.toxic.core.engine.DataProvider;
import com.toxic.core.engine.base.Background;
import com.toxic.core.engine.base.IElement;
import com.toxic.core.engine.base.IScene;
import com.toxic.core.engine.events.ActionEvent;
import com.toxic.core.engine.handlers.SelectHandler;
import com.toxic.core.engine.resources.ITextFormat;

/**
 * @author oleksandr.volkovskyi
 *
 */
public class MainScene {

	private static int CATEGORIES_NUM = 12;
	private static int COL_NUM = 3;
	private static int ROW_NUM = 4;
	private static int POS_X = 100;
	private static int POS_Y = 100;
	private static int ELEM_WIDTH = 150;
	private static int ELEM_HEIGHT = 100;
	private float balance = 0;
	
	private String[] categories = {"food","car","transport",
									"toilet","eating out","taxi",
									"entertainments","sick","sports",
									"communications","clothes","house" };
	private IScene scene;
	
	public MainScene(){
		scene = DataProvider.createScene();
	}
	
	public void init(){
		scene.setBackGround(new Background(0x0F00FF00));
		scene.setId("main");
		scene.setBackGround(new Background("images/background.jpg"));

		ITextFormat format = DataProvider.createTextFormat(
				DataProvider.createFont("italic48", Style.ITALIC, 48),
				Alignment.CENTER);
		
		for (int i = 0 ; i < ROW_NUM; i++){
			for (int j = 0 ; j < COL_NUM; j++){
				float posY = DisplayConstants.SCREEN_HEIGHT - j*(ELEM_WIDTH + DisplayConstants.offsetY) - DisplayConstants.offsetY;
				float posX = i*(ELEM_HEIGHT + DisplayConstants.offsetX) + DisplayConstants.offsetX;
				scene.addChild(createElement(posX, posY, categories[i*COL_NUM + j], i*COL_NUM + j ));
				System.out.println("PosX: " + posX + " PosY: " + posY);
			}
		}
		
		createBalanceItem();
		
		scene.activate();
	}
	
	private void createBalanceItem(){
		IElement balanceElem = DataProvider.createElement();
		balanceElem.setSize(200, 50);
		balanceElem.setPosition(500, (DisplayConstants.SCREEN_HEIGHT - balanceElem.width())/2);
		balanceElem.setTextFormat(getBalanceTextFormat());
		balanceElem.drawText("Balance: " + balance);
		scene.addChild(balanceElem);
	}
	
	private void createIncomeItem(){
		IElement incomeElem = DataProvider.createElement();
		incomeElem.setSize(200, 50);
		incomeElem.setPosition(500, DisplayConstants.SCREEN_HEIGHT - incomeElem.width()/2);
		incomeElem.setTextFormat(getBalanceTextFormat());
		incomeElem.drawText("Income");
		incomeElem.addSelectHandler(new SelectHandler() {
			
			@Override
			public void onSelect(ActionEvent e) {
				//KeyBo
				
			}
		});
		
		scene.addChild(incomeElem);
	}
	
	private IElement createElement(float posX, float posY, String title, int position ){
		IElement element = DataProvider.createElement();
		element.setWidth(ELEM_WIDTH);
		element.setHeight(ELEM_HEIGHT);
		element.setBackGround(new Background(0x870000FF));
		element.setRotation((float) -Math.PI/2);
		element.drawText(title);
		ITextFormat format = DataProvider.createTextFormat(DataProvider.createFont("italic48", Style.ITALIC, 15),
			      Alignment.CENTER);
		element.setTextFormat(format);
		element.setPosition(posX, posY);
		return element;
		
	}
	
	private ITextFormat getBalanceTextFormat(){
		return DataProvider.createTextFormat(DataProvider.createFont("italic48", Style.ITALIC, 15),
			      Alignment.CENTER);
	}
}
