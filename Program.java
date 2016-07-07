import java.lang.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Program
{    
    /**
     * This is the main entry point for the application
     */
    public static void main(String args[]) {
        Person []residents = new Person[100];
        AuthorizedPerson []authorizedPerson = new AuthorizedPerson[100];
        int totalResidents = 0;
        int totalAuthorized = 0;
        try {
        	Scanner s = new Scanner(new File("inp.dat"));
            while(s.hasNextLine()) {
                residents[totalResidents] = new Person();
            	residents[totalResidents].setName(s.nextLine());
                boolean isAuthority = false;
                if (s.nextLine().endsWith("yes"))
                    isAuthority = true;
                residents[totalResidents].setSex(s.nextLine());
                residents[totalResidents].setAge((int)Integer.parseInt(s.nextLine()));
                residents[totalResidents].setAddress(s.nextLine());
                if (isAuthority) {
                    authorizedPerson[totalAuthorized] = new AuthorizedPerson();
                    authorizedPerson[totalAuthorized].setName(residents[totalResidents].getName());
                    authorizedPerson[totalAuthorized].setAge(residents[totalResidents].getAge());
                    authorizedPerson[totalAuthorized].setSex(residents[totalResidents].getSex());
                    authorizedPerson[totalAuthorized].setAddress(residents[totalResidents].getAddress());
                    totalAuthorized++;
                }
                totalResidents++;
        	}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Done with data inputting.
        System.out.println(totalResidents+", "+totalAuthorized);
        // Query 1 - Residents elder than the requester - We query over all authorized females since
        // the answer is dependent on who the asker is.
        for (int i = 0; i < totalAuthorized; i++) {
            if (authorizedPerson[i].getSex().equals("female")) {
                int q1 = authorizedPerson[i].residentsElderThanMe(residents, totalResidents);
                System.out.println("Query 1: "+q1+", asked by - "+authorizedPerson[i].getName());
            }
        }
        // Query 2 - oldest male age. We use break here since the query output doesn't change based on
        // who is asking it.
        for (int i = 0; i < totalAuthorized; i++) {
            if (authorizedPerson[i].getSex().equals("male")) {
                int q2 = authorizedPerson[i].oldestMaleAge(residents, totalResidents);
                System.out.println("Query 2: "+q2+", asked by - "+authorizedPerson[i].getName());          
                break;
            }
        }
        // Query 3 - Find name provided an address
        for (int i = 0; i < totalAuthorized; i++) {
            if (authorizedPerson[i].getAge() < 20) {
                String q3 = authorizedPerson[i].getNameGivenAddress(residents, totalResidents, "B-14 James, Avenue ");
                System.out.println("Query 3: "+q3+", asked by - "+authorizedPerson[i].getName());
                break;
            }
        }
    }
}
