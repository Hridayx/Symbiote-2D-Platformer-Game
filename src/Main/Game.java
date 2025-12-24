package Main;

import java.awt.Graphics;
import Entities.Player;
import Levels.LevelManager;

public class Game implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    private Player player;
    private LevelManager levelManager;

    public final static int Tiles_Default_Size = 32;   // Default Size of the tile 
    public final static float Scale = 1.75f;            // Scale factor for components
    public final static int Tiles_in_Width = 26;
    public final static int Tiles_in_Height = 14;
    public final static int Tiles_Size = (int)(Tiles_Default_Size * Scale);  // Calculated tile size (48 in this case)
    public final static int Game_Width = Tiles_Size * Tiles_in_Width;
    public final static int Game_Height = Tiles_Size * Tiles_in_Height;

    public Game() {
        initClasses();

        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);

        gamePanel.requestFocus();  // Ensure the game panel gets focus for input

        startGameLoop();
    }

    private void initClasses() {
        levelManager = new LevelManager(this);
        player = new Player(80, 170); // Initialize player with x and y position only
        player.loadLvlData(LevelManager.getCurrentLevel().getLevelData());
    }

    void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        player.update();
        levelManager.update();
    }

    public void render(Graphics g) {
        levelManager.draw(g);
        player.render(g);
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET; // Time per frame in nanoseconds
        double timePerUpdate = 1000000000.0 / UPS_SET; // Time per update in nanoseconds

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }
    

    public Player getPlayer() {
        return player;
    }

    public void windowFocusLost() {
        // Removed resetting of direction booleans to avoid interrupting player movement
        // You can still implement other behavior like pausing the game here
        // player.resetDirBooleans();
    }
}
