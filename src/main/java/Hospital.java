import java.util.ArrayList;
import java.util.Date;

public class Hospital {

    private String location;
    private String name;
    ArrayList<Patient> patient_inside = new ArrayList<Patient>();

    public Hospital(String location,String name) {
        this.location = location;
        this.name = name;
    }

    public void add_patients(Patient patient)   // Patient added only when both location hospital name is same
    {
        if(patient.getLocation().equals(this.location) && patient.hospital_name.equals(this.name)) {
            patient_inside.add(patient);
        }
    }

    public int getPatientInTimeDuration(Date date1,Date date2, Patient patient) {
        if(patient.getConsultationDate().compareTo(date1) <= 0 && patient.getConsultationDate().compareTo(date2) >= 0) {
            return -1;
        }
        return 1;
    }
    public int getsizePatients()
    {
        return patient_inside.size();
    }
}




