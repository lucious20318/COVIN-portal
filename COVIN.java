import java.util.*;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class COWIN 
{

    static class add_vaccine
    {

        public HashMap <String, Integer> vacc_numb = new HashMap<>();
        public static HashMap <String, Integer> vacc_gap = new HashMap<>();
        public static ArrayList<String> vaccine = new ArrayList<>();

        public void add__vaccine()
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Vaccine Name: ");
            String name = sc.next();

            vaccine.add(name);
    
            System.out.print("Number of doses: ");
            int doses = sc.nextInt();

            vacc_numb.put(name,doses);
    
            int gap_doses;
    
            if (doses == 1)
            {
                gap_doses = 0;
                vacc_gap.put(name,doses);
                System.out.println("Vaccine Name: " + name + ", Number of Doses: " + doses + ", Gap betweem Doses: " + gap_doses); 
            }
    
            else
            {
                System.out.print("Gap between doses: ");
                gap_doses = sc.nextInt();
                vacc_gap.put(name, gap_doses);
                System.out.println("Vaccine Name: " + name + ", Number of Doses: " + doses + ", Gap betweem Doses: " + gap_doses);
            }
        }
    }

    static class add_hospital
    {
        public static HashMap < Integer,String > hospital_na = new HashMap<>();
        public static HashMap < Integer,String > hospital_pc = new HashMap<>();
        
        public void add__hospital()
        {
            Scanner sc = new Scanner(System.in);
        
            System.out.print("Hospital name: ");
            String hname = sc.next();

            System.out.print("PinCode: ");
            String pincode = sc.next();

            int uniqueID = (int)(Math.random() * ((999999-100000)+1));
            
            hospital_na.put(uniqueID, hname);
            hospital_pc.put(uniqueID, pincode);

            System.out.println("Hospital Name: " + hname + ", PinCode: " + pincode + ", Unique ID: " + uniqueID);
            
        }
    }

    static class Citizen
    {

        public static HashMap <String, String> vaccination_status = new HashMap<>();
        public static HashMap <String, Integer> vacc_dose = new HashMap<>();
        public static HashMap <String, String> vacc_given = new HashMap<>();

        public void citizen_()
        {

            Scanner sc = new Scanner(System.in);

            System.out.print("Citizen Name: ");
            String name_cit = sc.next();

            System.out.print("Age: ");
            int age = sc.nextInt();

            System.out.print("Unique ID: ");
            String uniqID = sc.next();

            System.out.println("Citizen Name: " + name_cit + ", Age: " + age + ", Unique ID: " + uniqID);        
            
            if (age < 18)
            {
                System.out.println("Only above 18 are allowed");
                //Cannot register
            }
            else
            {
                //Else register , feed in the records.
                vaccination_status.put(uniqID,"REGISTERED");   
            }        
        }

        public void vacc_status()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Patient ID: ");
            String patID = sc.next();

            String status = vaccination_status.get(patID);
            System.out.println(status);

            if(status.equals("PARTIALLY VACCINATED"))
            {
                System.out.print("Vaccine Given: " + vacc_given.get(patID));
                System.out.print("Number of Doses given: " + vacc_dose.get(patID));
                String given = vacc_given.get(patID);
                int due = add_vaccine.vacc_gap.get(given);
                System.out.print("Next Dose due date: " + due+1);
            }

            else
            {
                System.out.print("Vaccine Given: " + vacc_given.get(patID));
                System.out.print("Number of Doses given: " + vacc_dose.get(patID));
            }
        }
    }

    static class SLOT
    {
        /*public static HashMap <Integer,Integer> hos_day = new HashMap<>();
        public static HashMap <Integer,Integer> hos_qty = new HashMap<>();
        public static HashMap <Integer,String> hos_vac = new HashMap<>();*/

        public static HashMap <Integer,ArrayList> hos_deets = new HashMap<>();

        public void create_slot()
        {
            Scanner sc = new Scanner(System.in);

            ArrayList<Integer> deet = new ArrayList<>();

            System.out.print("Enter Hospital ID: ");
            int hosID = sc.nextInt();

            System.out.print("Enter number of slots to be added: ");
            int n = sc.nextInt();

            for(int i=0; i<n; i++)
            {
                System.out.print("Enter Day Number: ");
                int dayno = sc.nextInt();
                deet.add(dayno);

                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();
                deet.add(qty);

                System.out.println("Select Vaccine");

                for(int j=0; j<add_vaccine.vaccine.size(); j++)
                {
                    String s = add_vaccine.vaccine.get(j);
                    System.out.println(j + ". " + s);
                }
    
                int ch = sc.nextInt();
                deet.add(ch);
                
                hos_deets.put(hosID,deet);

                /*hos_day.put(hosID, dayno);
                hos_qty.put(hosID, qty);
                String st = add_vaccine.vaccine.get(ch);
                hos_vac.put(hosID, st);*/

                System.out.println("Slot added by Hospital " + hosID + " for Day: " + dayno + ", Available Quantity: " + qty + " of Vaccine " + st);  
            }
        }

        public void book_slot()
        {
            System.out.print("Enter patient Unique ID: ");
            String uniqID = sc.next();

            System.out.println("1. Search by area");
            System.out.println("2. Search by Vaccine");
            System.out.println("3. Exit");

            int ch;
            System.out.print("Enter option: ");
            ch = sc.nextInt();

            switch(ch)
            {
                case 1: System.out.print("Enter PinCode: ");
                String pinco = sc.next();

                
            }

        }

        public void availability()
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Hospital ID: ");
            int hospID = sc.nextInt();

            ArrayList<Integer> details = new ArrayList<>();
            details = hos_deets.get(hospID);

            int ind = details.get(2);
            String va = add_vaccine.vaccine.get(ind);

            System.out.println("Day: " + details.get(0) + " Vaccine: " + va + " Available Qty:" + details.get(1));  
        } 
    }


    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        add_vaccine add_vac = new add_vaccine();
        add_hospital add_ho = new add_hospital();
        Citizen citrec = new Citizen();
        SLOT slott = new SLOT();

        while(true)
        {
            System.out.println("");
            System.out.println("CoWin Portal initialized...");
            System.out.println("---------------------------------");
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination");
            System.out.println("6. List all slots for a hospital");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.println("---------------------------------");
    
            int opt = sc.nextInt();
            
            if(opt == 1)
            {
                add_vac.add__vaccine();
            }

            else if(opt == 2)
            {
                add_ho.add__hospital();
            }

            else if(opt == 3)
            {
                citrec.citizen_();
            }

            else if(opt == 4)
            {
                slott.create_slot();
            }

            else if(opt == 5)
            {
                slott.book_slot();
            }
            
            else if(opt == 6)
            {
                slott.availability();
            }

            else if(opt == 7)
            {
                citrec.vacc_status();
            }

            else if(opt == 8)
            {
                System.exit(0);
            }
            else
            {
                System.out.println("Wrong option");
            }
        }
    }    
}
