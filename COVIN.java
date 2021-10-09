import java.util.*;

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

    public static void main(String[] args) 
    {
        //end
	}

}
