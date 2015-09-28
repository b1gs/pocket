/**
 * 
 */
package com.b1gs.app.core.input;

import playn.core.Font.Style;
import playn.core.TextFormat.Alignment;

import com.b1gs.app.core.constants.DisplayConstants;
import com.toxic.core.engine.DataProvider;
import com.toxic.core.engine.base.IElement;
import com.toxic.core.engine.base.IScene;
import com.toxic.core.engine.events.ActionEvent;
import com.toxic.core.engine.handlers.SelectHandler;
import com.toxic.core.engine.resources.ITextFormat;

/**
 * @author oleksandr.volkovskyi
 *
 */
public class DigitalInput {

	private IScene scene;
	private static int BUTTON_WIDTH = 100;
	private static int BUTTON_HEIGHT = 100;
	private String input;
	private IElement inputElement;

	private String[] buttons = { "1", "2", "3", "<-", "4", "5", "6", ".", "7",
			"8", "9", "+", "-", "0", "-", "Done" };

	public DigitalInput(IScene scene) {
		this.scene = scene;
	}

	public void init() {
		createInput();
		createButtons();
	}

	private void createInput() {

		inputElement = DataProvider.createElement();
		inputElement.setSize(300, 50);
		inputElement.setPosition(300,
				(DisplayConstants.SCREEN_HEIGHT - inputElement.width()) / 2);
		inputElement.setTextFormat(getTextFormat());
		inputElement.drawText("");
		inputElement.setRotation((float) Math.PI / 2);
		scene.addChild(inputElement);

	}
	
	private void createButtons() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; i < 4; j++) {
				float posX = DisplayConstants.SCREEN_WIDTH - BUTTON_HEIGHT - DisplayConstants.offsetX - (4 - i)*(BUTTON_HEIGHT + DisplayConstants.offsetX);
				float posY = DisplayConstants.SCREEN_HEIGHT - DisplayConstants.offsetY - j*(BUTTON_HEIGHT + DisplayConstants.offsetY);
				createElement(posX, posY, i * 4 + j);
			}
		}
	}

	private IElement createElement(float posX, float posY, int num) {
		IElement elem = DataProvider.createElement();
		elem.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		elem.setPosition(posX, posY);
		elem.setRotation((float) Math.PI);
		elem.setTextFormat(getTextFormat());
		elem.drawText("" + num);
		elem.addSelectHandler(getSelectHandler(buttons[num]));
		return elem;
	}

	private ITextFormat getTextFormat() {
		return DataProvider.createTextFormat(
				DataProvider.createFont("italic48", Style.ITALIC, 15),
				Alignment.CENTER);
	}
	
	private SelectHandler getSelectHandler(final String id){
		SelectHandler handler = new SelectHandler() {
			String elemId = id;
			@Override
			public void onSelect(ActionEvent e) {
				String input = DigitalInput.this.input;
				if ( "<-".equals(elemId) && DigitalInput.this.input.length() > 0){
					input = input.substring(0, input.length());
					DigitalInput.this.input = input;
				}else if("+".equals(elemId)){
					
				}else if ("-".equals(elemId)){
					
				}else if ("Done".equals(elemId)){
					
				}else{
					input = input + id;
				}
				DigitalInput.this.inputElement.drawText(input);
			}
		};
		return handler;
	}
}
