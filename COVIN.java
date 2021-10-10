import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.lang.Math;
import javax.swing.text.GapContent;

public class COVIN
{
    
    class add_vaccine
    {

        public HashMap <String, ArrayList> vacc_rec = new HashMap<>();

        public void add__vaccine()
        {
            ArrayList<Integer> inf = new ArrayList<>();

            Scanner sc = new Scanner(System.in);
            System.out.println("Vaccine Name: ");
            String name = sc.next();
    
            System.out.println("Number of doses: ");
            int doses = sc.nextInt();
            inf.add(doses);
    
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
            
            inf.add(gap_doses);

            vacc_rec.put(name, inf);
            
            sc.close();
        }

    }

    static class add_hospital
    {
        public static HashMap < Integer,ArrayList > hospital_rec = new HashMap<>();

        public void add__hospital()
        {
            Scanner sc = new Scanner(System.in);
            ArrayList<String> info = new ArrayList<>(); 

            System.out.println("Hospital name: ");
            String hname = sc.next();
            info.add(hname);

            System.out.println("PinCode: ");
            String pincode = sc.next();
            info.add(pincode);

            int uniqueID = (int)(Math.random() * 100000) + 0;
            hospital_rec.put(uniqueID, info);

            System.out.println("Hospital Name: " + hname + ", PinCode: " + pincode + ", Unique ID: " + uniqueID+1);
            sc.close();
        }
    }

    static class Citizen
    {

        public HashMap < String, Age > citizen_rec = new HashMap<>();
        public static HashMap < String, String > citizen_na = new HashMap<>();

        public HashMap <String, String> vaccination_status = new HashMap<>();
        public static HashMap <String, ArrayList> additional_info = new HashMap<>();
        
