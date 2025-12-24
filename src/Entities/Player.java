package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Main.Game;
import Utilz.LoadSave;
import static Utilz.Constant.PlayerConstants.*;
import static Utilz.HelpMethodClass.*;

public class Player extends Entity {
    private BufferedImage[][] animations;
    private int aniTick, aniIndex;
    private int aniSpeed = 25;

    private int playerAction = Idle;
    private boolean moving = false, attacking = false;
    private boolean left, up, right, down, jump;

    private static final int SCALED_WIDTH;
    private static final int SCALED_HEIGHT;
    private float playerSpeed = 1.5f;

    // Manually set offsets based on visual alignment
    private final float xDrawOffset = 40f;
    private final float yDrawOffset = 80f;

    // Jumping / Gravity:
    private float airSpeed = 0f;
    private float gravity = 0.035f * Game.Scale;
    private float jumpSpeed = -2.25f * Game.Scale;
    private float fallSpeedAfterCollision = 0.5f * Game.Scale;
    private boolean inAir = false;

    private int[][] lvlData;

    static {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.Player_Atlas);
        SCALED_WIDTH = img.getWidth() / 13;
        SCALED_HEIGHT = img.getHeight() / 8;
    }

    public Player(float x, float y) {
        super(x, y, SCALED_WIDTH, SCALED_HEIGHT);
        loadAnimations();
        initHitBox(x, y, SCALED_WIDTH * 0.4f, SCALED_HEIGHT * 0.4f);
        
        
    }

    public void update() {
        updatePos();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex],
                (int) (hitbox.x - xDrawOffset),
                (int) (hitbox.y - yDrawOffset),
                width, height, null);
        //drawHitBox(g);
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction)) {
                aniIndex = 0;
                attacking = false;
            }
        }
    }

    private void setAnimation() {
        int startAction = playerAction;
        int jumpAniSpeed = 15;    // Faster animation speed for jump

        if (attacking) {
            playerAction = Attack_1;
            aniSpeed = 25; // Default animation speed for other actions
        } else if (inAir) {
            if (airSpeed < 0) {
                playerAction = Jump;
                aniSpeed = jumpAniSpeed; // Set faster speed for jump
            }
        } else if (moving) {
            playerAction = Run;
            aniSpeed = 25;
        } else {
            playerAction = Idle;
            aniSpeed = 25;
        }

        if (startAction != playerAction) {
            resetAniTick();
        }
    }


    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    private void updatePos() {
        moving = false;

        if (jump) jump();
        if (!left && !right && !inAir) return;

        float xSpeed = 0;

        if (left) {
            xSpeed -= playerSpeed;
            moving = true;
        }
        if (right) {
            xSpeed += playerSpeed;
            moving = true;
        }
        
        if(!inAir)
        {
        	if(!IsEntityOnFloor(hitbox , lvlData))
        		inAir = true;
        }

        if (inAir) {
            if (CanMoveHere(hitbox.x, hitbox.y + airSpeed, hitbox.width, hitbox.height, lvlData)) {
                hitbox.y += airSpeed;
                airSpeed += gravity;
                updateXPos(xSpeed);
            } else {
                hitbox.y = GetEntityYPosUnderRoofOrAboveFloor(hitbox, airSpeed);
                if (airSpeed > 0) resetInAir();
                else airSpeed = fallSpeedAfterCollision;
                updateXPos(xSpeed);
            }
        } else {
            updateXPos(xSpeed);
        }
    }

    private void jump() {
        if (inAir) return;
        inAir = true;
        airSpeed = jumpSpeed;
    }

    private void resetInAir() {
        inAir = false;
        airSpeed = 0;
    }

    private void updateXPos(float xSpeed) {
        if (CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData)) {
            hitbox.x += xSpeed;
        } else {
            hitbox.x = GetEntityXposNextToWall(hitbox, xSpeed);
        }
    }

    private void loadAnimations() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.Player_Atlas);
        animations = new BufferedImage[8][13];
        for (int j = 0; j < animations.length; j++)
            for (int i = 0; i < animations[j].length; i++)
                animations[j][i] = img.getSubimage(i * SCALED_WIDTH, j * SCALED_HEIGHT, SCALED_WIDTH, SCALED_HEIGHT);
    }

    public void loadLvlData(int[][] lvlData) {
        this.lvlData = lvlData;
        
        if(!IsEntityOnFloor(hitbox , lvlData))
        	inAir = true;
    }

    public void resetDirBooleans() {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setAttack(boolean attacking) {
        this.attacking = attacking;
    }

    public void setLeft(boolean left) { this.left = left; }
    public void setUp(boolean up) { this.up = up; }
    public void setRight(boolean right) { this.right = right; }
    public void setDown(boolean down) { this.down = down; }
    public void setJump(boolean jump) { this.jump = jump; }
}