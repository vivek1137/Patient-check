import java.util.ArrayList;
import java.util.Date;

public class Hospital {

    private String location;
    private String name;
    private String city;

    ArrayList<Patient> patient = new ArrayList<Patient>();

    public Hospital(String location) {
        this.location = location;
    }

    private String getLocation() {
        return location;
    }

    private String getName() {
        return name;
    }

    private void setLocation(String location) {
        this.location = location;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private String getCity() {
        return city;
    }

    public void addPatient(int i,Patient patient_p)
    {
        patient.add(i,patient_p);
    }

    public int OP_inside_Bangalore(Patient pat) {
        if(pat.getLocation().equals("Bangalore")) {
            return 1;
        }
        else return -1;
    }

    public int getPatients(Date date1, Date date2 , Patient pat) {
        if(pat.getConsultationDate().compareTo(date1) > 0 && pat.getConsultationDate().compareTo(date2) < 0 && pat.getLocation().equals("Bangalore")) {
            return 1;
        }
        else return -1;
    }

}




