package Utilz;

import java.awt.geom.Rectangle2D;

import Main.Game;

public class HelpMethodClass 
{
    public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData)
    {
        return !(IsSolid(x, y, lvlData) || IsSolid(x + width, y, lvlData) || IsSolid(x, y + height, lvlData) || IsSolid(x + width, y + height, lvlData));
    }

    private static boolean IsSolid(float x, float y, int[][] lvlData) 
    {
    	int maxWidth = lvlData[0].length * Game.Tiles_Size;
        if (x < 0 || x >= maxWidth)
            return true;
        if (y < 0 || y >= Game.Game_Height)
            return true;

        int xIndex = (int) (x / Game.Tiles_Size);
        int yIndex = (int) (y / Game.Tiles_Size);

        int value = lvlData[yIndex][xIndex];
        return value >= 48 || value < 0 || value != 11;
    }
    
    public static float GetEntityXposNextToWall(Rectangle2D.Float hitbox, float xSpeed)
    {
    	int currentTile = (int) (hitbox.x / Game.Tiles_Size); //Will tell us on which tile the player is on
    	
    	
    	if(xSpeed > 0) //Will tell us we are colliding to the right
    	{
    		int tileXPos = currentTile * Game.Tiles_Size;
    		
    		int xOffset = (int)(Game.Tiles_Size - hitbox.width);
    		
    		return tileXPos + xOffset -1;
    	}
    	else //Will tell us we are colliding to the left
    	{
    		return currentTile * Game.Tiles_Size;
    	}
    }
    
    
    public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed) {
        int currentTile = (int) ((hitbox.y + hitbox.height) / Game.Tiles_Size); // Determine which tile the bottom of the hitbox is in

        if (airSpeed > 0) { // Falling
            int tileYPos = currentTile * Game.Tiles_Size;
            int yOffset = (int) (Game.Tiles_Size - hitbox.height);
            return tileYPos + yOffset - 1; // Align hitbox bottom with floor accurately
        } else { // Jumping up
            currentTile = (int) (hitbox.y / Game.Tiles_Size); // Tile directly above
            int tileYPos = currentTile * Game.Tiles_Size;
            return tileYPos; // Align hitbox top with ceiling if needed
        }
    }

    
    public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData) {
        float yFloorCheck = hitbox.y + hitbox.height + 1; // Checks just below the hitbox
        
        // Check bottom-left and bottom-right corners for floor
        if (IsSolid(hitbox.x, yFloorCheck, lvlData))
        {
            return true;
        }
        if (IsSolid(hitbox.x + hitbox.width, yFloorCheck, lvlData)) 
        {
            return true;
        }
        return false;
    }

    
    
    
    
    
    
}
