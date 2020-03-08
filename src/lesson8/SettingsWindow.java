package lesson8;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {

    private final GameWindow gameWindow;

    private static final int SW_POS_X = 550;
    private static final int SW_POS_Y = 350;
    private static final int SW_HEIGHT = 450;
    private static final int SW_WIDTH = 400;

    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int MIN_DOTS_TO_WIN = 3;

    private static final String STR_FIELD_SIZE = "Field size: ";
    private static final String STR_DOTS_TO_WIN = "Win line: ";

    private JRadioButton jrbEasy;
    private JRadioButton jrbMedium;
    private JRadioButton jrbHard;
    private ButtonGroup gameDifficulty;

    private JSlider slFieldSize;
    private JSlider slDotsToWin;

    public SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setTitle("Settings");
        setBounds(SW_POS_X, SW_POS_Y, SW_WIDTH, SW_HEIGHT);
        setLayout(new GridLayout(11, 1));
        setResizable(false);

        jrbEasy = new JRadioButton("Easy", true);
        jrbMedium = new JRadioButton("Medium");
        jrbHard = new JRadioButton("Hard");
        gameDifficulty = new ButtonGroup();
        gameDifficulty.add(jrbEasy);
        gameDifficulty.add(jrbMedium);
        gameDifficulty.add(jrbHard);
        add(new JLabel("Game difficulty: "));
        add(jrbEasy);
        add(jrbMedium);
        add(jrbHard);

        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slDotsToWin = new JSlider(MIN_DOTS_TO_WIN, MIN_DOTS_TO_WIN, MIN_DOTS_TO_WIN);
        slFieldSize.setMajorTickSpacing(1);
        slFieldSize.setPaintTicks(true);
        slFieldSize.setPaintLabels(true);
        slDotsToWin.setMajorTickSpacing(1);
        slDotsToWin.setPaintTicks(true);
        slDotsToWin.setPaintLabels(true);

        add(new JLabel("Choose field size: "));
        JLabel jlFieldSize = new JLabel(STR_FIELD_SIZE + MIN_FIELD_SIZE);
        add(jlFieldSize);
        add(slFieldSize);

        add(new JLabel("Choose win line: "));
        JLabel jlDotsToWin = new JLabel(STR_DOTS_TO_WIN + MIN_DOTS_TO_WIN);
        add(jlDotsToWin);
        add(slDotsToWin);

        slFieldSize.addChangeListener(e -> {
            jlFieldSize.setText(STR_FIELD_SIZE + slFieldSize.getValue());
            slDotsToWin.setMaximum(slFieldSize.getValue());
        });
        slDotsToWin.addChangeListener(e -> jlDotsToWin.setText(STR_DOTS_TO_WIN + slDotsToWin.getValue()));

        JButton btnStartGame = new JButton("Start game");
        add(btnStartGame);
        btnStartGame.addActionListener(e -> {
            int jrbDifficulty;
            if (jrbEasy.isSelected()) {
                jrbDifficulty = Logic.EASY;
            } else if (jrbMedium.isSelected()) {
                jrbDifficulty = Logic.MEDIUM;
            } else {
                jrbDifficulty = Logic.HARD;
            }
            int fieldSize = slFieldSize.getValue();
            int dotsToWin = slDotsToWin.getValue();
            int difficultySettings = jrbDifficulty;

            Logic.DOTS_TO_WIN = dotsToWin;
            Logic.SIZE = fieldSize;
            Logic.DIFFICULTY = difficultySettings;
            Logic.initMap();
            Logic.gameFinish = false;

            gameWindow.startNewGame(jrbDifficulty, fieldSize, fieldSize, dotsToWin);
            setVisible(false);
        });

        setVisible(false);
    }

}
