import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PatientTest {

    @Test
    public void  test_Specificpatient_visited_lastNDays() {
        Patient p = new Patient(1,"Bangalore",new Date(2019,1,30),"Apollo");
        Patient p1 = new Patient(2,"Mangalore",new Date(2018,2,30),"Apollo");
        Patient p2 = new Patient(3,"Mysore",new Date(2017,3,30),"Apollo");
        Patient p3 = new Patient(4,"Bangalore",new Date(2016,4,30),"Apollo");
        Patient p4 = new Patient(5,"Bangalore",new Date(2015,5,30),"Apollo");
        Patient p5 = new Patient(6,"Mangalore",new Date(2014,6,30),"Apollo");
        Patient p6 = new Patient(7,"Bangalore",new Date(2013,7,30),"Apollo");

        Hospital hospital = new Hospital("Bangalore","Apollo",1);
        hospital.add_patients(p);
        hospital.add_patients(p1);
        hospital.add_patients(p2);
        hospital.add_patients(p3);
        hospital.add_patients(p4);
        hospital.add_patients(p5);
        hospital.add_patients(p6);

        int total_patients_visited = hospital.get_Specificpatient_visited_currently(3);
        assertEquals(1,total_patients_visited);
    }
    @Test
    public void  test_patient_visited_lastNDays() {
        Patient p = new Patient(1,"Bangalore",new Date(2019,1,30),"Apollo");
        Patient p1 = new Patient(2,"Mangalore",new Date(2018,2,30),"Apollo");
        Patient p2 = new Patient(3,"Mysore",new Date(2017,3,30),"Apollo");
        Patient p3 = new Patient(4,"Bangalore",new Date(2016,4,30),"Apollo");
        Patient p4 = new Patient(5,"Bangalore",new Date(2015,5,30),"Apollo");
        Patient p5 = new Patient(6,"Mangalore",new Date(2014,6,30),"Apollo");
        Patient p6 = new Patient(7,"Bangalore",new Date(2013,7,30),"Apollo");

        Hospital hospital = new Hospital("Bangalore","Apollo");
        hospital.add_patients(p);
        hospital.add_patients(p1);
        hospital.add_patients(p2);
        hospital.add_patients(p3);
        hospital.add_patients(p4);
        hospital.add_patients(p5);
        hospital.add_patients(p6);

        int total_patients_visited = hospital.get_patients_visited_currently(3);
        assertEquals(4,total_patients_visited);
    }

    @Test
    public void test_Patients_During_A_TimeRange() {
        Patient p = new Patient(1,"Bangalore",new Date(2019,1,30),"Apollo");
        Patient p1 = new Patient(2,"Mangalore",new Date(2018,2,30),"Apollo");
        Patient p2 = new Patient(3,"Mysore",new Date(2017,3,30),"Apollo");
        Patient p3 = new Patient(4,"Bangalore",new Date(2016,4,30),"Apollo");
        Patient p4 = new Patient(5,"Bangalore",new Date(2015,5,30),"Apollo");
        Patient p5 = new Patient(6,"Mangalore",new Date(2014,6,30),"Apollo");
        Patient p6 = new Patient(7,"Bangalore",new Date(2013,7,30),"Apollo");

        Hospital hospital = new Hospital("Bangalore","Apollo",1);
        hospital.add_patients(p);
        hospital.add_patients(p1);
        hospital.add_patients(p2);
        hospital.add_patients(p3);
        hospital.add_patients(p4);
        hospital.add_patients(p5);
        hospital.add_patients(p6);

        int total_patients = hospital.getPatientInTimeDuration(new Date(1990,1,1),new Date(2021,12,30));
        assertEquals(4,total_patients);
    }

    @Test
    public void test_patient_insideBangalore() {
        Patient p = new Patient(1,"Bangalore",new Date(2021,5,1),"Apollo");
        Patient p1 = new Patient(1,"Mangalore",new Date(2021,5,2),"Apollo");
        Patient p2 = new Patient(1,"Mysore",new Date(2021,5,3),"Apollo");
        Patient p3 = new Patient(1,"Bangalore",new Date(2021,5,4),"Apollo");
        Patient p4 = new Patient(1,"Bangalore",new Date(2021,5,5),"Apollo");
        Patient p5 = new Patient(1,"Mangalore",new Date(2021,5,6),"Apollo");

        Hospital hospital = new Hospital("Bangalore","Apollo",1);
        hospital.add_patients(p);
        hospital.add_patients(p1);
        hospital.add_patients(p2);
        hospital.add_patients(p3);
        hospital.add_patients(p4);
        hospital.add_patients(p5);

        assertEquals(3,hospital.getsizePatients());
    }


    @Test
    public void test_patient_outsideBangalore() {
        Patient p = new Patient(1,"Bangalore",new Date(2021,5,1),"Apollo");
        Patient p1 = new Patient(1,"Mangalore",new Date(2021,5,2),"Apollo");
        Patient p2 = new Patient(1,"Mysore",new Date(2021,5,3),"Apollo");
        Patient p3 = new Patient(1,"Bangalore",new Date(2021,5,4),"Apollo");
        Patient p4 = new Patient(1,"Bangalore",new Date(2021,5,5),"Apollo");
        Patient p5 = new Patient(1,"Mangalore",new Date(2021,5,6),"Apollo");
        Patient p6 = new Patient(1,"Bangalore",new Date(2021,5,7),"Apollo");

        Hospital hospital = new Hospital("Bangalore","Apollo",1);
        hospital.add_patients(p);
        hospital.add_patients(p1);
        hospital.add_patients(p2);
        hospital.add_patients(p3);
        hospital.add_patients(p4);
        hospital.add_patients(p5);
        hospital.add_patients(p6);
        assertEquals(3,7 - hospital.getsizePatients());
    }


    @Test
    public void test_total_patients_visited() {
        Patient p = new Patient(1,"Bangalore",new Date(2021,5,1),"Apollo");
        Patient p1 = new Patient(1,"Mangalore",new Date(2021,5,2),"Apollo");
        Patient p2 = new Patient(1,"Mysore",new Date(2021,5,3),"Fortis");
        Patient p3 = new Patient(1,"Bangalore",new Date(2021,5,4),"Apollo");
        Patient p4 = new Patient(1,"Bangalore",new Date(2021,5,5),"Apollo");
        Patient p5 = new Patient(1,"Mangalore",new Date(2021,5,6),"Apollo");
        Patient p6 = new Patient(1,"Bangalore",new Date(2021,5,7),"Apollo");

        Hospital hospital = new Hospital("Bangalore","Apollo",1);
        hospital.add_patients(p);
        hospital.add_patients(p1);
        hospital.add_patients(p2);
        hospital.add_patients(p3);
        hospital.add_patients(p4);
        hospital.add_patients(p5);
        hospital.add_patients(p6);
        int total_patients = hospital.total_patients_visited();
        assertEquals(4,total_patients);
    }

    @Test
    public void hospital_visited() {   // This tc is not complete
        Patient p = new Patient(1,"Bangalore",new Date(2021,5,1),"Apollo");
        Patient p1 = new Patient(1,"Mangalore",new Date(2021,5,2),"Apollo");
        Patient p2 = new Patient(1,"Mysore",new Date(2021,5,3),"Apollo");
        Patient p3 = new Patient(1,"Bangalore",new Date(2021,5,4),"Fortis");
        Patient p4 = new Patient(2,"Bangalore",new Date(2021,5,5),"Apollo");
        Patient p5 = new Patient(1,"Mangalore",new Date(2021,5,6),"Apollo");
        Patient p6 = new Patient(3,"Bangalore",new Date(2021,5,7),"Apollo");

        ArrayList<Hospital> hospitals = new ArrayList<Hospital>();
        hospitals.add(new Hospital("Bangalore","Apollo",1));
        hospitals.add(new Hospital("Bangalore","Apollo",2));
        hospitals.add(new Hospital("Bangalore","Apollo",3));
        hospitals.add(new Hospital("Bangalore","Vellore",4));
        hospitals.add(new Hospital("Bangalore","Fortis",5));
        int count_hospital = 0;
        for(Hospital hospital : hospitals) {
            if(hospital.hospitalname.equals("Apollo") || hospital.hospitalname.equals("Fortis") || hospital.hospitalname.equals("Vellore")) count_hospital++;
        }
        assertEquals(5,count_hospital);

    }


}
