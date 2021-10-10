import java.util.*;

import java.lang.Math;

public class COVIN
{

    static class add_vaccine
    {

        public HashMap <String, ArrayList> vacc_rec = new HashMap<>();

        public void add__vaccine()
        {
            ArrayList<Integer> inf = new ArrayList<>();

            Scanner sc = new Scanner(System.in);
            System.out.print("Vaccine Name: ");
            String name = sc.next();
    
            System.out.print("Number of doses: ");
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
                System.out.print("Gap between doses: ");
                gap_doses = sc.nextInt();
                System.out.println("Vaccine Name: " + name + ", Number of Doses: " + doses + ", Gap betweem Doses: " + gap_doses);
            }
            
            inf.add(gap_doses);

            vacc_rec.put(name, inf);
        }

    }

    static class add_hospital
    {
        public static HashMap < Integer,ArrayList > hospital_rec = new HashMap<>();

        public void add__hospital()
        {
            Scanner sc = new Scanner(System.in);
            ArrayList<String> info = new ArrayList<>(); 

            System.out.print("Hospital name: ");
            String hname = sc.next();
            info.add(hname);

            System.out.print("PinCode: ");
            String pincode = sc.next();
            info.add(pincode);

            int uniqueID = (int)(Math.random() * 100000) + 0;
            hospital_rec.put(uniqueID, info);

            System.out.println("Hospital Name: " + hname + ", PinCode: " + pincode + ", Unique ID: " + uniqueID);
            
        }
    }

    static class Citizen
    {

        public HashMap < String, Integer > citizen_rec = new HashMap<>();
        public static HashMap < String, String > citizen_na = new HashMap<>();

        public static HashMap <String, String> vaccination_status = new HashMap<>();
        public static HashMap <String, ArrayList> additional_info = new HashMap<>();
        
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
                citizen_rec.put(uniqID,age);
                citizen_na.put(uniqID,name_cit);
                vaccination_status.put(uniqID,"REGISTERED");
                
                ArrayList<Integer> addinfo = new ArrayList<>();
                addinfo.add(0);
                addinfo.add(0);
                addinfo.add(0);
                additional_info.put(uniqID,addinfo);
                
            }
           
        }

        public void vacc_status()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Patient ID: ");
            String patID = sc.next();

            System.out.println(vaccination_status.get(patID));

            System.out.print("Vaccine Given: ");

            ArrayList<Integer> vacstat = new ArrayList<>();
            vacstat = additional_info.get(patID); 

            if(vacstat.get(0) == 1)
            {
                System.out.print(" Covax");
            }
            else
            {
                System.out.print("Covi");
            }
            System.out.println();
            System.out.println("Number of Doses given: " + vacstat.get(1));
        
            String stat = vaccination_status.get(patID);
            if(stat.equals("FULLY VACCINATED"))
            {
                int z = 1;
            }
            else
            {
                System.out.println("Next Dose due date: " + vacstat.get(2));
            }
        }
    }

    static class SLOT
    {   
        public HashMap <Integer , ArrayList> hos_cova_slot = new HashMap<>();
        public HashMap <Integer , ArrayList> hos_covi_slot = new HashMap<>();

        public void create_slot()
        {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Hospital ID: ");
            int hosID = sc.nextInt();

            System.out.print("Enter number of slots to be added: ");
            int n = sc.nextInt();

            for(int i=0; i<n; i++)
            {
                ArrayList<Integer> book_info = new ArrayList<>();
                System.out.print("Enter Day Number: ");
                int dayno = sc.nextInt();
                book_info.add(dayno);

                System.out.print("Enter Quantity: ");
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
                    System.out.println("Slot added by Hospital " + hosID + " for Day: " + dayno + ", Available Quantity: " + qty + " of Vaccine Covi");
                }
                else
                {
                    System.out.println("Error, wrong choice");
                    
                }
            }

        }
        
        public void book_slot()
        {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter patient Unique ID: ");
            String uniID = sc.next();

            System.out.println("1. Search by area");
            System.out.println("2. Search by Vaccine");
            System.out.println("3. Exit");

            int ch;
            System.out.print("Enter option: ");
            ch = sc.nextInt();

            switch(ch)
            {
                case 1: 
                System.out.print("Enter PinCode: ");
                String pinco = sc.next();

                for(HashMap.Entry <Integer, ArrayList> trav : add_hospital.hospital_rec.entrySet()) 
                {
                    {
                        ArrayList<String> alist = new ArrayList<>();
                        
                        alist = trav.getValue();
                        
                        String h = alist.get(1);
                        
                        if(h.equals(pinco))
                        {
                            int x = trav.getKey();
                            System.out.println(x + " " + alist.get(0));
                        }
                    }
   

                    /*if (trav.getValue().get(0).equals(pinco)) 
                    {
                        int x = trav.getKey();
                        System.out.println(x);
                        
                        ArrayList<String> y = new ArrayList<>();
                        y = add_hospital.hospital_rec.get(x);
                        System.out.print(" " + y.get(1));
                    }*/
                }

                System.out.print("Enter hospital id: ");
                int id = sc.nextInt();

                ArrayList <Integer> inf_cova = new ArrayList<>();
                ArrayList <Integer> inf_covi = new ArrayList<>(); 

                inf_cova = hos_cova_slot.get(id);
                inf_covi = hos_covi_slot.get(id);

                if(inf_cova.get(1) != 0)
                {
                    System.out.println(inf_cova.get(0) - 1 + "-> Day: " + inf_cova.get(0) + " Available Qty:" + inf_cova.get(1) + " Vaccine:Covax");  
                }

                if(inf_covi.get(1) !=0)
                {
                    System.out.println(inf_covi.get(0) - 1 + "-> Day: " + inf_covi.get(0) + " Available Qty:" + inf_covi.get(1) + " Vaccine:Covi");   
                }    

                int choice1;
                System.out.print("Choose Slot: ");
                choice1 = sc.nextInt();

                if(choice1 == 0)
                {
                    System.out.println(Citizen.citizen_na.get(uniID) + " vaccinated with Covax" );
                    ArrayList <Integer> citinf = new ArrayList<>();
                    citinf = Citizen.additional_info.get(uniID);
                    Citizen.vaccination_status.put(uniID,"PARTIALLY VACCINATED");
                    citinf.set(0,1);

                    ArrayList<Integer> dossinf = new ArrayList<>();
                    dossinf = Citizen.additional_info.get(uniID); 
                    int dosess = dossinf.get(1);
                    Citizen.additional_info.get(uniID).set(1, dosess+1);
                }
                else
                {
                    System.out.println(Citizen.citizen_na.get(uniID) + " vaccinated with Covi" );

                    ArrayList <Integer> citinf = new ArrayList<>();
                    citinf = Citizen.additional_info.get(uniID);
                    Citizen.vaccination_status.put(uniID,"PARTIALLY VACCINATED");
                    citinf.set(0,2);

                    ArrayList<Integer> dosinf = new ArrayList<>();
                    dosinf = Citizen.additional_info.get(uniID);
                    int dosess = dosinf.get(1);
                    dosinf.set(1,dosess + 1);
                }

                break;

                case 2: 
                System.out.println("Enter Vaccine name: ");
                String vac_name = sc.next();

                if(vac_name.equals("Covax"))
                {
                    for(HashMap.Entry trav : hos_cova_slot.entrySet())
                    {
                        ArrayList<String> xyz = new ArrayList<>();
                        xyz = add_hospital.hospital_rec.get(trav.getKey());
                        System.out.println(trav.getKey() + " " + xyz.get(0));
                    }
                }
                else if(vac_name.equals("Covi"))
                {
                    for(HashMap.Entry trav : hos_covi_slot.entrySet())
                    {
                        ArrayList<String> xyz = new ArrayList<>();
                        xyz = add_hospital.hospital_rec.get(trav.getKey());
                        System.out.println(trav.getKey() + " " + xyz.get(0));
                    }
                }
                else
                {
                    System.out.println("Wrong vaccine name, exiting...");
                    
                }

                System.out.println("Enter hospital id: ");
                String h_ID = sc.next();

                ArrayList<Integer> slot_info = new ArrayList<>();
                slot_info = hos_cova_slot.get(h_ID);
                
                ArrayList<Integer> slot_info2 = new ArrayList<>();
                slot_info2 = hos_covi_slot.get(h_ID);

                if(vac_name.equals("Covax"))
                {
                    if(slot_info.size() == 0)
                    {
                        System.out.println("No slots available");
                    }
                    else if(slot_info.get(1)!=0)
                    {                        
                        System.out.println(slot_info.get(0) - 1 + "-> Day: " + slot_info.get(0) + " Available Qty:" + slot_info.get(1) + " Vaccine:Covax");                      
                    }

                    else
                    {
                        System.out.println("No slots available");
                    }
                }

                if(vac_name.equals("Covi"))
                {
                    if(slot_info.size() == 0)
                    {
                        System.out.println("No slots available");
                    }

                    else if(slot_info2.get(1)!=0)
                    {   
                        System.out.println(slot_info2.get(0) - 1 + "-> Day: " + slot_info2.get(0) + " Available Qty:" + slot_info2.get(1) + " Vaccine:Covi");  
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

                if(choice2 == slot_info.get(0) - 1)
                {
                    if(vac_name.equals("Covax"))
                    {
                        System.out.println(Citizen.citizen_na.get(uniID) + "vaccinated with Covax" );
                        ArrayList <Integer> citinf = new ArrayList<>();
                        citinf = Citizen.additional_info.get(uniID);
                        Citizen.vaccination_status.put(uniID,"PARTIALLY VACCINATED");
                        citinf.set(0,1);
    
                        ArrayList<Integer> dossinf = new ArrayList<>();
                        dossinf = Citizen.additional_info.get(uniID); 
                        Citizen.vaccination_status.put(uniID,"PARTIALLY VACCINATED");
                        int dosess = dossinf.get(1);
                        Citizen.additional_info.get(uniID).set(1, dosess+1);
                    }                    
                }

                else if(choice2 == slot_info2.get(0) - 1)
                {
                    if(vac_name.equals("Covi"))
                    {
                        System.out.println(Citizen.citizen_na.get(uniID) + "vaccinated with Covi" );
                        ArrayList <Integer> citinf = new ArrayList<>();
                        citinf = Citizen.additional_info.get(uniID);
                        Citizen.vaccination_status.put(uniID,"PARTIALLY VACCINATED");
                        citinf.set(0,2);
    
                        ArrayList<Integer> dosinf = new ArrayList<>();
                        dosinf = Citizen.additional_info.get(uniID);
                        Citizen.vaccination_status.put(uniID,"PARTIALLY VACCINATED");
                        int dosess = dosinf.get(1);
                        dosinf.set(1,dosess + 1);
                    }
                }
                else
                {
                    System.out.println("No slot exist");
                }

                break; 
                
                case 3: System.out.println("Exiting...");
                

            }

            
        }

        public void availability()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Hospital ID: ");
            int hospID = sc.nextInt();

            ArrayList<Integer> ava_cova = new ArrayList<>();
            ArrayList<Integer> ava_covi = new ArrayList<>();
            ava_cova = hos_cova_slot.get(hospID);
            ava_covi = hos_covi_slot.get(hospID);

            if(ava_cova.get(1)!=0)
            {
                System.out.println("Day: " + ava_cova.get(0) + " Vaccine: Covax Available Qty:" + ava_cova.get(1));  
            }

            if(ava_covi.get(1)!=0)
            {
                System.out.println("Day: " + ava_covi.get(0) + " Vaccine: Covi Available Qty:" + ava_covi.get(1));  
            }

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
