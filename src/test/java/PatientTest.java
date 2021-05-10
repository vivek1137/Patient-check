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

            Hospitalvisit hospital1 = new Hospitalvisit("Apollo","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,5,30),LocalDate.of(2021,3,30)));
            Hospitalvisit hospital2 = new Hospitalvisit("Apollo","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,5,30),LocalDate.of(2021,3,30)));
            Patient p1 = new Patient(2,"Rahul","Chennai",Arrays.asList(hospital1,hospital2));
            Patient p = new Patient(1,"Rahul","Bangalore",Arrays.asList(hospital1,hospital2));
            assertEquals(8,p1.visitcount("Apollo"));
    }


    @Test
    public void testlast3daysVisit() {


            Hospitalvisit hospital1 = new Hospitalvisit("Apollo","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,5,30),LocalDate.of(2021,3,30)));
            Hospitalvisit hospital2 = new Hospitalvisit("Apollo","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,5,30),LocalDate.of(2021,3,30)));
            Patient p1 = new Patient(2,"Rahul","Chennai",Arrays.asList(hospital1,hospital2));
            Patient p = new Patient(1,"Rahul","Bangalore",Arrays.asList(hospital1,hospital2));
            assertEquals(2,hospital1.get_lastNdaysvisit(3));
    }

    @Test
    public void testtotalvisitduringrange()
    {
            Hospitalvisit hospital1 = new Hospitalvisit("Apollo","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,5,30),LocalDate.of(2021,3,30)));
            LocalDate date = LocalDate.now();

            Hospitalvisit hospital2 = new Hospitalvisit("Apollo","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,5,30),LocalDate.of(2021,3,30)));
            Patient p1 = new Patient(2,"Rahul","Chennai",Arrays.asList(hospital1,hospital2));
            LocalDate date1 = LocalDate.now();
            Patient p = new Patient(1,"Rahul","Bangalore",Arrays.asList(hospital1,hospital2));
            assertEquals(1,hospital1.get_visitDuringAtimeRange(date.minusDays(5),date.plusDays(5)));

    }



    @Test
    public void test_patient_insideBangalore() {
            Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,5,30),LocalDate.of(2021,3,30)));
            Hospitalvisit hospital_bangalore = new Hospitalvisit("Apollo","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,5,30),LocalDate.of(2021,3,30)));
            Patient p = new Patient(1,"Rahul","Chennai",Arrays.asList(hospital_bangalore,hospital_chennai));
            Patient p2 = new Patient(2,"Rahul","Bangalore",Arrays.asList(hospital_bangalore,hospital_chennai));
            Patient p1 = new Patient(3,"Rahul","Noida",Arrays.asList(hospital_bangalore,hospital_chennai));
            Hospital hospital = new Hospital("Bangalore","Apollo",Arrays.asList(p,p1,p2));
            assertEquals(1,hospital.getLocationPatients("Bangalore"));
    }

        @Test
        public void test_Patient_Inside_Bangalore() {
                Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,5,30),LocalDate.of(2021,3,30)));
                Hospitalvisit hospital_bangalore = new Hospitalvisit("Fortis","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,5,30),LocalDate.of(2021,3,30)));
                Patient p = new Patient(1,"Rahul","Chennai",Arrays.asList(hospital_bangalore,hospital_chennai));
                Patient p2 = new Patient(2,"Vivek","Bangalore",Arrays.asList(hospital_bangalore,hospital_chennai));
                Patient p1 = new Patient(3,"Mohit","Noida",Arrays.asList(hospital_bangalore,hospital_chennai));
                Hospital hospital = new Hospital("Bangalore","Apollo",Arrays.asList(p,p1,p2));
                assertEquals(2,hospital.getPatientsOutsideBangalore("Bangalore"));
        }


        @Test
        public void test_Patient_Outside_Bangalore() {
                Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,5,30),LocalDate.of(2021,3,30)));
                Hospitalvisit hospital_bangalore = new Hospitalvisit("Fortis","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,5,30),LocalDate.of(2021,3,30)));
                Patient p = new Patient(1,"Rahul","Chennai",Arrays.asList(hospital_bangalore,hospital_chennai));
                Patient p2 = new Patient(2,"Vivek","Bangalore",Arrays.asList(hospital_bangalore,hospital_chennai));// Patient p2 = new Patient(2,"Vivek","Chennai");
                Patient p1 = new Patient(3,"Mohit","Noida",Arrays.asList(hospital_bangalore,hospital_chennai));
                Hospital hospital = new Hospital("Bangalore","Apollo",Arrays.asList(p,p1,p2));
                assertEquals(2,hospital.getPatientsOutsideBangalore("Bangalore"));
        }
        @Test
        public void test_Patient_Ratio() {
                Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,5,30),LocalDate.of(2021,3,30)));
                Hospitalvisit hospital_bangalore = new Hospitalvisit("Fortis","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,5,30),LocalDate.of(2021,3,30)));
                LocalDate date2 = LocalDate.now();
                Patient p = new Patient(1,"Rahul","Chennai",Arrays.asList(hospital_bangalore,hospital_chennai));
                Patient p2 = new Patient(2,"Vivek","Bangalore",Arrays.asList(hospital_bangalore,hospital_chennai));
                Patient p1 = new Patient(3,"Mohit","Noida",Arrays.asList(hospital_bangalore,hospital_chennai));
                Hospital hospital = new Hospital("Bangalore","Apollo",Arrays.asList(p,p1,p2));// assertEquals(3,hospital.getRatioInsideToOutside("Bangalore"));
                assertEquals(3,hospital.getRatioInsideToOutside("Bangalore"),4);
        }

        @Test
        public void test_patientvisit_withinArange() {
                Hospitalvisit hospital_chennai = new Hospitalvisit("Apollo","Chennai",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,30),LocalDate.of(2021,12,30),LocalDate.of(2021,5,30)));
                Hospitalvisit hospital_bangalore = new Hospitalvisit("Fortis","Bangalore",Arrays.asList(LocalDate.now(),LocalDate.of(2021,1,26),LocalDate.of(2021,2,20),LocalDate.of(2021,8,30)));
                Patient p = new Patient(1,"Rahul","Chennai",Arrays.asList(hospital_bangalore,hospital_chennai));
                Patient p2 = new Patient(2,"Vivek","Bangalore",Arrays.asList(hospital_bangalore,hospital_chennai));
                Patient p1 = new Patient(3,"Mohit","Noida",Arrays.asList(hospital_bangalore,hospital_chennai));
                Hospital hospital = new Hospital("Bangalore", "Apollo",Arrays.asList(p,p1,p2));
                List<Patient> patients = hospital.getPatientList();
                LocalDate date_start = LocalDate.of(2021, 1, 5);
                LocalDate date_end = LocalDate.of(2021, 12, 30);
                long dates = 0;
                int i=0;
                for(Patient patient : patients) {
                        dates = dates + patients.get(i).getTotalVisitWithinArange(date_start, date_end);
                        i++;
                }
                assertEquals(21, dates);
        }

}
