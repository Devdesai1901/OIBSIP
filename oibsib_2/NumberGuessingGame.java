import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGame {

    private int randomNumber;
    private int currentScore;
    private int attemptsLeft;
    private int highScore;

    private JLabel scoreLabel;
    private JLabel attemptsLabel;
    private JTextField guessField;

    public NumberGuessingGame() {
        // Create the main frame
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the start button
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame(frame);
            }
        });

        // Add start button to the main frame
        frame.add(startButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void startNewGame(JFrame frame) {
        currentScore = 100;
        attemptsLeft = 5;
        highScore = Math.max(highScore, currentScore);
        randomNumber = new Random().nextInt(100) + 1;

        // Create a new game window
        JFrame gameFrame = new JFrame("Number Guessing Game");
        gameFrame.setSize(400, 200);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLayout(new BorderLayout());

        // Create and add labels for score and attempts
        scoreLabel = new JLabel("Score: " + currentScore);
        attemptsLabel = new JLabel("Attempts Left: " + attemptsLeft);
        JPanel labelPanel = new JPanel();
        labelPanel.add(scoreLabel);
        labelPanel.add(attemptsLabel);
        gameFrame.add(labelPanel, BorderLayout.NORTH);

        // Create and add the guess text field
        guessField = new JTextField(10);
        guessField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        guessField.setHorizontalAlignment(SwingConstants.CENTER);
        gameFrame.add(guessField, BorderLayout.CENTER);

        // Create and add the submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess(gameFrame);
            }
        });
        gameFrame.add(submitButton, BorderLayout.SOUTH);

        gameFrame.setVisible(true);
    }

    private void handleGuess(JFrame frame) {
        if (attemptsLeft > 0) {
            try {
                int userGuess = Integer.parseInt(guessField.getText());

                if (userGuess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Your number guess is too low!!!");
                } else if (userGuess > randomNumber) {
                    JOptionPane.showMessageDialog(null, "Your number guess is too high!!!");
                } else {
                    currentScore += 20 * attemptsLeft;
                    JOptionPane.showMessageDialog(null, "Hurray! You win.\nYour Score: " + currentScore);
                    frame.dispose();
                    startNewGame(frame);
                }

                attemptsLeft--;
                scoreLabel.setText("Score: " + currentScore);
                attemptsLabel.setText("Attempts Left: " + attemptsLeft);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "It only allows numbers.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You lose. The correct number was " + randomNumber);
            frame.dispose();
            startNewGame(frame);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGuessingGame();
            }
        });
    }
}
