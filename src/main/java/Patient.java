import java.util.Date;

public class Patient {

    private int patientID;
    private String location;
    private Date consultationDate;


    public Patient(int patientID, String location, Date consultationDate) {
        this.patientID = patientID;
        this.location = location;
        this.consultationDate = consultationDate;
    }

    private void setConsultationDate(Date consultationDate) {
        this.consultationDate = consultationDate;
    }

    private void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    private void setLocation(String location) {
        this.location = location;
    }

    private int getPatientID() {
        return patientID;
    }

    public String getLocation() {
        return location;
    }
    public Date getConsultationDate() {
        return consultationDate;
    }
}
