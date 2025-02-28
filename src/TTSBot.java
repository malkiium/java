import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sun.speech.freetts.*;

public class TTSBot {

    private static final String VOICE_NAME = "kevin16";  // FreeTTS voice

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Journal TTS Bot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setMinimumSize(new Dimension(200, 200));
        frame.getContentPane().setBackground(new Color(46, 42, 40));  // Dark theme
        frame.setLayout(new BorderLayout());

        // Title label
        JLabel titleLabel = new JLabel("My TTS", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 20));
        titleLabel.setForeground(new Color(224, 214, 201));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Instruction label
        JLabel instructionLabel = new JLabel("Type your entry below:", SwingConstants.CENTER);
        instructionLabel.setFont(new Font("Georgia", Font.PLAIN, 14));
        instructionLabel.setForeground(new Color(197, 185, 174));
        frame.add(instructionLabel, BorderLayout.CENTER);

        // Text area (dark theme)
        JTextArea textBox = new JTextArea();
        textBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        textBox.setBackground(new Color(59, 54, 51));
        textBox.setForeground(new Color(224, 214, 201));
        textBox.setCaretColor(new Color(224, 214, 201));
        textBox.setWrapStyleWord(true);
        textBox.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textBox);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Button to speak
        JButton speakButton = new JButton("Speak");
        speakButton.setFont(new Font("Georgia", Font.PLAIN, 14));
        speakButton.setBackground(new Color(113, 91, 81));
        speakButton.setForeground(new Color(224, 214, 201));
        speakButton.setFocusPainted(false);
        speakButton.setBorderPainted(true);
        speakButton.setBorder(BorderFactory.createRaisedBevelBorder());
        speakButton.setPreferredSize(new Dimension(100, 40));
        frame.add(speakButton, BorderLayout.SOUTH);

        // Set up the Text-to-Speech engine
        final VoiceManager voiceManager = VoiceManager.getInstance();
        final Voice voice = voiceManager.getVoice(VOICE_NAME);

        if (voice != null) {
            voice.allocate();
        }

        // Action when the "Speak" button is pressed
        speakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textBox.getText().trim();
                if (!text.isEmpty()) {
                    if (voice != null) {
                        voice.speak(text);
                    }
                }
            }
        });

        // Display the frame
        frame.setVisible(true);
    }
}
