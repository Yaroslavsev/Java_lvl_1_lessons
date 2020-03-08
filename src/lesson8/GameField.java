package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameField extends JPanel {

    int fieldSizeX;
    int fieldSizeY;
    int dotsToWin;

    int cellHeight;
    int cellWidth;

    boolean isInitGameField = false;

    public GameField() {
        setBackground(new Color(106, 148, 212));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    void render(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));

        if (!isInitGameField) {
            return;
        }
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.setColor(new Color(0x437DD4));
            g.drawLine(0, y, panelWidth, y);
        }
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }
    }

    public void startNewGame(int jrbDifficulty, int fieldSizeX, int fieldSizeY, int dotsToWin) {

        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.dotsToWin = dotsToWin;

        isInitGameField = true;
        repaint();
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!Logic.gameFinish) {
            Logic.setHumanXY(cellX, cellY);
        }

        repaint();
    }

    private void drawX(Graphics g, int cellX, int cellY) {
        g.setColor(new Color(255, 255, 255));
        g.drawLine(cellX * cellWidth, cellY * cellHeight,
                (cellX + 1) * cellWidth, (cellY + 1) * cellHeight);
        g.drawLine((cellX + 1) * cellWidth, cellY * cellHeight,
                cellX * cellWidth, (cellY + 1) * cellHeight);

    }

    private void drawO(Graphics g, int cellX, int cellY) {
        g.setColor(new Color(255, 161, 0));
        g.drawOval(cellX * cellWidth, cellY * cellHeight,
                cellWidth, cellHeight);
    }

}
