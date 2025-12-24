package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameMenu extends JPanel {
    private StartButton startButton;
    private ExitButton exitButton;

    public GameMenu(Game game) {
        startButton = new StartButton("Start");
        exitButton = new ExitButton("Exit");

        // Set button locations
        startButton.setBounds(Game.Game_Width / 2 - 100, Game.Game_Height / 2 - 50, 200, 70); // Center the Start button
        exitButton.setBounds(Game.Game_Width / 2 - 100, Game.Game_Height / 2 + 50, 200, 70);  // Position Exit below Start

        // Add action listeners to buttons
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startGameLoop();  // Start the game when the Start button is clicked
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  // Exit the game when the Exit button is clicked
            }
        });

        setLayout(null);
        add(startButton);
        add(exitButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Optional: Custom drawing can go here, like background or title
    }
}

class StartButton extends JButton {
    public StartButton(String text) {
        super(text);
        setBackground(Color.BLUE);  // Red background color for Start button
        setForeground(Color.BLACK);  // White text color
        setPreferredSize(new Dimension(200, 70));  // Set button size (w: 200, h: 70)
        setFocusable(false);
    }
}

class ExitButton extends JButton {
    public ExitButton(String text) {
        super(text);
        setBackground(Color.RED);  // Red background color for Exit button
        setForeground(Color.WHITE);  // White text color
        setPreferredSize(new Dimension(200, 70));  // Set button size (w: 200, h: 70)
        setFocusable(false);
    }
}

