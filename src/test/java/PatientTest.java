import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PatientTest {


    Hospital hospital = new Hospital("Bangalore");
    Patient patient_inside = new Patient(1,"Bangalore",new Date(2021,1,1));
    Patient patient_outside = new Patient(1,"Mysore",new Date(2021,1,1));
    ArrayList<Patient> patients = new ArrayList<Patient>(1000);
    Patient patient_1;
    int inside_bangalore=0;
    int outside_bangalore=0;
    @Before
    public void setup() {
        int i = 0;
        for (i = 0; i < 800; i++) {
            patient_1 = new Patient(i, "Bangalore", new Date(2020 + i % 2, i % 13, i % 31));
            hospital.addPatient(0, patient_1);
            patients.add(i,patient_1);
        }

        for (i = 800; i < 1000; i++) {
            patient_1 = new Patient(i, "Mysore", new Date(2020 + i % 2, i % 13, i % 31));
            hospital.addPatient(0, patient_1);
            patients.add(i,patient_1);
        }


        for (i = 0; i < 1000; i++) {
            if (hospital.OP_inside_Bangalore(patients.get(i)) == 1) {
                if (hospital.getPatients(new Date(2021, 1, 1), new Date(2021, 12, 31), patients.get(i)) == 1) {
                    inside_bangalore++;
                    System.out.println(inside_bangalore);
                }
            }
        }

        for (i = 0; i < 1000; i++) {
            if (hospital.OP_inside_Bangalore(patients.get(i)) == -1) {
                if (hospital.getPatients(new Date(2021, 1, 1), new Date(2021, 12, 31), patients.get(i)) == -1) {
                    outside_bangalore++;
                    System.out.println(outside_bangalore);
                }
            }
        }

    }

    @Test
    public void test_patient_insideBangalore() {
            assertEquals(1,hospital.getPatients(new Date(2021,1,1),new Date(2021,12,31),patient_inside));
    }


    @Test
    public void test_patient_outsideBangalore() {
        assertEquals(-1,hospital.getPatients(new Date(2021,1,1),new Date(2021,12,31),patient_outside));

    }

    @Test
    public void test_OutsideToInsideRatio() {
        assertEquals(1,inside_bangalore/outside_bangalore);  // inside_bangalore value is 367 and outside_bangalore value is 200 as per provided data
    }


    @Test
    public void Patients_inside_bangalore() {
        assertEquals(367,inside_bangalore);   // Ratio should be 80/20
    }

    @Test
    public void Patients_outside_bangalore() {
        assertEquals(200,outside_bangalore);   // Ratio should be 80/20
    }

    @After
    public void tearDown() {

    }
}
