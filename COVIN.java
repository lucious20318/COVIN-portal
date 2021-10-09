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
        }
    }

    public static void main(String[] args) 
    {
        //end
	}

}
