import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Hospital {

    private String location;
    public String hospitalname;
    List<Patient> patient_inside;

    public Hospital(String location, String name, List<Patient> patients) {
        this.location = location;
        this.hospitalname = name;
        this.patient_inside = patients;
    }


    public List<Patient> getPatientList() {
            return patient_inside;
    }

    public long getLocationPatients(String location) {
        long count = this.patient_inside.stream().filter((s) -> s.getLocation().contains(location)).count();
       // System.out.println(count);
        return count;
    }

    public long getPatientsOutsideBangalore(String location) {

        long count = this.patient_inside.stream().filter((s) -> s.getLocation().contains(location)).count();
        return patient_inside.size() - count;
    }


    public double getRatioInsideToOutside(String location) {
        long count_inside = this.patient_inside.stream().filter((s) -> s.getLocation().contains(location)).count();
        long count_outside = patient_inside.size() - count_inside;

        return count_inside/count_outside;
    }



}