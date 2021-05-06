import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PatientTest {


    @Test
    public void test_patient_insideBangalore() {
        Patient p = new Patient(1,"Bangalore",new Date(11,8,1993),"Apollo");
        Patient p1 = new Patient(1,"Mangalore",new Date(11,8,1993),"Apollo");
        Patient p2 = new Patient(1,"Mysore",new Date(11,8,1993),"Apollo");
        Patient p3 = new Patient(1,"Bangalore",new Date(11,8,1993),"Apollo");
        Patient p4 = new Patient(1,"Bangalore",new Date(11,8,1993),"Apollo");
        Patient p5 = new Patient(1,"Mangalore",new Date(11,8,1993),"Apollo");
        Patient p6 = new Patient(1,"Bangalore",new Date(11,8,1993),"Apollo");

        Hospital hospital = new Hospital("Bangalore","Apollo");
        hospital.add_patients(p);
        hospital.add_patients(p1);
        hospital.add_patients(p2);
        hospital.add_patients(p3);
        hospital.add_patients(p4);
        hospital.add_patients(p5);
        hospital.add_patients(p6);

        assertEquals(4,hospital.getsizePatients());
    }


    @Test
    public void test_patient_outsideBangalore() {
        Patient p = new Patient(1,"Bangalore",new Date(1,1,1993),"Apollo");
        Patient p1 = new Patient(1,"Mangalore",new Date(2,2,2021),"Apollo");
        Patient p2 = new Patient(1,"Mysore",new Date(3,3,2021),"Apollo");
        Patient p3 = new Patient(1,"Bangalore",new Date(4,4,2021),"Apollo");
        Patient p4 = new Patient(1,"Bangalore",new Date(5,5,2021),"Apollo");
        Patient p5 = new Patient(1,"Mangalore",new Date(6,6,2021),"Apollo");
        Patient p6 = new Patient(1,"Bangalore",new Date(7,7,2021),"Apollo");

        Hospital hospital = new Hospital("Bangalore","Apollo");
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
    public void test_Patients_During_A_TimeRange() {
        Patient p = new Patient(1,"Bangalore",new Date(1,1,1993),"Apollo");
        Patient p1 = new Patient(2,"Mangalore",new Date(2,2,2020),"Apollo");
        Patient p2 = new Patient(3,"Mysore",new Date(3,3,2020),"Apollo");
        Patient p3 = new Patient(4,"Bangalore",new Date(4,4,2020),"Apollo");
        Patient p4 = new Patient(5,"Bangalore",new Date(5,5,2021),"Apollo");
        Patient p5 = new Patient(6,"Mangalore",new Date(6,6,2021),"Apollo");
        Patient p6 = new Patient(7,"Bangalore",new Date(7,7,2021),"Apollo");

        Hospital hospital = new Hospital("Bangalore","Apollo");
        hospital.add_patients(p);
        hospital.add_patients(p1);
        hospital.add_patients(p2);
        hospital.add_patients(p3);
        hospital.add_patients(p4);
        hospital.add_patients(p5);
        hospital.add_patients(p6);

        int total_patients = hospital.getPatientInTimeDuration(new Date(1990,1,1),new Date(2021,12,30),p)
                + hospital.getPatientInTimeDuration(new Date(1990,1,1),new Date(2021,12,30),p1)
                + hospital.getPatientInTimeDuration(new Date(1990,1,1),new Date(2021,12,30),p2)
                + hospital.getPatientInTimeDuration(new Date(1990,1,1),new Date(2021,12,30),p4)
                + hospital.getPatientInTimeDuration(new Date(1990,1,1),new Date(2021,12,30),p3)
                + hospital.getPatientInTimeDuration(new Date(1990,1,1),new Date(2021,12,30),p5)
                + hospital.getPatientInTimeDuration(new Date(1990,1,1),new Date(2021,12,30),p6) ;

        assertEquals(7,total_patients);
    }
    
}
