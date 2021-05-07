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

    public String getLocation() {
        return location;
    }
    public Date getConsultationDate() {
        return consultationDate;
    }
}
