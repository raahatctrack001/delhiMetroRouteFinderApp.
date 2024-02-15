import javax.swing.*;
import java.awt.event.*;

public class MetroStationSearch {
    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame("Metro Station Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Metro station data
        private String[] allStations = {
            "Shaheed Sthal (New Bus Adda)",
            "Hindon",
            "Arthala",
            "Mohan Nagar",
            // ... (other station names)
        };

        // Create JComboBox instances for source and destination
        JComboBox<String> sourceDropdown = new JComboBox<>(allStations);
        JComboBox<String> destinationDropdown = new JComboBox<>(allStations);

        // Create JTextFields for station search input
        JTextField sourceSearchField = new JTextField(20);
        JTextField destinationSearchField = new JTextField(20);

        // Create JLabel instances for source and destination labels
        JLabel sourceLabel = new JLabel("Source");
        JLabel destinationLabel = new JLabel("Destination");

        // Create ActionListeners for the search fields
        KeyAdapter searchFieldListener = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                updateDropdown(sourceSearchField.getText().toLowerCase(), sourceDropdown);
                updateDropdown(destinationSearchField.getText().toLowerCase(), destinationDropdown);
            }
        };

        // Add the KeyListeners to the search fields
        sourceSearchField.addKeyListener(searchFieldListener);
        destinationSearchField.addKeyListener(searchFieldListener);

        // Create ItemListeners for the dropdowns
        ItemListener dropdownListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
                    JTextField textField = null;

                    if (comboBox == sourceDropdown) {
                        textField = sourceSearchField;
                    } else if (comboBox == destinationDropdown) {
                        textField = destinationSearchField;
                    }

                    if (textField != null) {
                        textField.setText((String) comboBox.getSelectedItem());
                    }
                }
            }
        };

        // Add the ItemListeners to the dropdowns
        sourceDropdown.addItemListener(dropdownListener);
        destinationDropdown.addItemListener(dropdownListener);

        // Create a JPanel to hold the components
        JPanel panel = new JPanel();
        panel.add(sourceLabel);
        panel.add(sourceSearchField);
        panel.add(sourceDropdown);
        panel.add(destinationLabel);
        panel.add(destinationSearchField);
        panel.add(destinationDropdown);

        // Set the content pane of the frame
        frame.setContentPane(panel);

        // Set the frame to be visible
        frame.setVisible(true);
    }

    private static void updateDropdown(String searchText, JComboBox<String> comboBox) {
        // Clear the dropdown
        comboBox.removeAllItems();

        // Filter and add stations based on the search text
        for (String station : allStations) {
            if (station.toLowerCase().contains(searchText)) {
                comboBox.addItem(station);
            }
        }
    }
}
