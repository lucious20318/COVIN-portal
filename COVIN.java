import java.lang.reflect.Array;
import java.util.*;

import javax.lang.model.util.ElementScanner14;
import javax.print.attribute.standard.RequestingUserName;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class COWIN 
{

    static class add_vaccine
    {

        public static HashMap <String, Integer> vacc_numb = new HashMap<>();
        public static HashMap <String, Integer> vacc_gap = new HashMap<>();
        public static HashMap<Integer, String> vaccine = new HashMap<>();

        public void add__vaccine(int i)
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Vaccine Name: ");
            String name = sc.next();

            vaccine.put(i,name);
    
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

            int uniqueID = (int)(Math.random() * (999999-100000+1)+100000);
            
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
        public static HashMap <String, String> cit_name = new HashMap<>();
        public static HashMap <String, Integer> vacc_tak = new HashMap<>();
        public static HashMap <String, Integer> vacc_next = new HashMap<>();

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
                cit_name.put(uniqID,name_cit); 
                vacc_tak.put(uniqID, 0);  
                vacc_next.put(uniqID,0);
            }        
        }

        public void vacc_status()
        {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Patient ID: ");
            String patID = sc.next();

            String status = vaccination_status.get(patID);
            

            if(status.equals("PARTIALLY VACCINATED"))
            {
                System.out.println(status);
                System.out.print("Vaccine Given: " + vacc_given.get(patID));
                System.out.println();
                System.out.print("Number of Doses given: " + vacc_tak.get(patID));
                String given = vacc_given.get(patID);
                int due = add_vaccine.vacc_gap.get(given)+1;
                System.out.println();
                System.out.print("Next Dose due date: " + due);
                vacc_next.put(patID, due);
            }

            else if(status.equals("REGISTERED"))
            {
                System.out.println("Citizen REGISTERED");
                
            }
            else
            {
                System.out.println(status);
                System.out.print("Vaccine Given: " + vacc_given.get(patID));
                System.out.println();
                System.out.println("Number of Doses given: " + vacc_tak.get(patID));
            }
        }
    }

    static class SLOT
    {
        /*public static HashMap <Integer,Integer> hos_day = new HashMap<>();
        public static HashMap <Integer,Integer> hos_qty = new HashMap<>();
        public static HashMap <Integer,String> hos_vac = new HashMap<>();*/

        public static HashMap <Integer,ArrayList> hos_deets = new HashMap<>();
        public static HashMap <String, Integer> hos_vac = new HashMap<>();
        public void create_slot()
        {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Hospital ID: ");
            int hosID = sc.nextInt();

            System.out.print("Enter number of slots to be added: ");
            int n = sc.nextInt();

            for(int i=0; i<n; i++)
            {
                ArrayList<Integer> deet = new ArrayList<>();
                System.out.print("Enter Day Number: ");
                int dayno = sc.nextInt();

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
                
                deet.add(hosID);

                hos_deets.put(dayno,deet);

                String st = add_vaccine.vaccine.get(ch);

                hos_vac.put(st, hosID);

                /*hos_day.put(hosID, dayno);
                hos_qty.put(hosID, qty);
                String st = add_vaccine.vaccine.get(ch);
                hos_vac.put(hosID, st);*/

                System.out.println("Slot added by Hospital " + hosID + " for Day: " + dayno + ", Available Quantity: " + qty + " of Vaccine " + st);  
            }
        }

        public void book_slot()
        {
            Scanner sc = new Scanner(System.in);

            HashMap<Integer,String> str = new HashMap<>();

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

                for(HashMap.Entry <Integer, String> trav : add_hospital.hospital_pc.entrySet()) 
                {
                    {   
                        String h = trav.getValue();

                        if(h.equals(pinco))
                        {
                            int x = trav.getKey();
                            System.out.println(x + " " + add_hospital.hospital_na.get(x));
                        }
                    }               
                }

                System.out.print("Enter hospital id: ");
                int id = sc.nextInt();

                

                for(HashMap.Entry <Integer, ArrayList> trav : hos_deets.entrySet()) 
                {
                    {
                        ArrayList<Integer> travlist = new ArrayList<>();
                        travlist = trav.getValue();
    
                        int idd = travlist.get(2);
                        if(id == idd)
                        {
                            int x = trav.getKey();
                            int slot_no = x-1;
                            int y = travlist.get(0);
                            int z = travlist.get(1);
                            
                            int check = Citizen.vacc_next.get(uniqID);
                            if(check <= x)
                            {
                                String h = add_vaccine.vaccine.get(z);
                                str.put(slot_no, h);
                                System.out.println(slot_no + "-> Day: " + trav.getKey() + " Available Qty:" + y + " Vaccine: " + h); 
                            }
                            else
                            {
                                System.out.print("No slots available");
                                return;
                            }
                                                                             
                        }
                    }
                }  
                
                int choice;
                System.out.println("Choose Slot: ");
                choice = sc.nextInt();

                String h = str.get(choice);

                String pat = Citizen.cit_name.get(uniqID);            
                System.out.println(pat + " vaccinated with " + h);
                Citizen.vacc_given.put(uniqID, h);   
                
                for(HashMap.Entry <Integer, ArrayList> trav : hos_deets.entrySet()) 
                {
                    {
                        ArrayList<Integer> travlist = new ArrayList<>();
                        travlist = trav.getValue();
                        int hID = travlist.get(2);
                        int inde = travlist.get(1);
                        String vaa = add_vaccine.vaccine.get(inde);

                        if(vaa == h)
                        {
                            if(id == hID)
                            {
                                int z = trav.getKey();
                                int q = travlist.get(0);
                                travlist.set(0, q-1);
                                hos_deets.put(z, travlist);   
                            }
                        }
                    }
                }

                int req = add_vaccine.vacc_numb.get(h);

                int taken = Citizen.vacc_tak.get(uniqID) + 1;

                Citizen.vacc_tak.put(uniqID, taken);

                if(taken == req)
                {
                    Citizen.vaccination_status.put(uniqID, "FULLY VACCINATED");
                }
                else
                {
                    Citizen.vaccination_status.put(uniqID, "PARTIALLY VACCINATED");
                }

                break;

                case 2: System.out.print("Enter Vaccine name: ");
                String in = sc.next();

                for(HashMap.Entry <Integer, ArrayList> trav : hos_deets.entrySet()) 
                {
                    ArrayList<Integer> tra = new ArrayList<>();
                    tra = trav.getValue();
                    int w = tra.get(1);
                    String sr = add_vaccine.vaccine.get(w);

                    if(in.equals(sr))
                    {
                        int uID = tra.get(2);
                        System.out.println(uID + " " + add_hospital.hospital_na.get(uID));
                    }                                                
                } 
                
                /*for(HashMap.Entry <String,Integer> trav : hos_vac.entrySet())
                {
                    String sr = trav.getKey();

                    if(sr.equals(in))
                    {
                        int uID = trav.getValue();
                        System.out.println(uID + add_hospital.hospital_na.get(uID));
                    }
                }*/

                System.out.print("Enter hospital id:");
                int id1 = sc.nextInt();
                
                for(HashMap.Entry <Integer, ArrayList> trav : hos_deets.entrySet()) 
                {
                    {
                        ArrayList<Integer> travlist = new ArrayList<>();
                        travlist = trav.getValue();
    
                        int idd = travlist.get(2);
                        if(id1 == idd)
                        {
                            int x = trav.getKey();
                            int slot_no = x-1;
                            int y = travlist.get(0);

                            
                            int check = Citizen.vacc_next.get(uniqID);
                            if(check <= x)
                            {
                                int w = travlist.get(1);
                                String sr = add_vaccine.vaccine.get(w);
                                if(in.equals(sr))
                                {
                                    int e = travlist.get(1);
                                    String qw = add_vaccine.vaccine.get(e);
                                    str.put(slot_no, qw);
                                    System.out.println(slot_no + "-> Day: " + trav.getKey() + " Available Qty:" + y + " Vaccine: " + qw);    
                                }

                            }
                            else
                            {
                                System.out.print("No slots available");
                                return;
                            }
                                                
                        }
                    }
                } 

                int cho;
                System.out.println("Choose Slot: ");
                cho = sc.nextInt();

                String hef = str.get(cho);

                String patiID = Citizen.cit_name.get(uniqID);            
                System.out.println(patiID + " vaccinated with " + hef);
                Citizen.vacc_given.put(uniqID, hef);   
                
                for(HashMap.Entry <Integer, ArrayList> trav : hos_deets.entrySet()) 
                {
                    
                    ArrayList<Integer> travlist = new ArrayList<>();
                    travlist = trav.getValue();
                    int hID = travlist.get(2);
                    int inde = travlist.get(1);
                    String vaa = add_vaccine.vaccine.get(inde);

                    if(vaa == hef)
                    {
                        if(hID == id1)
                        {
                            int z = trav.getKey();
                            int q = travlist.get(0);
                            travlist.set(0, q-1);
                            hos_deets.put(z, travlist);                            
                        }                      
                    }
                }

                int reqd = add_vaccine.vacc_numb.get(hef);

                int take = Citizen.vacc_tak.get(uniqID) + 1;

                Citizen.vacc_tak.put(uniqID, take);

                if(take == reqd)
                {
                    Citizen.vaccination_status.put(uniqID, "FULLY VACCINATED");
                }
                else
                {
                    Citizen.vaccination_status.put(uniqID, "PARTIALLY VACCINATED");
                }

                break;

                case 3: 
                default: System.out.println("Wrong option");

            }

        }

        public void availability()
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Hospital ID: ");
            int hospID = sc.nextInt();

            /*ArrayList<Integer> details = new ArrayList<>();
            details = hos_deets.get(hospID);*/

            for(HashMap.Entry <Integer, ArrayList> trav : hos_deets.entrySet()) 
            {
                {
                    ArrayList<Integer> alist = new ArrayList<>();
                    alist = trav.getValue();
                
                    int id = alist.get(2);

                    if(id == hospID)
                    {
                        int x = trav.getKey();
                        int y = alist.get(1);
                        String h = add_vaccine.vaccine.get(y);
                        System.out.println("Day: " + x + " Vaccine: " + h + " Available Qty:" + alist.get(0));                       
                    }
                }
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

        int i = 0;

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
                add_vac.add__vaccine(i);

                i = i+1;
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
