
/**
 * Write a description of class BaseballRoster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BaseballRoster
{
    //fields
    private String name;
    private String city;
    private int year;
    private String[] positions;
    private String[] players;
    
    /**
     * Constructor for BaseballRoster class
     * @param String city City of the team
     * @param String name Name of the team
     * @param int year Palying year
     * @param String manager Manager of the team
     */
    public BaseballRoster(String city,String name,int year,String manager)
    {
        city = city.trim().toUpperCase();
        name = name.trim().toUpperCase();
        year = year;
        positions = new String[10];
        players = new String[positions.length];
        positions[0] = manager;
    }
    
    /**
     * Mehtod to return the city that the team plays in
     * @return String city City of the team
     */
    public String getCity()
    {
        return city;
    }
    
    /**
     * Method to return the name of the team
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method to return the playing year
     * @return int year Current playing year
     */
    public int getYear()
    {
        return year;
    }
    
    /**
     * Method to return a String with details about the team
     * @return String detailsString Details about the team
     */
    public String toString()
    {
        String detailsString = ("<"+year+"> <"+city+"> <"+name+">");
        return detailsString;
    }
    
    /**
     * Method to return a player with the specified index
     * @param int index The intex of the player to be returned
     * @return String playerString the detials of the player
     */
    public String getPlayerString(int index)
    {
        if (players[index] != null || players[index] != ""){
            String playerString = ("<"+players[index]+"> (<"+positions[index]+">)");
            return playerString;
        }
        else{
            String playerString = ("<NA> (<"+positions[index]+">)");
            return playerString;
        }
    }
    
    /**
     * Method to return the index mathcing the position
     * @param String position The position to be located
     * @return int index The index of the position
     */
    public int findIndex(String position)
    {
        position.trim().toUpperCase();
        int index = 0;
        boolean found = false;
        while (found = false){
            if(positions[index].equalsIgnoreCase(position) == true){
                found = true;
                return index;
            }
            else{
                index++;
            }
        }
        return index;
    }
    
    /**
     * Method the position of the player
     * @param String player The player to have their position returned
     * @return String position The position of that player
     */
    public String findPlayerPosition(String player)
    {
        player.trim().toUpperCase();
        int index = 0;
        boolean found = false;
        while (found = false){
            if(players[index].equalsIgnoreCase(player) == true){
                found = true;
                return positions[index];
            }
            else if(index > players.length){
                found = true;
                return ("NONE");
            }
            else{
                index++;
            }
        }
        return positions[index];
    }
    
    /**
     * Method to assign a player a position
     * @param String player Player to be assigned
     * @param String position Position to be assigned
     */
    public void assignPlayerInPosition(String player,String position)
    {
        player.trim().toUpperCase();
        position.trim().toUpperCase();
        int index = findIndex(position);
        if(index >= 0){
            positions[index] = player;
            System.out.println("ASSISGNED <"+getPlayerString(index)+">");
        }
        else{
            System.out.println("ERROR invalid position");
        }
    }
    
    /**
     * Method to remove a player from the roster
     * @param String player Player to be removed from the roster
     */
    public void takePlayerOut(String player)
    {
        player.trim().toUpperCase();
        int index = findIndex(findPlayerPosition(player));
        if (index >= 0){
            System.out.println("TAKEN OUT <"+getPlayerString(index)+">");
            players[index] = null;
        }
        else{
            System.out.println("ERROR invalid player");
        }
    }
    
    /**
     * Method to print the whole roster
     */
    public void printRoster()
    {
        System.out.println(toString());
        for(int index = 0;index <positions.length;index++){
            System.out.println(getPlayerString(index)+positions[index]);
        }
    }
    
    /**
     * Method to list only the names of the players
     */
    public void listPlayers()
    {
        System.out.println(toString());
        for(String player : players){
            System.out.println(player);
        }
    }
}
