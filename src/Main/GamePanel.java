package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

public class GamePanel extends JPanel {
    private BufferedImage backgroundImage;
    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        loadBackgroundImage();
        setPanelSize();
        
        // Add input listeners for keyboard and mouse
        this.addKeyListener(new KeyboardInputs(this));
        this.addMouseListener(new MouseInputs(this));
        this.addMouseMotionListener(new MouseInputs(this));
        
        // Make sure the panel can receive focus
        this.setFocusable(true);
    }

    private void setPanelSize() {
        // Use the game's dimensions
        Dimension size = new Dimension(Game.Game_Width, Game.Game_Height);
        setPreferredSize(size);
    }

    private void loadBackgroundImage() {
        try {
            // Load the background image from the resources
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("/background.JPG"));
            System.out.println("Background image loaded successfully.");
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error loading background image:");
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        }

        // Additional rendering for the game can go here
        game.render(g); // Assuming your game has a render method
    }

    public Game getGame() {
        return game;
    }
}
