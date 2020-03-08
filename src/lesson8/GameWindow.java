package lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private static final int GW_POS_X = 500;
    private static final int GW_POS_Y = 300;
    private static final int GW_HEIGHT = 550;
    private static final int GW_WIDTH = 550;

    SettingsWindow settingsWindow;
    GameField gameField;

    public GameWindow() {
        setTitle("Tic Tac Toe");
        setBounds(GW_POS_X, GW_POS_Y, GW_WIDTH, GW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel gwPanel = new JPanel(new GridLayout(1, 2));
        JButton btnNewGame = new JButton("New Game");
        JButton btnExit = new JButton("Exit");
        gwPanel.add(btnNewGame);
        gwPanel.add(btnExit);
        add(gwPanel, BorderLayout.SOUTH);

        settingsWindow = new SettingsWindow(this);

        gameField = new GameField();
        add(gameField, BorderLayout.CENTER);

        btnExit.addActionListener(event -> System.exit(0));
        btnNewGame.addActionListener(event -> settingsWindow.setVisible(true));

        setVisible(true);
    }

    public void startNewGame(int jrbDifficulty, int fieldSizeX, int fieldSizeY, int dotsToWin) {
        gameField.startNewGame(jrbDifficulty, fieldSizeX, fieldSizeY, dotsToWin);
    }

}
