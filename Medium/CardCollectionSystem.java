import java.util.*;

class CardCollection {
    private HashMap<String, List<String>> cardMap;
    private Scanner scanner;

    public CardCollection() {
        cardMap = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void addCard() {
        System.out.print("Enter Card Symbol (e.g., Hearts, Spades): ");
        String symbol = scanner.nextLine();
        System.out.print("Enter Card Name (e.g., Ace, King, 2): ");
        String name = scanner.nextLine();

        cardMap.putIfAbsent(symbol, new ArrayList<>());
        cardMap.get(symbol).add(name);

        System.out.println("Card added successfully!\n");
    }

    public void searchCardsBySymbol() {
        System.out.print("Enter Card Symbol to search: ");
        String symbol = scanner.nextLine();
        
        if (cardMap.containsKey(symbol)) {
            System.out.println("Cards of " + symbol + ": " + cardMap.get(symbol) + "\n");
        } else {
            System.out.println("No cards found for symbol: " + symbol + "\n");
        }
    }

    public void displayAllCards() {
        System.out.println("All Stored Cards:");
        for (Map.Entry<String, List<String>> entry : cardMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    public void start() {
        while (true) {
            System.out.println("Card Collection System");
            System.out.println("1. Add Card");
            System.out.println("2. Search Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    searchCardsBySymbol();
                    break;
                case 3:
                    displayAllCards();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice, try again!\n");
            }
        }
    }

    public static void main(String[] args) {
        CardCollection collection = new CardCollection();
        collection.start();
    }
}
