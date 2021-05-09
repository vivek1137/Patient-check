import java.util.ArrayList;


public class Hospital {

    private String location;
    public String hospitalname;
    ArrayList<Patient> patient_inside;

    public Hospital(String location, String name) {
        this.location = location;
        this.hospitalname = name;
    }

    public void patientdata(Patient patient) {
        this.patient_inside.add(patient);
    }

    public long local_patient

    public int getsizePatients() {
        return patient_inside.size();
    }

    public int visited_hospital(String hospital_name) {
        int total_days_visited = 0;
        if (this.hospitalname.equals(hospital_name)) {
            for (Patient patient : patient_inside) {
                total_days_visited++;
            }
        }
        return total_days_visited;
    }

}