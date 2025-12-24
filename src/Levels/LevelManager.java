package Levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;
import Utilz.LoadSave;

public class LevelManager 
{

	private Game game;
	private BufferedImage[] levelSprite;
	private static Level levelOne;

	public LevelManager(Game game) 
	{
		this.game = game;
		importOutsideSprites();
		levelOne = new Level(LoadSave.GetLevelData());
	}

	private void importOutsideSprites() 
	{
		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.Level_Atlas);
		levelSprite = new BufferedImage[48];
		for (int j = 0; j < 4; j++)
			for (int i = 0; i < 12; i++)
			{
				int index = j * 12 + i;
				levelSprite[index] = img.getSubimage(i * 32, j * 32, 32, 32);
			}
	}

	public void draw(Graphics g)
	{
		for (int j = 0; j < Game.Tiles_in_Height; j++)
			for (int i = 0; i < Game.Tiles_in_Width; i++)
			{
				int index = levelOne.getSpriteIndex(i, j);
				g.drawImage(levelSprite[index], Game.Tiles_Size * i, Game.Tiles_Size * j, Game.Tiles_Size, Game.Tiles_Size, null);
			}
	}

	public void update() 
	{

	}
	
	public static Level getCurrentLevel()
	{
		return levelOne;
	}

	
}

