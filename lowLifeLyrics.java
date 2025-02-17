import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class lowLifeLyrics {
    private JLabel lyricsLabel;

    public lowLifeLyrics() {
        JFrame frame = new JFrame("Low Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout());

        // Create a panel to hold the label and center it
        JPanel panel = new JPanel(new GridBagLayout());
        lyricsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        lyricsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(lyricsLabel);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);

        // Start the song animation in a separate thread
        new Thread(this::singSong).start();
    }

    public void animateText(String text, long delay) {
        StringBuilder currentText = new StringBuilder();

        for (char c : text.toCharArray()) {
            currentText.append(c);
            SwingUtilities.invokeLater(() -> lyricsLabel.setText(currentText.toString()));

            try {
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void singSong() {
        String[][] lyrics = {
                { "Yeah, they stereotypin' 'cause they know a nigga keep 20 rifles", "100" },
                { "And they know a nigga keep 20 snipers", "65" },
                { "And they know a nigga keep ten wifeys (ha-ha-ha)", "70" },
                { "Sniper, sniper, sniper, sniper, sniper", "70" },
                { "Wifey, wifey, wifey, wifey, wifey", "100" },
                { "That's your wifey, wifey, wifey, wifey?", "70" },
                { "I think I like her, like her, like her, like her", "80" },
        };

        long speed = 100; // Typing speed (milliseconds per character)

        for (String[] lyric : lyrics) {
            animateText(lyric[0], Long.parseLong(lyric[1]));
            try {
                TimeUnit.MILLISECONDS.sleep(500); // Pause between lines
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new lowLifeLyrics();
    }
}
