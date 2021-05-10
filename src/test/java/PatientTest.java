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

            Hospitalvisit hospital1 = new Hospitalvisit("Apollo","Chennai");
            LocalDate date = LocalDate.now();
            hospital1.add_visitDetails(date);
            hospital1.add_visitDetails(date);
            hospital1.add_visitDetails(date);
            hospital1.add_visitDetails(date);

            Patient p1 = new Patient(2,"Rahul","Chennai");
            Hospitalvisit hospital2 = new Hospitalvisit("Fortis","Bangalore");
            LocalDate date1 = LocalDate.now();
            hospital2.add_visitDetails(date1);
            hospital2.add_visitDetails(date1);
            hospital2.add_visitDetails(date1);
            hospital2.add_visitDetails(date1);
            Patient p = new Patient(1,"Rahul","Bangalore");
            p1.hospital_visit_details(hospital1);
            p1.hospital_visit_details(hospital2);
            assertEquals(4,p1.visitcount("Apollo"));
    }


    @Test
    public void testlast3daysVisit() {


            Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo","Chennai");
            LocalDate date = LocalDate.now();
            LocalDate day1 = date.minusDays(1);
            LocalDate day2 = date.minusDays(2);
            hospital_chennai.add_visitDetails(day1);
            hospital_chennai.add_visitDetails(day2);
            hospital_chennai.add_visitDetails(date);
            Patient p = new Patient(1,"Rahul","Bangalore");
            p.hospital_visit_details(hospital_chennai);
            assertEquals(3,hospital_chennai.get_lastNdaysvisit(3));
    }

    @Test
    public void testtotalvisitduringrange()
    {
            Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo","Chennai");
            LocalDate date = LocalDate.now();
            LocalDate day1 = date.minusDays(1);
            LocalDate day2 = date.minusDays(2);
            hospital_chennai.add_visitDetails(day1);
            hospital_chennai.add_visitDetails(day2);
            hospital_chennai.add_visitDetails(date);
            Patient p = new Patient(1,"Rahul","Bangalore");
            p.hospital_visit_details(hospital_chennai);
            assertEquals(3,hospital_chennai.get_visitDuringAtimeRange(date.minusDays(5),date.plusDays(5)));

    }



    @Test
    public void test_patient_insideBangalore() {
            Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo","Chennai");
            LocalDate date = LocalDate.now();
            LocalDate day1 = date.minusDays(1);
            LocalDate day2 = date.minusDays(2);
            hospital_chennai.add_visitDetails(day1);
            hospital_chennai.add_visitDetails(day2);
            hospital_chennai.add_visitDetails(date);

            Hospitalvisit hospital_bangalore = new Hospitalvisit("Fortis","Bangalore");
            LocalDate date2 = LocalDate.now();
            LocalDate day3 = date.minusDays(1);
            LocalDate day4 = date.minusDays(2);
            hospital_chennai.add_visitDetails(date2);
            hospital_chennai.add_visitDetails(day3);
            hospital_chennai.add_visitDetails(day4);

            Patient p = new Patient(1,"Rohit","Bangalore");
            p.hospital_visit_details(hospital_chennai);
            p.hospital_visit_details(hospital_bangalore);

            Patient p2 = new Patient(2,"Vivek","Chennai");
            p2.hospital_visit_details(hospital_chennai);

            Patient p1 = new Patient(1,"Varun","Bangalore");
            p1.hospital_visit_details(hospital_chennai);

            Hospital hospital = new Hospital("Bangalore","Apollo");
            hospital.init_patientdata();
            hospital.add_patients_registered(p1);
            hospital.add_patients_registered(p1);
            hospital.add_patients_registered(p2);
            assertEquals(6,hospital.getLocationPatients("Bangalore"));
    }

        @Test
        public void test_Patient_Inside_Bangalore() {
                Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo","Chennai");
                LocalDate date = LocalDate.now();
                LocalDate day1 = date.minusDays(1);
                LocalDate day2 = date.minusDays(2);
                hospital_chennai.add_visitDetails(day1);
                hospital_chennai.add_visitDetails(day2);
                hospital_chennai.add_visitDetails(date);

                Hospitalvisit hospital_bangalore = new Hospitalvisit("Fortis","Bangalore");
                LocalDate date2 = LocalDate.now();
                LocalDate day3 = date.minusDays(1);
                LocalDate day4 = date.minusDays(2);
                hospital_chennai.add_visitDetails(date2);
                hospital_chennai.add_visitDetails(day3);
                hospital_chennai.add_visitDetails(day4);

                Patient p = new Patient(1,"Rohit","Bangalore");
                p.hospital_visit_details(hospital_chennai);
                p.hospital_visit_details(hospital_bangalore);

                Patient p2 = new Patient(2,"Vivek","Chennai");
                p2.hospital_visit_details(hospital_chennai);

                Patient p1 = new Patient(1,"Varun","Bangalore");
                p1.hospital_visit_details(hospital_chennai);

                Hospital hospital = new Hospital("Bangalore","Apollo");
                hospital.init_patientdata();
                assertEquals(3,hospital.getPatientsOutsideBangalore("Bangalore"));
        }


        @Test
        public void test_Patient_Outside_Bangalore() {
                Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo","Chennai");
                LocalDate date = LocalDate.now();
                LocalDate day1 = date.minusDays(1);
                LocalDate day2 = date.minusDays(2);
                hospital_chennai.add_visitDetails(day1);
                hospital_chennai.add_visitDetails(day2);
                hospital_chennai.add_visitDetails(date);

                Hospitalvisit hospital_bangalore = new Hospitalvisit("Fortis","Bangalore");
                LocalDate date2 = LocalDate.now();
                LocalDate day3 = date.minusDays(1);
                LocalDate day4 = date.minusDays(2);
                hospital_chennai.add_visitDetails(date2);
                hospital_chennai.add_visitDetails(day3);
                hospital_chennai.add_visitDetails(day4);

                Patient p = new Patient(1,"Rohit","Bangalore");
                p.hospital_visit_details(hospital_chennai);
                p.hospital_visit_details(hospital_bangalore);

                Patient p2 = new Patient(2,"Vivek","Chennai");
                p2.hospital_visit_details(hospital_chennai);

                Patient p1 = new Patient(1,"Varun","Bangalore");
                p1.hospital_visit_details(hospital_chennai);

                Hospital hospital = new Hospital("Bangalore","Apollo");
                hospital.init_patientdata();
                assertEquals(3,hospital.getPatientsOutsideBangalore("Bangalore"));
        }
        @Test
        public void test_Patient_Ratio() {
                Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo","Chennai");
                LocalDate date = LocalDate.now();
                LocalDate day1 = date.minusDays(1);
                LocalDate day2 = date.minusDays(2);
                hospital_chennai.add_visitDetails(day1);
                hospital_chennai.add_visitDetails(day2);
                hospital_chennai.add_visitDetails(date);

                Hospitalvisit hospital_bangalore = new Hospitalvisit("Fortis","Bangalore");
                LocalDate date2 = LocalDate.now();
                LocalDate day3 = date.minusDays(1);
                LocalDate day4 = date.minusDays(2);
                hospital_chennai.add_visitDetails(date2);
                hospital_chennai.add_visitDetails(day3);
                hospital_chennai.add_visitDetails(day4);

                Patient p = new Patient(1,"Rohit","Bangalore");
                p.hospital_visit_details(hospital_chennai);
                p.hospital_visit_details(hospital_bangalore);

                Patient p2 = new Patient(2,"Vivek","Chennai");
                p2.hospital_visit_details(hospital_chennai);

                Patient p1 = new Patient(1,"Varun","Bangalore");
                p1.hospital_visit_details(hospital_chennai);

                Hospital hospital = new Hospital("Bangalore","Apollo");
                hospital.init_patientdata();
               // assertEquals(3,hospital.getRatioInsideToOutside("Bangalore"));
                assertEquals(3,hospital.getRatioInsideToOutside("Bangalore"),4);
        }

}
