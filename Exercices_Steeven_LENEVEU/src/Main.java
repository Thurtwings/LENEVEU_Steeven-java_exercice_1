import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException
    {
        /*
         * Random rdm = new Random();
         * int[] numbers = new int[1000000];
         *
         * for(int i = 0; i< numbers.length; i++)
         * {
         * numbers[i] = rdm.nextInt(1000001);
         * }
         *
         *
         * System.out.println("\nTableau trié: ");
         *
         * QuickSort(numbers, 0, numbers.length - 1);
         * System.out.print("firt index:" + numbers[0]+"\nlast index:" +
         * numbers[numbers.length - 1]);




       FromMorseToLatin("morse_code.txt");

        System.out.println(GetInitDico());
        WriteKeysToTxt(GetInitDico());


        Bibliotheque bibliotheque = new Bibliotheque();
        // Ajout de livres
        Livre livre1 = new Livre("Les Misérables", "Victor Hugo", "1862", 1, true);
        Livre livre2 = new Livre("Germinal", "Emile Zola", "1885", 2, true);
        bibliotheque.ajouterLivre(livre1);
        bibliotheque.ajouterLivre(livre2);

        // Ajout d'auteurs
        Auteur auteur1 = new Auteur("Victor Hugo", "26 février 1802", "Française");
        Auteur auteur2 = new Auteur("Emile Zola", "2 avril 1840", "Française");
        bibliotheque.ajouterAuteur(auteur1);
        bibliotheque.ajouterAuteur(auteur2);

        // Ajout d'emprunteurs
        Emprunteur emprunteur1 = new Emprunteur("Alice", "10 rue des Fleurs", "01 23 45 67 89", "", "");
        Emprunteur emprunteur2 = new Emprunteur("Bob", "20 rue des Arbres", "02 34 56 78 90", "", "");
        bibliotheque.ajouterEmprunteur(emprunteur1);
        bibliotheque.ajouterEmprunteur(emprunteur2);

        // Affichage des livres, auteurs et emprunteurs
        System.out.println("Liste des livres :");
        bibliotheque.afficherLivres();

        System.out.println("\nListe des auteurs :");
        bibliotheque.afficherAuteurs();

        System.out.println("\nListe des emprunteurs :");
        bibliotheque.afficherEmprunteurs();

        // Emprunt d'un livre
        bibliotheque.emprunterLivre(1, "Alice");

        // Affichage des livres et emprunteurs après emprunt
        System.out.println("\nListe des livres après emprunt :");
        bibliotheque.afficherLivres();

        System.out.println("\nListe des emprunteurs après emprunt :");
        bibliotheque.afficherEmprunteurs();

        // Retour d'un livre
        bibliotheque.retournerLivre(1);

        // Affichage des livres et emprunteurs après retour
        System.out.println("\nListe des livres après retour :");
        bibliotheque.afficherLivres();

        System.out.println("\nListe des emprunteurs après retour :");
        bibliotheque.afficherEmprunteurs();

        //ReadIt("exo.txt");




        // Création des plats
        exo_1.Plat p1 = new exo_1.Plat("Pizza Margherita", "Tomate, mozzarella, basilic", 10.50);
        exo_1.Plat p2 = new exo_1.Plat("Pâtes à la Carbonara", "Sauce à la crème, pancetta, parmesan", 12.75);
        exo_1.Plat p3 = new exo_1.Plat("Burger", "Pain, steak, cheddar, salade, tomate, oignons", 9.90);
        exo_1.Plat p4 = new exo_1.Plat("Salade Caesar", "Laitue, poulet grillé, croûtons, parmesan, sauce Caesar", 8.50);

        // Création des menus
        exo_1.Menu m1 = new exo_1.Menu("exo_1.Menu Italien", "Des plats typiquement italiens");
        m1.ajouterPlat(p1);
        m1.ajouterPlat(p2);

        exo_1.Menu m2 = new exo_1.Menu("exo_1.Menu Américain", "Des plats typiquement américains");
        m2.ajouterPlat(p3);
        m2.ajouterPlat(p4);

        // Affichage des menus
        exo_1.Restaurant restaurant = new exo_1.Restaurant();
        restaurant.ajouterMenu(m1);
        restaurant.ajouterMenu(m2);
        restaurant.afficherMenus();

        // Création des clients
        exo_1.Client c1 = new exo_1.Client("John Doe", "Rue de la Paix 10, Paris", "+33 6 12 34 56 78");
        exo_1.Client c2 = new exo_1.Client("Jane Smith", "5th Avenue, New York", "+1 212-555-1234");

        // Affichage des clients
        restaurant.ajouterClient(c1);
        restaurant.ajouterClient(c2);
        restaurant.afficherClients();

        // Passage de commandes
        restaurant.passerCommande(c1, m1, Arrays.asList(p1, p2));
        restaurant.passerCommande(c2, m2, Arrays.asList(p3, p4));

        // Affichage des commandes pour un client spécifique
        restaurant.afficherCommandes(c1);
        restaurant.afficherCommandes(c2);

        m1.modifierPlat(p3, "Burger", "Pain, steak, cheddar, salade, tomate, oignons", 55.99 );
        m1.afficherPlats();


        Calculatrice.Calculatrice calculatrice = new Calculatrice.Calculatrice();
        */



    }
    // #region Exercice 1

    static int[] BubbleSort(int[] tab)
    {
        int tabSize = tab.length;
        int temp = 0;
        for (int i = 0; i < tabSize; i++)
        {
            for (int j = 1; j < (tabSize - i); j++)
            {
                if (tab[j - 1] > tab[j]) {
                    temp = tab[j - 1];
                    tab[j - 1] = tab[j];
                    tab[j] = temp;
                }

            }
        }

        return tab;
    }

    static void DisplayTab(int[] tab)
    {
        for (int i = 0; i < tab.length; i++)
        {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    // #endregion
    // #region Exercice 2
    static int partition(int tab[], int fstElt, int lstElt)
    {
        int pivot = tab[lstElt];
        // smaller element index
        int i = (fstElt - 1);
        for (int j = fstElt; j <= lstElt - 1; j++)
        {
            // check if current element is less than or equal to pivot
            if (tab[j] <= pivot)
            {
                i++;
                // swap the elements
                int temp = tab[i];
                tab[i] = tab[j];
                tab[j] = temp;
            }
        }
        // swap numArray[i+1] and numArray[high] (or pivot)
        int temp = tab[i + 1];
        tab[i + 1] = tab[lstElt];
        tab[lstElt] = temp;
        return i + 1;
    }

    static void QuickSort(int numArray[], int low, int high) {
        // auxillary stack
        int[] intStack = new int[high - low + 1];

        // top of stack initialized to -1
        int top = -1;

        // push initial values of low and high to stack
        intStack[++top] = low;
        intStack[++top] = high;

        // Keep popping from stack while is not empty
        while (top >= 0) {
            // Pop h and l
            high = intStack[top--];
            low = intStack[top--];

            // Set pivot element at its correct position
            // in sorted array
            int pivot = partition(numArray, low, high);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if (pivot - 1 > low) {
                intStack[++top] = low;
                intStack[++top] = pivot - 1;
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if (pivot + 1 < high) {
                intStack[++top] = pivot + 1;
                intStack[++top] = high;
            }
        }
    }

    // #endregion
    // #region Exercice 3
    static void ReadIt(String fileTxt) {
        File myObj;
        try {
            myObj = new File(fileTxt);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                System.out.println(ToCamelCase(data));

            }
            myReader.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    static String ReadIt(String fileTxt, boolean isMorse) {
        File myObj;
        try {
            myObj = new File(fileTxt);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                System.out.println(ToCamelCase(data));

            }
            myReader.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return fileTxt;

    }

    static String ToCamelCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] parts = str.split("[\\s_-]+");
        StringBuilder camelCase = new StringBuilder(parts[0].toLowerCase());

        for (int i = 1; i < parts.length; i++) {
            String capitalized = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1).toLowerCase();
            camelCase.append(capitalized);
        }

        return camelCase.toString();
    }
    // #endregion
    // #region Exercice 4

    static HashMap<String, String> GetInitDico() {
        HashMap<String, String> morseMap = new HashMap<String, String>();

        morseMap.put(".-", "A");
        morseMap.put(".--.-", "À");
        morseMap.put("-...", "B");
        morseMap.put("-.-.", "C");
        morseMap.put("-.-..", "Ç");
        morseMap.put("-..", "D");
        morseMap.put(".", "E");
        morseMap.put("..-.", "F");
        morseMap.put("--.", "G");
        morseMap.put("....", "H");
        morseMap.put("..", "I");
        morseMap.put(".---", "J");
        morseMap.put("-.-", "K");
        morseMap.put(".-..", "L");
        morseMap.put("--", "M");
        morseMap.put("-.", "N");
        morseMap.put("---", "O");
        morseMap.put(".--.", "P");
        morseMap.put("--.-", "Q");
        morseMap.put(".-.", "R");
        morseMap.put("...", "S");
        morseMap.put("-", "T");
        morseMap.put("..-", "U");
        morseMap.put("...-", "V");
        morseMap.put(".--", "W");
        morseMap.put("-..-", "X");
        morseMap.put("-.--", "Y");
        morseMap.put("--..", "Z");
        morseMap.put(".-.-.-", ".");
        morseMap.put("--..--", ",");
        morseMap.put("..--..", "?");
        morseMap.put(".----.", "\'");
        morseMap.put("-.-.--", "!");

        return morseMap;
    }
//TODO: cette fonction
	/* static HashMap WriteKeysToTxt(HashMap map) {
		// #region creation du fichier
		try {
			File newFile = new File("D:\\Cours\\UHA SERFA\\Cours JAVA\\Philippe\\Exercice_JAVA_1\\morse_alphabet.txt");
			if (newFile.createNewFile()) {
				System.out.println("File created: " + newFile.getName());
				System.out.println("Absolute path: " + newFile.getAbsolutePath());
			} else {
				System.out.println("File already exists.");
			}
		} catch (Exception e) {

			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		// #endregion
		map.put(ReadIt("morse_code.txt", true), "A");

		return map;

	} */

    static void WriteKeysToTxt(HashMap<String, String> map) {
        try {
            File newFile = new File("D:\\Cours\\UHA SERFA\\Cours JAVA\\Philippe\\Exercices_Steeven_LENEVEU\\morse_alphabet.txt");
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
                System.out.println("Absolute path: " + newFile.getAbsolutePath());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter writer = new FileWriter(newFile);
            for (String key : map.keySet()) {
                writer.write(key + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    static String FromMorseToLatin(String fileTxt) throws IOException {
        HashMap<String, String> morseMap = GetInitDico();
        String line;

        BufferedReader reader = new BufferedReader(new FileReader(fileTxt));

        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                String latinWord = "";
                String[] letters = word.split(" ");

                for (String letter : letters) {
                    String latinLetter = morseMap.get(letter);
                    if (latinLetter == null) {
                        System.out.println("Invalid character in input file: " + letter);
                        break;
                    }
                    latinWord += latinLetter;
                }
                System.out.print(latinWord + " ");
            }
            System.out.println();
        }

        reader.close();
        return fileTxt;
    }
    // #endregion

}
