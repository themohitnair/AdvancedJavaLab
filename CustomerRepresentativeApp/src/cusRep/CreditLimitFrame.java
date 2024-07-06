package cusRep;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CreditLimitFrame extends JFrame {

    CreditLimitFrame(List<String> repsAboveCredit) {
        this.setTitle("Representatives with Customers Above Credit Limit");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Representatives with Customers Above Credit Limit:");
        panel.add(titleLabel);

        for (String repName : repsAboveCredit) {
            JLabel repLabel = new JLabel(repName);
            panel.add(repLabel);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        this.add(scrollPane, BorderLayout.CENTER);

        this.setVisible(true);
    }
}

