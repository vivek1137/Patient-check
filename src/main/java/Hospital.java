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

    public int getPatientInTimeDuration(Date date1,Date date2) {
        int count = 0;

        for (Patient element : patient_inside) {
            boolean check_inside_patient = element.getLocation().equals(this.location) && element.hospital_name.equals(this.name);
            boolean a = element.getConsultationDate().after(date1);
           // System.out.println(check_inside_patient);
                if (check_inside_patient) {
                if(element.getConsultationDate().after(date1) && element.getConsultationDate().before(date2)) {
                    count++;
                 //   System.out.println("count inside is :"+count);
                }}
        }
     //   System.out.println(count);
        return count;
    }
    public int getsizePatients()
    {
        return patient_inside.size();
    }
}