        public void citizen_()
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
                exit(0);
                //Cannot register
            }
            else
            {
                //Else register , feed in the records.
                citizen_rec.put(uniqID,age);
                citizen_na.put(uniqID,name_cit);
                vaccination_status.put(uniID,"REGISTERED");
                
                ArrayList<Integer> addinfo = new ArrayList<>();
                addinfo.add(0);
                addinfo.add(0);
                addinfo.add(0);
                additional_info.put(uniqID,addinfo);
                
            }
            sc.close();
        }

        public void vacc_status()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Patient ID: ");
            String patID = sc.next();

            System.out.println(vaccination_status.get(patID));

            System.out.println("Vaccine Given: ");
            if(additional_info.get(patID).get(0) == 1)
            {
                System.out.print("Covax");
            }
            else
            {
                System.out.print("Covi");
            }
            
            System.out.println("Number of Doses given: " + additional_info.get(patID).get(1));
        
            if(vaccination_status.get(patID).eqauls("FULLY VACCINATED"))
            {
                int z = 1;
            }
            else
            {
                System.out.println("Next Dose due date: " + additional_info.get(patID).get(2));
            }

            sc.close();
        }
    }

    class SLOT
    {   
        public Hashmap <Integer , ArrayList> hos_cova_slot = new Hashmap<>();
        public Hashmap <Integer , ArrayList> hos_covi_slot = new Hashmap<>();

        public void create_slot()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Hospital ID: ");
            int hosID = sc.next();

            System.out.println("Enter number of slots to be added: ");
            int n = sc.nextInt();

            for(int i=0; i<n; i++)
            {
                ArrayList<Integer> book_info = new ArrayList<>();
                System.out.println("Enter Day Number: ");
                int dayno = sc.nextInt();
                book_info.add(dayno);

                System.out.println("Enter Quantity: ");
                int qty = sc.nextInt();
                book_info.add(qty);

                System.out.println("Select Vaccine");
                System.out.println("0. Covax");
                System.out.println("1. Covi");
    
                int ch = sc.nextInt();
    
                switch(ch)
                {
                    case 0: hos_cova_slot.put(hosID,book_info);
                    break;

                    case 1: hos_covi_slot.put(hosID,book_info);
                    break;
                }

                if(ch==0)
                {
                    System.out.println("Slot added by Hospital " + hosID + " for Day: " + dayno + ", Available Quantity: " + qty + " of Vaccine Covax");
                }
                else if(ch == 1)
                {
                    System.out.println("Slot added by Hospital " + hosID + " for Day: " + i + ", Available Quantity: " + qty + " of Vaccine Covi");
                }
                else
                {
                    System.out.println("Error, wrong choice");
                    exit(0);
                }
            }

            sc.close();
        }
        
        public void book_slot()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter patient Unique ID: ");
            int uniID = sc.nextInt();

            System.out.println("1. Search by area");
            System.out.println("2. Search by Vaccine");
            System.out.println("3. Exit");

            int ch;
            System.out.println("Enter option: ");
            ch = sc.nextInt();

            switch(ch)
            {
                case 1: String pin;
                System.out.println("Enter PinCode: ");
                String pinco = sc.next();

                for(Entry<Integer, String> trav : add_hospital.hospital_rec.entrySet()) 
                {
                    if (trav.getValue().get(0).equals(pinco)) 
                    {
                        int x = trav.getKey();
                        System.out.println(trav.getKey());
                        
                        ArrayList<String> y = new ArrayList<>();
                        y = add_hospital.hospital_rec.get(x);
                        System.out.print(" " + y.get(1));
                    }
                }

                System.out.println("Enter hospital id: ");
                int id = sc.nextInt();

                if(hos_cova_slot.get(id).get(1)!=0)
                {
                    System.out.println(hos_cova_slot.get(id).get(0) - 1 + "-> Day: " + hos_cova_slot.get(id).get(0) + " Available Qty:" + hos_cova_slot.get(id).get(1) + " Vaccine:Covax");  
                }
                if(hos_covi_slot.get(id).get(1)!=0)
                {
                    System.out.println(hos_covi_slot.get(id).get(0) - 1 + "-> Day: " + hos_covi_slot.get(id).get(0) + " Available Qty:" + hos_covi_slot.get(id).get(1) + " Vaccine:Covi");   
                }    

                int choice1;
                System.out.println("Choose Slot: ");
                choice1 = sc.nextInt();

                if(choice1 == 0)
                {
                    System.out.println(Citizen.citizen_na.get(uniID) + "vaccinated with Covax" );
                    Citizen.additional_info.get(uniID).set(0,1);
                    int dosess = Citizen.additional_info.get(uniID).get(1);
                    Citizen.additional_info.get(uniID).set(1, dosess+1);
                }
                else
                {
                    System.out.println(Citizen.citizen_na.get(uniID) + "vaccinated with Covi" );
                    Citizen.additional_info.get(uniID).set(0,2);
                    int dosess = Citizen.additional_info.get(uniID).get(1);
                    Citizen.additional_info.get(uniID).set(1, dosess+1);
                }

                break;

                case 2: String vac;
                System.out.println("Enter Vaccine name: ");
                String vac_name = sc.next();

                if(vac_name.equals("Covax"))
                {
                    for(HashMap.Entry trav : hos_cova_slot.entrySet())
                    {
                        System.out.println(trav.getKey() + " " + add_hospital.hospital_rec.get(trav.getKey()));
                    }
                }
                else if(vac_name.equals("Covi"))
                {
                    for(HashMap.Entry trav : hos_covi_slot.entrySet())
                    {
                        System.out.println(trav.getKey() + " " + add_hospital.hospital_rec.get(trav.getKey()));
                    }
                }
                else
                {
                    System.out.println("Wrong vaccine name, exiting...");
                    
                }

                System.out.println("Enter hospital id: ");
                String h_ID = sc.next();

                if(vac_name.equals("Covax"))
                {
                    if(hos_cova_slot.get(id).get(1)!=0)
                    {
                        System.out.println(hos_cova_slot.get(h_ID).get(0) - 1 + "-> Day: " + hos_cova_slot.get(h_ID).get(0) + " Available Qty:" + hos_cova_slot.get(id).get(1) + " Vaccine:Covax");  
                                             
                    }
                    else
                    {
                        System.out.println("No slots available");
                    }
                }
                else if(vac_name.equals("Covi"))
                {
                    if(hos_covi_slot.get(id).get(1)!=0)
                    {
                        System.out.println(hos_covi_slot.get(h_ID).get(0) - 1 + "-> Day: " + hos_covi_slot.get(h_ID).get(0) + " Available Qty:" + hos_covi_slot.get(id).get(1) + " Vaccine:Covi");  
                        
                    }
                    else
                    {
                        System.out.println("No slots available");
                        
                    }
                }
                else
                {
                    System.out.println("Wrong name of Vaccine, exiting....");
                }

                int choice2;
                System.out.println("Choose Slot: ");
                choice2 = sc.nextInt();

                if(choice2 == hos_cova_slot.get(id).get(0) - 1)
                {
                    if(vac_name.equals("Covax"))
                    {
                        System.out.println(Citizen.citizen_na.get(uniID) + "vaccinated with Covax" );
                        Citizen.additional_info.get(uniID).set(0,1);
                        int dosess = Citizen.additional_info.get(uniID).get(1);
                        Citizen.additional_info.get(uniID).set(1, dosess+1);
                    }                    
                }

                else if(choice2 == hos_covi_slot.get(id).get(0) - 1)
                {
                    if(vac_name.equals("Covi"))
                    {
                        System.out.println(Citizen.citizen_na.get(uniID) + "vaccinated with Covi" );
                        Citizen.additional_info.get(uniID).set(0,2);
                        int dosess = Citizen.additional_info.get(uniID).get(1);
                        Citizen.additional_info.get(uniID).set(1, dosess+1);
                    }
                }
                else
                {
                    System.out.println("No slot exist");
                }

                break; 
                
                case 3: System.out.println("Exiting...");
                exit(0);
            }

            sc.close();
        }

        public void availability()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Hospital ID: ");
            int hospID = sc.nextInt();

            if(hos_cova_slot.get(id).get(1)!=0)
            {
                System.out.println("Day: " + hos_cova_slot.get(id).get(0) + " Vaccine: Covax Available Qty:" + hos_cova_slot.get(id).get(1));  
            }

            if(hos_covi_slot.get(id).get(1)!=0)
            {
                System.out.println("Day: " + hos_covi_slot.get(id).get(0) + " Vaccine: Covi Available Qty:" + hos_covi_slot.get(id).get(1));  
            }

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
