import java.util.Comparator;
import java.util.Date;

public class Patient {

    public int patientID;
    private String location;
    private Date consultationDate;
    public String hospital_name;

    public Patient(int patientID, String location, Date consultationDate,String hospital_name) {
        this.patientID = patientID;
        this.location = location;
        this.consultationDate = consultationDate;
        this.hospital_name = hospital_name;
    }

    public int getID() {
        return this.patientID;
    }

    public String getLocation() {
        return location;
    }
    public Date getConsultationDate() {
        return consultationDate;
    }


    public Comparator<Patient> patientid = new Comparator<Patient>() {
        @Override
        public int compare(Patient o1, Patient o2) {
            int id1 = o1.getID();
            int id2 = o2.getID();
            return  id1 - id2;
        }
    };
}
