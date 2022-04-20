package cs520.hw5;

public class DatabaseTest {

    public static void main(String[] args) throws DatabaseException {
        Scanner scanner = null;

        try {
            File file = new File("team.txt");
            scanner = new Scanner(file);
            Collection<Player> players = new LinkedHashSet<>();

            while (scanner.hasNextLine()) {
                String number = scanner.nextLine();
                String name = scanner.nextLine();
                String position = scanner.nextLine();
                String year = scanner.nextLine();
                scanner.nextLine();

                Player eachPlayer = createPlayer(number, name, position, year);
                players.add(eachPlayer);
            }

            Database.insertPlayers(players);

            Map<String, Player> selectedPlayers =  Database.selectPlayers();

            Iterator<String> it = selectedPlayers.keySet().iterator();
            while(it.hasNext()) {
                String key = it.next();
                System.out.println(key + ": " + selectedPlayers.get(key));
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            throw new DatabaseException();
        } finally {
            scanner.close();
        }
    }

    static Player createPlayer(String number, String name, String position, String year) throws SQLException {

        int numberInt=Integer.parseInt(number);

        Player player = new Player(name);
        player.setNumber(numberInt);
        player.setPosition(position);
        player.setYear(year);

        return player;    
    }
}
