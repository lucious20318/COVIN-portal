import java.util.*;
import java.lang.Math;
import javax.swing.text.GapContent;

public class COVIN
{
    
    class add_vaccine
    {
        void add__vaccine()
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Vaccine Name: ");
            String name = sc.next();
    
            System.out.println("Number of doses: ");
            int doses = sc.nextInt();
    
            int gap_doses;
    
            if (doses == 0 || doses == 1)
            {
                gap_doses = 0;
                System.out.println("Vaccine Name: " + name + ", Number of Doses: " + doses + ", Gap betweem Doses: " + gap_doses); 
            }
    
            else
            {
                System.out.println("Gap between doses: ");
                gap_doses = sc.nextInt();
                System.out.println("Vaccine Name: " + name + ", Number of Doses: " + doses + ", Gap betweem Doses: " + gap_doses);
            }
            
            sc.close();
        }

    }

    class add_hospital
    {
        void add__hospital()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Hospital name: ");
            String hname = sc.next();

            System.out.println("PinCode: ");
            String pincode = sc.next();

            int uniqueID = (int)(Math.random() * 100000) + 0;
            System.out.println("Hospital Name: " + hname + ", PinCode: " + pincode + ", Unique ID: " + uniqueID+1);

            sc.close();
        }
    }

    class Citizen
    {
        void citizen_()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Citizen Name: ");
            String name_cit = sc.next();

            System.out.println("Age: ");
            int age = sc.nextInt();

            System.out.println("Unique ID: ");
            String uniqID = sc.next();

            System.out.println("Citizen Name: " + name_cit + ", Age: " + age + ", Unique ID: " + uniqID);

            if (age < 18)
            {
                System.out.println("Only above 18 are allowed");
                //Cannot register
            }

            //Else register , feed in the records.

            sc.close();
        }

        void vacc_status()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Patient ID: ");
            String patID = sc.next();

            System.out.println("Vaccine Given: ");
            //
            System.out.println("Number if Doses given: ");
            //
            System.out.println("Next Dose due date: ");

            sc.close();
        }
    }

    class SLOT
    {
        void create_slot()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Hospital ID: ");
            String hosID = sc.next();

            System.out.println("Enter number of slots to be added: ");
            int n = sc.nextInt();

            for(int i=0; i<n; i++)
            {
                System.out.println("Enter Day Number: ");
                int dayno = sc.nextInt();
    
                System.out.println("Enter Quantity: ");
                int qty = sc.nextInt();
    
                System.out.println("Select Vaccine");
                System.out.println("0. Covax");
                System.out.println("1. Covi");
    
                int ch = sc.nextInt();
    
                switch(ch)
                {
                    case 0: 
                    case 1:
                }

                if(ch==0)
                {
                    System.out.println("Slot added by Hospital " + hosID + " for Day: " + dayno + ", Available Quantity: " + qty + " of Vaccine Covax");
                }
                else
                {
                    System.out.println("Slot added by Hospital " + hosID + " for Day: " + i + ", Available Quantity: " + qty + " of Vaccine Covi");

                }
            }

            sc.close();
        }
        
        void book_slot()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter patient Unique ID: ");
            String uniID = sc.next();

            System.out.println("1. Seach by area");
            System.out.println("2. Search by Vaccine");
            System.out.println("3. Exit");

            int ch;
            System.out.println("Enter option: ");
            ch = sc.nextInt();

            switch(ch)
            {
                case 1: String pin;
                System.out.println("Enter PinCode: ");

                //incomp

                System.ou.println("Enter hospital id: ");

                //incomp

                int choice1;
                System.out.println("Choose Slot: ");
                choice1 = sc.nextInt();

                //dash vaccinated with dash
                break;

                case 2: String vac;
                System.out.println("Enter Vaccine name: ");

                //incomp

                System.ou.println("Enter hospital id: ");

                //incomp

                int choice2;
                System.out.println("Choose Slot: ");
                choice2 = sc.nextInt();

                //dash vaccinated with dash
                break; 
                
                case 3: System.out.println("Exiting...");
                exit(0);
            }

            sc.close();
        }

        void availability()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Hospital ID: ");
            String hospID = sc.next();

            //incomp

            sc.close();
        }

    }



    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("CoWin Portal initialized...");
        System.out.println(50*'-');
        System.out.println("1. Add Vaccine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add Slot for Vaccination");
        System.out.println("5. Book Slot for Vaccination");
        System.out.println("6. List all slots for a hospital");
        System.out.println("7. Check Vaccination Status");
        System.out.println("8. Exit");
        System.out.println(50*'-');

        int opt = sc.nextInt();

        switch(opt)
        {
            case 1:  
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
        }

        sc.close();

	}

}
