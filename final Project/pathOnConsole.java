import java.util.*;
import javax.swing.*;
import java.awt.event.*;

class Graph {
    private Map<String, List<String>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addNode(String node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String source, String destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); 
    }

    public List<String> getNeighbors(String node) {
        List<String> neighbors = adjList.get(node);
        return neighbors != null ? neighbors : Collections.emptyList();
    }

    public void printGraph() {
        for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            System.out.println(entry.getValue());
        }
    }

    public List<String> shortestPathBFS(String source, String destination) {
        Map<String, String> parentMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (String neighbor : getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);

                    if (neighbor.equals(destination)) {
                        // Destination reached, reconstruct the path
                        List<String> path = new ArrayList<>();
                        String reconstructNode = destination;

                        while (reconstructNode != null) {
                            path.add(reconstructNode);
                            reconstructNode = parentMap.get(reconstructNode);
                        }

                        Collections.reverse(path);
                        return path;
                    }
                }
            }
        }

        // No path found
        return Collections.emptyList();
    }
}

public class pathOnConsole {
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
    public static String sourceSelected;
    public static String destinationSelected;

    public static void main(String[] args) {
        Graph graph = new Graph();

        // Adding nodes
        graph.addNode("Shaheed Sthal (New Bus Adda) ");
        graph.addNode("Hindon");
        graph.addNode("Arthala");
        graph.addNode("Mohan Nagar");
        graph.addNode("Shyam park");
        graph.addNode("Major Mohit Sharma");
        graph.addNode("Raj Bagh");
        graph.addNode("Shaheed Nagar");
        graph.addNode("Dilshad Garden");
        graph.addNode("Jhilmil");
        graph.addNode("Mansarovar Park");
        graph.addNode("Shahdara");
        graph.addNode("Welcome");
        graph.addNode("Seelampur");
        graph.addNode("Shastri Park");
        graph.addNode("Kashmere Gate");
        graph.addNode("Tis Hazari");
        graph.addNode("Pul Bangash");
        graph.addNode("Pratap Nagar");
        graph.addNode("Shastri Nagar");
        graph.addNode("Inderlok");
        graph.addNode("Kanhiya Nagar");
        graph.addNode("Keshav Puram");
        graph.addNode("Netaji Subhash Place");
        graph.addNode("Kohat Enclave");
        graph.addNode("Pitam Pura");
        graph.addNode("Rohini East");
        graph.addNode("Rohini West");
        // graph.addNode ( ) ;
        graph.addNode("Kirti Nagar");
        graph.addNode("Satguru Ram Singh Marg");
        graph.addNode("Inderlok");
        graph.addNode("Ashok Park Main");
        graph.addNode("Punjabi Bagh");
        graph.addNode("Punjabi Bagh West");
        graph.addNode("Shivaji Park");
        graph.addNode("Madipur");
        graph.addNode("Paschim Vihar East");
        graph.addNode("Paschim Vihar West");
        graph.addNode("Peera Garhi");
        graph.addNode("Udyog Nagar");
        graph.addNode("Surajmal Stadium");
        graph.addNode("Nangloi");
        graph.addNode("Nangloi Railway Station");
        graph.addNode("Rajdhani Park");
        graph.addNode("Mundka");
        graph.addNode("Mundka Industrial Area (MIA)");
        graph.addNode("Ghevra");
        graph.addNode("Tikri Kalan");
        graph.addNode("Tikri Border");
        graph.addNode("Pandit Shree Ram Sharma");
        graph.addNode("(Mordern Industrial Estate)");
        graph.addNode("Bahadurgarh City");
        graph.addNode("Brigadier Hoshiyar Singh");
        graph.addNode("Kashmere Gate");
        graph.addNode("Lal Qila");
        graph.addNode("Jama Masjid");
        graph.addNode("Delhi Gate");
        graph.addNode("ITO");
        graph.addNode("Mandi House");
        graph.addNode("Janpath");
        graph.addNode("Central Secretariat");
        graph.addNode("Khan Market");
        graph.addNode("Jawaharlal Nehru Stadium");
        graph.addNode("Jangpura");
        graph.addNode("Lajpat Nagar");
        graph.addNode("Moolchand");
        graph.addNode("Kailash Colony");
        graph.addNode("Nehru Place");
        graph.addNode("Kalkaji Mandir");
        graph.addNode("Govind Puri");
        graph.addNode("Harkesh Nagar");
        graph.addNode("Jasola Apollo");
        graph.addNode("Sarita Vihar");
        graph.addNode("Mohan Estate");
        graph.addNode("Tughlakabad");
        graph.addNode("Badarpur");
        graph.addNode("Sarai");
        graph.addNode("NHPC Chowk");
        graph.addNode("Mewla Maharajpur");
        graph.addNode("Sector 28");
        graph.addNode("Badkhal Mor");
        graph.addNode("Faridabad Old");
        graph.addNode("Neelam Chowk Ajronda");
        graph.addNode("Bata Chowk");
        graph.addNode("Escorts Mujesar");
        graph.addNode("Sant Surdas — Sihi (NCB Colony)");
        graph.addNode("Noida Electronic City");
        graph.addNode("Noida Sector 62");
        graph.addNode("Noida Sector 59");
        graph.addNode("Noida Sector 61");
        graph.addNode("Noida Sector 52");
        graph.addNode("Noida Sector 34");
        graph.addNode("Noida City Centre");
        graph.addNode("Golf Course");
        graph.addNode("Botanical Garden");
        graph.addNode("Noida Sect 18");
        graph.addNode("Noida Sect 16");
        graph.addNode("Noida Sect 15");
        graph.addNode("New Ashok Nagar");
        graph.addNode("Mayur Vihar Ext");
        graph.addNode("Mayur Vihar-I");
        graph.addNode("Akshardham");
        graph.addNode("Yamuna Bank");
        graph.addNode("Indraprasta");
        graph.addNode("Supreme Court");
        graph.addNode("Mandi House");
        graph.addNode("Barakhamba");
        graph.addNode("Rajiv Chowk");
        graph.addNode("RK Ashram Marg");
        graph.addNode("Jhandewalan");
        graph.addNode("Karol Bagh");
        graph.addNode("Rajendra Place");
        graph.addNode("Patel Nagar");
        graph.addNode("Shadi Pur");
        graph.addNode("Kirti Nagar");
        graph.addNode("Moti Nagar");
        graph.addNode("Ramesh Nagar");
        graph.addNode("Rajouri Garden");
        graph.addNode("Tagore Garden");
        graph.addNode("Subash Nagar");
        graph.addNode("Tilak Nagar");
        graph.addNode("Janak Puri East");
        graph.addNode("Janak Puri West");
        graph.addNode("Uttam Nagar East");
        graph.addNode("Uttam Nagar West");
        graph.addNode("Nawada");
        graph.addNode("Dwaraka Mor");
        graph.addNode("Dwarka");
        graph.addNode("Dwarka Sector - 14");
        graph.addNode("Dwarka Sector - 13");
        graph.addNode("Dwarka Sector - 12");
        graph.addNode("Dwarka Sector - 11");
        graph.addNode("Dwarka Sector - 10");
        graph.addNode("Dwarka Sector - 9");
        graph.addNode("Dwarka Sector - 8");
        graph.addNode("Yamuna Bank");
        graph.addNode("Laxmi Nagar");
        graph.addNode("Nirman Vihar");
        graph.addNode("Preet Vihar");
        graph.addNode("Karkar Duma");
        graph.addNode("Anand Vihar");
        graph.addNode("Kaushambi");
        graph.addNode("Samaypur Badli");
        graph.addNode("Rohini Sector 18, 19");
        graph.addNode("Haiderpur Badli Mor");
        graph.addNode("Jahangirpuri");
        graph.addNode("Adarsh Nagar");
        graph.addNode("Azadpur");
        graph.addNode("Model Town");
        graph.addNode("GTB Nagar");
        graph.addNode("Viswavidyalaya");
        graph.addNode("Vidhan Sabha");
        graph.addNode("Civil Lines");
        graph.addNode("Kashmere Gate");
        graph.addNode("Chandhni Chowk");
        graph.addNode("Chawri Bazar");
        graph.addNode("NewDelhi");
        graph.addNode("Rajiv Chowk");
        graph.addNode("Patel Chowk");
        graph.addNode("Central Secretariat");
        graph.addNode("Udyog Bhawan");
        graph.addNode("Lok Kalyan Marg");
        graph.addNode("Jorbagh");
        graph.addNode("INA");
        graph.addNode("AIIMS");
        graph.addNode("Green Park");
        graph.addNode("Hauz Khas");
        graph.addNode("MalviaNagar");
        graph.addNode("Saket");
        graph.addNode("Qutab Minar");
        graph.addNode("Chhattarpur");
        graph.addNode("Sultanpur");
        graph.addNode("Ghotorni");
        graph.addNode("Arjan Garh");
        graph.addNode("Gurudronacharya");
        graph.addNode("Sikandarpur.");
        graph.addNode("MG Road");
        graph.addNode("IFFCO Chowk");
        graph.addNode("Mukundpur Depot");
        graph.addNode("Majlis Park");
        graph.addNode("Azadpur");
        graph.addNode("Shalimar Bagh");
        graph.addNode("Netaji Subhash Place");
        graph.addNode("Shakurpur");
        graph.addNode("Punjabi Bagh West");
        graph.addNode("ESI Hospital");
        graph.addNode("Rajouri Garden");
        graph.addNode("Maya Puri");
        graph.addNode("Nariana Vihar");
        graph.addNode("Delhi Cantt");
        graph.addNode("Durgabai Deshmukh South Campus");
        graph.addNode("Sir Vishweshwaraiah Moti Bagh");
        graph.addNode("Bhikaji Cama Place");
        graph.addNode("Sarojini Nagar");
        graph.addNode("INA");
        graph.addNode("South Extension");
        graph.addNode("Lajpat Nagar");
        graph.addNode("Vinobapuri");
        graph.addNode("Ashram");
        graph.addNode("Hazrat Nizamuddin");
        graph.addNode("Mayur Vihar - I");
        graph.addNode("Mayur Vihar Pocket 1");
        graph.addNode("Trilok Puri Sanjay Lake");
        graph.addNode("Vinod Nagar East");
        graph.addNode("Vinod Nagar");
        graph.addNode("IP Extension");
        graph.addNode("Anand Vihar");
        graph.addNode("Karkarduma");
        graph.addNode("Karkarduma Court");
        graph.addNode("Krishna Nagar");
        graph.addNode("East Azad Nagar");
        graph.addNode("Welcome");
        graph.addNode("Jaffrabad");
        graph.addNode("Maujpur");
        graph.addNode("Gokul Puri");
        graph.addNode("Johri Enclave");
        graph.addNode("Janakpuri West");
        graph.addNode("Dabri Mor");
        graph.addNode("Dashrath Puri");
        graph.addNode("Palam");
        graph.addNode("Sadaar Bazaar Cantonment");
        graph.addNode("Terminal 1 IGI Airport");
        graph.addNode("Shankar Vihar");
        graph.addNode("Vasant Vihar");
        graph.addNode("Munirka");
        graph.addNode("R.K Puram");
        graph.addNode("IIT Delhi");
        graph.addNode("Hauz Khas");
        graph.addNode("Panchsheel Park");
        graph.addNode("Chirag Delhi");
        graph.addNode("Greater Kailash");
        graph.addNode("Nehru Enclave");
        graph.addNode("Kalkaji Mandir");
        graph.addNode("Okhla NSIC");
        graph.addNode("Sukhdev Vihar");
        graph.addNode("Jamia Millia Islamia");
        graph.addNode("Okhla Vihar");
        graph.addNode("Jasola Vihar Shaheen Bagh");
        graph.addNode("Kalindi Kunj");
        graph.addNode("Okhla Bird Sanctuary");
        graph.addNode("New Delhi");
        graph.addNode("Shivaji Stadium");
        graph.addNode("Dhaula Kuan");
        graph.addNode("Delhi Aerocity");
        graph.addNode("IGI Airport");
        graph.addNode("Rithala");
        graph.addNode("(Bahadurgarh City Park)");
        graph.addNode("Raja Nahar Singh (Ballabhgarh)");
        graph.addNode("Dwarka Sector - 21");
        graph.addNode("Vaishali");
        graph.addNode("Huda City Centre");
        graph.addNode("Shiv Vihar");
        graph.addNode("Botanical Garden");

        graph.addEdge("Shaheed Sthal (New Bus Adda) ", "Hindon");
        graph.addEdge("Hindon", "Arthala");
        graph.addEdge("Arthala", "Mohan Nagar");
        graph.addEdge("Mohan Nagar", "Shyam park");
        graph.addEdge("Shyam park", "Major Mohit Sharma");
        graph.addEdge("Major Mohit Sharma", "Raj Bagh");
        graph.addEdge("Raj Bagh", "Shaheed Nagar");
        graph.addEdge("Shaheed Nagar", "Dilshad Garden");
        graph.addEdge("Dilshad Garden", "Jhilmil");
        graph.addEdge("Jhilmil", "Mansarovar Park");
        graph.addEdge("Mansarovar Park", "Shahdara");
        graph.addEdge("Shahdara", "Welcome");
        graph.addEdge("Welcome", "Seelampur");
        graph.addEdge("Seelampur", "Shastri Park");
        graph.addEdge("Shastri Park", "Kashmere Gate");
        graph.addEdge("Kashmere Gate", "Tis Hazari");
        graph.addEdge("Tis Hazari", "Pul Bangash");
        graph.addEdge("Pul Bangash", "Pratap Nagar");
        graph.addEdge("Pratap Nagar", "Shastri Nagar");
        graph.addEdge("Shastri Nagar", "Inderlok");
        graph.addEdge("Inderlok", "Kanhiya Nagar");
        graph.addEdge("Kanhiya Nagar", "Keshav Puram");
        graph.addEdge("Keshav Puram", "Netaji Subhash Place");
        graph.addEdge("Netaji Subhash Place", "Kohat Enclave");
        graph.addEdge("Kohat Enclave", "Pitam Pura");
        graph.addEdge("Pitam Pura", "Rohini East");
        graph.addEdge("Rohini East", "Rohini West");
        graph.addEdge("Rohini West", "Rithala");
        // graph.addEdge ( ) ;
        graph.addEdge("Kirti Nagar", "Satguru Ram Singh Marg");
        graph.addEdge("Satguru Ram Singh Marg", "Inderlok");
        graph.addEdge("Inderlok", "Ashok Park Main");
        graph.addEdge("Ashok Park Main", "Punjabi Bagh");
        graph.addEdge("Punjabi Bagh", "Punjabi Bagh West");
        graph.addEdge("Punjabi Bagh West", "Shivaji Park");
        graph.addEdge("Shivaji Park", "Madipur");
        graph.addEdge("Madipur", "Paschim Vihar East");
        graph.addEdge("Paschim Vihar East", "Paschim Vihar West");
        graph.addEdge("Paschim Vihar West", "Peera Garhi");
        graph.addEdge("Peera Garhi", "Udyog Nagar");
        graph.addEdge("Udyog Nagar", "Surajmal Stadium");
        graph.addEdge("Surajmal Stadium", "Nangloi");
        graph.addEdge("Nangloi", "Nangloi Railway Station");
        graph.addEdge("Nangloi Railway Station", "Rajdhani Park");
        graph.addEdge("Rajdhani Park", "Mundka");
        graph.addEdge("Mundka", "Mundka Industrial Area (MIA)");
        graph.addEdge("Mundka Industrial Area (MIA)", "Ghevra");
        graph.addEdge("Ghevra", "Tikri Kalan");
        graph.addEdge("Tikri Kalan", "Tikri Border");
        graph.addEdge("Tikri Border", "Pandit Shree Ram Sharma");
        graph.addEdge("Pandit Shree Ram Sharma", "(Mordern Industrial Estate)");
        graph.addEdge("(Mordern Industrial Estate)", "Bahadurgarh City");
        graph.addEdge("Bahadurgarh City", "Brigadier Hoshiyar Singh");
        graph.addEdge("Brigadier Hoshiyar Singh", "(Bahadurgarh City Park)");
        graph.addEdge("Kashmere Gate", "Lal Qila");
        graph.addEdge("Lal Qila", "Jama Masjid");
        graph.addEdge("Jama Masjid", "Delhi Gate");
        graph.addEdge("Delhi Gate", "ITO");
        graph.addEdge("ITO", "Mandi House");
        graph.addEdge("Mandi House", "Janpath");
        graph.addEdge("Janpath", "Central Secretariat");
        graph.addEdge("Central Secretariat", "Khan Market");
        graph.addEdge("Khan Market", "Jawaharlal Nehru Stadium");
        graph.addEdge("Jawaharlal Nehru Stadium", "Jangpura");
        graph.addEdge("Jangpura", "Lajpat Nagar");
        graph.addEdge("Lajpat Nagar", "Moolchand");
        graph.addEdge("Moolchand", "Kailash Colony");
        graph.addEdge("Kailash Colony", "Nehru Place");
        graph.addEdge("Nehru Place", "Kalkaji Mandir");
        graph.addEdge("Kalkaji Mandir", "Govind Puri");
        graph.addEdge("Govind Puri", "Harkesh Nagar");
        graph.addEdge("Harkesh Nagar", "Jasola Apollo");
        graph.addEdge("Jasola Apollo", "Sarita Vihar");
        graph.addEdge("Sarita Vihar", "Mohan Estate");
        graph.addEdge("Mohan Estate", "Tughlakabad");
        graph.addEdge("Tughlakabad", "Badarpur");
        graph.addEdge("Badarpur", "Sarai");
        graph.addEdge("Sarai", "NHPC Chowk");
        graph.addEdge("NHPC Chowk", "Mewla Maharajpur");
        graph.addEdge("Mewla Maharajpur", "Sector 28");
        graph.addEdge("Sector 28", "Badkhal Mor");
        graph.addEdge("Badkhal Mor", "Faridabad Old");
        graph.addEdge("Faridabad Old", "Neelam Chowk Ajronda");
        graph.addEdge("Neelam Chowk Ajronda", "Bata Chowk");
        graph.addEdge("Bata Chowk", "Escorts Mujesar");
        graph.addEdge("Escorts Mujesar", "Sant Surdas — Sihi (NCB Colony)");
        graph.addEdge("Sant Surdas — Sihi (NCB Colony)", "Raja Nahar Singh (Ballabhgarh)");
        graph.addEdge("Noida Electronic City", "Noida Sector 62");
        graph.addEdge("Noida Sector 62", "Noida Sector 59");
        graph.addEdge("Noida Sector 59", "Noida Sector 61");
        graph.addEdge("Noida Sector 61", "Noida Sector 52");
        graph.addEdge("Noida Sector 52", "Noida Sector 34");
        graph.addEdge("Noida Sector 34", "Noida City Centre");
        graph.addEdge("Noida City Centre", "Golf Course");
        graph.addEdge("Golf Course", "Botanical Garden");
        graph.addEdge("Botanical Garden", "Noida Sect 18");
        graph.addEdge("Noida Sect 18", "Noida Sect 16");
        graph.addEdge("Noida Sect 16", "Noida Sect 15");
        graph.addEdge("Noida Sect 15", "New Ashok Nagar");
        graph.addEdge("New Ashok Nagar", "Mayur Vihar Ext");
        graph.addEdge("Mayur Vihar Ext", "Mayur Vihar-I");
        graph.addEdge("Mayur Vihar-I", "Akshardham");
        graph.addEdge("Akshardham", "Yamuna Bank");
        graph.addEdge("Yamuna Bank", "Indraprasta");
        graph.addEdge("Indraprasta", "Supreme Court");
        graph.addEdge("Supreme Court", "Mandi House");
        graph.addEdge("Mandi House", "Barakhamba");
        graph.addEdge("Barakhamba", "Rajiv Chowk");
        graph.addEdge("Rajiv Chowk", "RK Ashram Marg");
        graph.addEdge("RK Ashram Marg", "Jhandewalan");
        graph.addEdge("Jhandewalan", "Karol Bagh");
        graph.addEdge("Karol Bagh", "Rajendra Place");
        graph.addEdge("Rajendra Place", "Patel Nagar");
        graph.addEdge("Patel Nagar", "Shadi Pur");
        graph.addEdge("Shadi Pur", "Kirti Nagar");
        graph.addEdge("Kirti Nagar", "Moti Nagar");
        graph.addEdge("Moti Nagar", "Ramesh Nagar");
        graph.addEdge("Ramesh Nagar", "Rajouri Garden");
        graph.addEdge("Rajouri Garden", "Tagore Garden");
        graph.addEdge("Tagore Garden", "Subash Nagar");
        graph.addEdge("Subash Nagar", "Tilak Nagar");
        graph.addEdge("Tilak Nagar", "Janak Puri East");
        graph.addEdge("Janak Puri East", "Janak Puri West");
        graph.addEdge("Janak Puri West", "Uttam Nagar East");
        graph.addEdge("Uttam Nagar East", "Uttam Nagar West");
        graph.addEdge("Uttam Nagar West", "Nawada");
        graph.addEdge("Nawada", "Dwaraka Mor");
        graph.addEdge("Dwaraka Mor", "Dwarka");
        graph.addEdge("Dwarka", "Dwarka Sector - 14");
        graph.addEdge("Dwarka Sector - 14", "Dwarka Sector - 13");
        graph.addEdge("Dwarka Sector - 13", "Dwarka Sector - 12");
        graph.addEdge("Dwarka Sector - 12", "Dwarka Sector - 11");
        graph.addEdge("Dwarka Sector - 11", "Dwarka Sector - 10");
        graph.addEdge("Dwarka Sector - 10", "Dwarka Sector - 9");
        graph.addEdge("Dwarka Sector - 9", "Dwarka Sector - 8");
        graph.addEdge("Dwarka Sector - 8", "Dwarka Sector - 21");
        graph.addEdge("Yamuna Bank", "Laxmi Nagar");
        graph.addEdge("Laxmi Nagar", "Nirman Vihar");
        graph.addEdge("Nirman Vihar", "Preet Vihar");
        graph.addEdge("Preet Vihar", "Karkar Duma");
        graph.addEdge("Karkar Duma", "Anand Vihar");
        graph.addEdge("Anand Vihar", "Kaushambi");
        graph.addEdge("Kaushambi", "Vaishali");
        graph.addEdge("Samaypur Badli", "Rohini Sector 18, 19");
        graph.addEdge("Rohini Sector 18, 19", "Haiderpur Badli Mor");
        graph.addEdge("Haiderpur Badli Mor", "Jahangirpuri");
        graph.addEdge("Jahangirpuri", "Adarsh Nagar");
        graph.addEdge("Adarsh Nagar", "Azadpur");
        graph.addEdge("Azadpur", "Model Town");
        graph.addEdge("Model Town", "GTB Nagar");
        graph.addEdge("GTB Nagar", "Viswavidyalaya");
        graph.addEdge("Viswavidyalaya", "Vidhan Sabha");
        graph.addEdge("Vidhan Sabha", "Civil Lines");
        graph.addEdge("Civil Lines", "Kashmere Gate");
        graph.addEdge("Kashmere Gate", "Chandhni Chowk");
        graph.addEdge("Chandhni Chowk", "Chawri Bazar");
        graph.addEdge("Chawri Bazar", "NewDelhi");
        graph.addEdge("NewDelhi", "Rajiv Chowk");
        graph.addEdge("Rajiv Chowk", "Patel Chowk");
        graph.addEdge("Patel Chowk", "Central Secretariat");
        graph.addEdge("Central Secretariat", "Udyog Bhawan");
        graph.addEdge("Udyog Bhawan", "Lok Kalyan Marg");
        graph.addEdge("Lok Kalyan Marg", "Jorbagh");
        graph.addEdge("Jorbagh", "INA");
        graph.addEdge("INA", "AIIMS");
        graph.addEdge("AIIMS", "Green Park");
        graph.addEdge("Green Park", "Hauz Khas");
        graph.addEdge("Hauz Khas", "MalviaNagar");
        graph.addEdge("MalviaNagar", "Saket");
        graph.addEdge("Saket", "Qutab Minar");
        graph.addEdge("Qutab Minar", "Chhattarpur");
        graph.addEdge("Chhattarpur", "Sultanpur");
        graph.addEdge("Sultanpur", "Ghotorni");
        graph.addEdge("Ghotorni", "Arjan Garh");
        graph.addEdge("Arjan Garh", "Gurudronacharya");
        graph.addEdge("Gurudronacharya", "Sikandarpur.");
        graph.addEdge("Sikandarpur.", "MG Road");
        graph.addEdge("MG Road", "IFFCO Chowk");
        graph.addEdge("IFFCO Chowk", "Huda City Centre");
        graph.addEdge("Mukundpur Depot", "Majlis Park");
        graph.addEdge("Majlis Park", "Azadpur");
        graph.addEdge("Azadpur", "Shalimar Bagh");
        graph.addEdge("Shalimar Bagh", "Netaji Subhash Place");
        graph.addEdge("Netaji Subhash Place", "Shakurpur");
        graph.addEdge("Shakurpur", "Punjabi Bagh West");
        graph.addEdge("Punjabi Bagh West", "ESI Hospital");
        graph.addEdge("ESI Hospital", "Rajouri Garden");
        graph.addEdge("Rajouri Garden", "Maya Puri");
        graph.addEdge("Maya Puri", "Nariana Vihar");
        graph.addEdge("Nariana Vihar", "Delhi Cantt");
        graph.addEdge("Delhi Cantt", "Durgabai Deshmukh South Campus");
        graph.addEdge("Durgabai Deshmukh South Campus", "Sir Vishweshwaraiah Moti Bagh");
        graph.addEdge("Sir Vishweshwaraiah Moti Bagh", "Bhikaji Cama Place");
        graph.addEdge("Bhikaji Cama Place", "Sarojini Nagar");
        graph.addEdge("Sarojini Nagar", "INA");
        graph.addEdge("INA", "South Extension");
        graph.addEdge("South Extension", "Lajpat Nagar");
        graph.addEdge("Lajpat Nagar", "Vinobapuri");
        graph.addEdge("Vinobapuri", "Ashram");
        graph.addEdge("Ashram", "Hazrat Nizamuddin");
        graph.addEdge("Hazrat Nizamuddin", "Mayur Vihar - I");
        graph.addEdge("Mayur Vihar - I", "Mayur Vihar Pocket 1");
        graph.addEdge("Mayur Vihar Pocket 1", "Trilok Puri Sanjay Lake");
        graph.addEdge("Trilok Puri Sanjay Lake", "Vinod Nagar East");
        graph.addEdge("Vinod Nagar East", "Vinod Nagar");
        graph.addEdge("Vinod Nagar", "IP Extension");
        graph.addEdge("IP Extension", "Anand Vihar");
        graph.addEdge("Anand Vihar", "Karkarduma");
        graph.addEdge("Karkarduma", "Karkarduma Court");
        graph.addEdge("Karkarduma Court", "Krishna Nagar");
        graph.addEdge("Krishna Nagar", "East Azad Nagar");
        graph.addEdge("East Azad Nagar", "Welcome");
        graph.addEdge("Welcome", "Jaffrabad");
        graph.addEdge("Jaffrabad", "Maujpur");
        graph.addEdge("Maujpur", "Gokul Puri");
        graph.addEdge("Gokul Puri", "Johri Enclave");
        graph.addEdge("Johri Enclave", "Shiv Vihar");
        graph.addEdge("Janakpuri West", "Dabri Mor");
        graph.addEdge("Dabri Mor", "Dashrath Puri");
        graph.addEdge("Dashrath Puri", "Palam");
        graph.addEdge("Palam", "Sadaar Bazaar Cantonment");
        graph.addEdge("Sadaar Bazaar Cantonment", "Terminal 1 IGI Airport");
        graph.addEdge("Terminal 1 IGI Airport", "Shankar Vihar");
        graph.addEdge("Shankar Vihar", "Vasant Vihar");
        graph.addEdge("Vasant Vihar", "Munirka");
        graph.addEdge("Munirka", "R.K Puram");
        graph.addEdge("R.K Puram", "IIT Delhi");
        graph.addEdge("IIT Delhi", "Hauz Khas");
        graph.addEdge("Hauz Khas", "Panchsheel Park");
        graph.addEdge("Panchsheel Park", "Chirag Delhi");
        graph.addEdge("Chirag Delhi", "Greater Kailash");
        graph.addEdge("Greater Kailash", "Nehru Enclave");
        graph.addEdge("Nehru Enclave", "Kalkaji Mandir");
        graph.addEdge("Kalkaji Mandir", "Okhla NSIC");
        graph.addEdge("Okhla NSIC", "Sukhdev Vihar");
        graph.addEdge("Sukhdev Vihar", "Jamia Millia Islamia");
        graph.addEdge("Jamia Millia Islamia", "Okhla Vihar");
        graph.addEdge("Okhla Vihar", "Jasola Vihar Shaheen Bagh");
        graph.addEdge("Jasola Vihar Shaheen Bagh", "Kalindi Kunj");
        graph.addEdge("Kalindi Kunj", "Okhla Bird Sanctuary");
        graph.addEdge("Okhla Bird Sanctuary", "Botanical Garden");
        graph.addEdge("New Delhi", "Shivaji Stadium");
        graph.addEdge("Shivaji Stadium", "Dhaula Kuan");
        graph.addEdge("Dhaula Kuan", "Delhi Aerocity");
        graph.addEdge("Delhi Aerocity", "IGI Airport");
        graph.addEdge("IGI Airport", "Dwarka Sector - 21");
        // Print the graph
        // System.out.println("Graph representation using adjacency list:");
        // graph.printGraph();

        // Find shortest path from source to destination

        JFrame frame = new JFrame("Metro Station Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create JComboBox instances for source and destination
        JComboBox<String> sourceDropdown = new JComboBox<>(allStations);
        JComboBox<String> destinationDropdown = new JComboBox<>(allStations);

        // Create JTextFields for station search input
        JTextField sourceSearchField = new JTextField(20);
        JTextField destinationSearchField = new JTextField(20);

        // Create JLabel instances for source and destination labels
        JLabel sourceLabel = new JLabel("Source");
        JLabel destinationLabel = new JLabel("Destination");

        // Creating Button
        JButton button = new JButton("search");

        JLabel routeLabel = new JLabel("Shortest Route");
        JTextArea routeField = new JTextArea();
        routeField.setLineWrap(true); // Enable line wrapping
        routeField.setWrapStyleWord(true); // Wrap at word boundaries

        JScrollPane scrollPane = new JScrollPane(routeField);

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
                sourceSelected = sourceDropdown.getSelectedItem().toString();
                destinationSelected = destinationDropdown.getSelectedItem().toString();
                System.out.println("Selected Source: " + sourceSelected);
                System.out.println("Selected Destination: " + destinationSelected);
                System.out.println();
            }
        };
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to be executed when the button is clicked
                // JOptionPane.showMessageDialog(frame, "Button Clicked!");
                // String source = "Indraprasta";
                // String destination = "Noida Electronic City";
                List<String> shortestPath = graph.shortestPathBFS(sourceSelected, destinationSelected);
                String completeRoute = "";
                if (!shortestPath.isEmpty()) {
                    for (String station : shortestPath) {
                        completeRoute = completeRoute + " -> " + station;
                        System.out.print("  ->  " + station);
                    }
                    routeField.setText(completeRoute);
                } else {
                    System.out.println("No path found from " + sourceSelected + " to " + destinationSelected);
                }
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
