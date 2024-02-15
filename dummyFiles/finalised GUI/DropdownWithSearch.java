import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class DropdownWithSearch {
    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame("Dropdown with Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create an array of items for the dropdown
        String[] allItems = {"	Shaheed Sthal (New Bus Adda) 	"	,
        "	Hindon	"	,
        "	Arthala	"	,
        "	Mohan Nagar	"	,
        "	Shyam park	"	,
        "	Major Mohit Sharma	"	,
        "	Raj Bagh	"	,
        "	Shaheed Nagar	"	,
        "	Dilshad Garden	"	,
        "	Jhilmil	"	,
        "	Mansarovar Park	"	,
        "	Shahdara	"	,
        "	Welcome	"	,
        "	Seelampur	"	,
        "	Shastri Park	"	,
        "	Kashmere Gate	"	,
        "	Tis Hazari	"	,
        "	Pul Bangash	"	,
        "	Pratap Nagar	"	,
        "	Shastri Nagar	"	,
        "	Inderlok	"	,
        "	Kanhiya Nagar	"	,
        "	Keshav Puram	"	,
        "	Netaji Subhash Place	"	,
        "	Kohat Enclave	"	,
        "	Pitam Pura	"	,
        "	Rohini East	"	,
        "	Rohini West	"	,
        "	Rithala	"	,			
        "	Kirti Nagar	"	,
        "	Satguru Ram Singh Marg	"	,
        "	Inderlok	"	,
        "	Ashok Park Main	"	,
        "	Punjabi Bagh	"	,
        "	Punjabi Bagh West	"	,
        "	Shivaji Park	"	,
        "	Madipur	"	,
        "	Paschim Vihar East	"	,
        "	Paschim Vihar West	"	,
        "	Peera Garhi	"	,
        "	Udyog Nagar	"	,
        "	Surajmal Stadium	"	,
        "	Nangloi	"	,
        "	Nangloi Railway Station	"	,
        "	Rajdhani Park	"	,
        "	Mundka	"	,
        "	Mundka Industrial Area (MIA)	"	,
        "	Ghevra	"	,
        "	Tikri Kalan	"	,
        "	Tikri Border	"	,
        "	Pandit Shree Ram Sharma	"	,
        "	(Mordern Industrial Estate)	"	,
        "	Bahadurgarh City	"	,
        "	Brigadier Hoshiyar Singh	"	,
        "	(Bahadurgarh City Park)	"	,
       			
        "	Kashmere Gate	"	,
        "	Lal Qila	"	,
        "	Jama Masjid	"	,
        "	Delhi Gate	"	,
        "	ITO	"	,
        "	Mandi House	"	,
        "	Janpath	"	,
        "	Central Secretariat	"	,
        "	Khan Market	"	,
        "	Jawaharlal Nehru Stadium	"	,
        "	Jangpura	"	,
        "	Lajpat Nagar	"	,
        "	Moolchand	"	,
        "	Kailash Colony	"	,
        "	Nehru Place	"	,
        "	Kalkaji Mandir	"	,
        "	Govind Puri	"	,
        "	Harkesh Nagar	"	,
        "	Jasola Apollo	"	,
        "	Sarita Vihar	"	,
        "	Mohan Estate	"	,
        "	Tughlakabad	"	,
        "	Badarpur	"	,
        "	Sarai	"	,
        "	NHPC Chowk	"	,
        "	Mewla Maharajpur	"	,
        "	Sector 28	"	,
        "	Badkhal Mor	"	,
        "	Faridabad Old	"	,
        "	Neelam Chowk Ajronda	"	,
        "	Bata Chowk	"	,
        "	Escorts Mujesar	"	,
        "	Sant Surdas — Sihi (NCB Colony)	"	,
        "	Raja Nahar Singh (Ballabhgarh)	"	,
       		
        "	Noida Electronic City	"	,
        "	Noida Sector 62	"	,
        "	Noida Sector 59	"	,
        "	Noida Sector 61	"	,
        "	Noida Sector 52	"	,
        "	Noida Sector 34	"	,
        "	Noida City Centre	"	,
        "	Golf Course	"	,
        "	Botanical Garden	"	,
        "	Noida Sect 18	"	,
        "	Noida Sect 16	"	,
        "	Noida Sect 15	"	,
        "	New Ashok Nagar	"	,
        "	Mayur Vihar Ext	"	,
        "	Mayur Vihar-I	"	,
        "	Akshardham	"	,
        "	Yamuna Bank	"	,
        "	Indraprasta	"	,
        "	Supreme Court	"	,
        "	Mandi House	"	,
        "	Barakhamba	"	,
        "	Rajiv Chowk	"	,
        "	RK Ashram Marg	"	,
        "	Jhandewalan	"	,
        "	Karol Bagh	"	,
        "	Rajendra Place	"	,
        "	Patel Nagar	"	,
        "	Shadi Pur	"	,
        "	Kirti Nagar	"	,
        "	Moti Nagar	"	,
        "	Ramesh Nagar	"	,
        "	Rajouri Garden	"	,
        "	Tagore Garden	"	,
        "	Subash Nagar	"	,
        "	Tilak Nagar	"	,
        "	Janak Puri East	"	,
        "	Janak Puri West	"	,
        "	Uttam Nagar East	"	,
        "	Uttam Nagar West	"	,
        "	Nawada	"	,
        "	Dwaraka Mor	"	,
        "	Dwarka	"	,
        "	Dwarka Sector - 14	"	,
        "	Dwarka Sector - 13	"	,
        "	Dwarka Sector - 12	"	,
        "	Dwarka Sector - 11	"	,
        "	Dwarka Sector - 10	"	,
        "	Dwarka Sector - 9	"	,
        "	Dwarka Sector - 8	"	,
        "	Dwarka Sector - 21	"	,
      			
        "	Yamuna Bank	"	,
        "	Laxmi Nagar	"	,
        "	Nirman Vihar	"	,
        "	Preet Vihar	"	,
        "	Karkar Duma	"	,
        "	Anand Vihar	"	,
        "	Kaushambi	"	,
        "	Vaishali	"	,			
    		
        "	Samaypur Badli	"	,
        "	Rohini Sector 18, 19	"	,
        "	Haiderpur Badli Mor	"	,
        "	Jahangirpuri	"	,
        "	Adarsh Nagar	"	,
        "	Azadpur	"	,
        "	Model Town	"	,
        "	GTB Nagar	"	,
        "	Viswavidyalaya	"	,
        "	Vidhan Sabha	"	,
        "	Civil Lines	"	,
        "	Kashmere Gate	"	,
        "	Chandhni Chowk	"	,
        "	Chawri Bazar	"	,
        "	NewDelhi	"	,
        "	Rajiv Chowk	"	,
        "	Patel Chowk	"	,
        "	Central Secretariat	"	,
        "	Udyog Bhawan	"	,
        "	Lok Kalyan Marg	"	,
        "	Jorbagh	"	,
        "	INA	"	,
        "	AIIMS	"	,
        "	Green Park	"	,
        "	Hauz Khas	"	,
        "	MalviaNagar	"	,
        "	Saket	"	,
        "	Qutab Minar	"	,
        "	Chhattarpur	"	,
        "	Sultanpur	"	,
        "	Ghotorni	"	,
        "	Arjan Garh	"	,
        "	Gurudronacharya	"	,
        "	Sikandarpur.	"	,
        "	MG Road	"	,
        "	IFFCO Chowk	"	,
        "	Huda City Centre	"	,
    		
        "	Mukundpur Depot	"	,
        "	Majlis Park	"	,
        "	Azadpur	"	,
        "	Shalimar Bagh	"	,
        "	Netaji Subhash Place	"	,
        "	Shakurpur	"	,
        "	Punjabi Bagh West	"	,
        "	ESI Hospital	"	,
        "	Rajouri Garden	"	,
        "	Maya Puri	"	,
        "	Nariana Vihar	"	,
        "	Delhi Cantt	"	,
        "	Durgabai Deshmukh South Campus	"	,
        "	Sir Vishweshwaraiah Moti Bagh	"	,
        "	Bhikaji Cama Place	"	,
        "	Sarojini Nagar	"	,
        "	INA	"	,
        "	South Extension	"	,
        "	Lajpat Nagar	"	,
        "	Vinobapuri	"	,
        "	Ashram	"	,
        "	Hazrat Nizamuddin	"	,
        "	Mayur Vihar - I	"	,
        "	Mayur Vihar Pocket 1	"	,
        "	Trilok Puri Sanjay Lake	"	,
        "	Vinod Nagar East	"	,
        "	Vinod Nagar	"	,
        "	IP Extension	"	,
        "	Anand Vihar	"	,
        "	Karkarduma	"	,
        "	Karkarduma Court	"	,
        "	Krishna Nagar	"	,
        "	East Azad Nagar	"	,
        "	Welcome	"	,
        "	Jaffrabad	"	,
        "	Maujpur	"	,
        "	Gokul Puri	"	,
        "	Johri Enclave	"	,
        "	Shiv Vihar	"	,
      			
        "	Janakpuri West	"	,
        "	Dabri Mor	"	,
        "	Dashrath Puri	"	,
        "	Palam	"	,
        "	Sadaar Bazaar Cantonment	"	,
        "	Terminal 1 IGI Airport	"	,
        "	Shankar Vihar	"	,
        "	Vasant Vihar	"	,
        "	Munirka	"	,
        "	R.K Puram	"	,
        "	IIT Delhi	"	,
        "	Hauz Khas	"	,
        "	Panchsheel Park	"	,
        "	Chirag Delhi	"	,
        "	Greater Kailash	"	,
        "	Nehru Enclave	"	,
        "	Kalkaji Mandir	"	,
        "	Okhla NSIC	"	,
        "	Sukhdev Vihar	"	,
        "	Jamia Millia Islamia	"	,
        "	Okhla Vihar	"	,
        "	Jasola Vihar Shaheen Bagh	"	,
        "	Kalindi Kunj	"	,
        "	Okhla Bird Sanctuary	"	,
        "	Botanical Garden	"	,
        			
        "	New Delhi	"	,
        "	Shivaji Stadium	"	,
        "	Dhaula Kuan	"	,
        "	Delhi Aerocity	"	,
        "	IGI Airport	"	,
        "	Dwarka Sector 21	"	,};
        // Create a list to store filtered items
        List<String> filteredItems = new ArrayList<>();

        // Create a JComboBox with initial items
        JComboBox<String> dropdown = new JComboBox<>(allItems);

        // Create a JTextField for search input
        JTextField searchField = new JTextField(20);

        // Create an ActionListener for the search field
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the search field
                String searchText = searchField.getText().toLowerCase();

                // Clear the filtered items
                filteredItems.clear();

                // Filter items based on the search text
                for (String item : allItems) {
                    if (item.toLowerCase().contains(searchText)) {
                        filteredItems.add(item);
                    }
                }

                // Update the dropdown with filtered items
                updateDropdown(dropdown, filteredItems);
            }
        });

        // Create a JPanel to hold the components
        JPanel panel = new JPanel();
        panel.add(searchField);
        panel.add(dropdown);

        // Set the content pane of the frame
        frame.setContentPane(panel);

        // Set the frame to be visible
        frame.setVisible(true);
    }

    // Method to update the dropdown with a list of items
    private static void updateDropdown(JComboBox<String> dropdown, List<String> items) {
        dropdown.removeAllItems();
        for (String item : items) {
            dropdown.addItem(item);
        }
    }
}
