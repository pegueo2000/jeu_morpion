import entities.Joueur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Play extends JFrame {
    JPanel titlePanel, buttonPanel, rejouerPanel;
    JLabel titleLabel;
    JButton[] buttons = new JButton[9];

    JButton rejouerButton;
    Joueur joueur1 = new Joueur("X", false);
    Joueur joueur2 = new Joueur("Y", false);
    Random random = new Random();

    public Play() throws HeadlessException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(50, 50, 50));
        this.setLocationRelativeTo(null);
        // le panel du titre
        titlePanel = new JPanel();
        titlePanel.setBackground(new Color(50, 50, 50));
        titlePanel.setPreferredSize(new Dimension(100, 100));
        //le label du titre
        titleLabel = new JLabel();
        titleLabel.setBackground(new Color(50, 50, 50));
        titleLabel.setForeground(new Color(25, 255, 0));
        titleLabel.setFont(new Font("Ink Free", Font.BOLD, 60));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setText("jeu de morpion");
        titleLabel.setOpaque(true);

        titlePanel.add(titleLabel);


        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));
        buttonPanel.setPreferredSize(new Dimension(100, 100));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 60));
            buttons[i].setBackground(Color.lightGray);
            buttons[i].setFocusable(false);
            //buttons[i].addActionListener(this);
            buttons[i].addActionListener(new MorpionActionListener(this));

        }

        rejouerPanel = new JPanel();
        rejouerPanel.setBackground(Color.gray);
        rejouerPanel.setPreferredSize(new Dimension(100, 70));
        rejouerButton = new JButton();
        rejouerButton.setText("rejouer");
        rejouerButton.setFont(new Font("Arial", Font.BOLD, 30));
        rejouerButton.setHorizontalAlignment(SwingConstants.CENTER);
        rejouerButton.setVerticalAlignment(SwingConstants.CENTER);
        rejouerButton.addActionListener(new MorpionActionListener(this));
        rejouerPanel.add(rejouerButton);
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(buttonPanel);
        this.add(rejouerPanel, BorderLayout.SOUTH);
        aQuiLePremierTour();

    }

    public JPanel getTitlePanel() {
        return titlePanel;
    }

    public void setTitlePanel(JPanel titlePanel) {
        this.titlePanel = titlePanel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public JPanel getRejouerPanel() {
        return rejouerPanel;
    }

    public void setRejouerPanel(JPanel rejouerPanel) {
        this.rejouerPanel = rejouerPanel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JButton[] getButtons() {
        return buttons;
    }

    public void setButtons(JButton[] buttons) {
        this.buttons = buttons;
    }

    public JButton getRejouerButton() {
        return rejouerButton;
    }

    public void setRejouerButton(JButton rejouerButton) {
        this.rejouerButton = rejouerButton;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public void aQuiLePremierTour() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (random.nextInt(2) == 0) {
            joueur1.setTour(true);
            joueur2.setTour(false);
            titleLabel.setText("Tour du joueur " + joueur1.getSymbole());
        } else {
            joueur1.setTour(false);
            joueur2.setTour(true);
            titleLabel.setText("Tour du joueur " + joueur2.getSymbole());
        }
    }

    public void test() {
        // les conditions pour que le joueur 1 gagne
        if ((buttons[0].getText() == joueur1.getSymbole()) && (buttons[1].getText() == joueur1.getSymbole()) && (buttons[2].getText() == joueur1.getSymbole())) {
            joueurGagnant(0, 1, 2, joueur1);
        }
        if ((buttons[3].getText() == joueur1.getSymbole()) && (buttons[4].getText() == joueur1.getSymbole()) && (buttons[5].getText() == joueur1.getSymbole())) {
            joueurGagnant(3, 4, 5, joueur1);
        }
        if ((buttons[6].getText() == joueur1.getSymbole()) && (buttons[7].getText() == joueur1.getSymbole()) && (buttons[8].getText() == joueur1.getSymbole())) {
            joueurGagnant(6, 7, 7, joueur1);
        }
        if ((buttons[0].getText() == joueur1.getSymbole()) && (buttons[3].getText() == joueur1.getSymbole()) && (buttons[6].getText() == joueur1.getSymbole())) {
            joueurGagnant(0, 3, 6, joueur1);
        }
        if ((buttons[1].getText() == joueur1.getSymbole()) && (buttons[4].getText() == joueur1.getSymbole()) && (buttons[7].getText() == joueur1.getSymbole())) {
            joueurGagnant(1, 4, 7, joueur1);
        }
        if ((buttons[2].getText() == joueur1.getSymbole()) && (buttons[5].getText() == joueur1.getSymbole()) && (buttons[8].getText() == joueur1.getSymbole())) {
            joueurGagnant(2, 5, 8, joueur1);
        }
        if ((buttons[0].getText() == joueur1.getSymbole()) && (buttons[4].getText() == joueur1.getSymbole()) && (buttons[8].getText() == joueur1.getSymbole())) {
            joueurGagnant(0, 4, 8, joueur1);
        }
        if ((buttons[2].getText() == joueur1.getSymbole()) && (buttons[4].getText() == joueur1.getSymbole()) && (buttons[6].getText() == joueur1.getSymbole())) {
            joueurGagnant(2, 4, 6, joueur1);
        }
        // les conditions pour que le joueur 2 gagne
        if ((buttons[0].getText() == joueur2.getSymbole()) && (buttons[1].getText() == joueur2.getSymbole()) && (buttons[2].getText() == joueur2.getSymbole())) {
            joueurGagnant(0, 1, 2, joueur2);
        }
        if ((buttons[3].getText() == joueur2.getSymbole()) && (buttons[4].getText() == joueur2.getSymbole()) && (buttons[5].getText() == joueur2.getSymbole())) {
            joueurGagnant(3, 4, 5, joueur2);
        }
        if ((buttons[6].getText() == joueur2.getSymbole()) && (buttons[7].getText() == joueur2.getSymbole()) && (buttons[8].getText() == joueur2.getSymbole())) {
            joueurGagnant(6, 7, 7, joueur2);
        }
        if ((buttons[0].getText() == joueur2.getSymbole()) && (buttons[3].getText() == joueur2.getSymbole()) && (buttons[6].getText() == joueur2.getSymbole())) {
            joueurGagnant(0, 3, 6, joueur2);
        }
        if ((buttons[1].getText() == joueur2.getSymbole()) && (buttons[4].getText() == joueur2.getSymbole()) && (buttons[7].getText() == joueur2.getSymbole())) {
            joueurGagnant(1, 4, 7, joueur2);
        }
        if ((buttons[2].getText() == joueur2.getSymbole()) && (buttons[5].getText() == joueur2.getSymbole()) && (buttons[8].getText() == joueur2.getSymbole())) {
            joueurGagnant(2, 5, 8, joueur2);
        }
        if ((buttons[0].getText() == joueur2.getSymbole()) && (buttons[4].getText() == joueur2.getSymbole()) && (buttons[8].getText() == joueur2.getSymbole())) {
            joueurGagnant(0, 4, 8, joueur2);
        }
        if ((buttons[2].getText() == joueur2.getSymbole()) && (buttons[4].getText() == joueur2.getSymbole()) && (buttons[6].getText() == joueur2.getSymbole())) {
            joueurGagnant(2, 4, 6, joueur2);
        }
    }

    public void joueurGagnant(int a, int b, int c, Joueur joueur) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        if (joueur.getSymbole() == joueur1.getSymbole())
            titleLabel.setText("Vainqueur: " + joueur1.getSymbole());
        else
            titleLabel.setText("Vainqueur: " + joueur2.getSymbole());
    }

    // Inner class
    class MorpionActionListener implements ActionListener {
        Frame frame;
        public MorpionActionListener(Frame frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            for (int i = 0; i < 9; i++) {
                if (actionEvent.getSource() == buttons[i]) {
                    if (joueur1.getTour()) {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(255, 0, 0));
                            buttons[i].setText(joueur1.getSymbole());
                            joueur1.setTour(false);
                            titleLabel.setText("Tour du joueur " + joueur2.getSymbole());
                            joueur2.setTour(true);
                            test();
                        }
                    }
                    if (joueur2.getTour()){
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(new Color(0, 0, 255));
                            buttons[i].setText(joueur2.getSymbole());
                            joueur2.setTour(false);

                            titleLabel.setText("Tour du joueur " + joueur1.getSymbole());
                            joueur1.setTour(true);
                            test();
                        }
                    }
                }
            }
            if (actionEvent.getSource() == rejouerButton)
            {
                for (int i = 0; i < 9; i++) {
                    buttons[i].setText("");
                    buttons[i].setBackground(Color.lightGray);
                    buttons[i].setEnabled(true);
                    aQuiLePremierTour();
                }
               // frame.dispose();
               // new Play().setVisible(true);
            }
        }

    }
}