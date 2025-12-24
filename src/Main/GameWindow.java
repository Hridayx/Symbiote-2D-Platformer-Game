package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow {
    private JFrame jframe;
    private GamePanel gamePanel;
    private JButton startButton, exitButton;

    public GameWindow(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        // Initialize JFrame
        jframe = new JFrame("Symbiote-Game");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setLayout(null); // Use null layout for precise placement of buttons

        // Add GamePanel as the background
        jframe.setContentPane(gamePanel);
        gamePanel.setLayout(null); // Allow custom placement of components

        // Add buttons
        addButtons();

        jframe.pack();
        jframe.setSize(Game.Game_Width, Game.Game_Height);
        jframe.setLocationRelativeTo(null); // Center the window on the screen
        jframe.setVisible(true);
    }

    private void addButtons() {
        // Exit Button
        exitButton = new JButton("Exit");
        styleButton(exitButton, Color.RED);
        exitButton.setBounds(Game.Game_Width - 100, 10, 80, 30); // Top-right corner
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });

        // Start Button (centered in the middle of the game screen)
        startButton = new JButton("Start Game");
        styleButton(startButton, Color.GREEN);
        startButton.setBounds(
            (Game.Game_Width - 150) / 2, // Center horizontally
            (Game.Game_Height - 40) / 2, // Center vertically
            150,                         // Button width
            40                           // Button height
        );
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        // Add buttons to the game panel
        gamePanel.add(exitButton);
        gamePanel.add(startButton);
    }

    private void styleButton(JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusable(false); // Prevent focus conflicts
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }

    private void startGame() {
        startButton.setVisible(false); // Hide the start button
        gamePanel.remove(startButton); // Remove the button from the panel
        gamePanel.repaint(); // Refresh the panel to reflect the change
        gamePanel.getGame().startGameLoop(); // Start the game thread
        gamePanel.requestFocusInWindow(); // Set focus back to the game panel
    }
}
