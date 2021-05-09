import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.*;

import static org.junit.Assert.assertEquals;

public class PatientTest {

    @Test
    public void testtotalVisitedCount() {

            Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo");
            LocalDate date = LocalDate.now();
            hospital_chennai.add_visitDetails(date);
            hospital_chennai.add_visitDetails(date);
            hospital_chennai.add_visitDetails(date);
            hospital_chennai.add_visitDetails(date);

            Patient p1 = new Patient(2,"Rahul");
            Hospitalvisit hospital_bangalore = new Hospitalvisit("Fortis");
            LocalDate date1 = LocalDate.now();
            hospital_chennai.add_visitDetails(date1);
            hospital_chennai.add_visitDetails(date1);
            hospital_chennai.add_visitDetails(date1);
            hospital_chennai.add_visitDetails(date1);
            Patient p = new Patient(1,"Rahul");
            p1.add_patient_details(hospital_bangalore,"Bangalore");
            p1.add_patient_details(hospital_chennai,"Chennai");
            p1.add_visitcount("Chennai");
            assertEquals(1,p1.gettotalvisitedCount("Chennai"));
    }


    @Test
    public void testlast3daysVisit() {


            Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo");
            LocalDate date = LocalDate.now();
            LocalDate day1 = date.minusDays(1);
            LocalDate day2 = date.minusDays(2);
            hospital_chennai.add_visitDetails(day1);
            hospital_chennai.add_visitDetails(day2);
            hospital_chennai.add_visitDetails(date);
            Patient p = new Patient(1,"Rahul");
            p.add_patient_details(hospital_chennai,"Bangalore");
            assertEquals(3,hospital_chennai.get_lastNdaysvisit(3));
    }

    @Test
    public void testtotalvisitduringrange()
    {
            Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo");
            LocalDate date = LocalDate.now();
            LocalDate day1 = date.minusDays(1);
            LocalDate day2 = date.minusDays(2);
            hospital_chennai.add_visitDetails(day1);
            hospital_chennai.add_visitDetails(day2);
            hospital_chennai.add_visitDetails(date);
            Patient p = new Patient(1,"Rahul");
            p.add_patient_details(hospital_chennai,"Bangalore");
            assertEquals(3,hospital_chennai.get_visitDuringAtimeRange(date.minusDays(5),date.plusDays(5)));

    }



    @Test
    public void test_patient_insideBangalore() {
            Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo");
            LocalDate date = LocalDate.now();
            LocalDate day1 = date.minusDays(1);
            LocalDate day2 = date.minusDays(2);
            hospital_chennai.add_visitDetails(day1);
            hospital_chennai.add_visitDetails(day2);
            hospital_chennai.add_visitDetails(date);

            Patient p = new Patient(1,"Rohit");
            p.add_patient_details(hospital_chennai,"Bangalore");
            Patient p2 = new Patient(2,"Vivek");
            p2.add_patient_details(hospital_chennai,"Bangalore");

            Patient p1 = new Patient(1,"Varun");
            p1.add_patient_details(hospital_chennai,"Bangalore");

            Hospital hospital = new Hospital("Bangalore","Apollo");
            hospital.patientdata(p1);
            hospital.patientdata(p2);

            assertEquals(3,hospital_chennai.get_lastNdaysvisit(3));
    }
//
//
//    @Test
//    public void test_patient_outsideBangalore() {
//        Patient p = new Patient(1,"Bangalore",new Date(2021,5,1),"Apollo");
//        Patient p1 = new Patient(1,"Mangalore",new Date(2021,5,2),"Apollo");
//        Patient p2 = new Patient(1,"Mysore",new Date(2021,5,3),"Apollo");
//        Patient p3 = new Patient(1,"Bangalore",new Date(2021,5,4),"Apollo");
//        Patient p4 = new Patient(1,"Bangalore",new Date(2021,5,5),"Apollo");
//        Patient p5 = new Patient(1,"Mangalore",new Date(2021,5,6),"Apollo");
//        Patient p6 = new Patient(1,"Bangalore",new Date(2021,5,7),"Apollo");
//
//        Hospital hospital = new Hospital("Bangalore","Apollo",1);
//        hospital.add_patients(p);
//        hospital.add_patients(p1);
//        hospital.add_patients(p2);
//        hospital.add_patients(p3);
//        hospital.add_patients(p4);
//        hospital.add_patients(p5);
//        hospital.add_patients(p6);
//        assertEquals(3,7 - hospital.getsizePatients());
//    }
//
//
//    @Test
//    public void test_total_patients_visited() {
//        Patient p = new Patient(1,"Bangalore",new Date(2021,5,1),"Apollo");
//        Patient p1 = new Patient(1,"Mangalore",new Date(2021,5,2),"Apollo");
//        Patient p2 = new Patient(1,"Mysore",new Date(2021,5,3),"Fortis");
//        Patient p3 = new Patient(1,"Bangalore",new Date(2021,5,4),"Apollo");
//        Patient p4 = new Patient(1,"Bangalore",new Date(2021,5,5),"Apollo");
//        Patient p5 = new Patient(1,"Mangalore",new Date(2021,5,6),"Apollo");
//        Patient p6 = new Patient(1,"Bangalore",new Date(2021,5,7),"Apollo");
//
//        Hospital hospital = new Hospital("Bangalore","Apollo",1);
//        hospital.add_patients(p);
//        hospital.add_patients(p1);
//        hospital.add_patients(p2);
//        hospital.add_patients(p3);
//        hospital.add_patients(p4);
//        hospital.add_patients(p5);
//        hospital.add_patients(p6);
//        int total_patients = hospital.total_patients_visited();
//        assertEquals(4,total_patients);
//    }
//
//    @Test
//    public void hospital_visited() {
//
//        ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
//        hospitals.add(new Hospital("Bangalore","Apollo",1));
//        hospitals.add(new Hospital("Bangalore","Apollo",2));
//        hospitals.add(new Hospital("Bangalore","Apollo",3));
//        hospitals.add(new Hospital("Bangalore","Vellore",4));
//        hospitals.add(new Hospital("Bangalore","Fortis",5));
//
//        int count_hospital = 0;
//        for(Hospital hospital : hospitals) {
//            if(hospital.hospitalname.equals("Apollo") || hospital.hospitalname.equals("Fortis") || hospital.hospitalname.equals("Vellore")) count_hospital++;
//        }
//        assertEquals(5,count_hospital);
//
//    }


}
