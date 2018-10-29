import java.util.Random;
import java.util.HashMap;
import java.util.Iterator;
/**
 * A class used to keep track of employees in a company and information associated
 * with those employees
 * @author (Gustave Rosanio) 
 * @version (4/4/17)
 */
public class Company
{
    private static int max;
    private static int min;
    private Random randomGenerator;
    private String name;
    private HashMap<String,String> employees;

    /**
     * Constructor for objects of class Company
     * @param String name Name of the company
     */
    public Company(String name)
    {
        max = 100;
        min = 999;
        randomGenerator = new Random();
        name = name.trim();
        name = name.toUpperCase();
        name = name.replaceAll("\\s+","");
        this.name = name;
        employees = new HashMap<>();
    }

    /**
     * Method to get the name of the company
     * @return String name Name of the company
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method to return the employees of the company
     * @return HashMap employees
     */
    public HashMap getEmployees()
    {
        return employees;
    }
    
    /**
     * Method to get the employees of the company
     * @return int number Number of employees in the company
     */
    public int getTotalNumberEmployees()
    {
        return employees.size();
    }
    
    /**
     * Method to return a formated string after trim, uppercase
     * and replaced all between white spaces with a single space
     * @param String origString The String to be formated
     * @return String newString The formated String
     */
    public String formatString(String origString)
    {
        origString = origString.trim();
        origString = origString.toUpperCase();
        origString = origString.replaceAll("\\s+","");
        String newString = origString;
        return newString;
    }
    
    /**
     * Method to the generated ID of the employee by taking the first letter of each word in the
     * name parameter AND adding a random 3-digit integer between 100-99 (inclusive on both ends)
     * @param String name Name of the employee
     */
    public String generatedID(String name)
    {
        String firstLetter = name.substring(0);
        String lastLetter =  name.substring(name.length()-1);
        int ID;
        ID = randomGenerator.nextInt(max - min);
        String studentID = firstLetter + lastLetter + ID;
        return studentID;
    }
    
    /**
     * Mehtod to add an employee to the HashMap employees
     * @param String inputName name to be placed into the HashMap
     */
    public void addEmployee(String inputName)
    {
        if(inputName == ""){
            System.out.println("Name is INVALID");
        }else if(inputName == null){
            System.out.println("Name is INVALID");
        }
        String newString = formatString(inputName);
        if(employees.containsKey(newString)){
            System.out.println("Exising: <"+newString+">");
        }
        else{
            System.out.println("Non-exising: <"+newString+">");
        }
        String IDString = generatedID(newString);
        employees.put(newString,IDString);
        System.out.println("Employee" + newString + "with ID number" + " IDString");
    }
    
    /**
     * Method to remove employees from the HashMap employees
     * @param String inputName name to be removed form the list
     */
    public void removeEmployee(String inputName)
    {
        if(inputName == ""){
            System.out.println("Name is INVALID");
        }
        else if(inputName == null){
            System.out.println("Name is INVALID");
        }
        String newString = formatString(inputName);
        if(employees.containsKey(newString)){
            employees.remove(newString);
            System.out.println("Removed:<"+newString+">");
        }
    }
    
    /**
     * Method to remove all of the ID's from the employees collection
     * @param String id the id that matches those to be removed
     */
    public void removeIds(String id)
    {
        boolean found = false;
        if(id == ""){
            System.out.println("INVALID id");
        }else if (id == null){
            System.out.println("INVALID id");
        }
        else{
            String newString = formatString(id);
            Iterator it = employees.keySet().iterator();
            for (String values : employees.values()){
                if(it.hasNext()){
                    employees.remove(newString);
                }
            }
        }
    }
            
    /**
     * Method to list all the employees in the HashMap employees
     */   
    public void listEmployees()
    {
        System.out.println();
    }
    
}
