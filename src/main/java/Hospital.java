import java.util.ArrayList;
import java.util.stream.Collectors;


public class Hospital {

    private String location;
    public String hospitalname;
    ArrayList<Patient> patient_inside;

    public Hospital(String location, String name) {
        this.location = location;
        this.hospitalname = name;
        this.patient_inside = new ArrayList<Patient>();
    }

    public void init_patientdata() {
        patient_inside.add(new Patient(1,"Rahul","Bangalore"));
        patient_inside.add(new Patient(2,"Rahul","Chennai"));
        patient_inside.add(new Patient(3,"Rahul","Bangalore"));
        patient_inside.add(new Patient(4,"Rahul","Delhi"));
        patient_inside.add(new Patient(5,"Rahul","Bangalore"));
        patient_inside.add(new Patient(6,"Rahul","Noida"));
        patient_inside.add(new Patient(7,"Rahul","Bangalore"));
       }


    public long getLocationPatients(String location) {
        long count = this.patient_inside.stream().filter((s) -> s.getLocation().contains(location)).count();
        System.out.println(count);
        return count;
    }

}