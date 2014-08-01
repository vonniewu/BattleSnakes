package com.hakrx.battlesnakes.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.hakrx.battlesnakes.BattleSnakesGame;
import com.hakrx.battlesnakes.ScreenProperties;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.height = ScreenProperties.VIRTUAL_HEIGHT;
        config.width = ScreenProperties.VIRTUAL_WIDTH;

		new LwjglApplication(new BattleSnakesGame(), config);
	}
}
