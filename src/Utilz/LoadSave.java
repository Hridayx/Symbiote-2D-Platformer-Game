package Utilz;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Main.Game;

public class LoadSave   //Only static methods 
{
	public static final String Player_Atlas = "Slime_main_Sprite.png";
	
	public static final String Level_Atlas = "outside_sprites.png";
	
	public static final String Level_one_Data = "level_one_data.png";
	
	
	public static BufferedImage GetSpriteAtlas(String fileName)
	{
		BufferedImage img = null;
		
		InputStream is = LoadSave.class.getResourceAsStream("/"+ fileName);

        try 
        {
             img = ImageIO.read(is);

            // Initialize scaledWidth and scaledHeight after img is loaded
            
          
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                if (is != null)
                {
                    is.close();
                }
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
        return img;
	}
	
	public static int[][] GetLevelData()
	{
		int[][] lvlData = new int[Game.Tiles_in_Height][Game.Tiles_in_Width];
		
		BufferedImage img = GetSpriteAtlas(Level_one_Data);
		
		for(int j = 0;j<img.getHeight();j++)
			for(int i = 0; i < img.getWidth();i++)
			{
				Color color = new Color(img.getRGB(i, j));
				
				int value = color.getRed();
				
				if(value >= 48)
					value = 0;
				lvlData[j][i] = value;
					
				
			}
		return lvlData;
	}
}
