import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class routeGUI {
    // Metro station data
    private static String[] allStations = { "Shaheed Sthal (New Bus Adda) ",
            "Hindon",
            "Arthala",
            "Mohan Nagar",
            "Shyam park",
            "Major Mohit Sharma",
            "Raj Bagh",
            "Shaheed Nagar",
            "Dilshad Garden",
            "Jhilmil",
            "Mansarovar Park",
            "Shahdara",
            "Welcome",
            "Seelampur",
            "Shastri Park",
            "Kashmere Gate",
            "Tis Hazari",
            "Pul Bangash",
            "Pratap Nagar",
            "Shastri Nagar",
            "Inderlok",
            "Kanhiya Nagar",
            "Keshav Puram",
            "Netaji Subhash Place",
            "Kohat Enclave",
            "Pitam Pura",
            "Rohini East",
            "Rohini West",
            "Kirti Nagar",
            "Satguru Ram Singh Marg",
            "Inderlok",
            "Ashok Park Main",
            "Punjabi Bagh",
            "Punjabi Bagh West",
            "Shivaji Park",
            "Madipur",
            "Paschim Vihar East",
            "Paschim Vihar West",
            "Peera Garhi",
            "Udyog Nagar",
            "Surajmal Stadium",
            "Nangloi",
            "Nangloi Railway Station",
            "Rajdhani Park",
            "Mundka",
            "Mundka Industrial Area (MIA)",
            "Ghevra",
            "Tikri Kalan",
            "Tikri Border",
            "Pandit Shree Ram Sharma",
            "(Mordern Industrial Estate)",
            "Bahadurgarh City",
            "Brigadier Hoshiyar Singh",
            "Kashmere Gate",
            "Lal Qila",
            "Jama Masjid",
            "Delhi Gate",
            "ITO",
            "Mandi House",
            "Janpath",
            "Central Secretariat",
            "Khan Market",
            "Jawaharlal Nehru Stadium",
            "Jangpura",
            "Lajpat Nagar",
            "Moolchand",
            "Kailash Colony",
            "Nehru Place",
            "Kalkaji Mandir",
            "Govind Puri",
            "Harkesh Nagar",
            "Jasola Apollo",
            "Sarita Vihar",
            "Mohan Estate",
            "Tughlakabad",
            "Badarpur",
            "Sarai",
            "NHPC Chowk",
            "Mewla Maharajpur",
            "Sector 28",
            "Badkhal Mor",
            "Faridabad Old",
            "Neelam Chowk Ajronda",
            "Bata Chowk",
            "Escorts Mujesar",
            "Sant Surdas — Sihi (NCB Colony)",
            "Noida Electronic City",
            "Noida Sector 62",
            "Noida Sector 59",
            "Noida Sector 61",
            "Noida Sector 52",
            "Noida Sector 34",
            "Noida City Centre",
            "Golf Course",
            "Botanical Garden",
            "Noida Sect 18",
            "Noida Sect 16",
            "Noida Sect 15",
            "New Ashok Nagar",
            "Mayur Vihar Ext",
            "Mayur Vihar-I",
            "Akshardham",
            "Yamuna Bank",
            "Indraprasta",
            "Supreme Court",
            "Mandi House",
            "Barakhamba",
            "Rajiv Chowk",
            "RK Ashram Marg",
            "Jhandewalan",
            "Karol Bagh",
            "Rajendra Place",
            "Patel Nagar",
            "Shadi Pur",
            "Kirti Nagar",
            "Moti Nagar",
            "Ramesh Nagar",
            "Rajouri Garden",
            "Tagore Garden",
            "Subash Nagar",
            "Tilak Nagar",
            "Janak Puri East",
            "Janak Puri West",
            "Uttam Nagar East",
            "Uttam Nagar West",
            "Nawada",
            "Dwaraka Mor",
            "Dwarka",
            "Dwarka Sector - 14",
            "Dwarka Sector - 13",
            "Dwarka Sector - 12",
            "Dwarka Sector - 11",
            "Dwarka Sector - 10",
            "Dwarka Sector - 9",
            "Dwarka Sector - 8",
            "Yamuna Bank",
            "Laxmi Nagar",
            "Nirman Vihar",
            "Preet Vihar",
            "Karkar Duma",
            "Anand Vihar",
            "Kaushambi",
            "Samaypur Badli",
            "Rohini Sector 18, 19",
            "Haiderpur Badli Mor",
            "Jahangirpuri",
            "Adarsh Nagar",
            "Azadpur",
            "Model Town",
            "GTB Nagar",
            "Viswavidyalaya",
            "Vidhan Sabha",
            "Civil Lines",
            "Kashmere Gate",
            "Chandhni Chowk",
            "Chawri Bazar",
            "NewDelhi",
            "Rajiv Chowk",
            "Patel Chowk",
            "Central Secretariat",
            "Udyog Bhawan",
            "Lok Kalyan Marg",
            "Jorbagh",
            "INA",
            "AIIMS",
            "Green Park",
            "Hauz Khas",
            "MalviaNagar",
            "Saket",
            "Qutab Minar",
            "Chhattarpur",
            "Sultanpur",
            "Ghotorni",
            "Arjan Garh",
            "Gurudronacharya",
            "Sikandarpur.",
            "MG Road",
            "IFFCO Chowk",
            "Mukundpur Depot",
            "Majlis Park",
            "Azadpur",
            "Shalimar Bagh",
            "Netaji Subhash Place",
            "Shakurpur",
            "Punjabi Bagh West",
            "ESI Hospital",
            "Rajouri Garden",
            "Maya Puri",
            "Nariana Vihar",
            "Delhi Cantt",
            "Durgabai Deshmukh South Campus",
            "Sir Vishweshwaraiah Moti Bagh",
            "Bhikaji Cama Place",
            "Sarojini Nagar",
            "INA",
            "South Extension",
            "Lajpat Nagar",
            "Vinobapuri",
            "Ashram",
            "Hazrat Nizamuddin",
            "Mayur Vihar - I",
            "Mayur Vihar Pocket 1",
            "Trilok Puri Sanjay Lake",
            "Vinod Nagar East",
            "Vinod Nagar",
            "IP Extension",
            "Anand Vihar",
            "Karkarduma",
            "Karkarduma Court",
            "Krishna Nagar",
            "East Azad Nagar",
            "Welcome",
            "Jaffrabad",
            "Maujpur",
            "Gokul Puri",
            "Johri Enclave",
            "Janakpuri West",
            "Dabri Mor",
            "Dashrath Puri",
            "Palam",
            "Sadaar Bazaar Cantonment",
            "Terminal 1 IGI Airport",
            "Shankar Vihar",
            "Vasant Vihar",
            "Munirka",
            "R.K Puram",
            "IIT Delhi",
            "Hauz Khas",
            "Panchsheel Park",
            "Chirag Delhi",
            "Greater Kailash",
            "Nehru Enclave",
            "Kalkaji Mandir",
            "Okhla NSIC",
            "Sukhdev Vihar",
            "Jamia Millia Islamia",
            "Okhla Vihar",
            "Jasola Vihar Shaheen Bagh",
            "Kalindi Kunj",
            "Okhla Bird Sanctuary",
            "New Delhi",
            "Shivaji Stadium",
            "Dhaula Kuan",
            "Delhi Aerocity",
            "IGI Airport",
            "Rithala",
            "(Bahadurgarh City Park)",
            "Raja Nahar Singh (Ballabhgarh)",
            "Dwarka Sector - 21",
            "Vaishali",
            "Huda City Centre",
            "Shiv Vihar",
            "Botanical Garden", };

    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame("Metro Station Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create JComboBox instances for source and destination
        JComboBox<String> sourceDropdown = new JComboBox<>(allStations);
        JComboBox<String> destinationDropdown = new JComboBox<>(allStations);

        // Create JTextFields for station search input
        JTextField sourceSearchField = new JTextField(50);
        JTextField destinationSearchField = new JTextField(50);

        // Create JLabel instances for source and destination labels
        JLabel sourceLabel = new JLabel("Source");
        JLabel destinationLabel = new JLabel("Destination");

        //Creating Button
        JButton button = new JButton("      search           ");

        JLabel routeLabel = new JLabel("Shortest Route");
        JTextField routeField = new JTextField(50);

        // Create ActionListeners for the search fields
        KeyAdapter searchFieldListener = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String sourceSearchText = sourceSearchField.getText().toLowerCase();
                String destinationSearchText = destinationSearchField.getText().toLowerCase();

                // Clear and update the source dropdown
                sourceDropdown.removeAllItems();
                for (String station : allStations) {
                    if (station.toLowerCase().contains(sourceSearchText)) {
                        sourceDropdown.addItem(station);
                    }
                }

                // Clear and update the destination dropdown
                destinationDropdown.removeAllItems();
                for (String station : allStations) {
                    if (station.toLowerCase().contains(destinationSearchText)) {
                        destinationDropdown.addItem(station);
                    }
                }

                // Print selected source and destination
                String sourceSelected = sourceDropdown.getSelectedItem().toString();
                String destinationSelected = destinationDropdown.getSelectedItem().toString();
                System.out.println("Selected Source: " + sourceSelected);
                System.out.println("Selected Destination: " + destinationSelected);
                System.out.println();
            }
        };
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to be executed when the button is clicked
                JOptionPane.showMessageDialog(frame, "Button Clicked!");
            }
        };

        // Add the ActionListener to the button
        button.addActionListener(actionListener);
        // Add the KeyListeners to the search fields
        sourceSearchField.addKeyListener(searchFieldListener);
        destinationSearchField.addKeyListener(searchFieldListener);

        // Create a JPanel to hold the components
        JPanel panel = new JPanel();
        panel.add(sourceLabel);
        panel.add(sourceSearchField);
        panel.add(sourceDropdown);
        panel.add(destinationLabel);
        panel.add(destinationSearchField);
        panel.add(destinationDropdown);
        panel.add(button);
        panel.add(routeLabel);
        panel.add(routeField);

        // Set the content pane of the frame
        frame.setContentPane(panel);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}
