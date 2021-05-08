import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class Hospital {

    private String location;
    public String hospitalname;
    ArrayList<Patient> patient_inside;

    public Hospital(String location,String name) {
        this.location = location;
        this.hospitalname = name;
    }

    public void patientdata(Patient patient) {
        this.patient_inside.add(patient);
    }

    public int getsizePatients()
    {
        return patient_inside.size();
    }

    public int visited_hospital(String hospital_name) {
        int total_days_visited = 0;
        if(this.hospitalname.equals(hospital_name)) {
            for (Patient patient : patient_inside) {
                        total_days_visited++;
                }
            }
        return total_days_visited;
    }

//    public int total_patients_visited() {
//        int cal_patients_visited = 0;
//        for(Patient patient : patient_inside) {
//            if(this.patient_ID == patient.patientID) {
//                cal_patients_visited++;
//            }
//        }
//        return cal_patients_visited;
//    }
//
//    public int visited_hospital_local(String hospital_name,String city) {
//        int total_days_visited_local = 0;
//        if(this.hospitalname.equals(hospital_name) && this.location.equals(city)) {
//            for (Patient patient : patient_inside) {
//                if(this.patient_ID == patient.patientID) {
//                    total_days_visited_local++;
//                    //   System.out.println("entered ");
//                }
//            }
//        }
//        return total_days_visited_local;
//    }
//    public int get_Specificpatient_visited_currently(int days) {
//
//        Calendar cal = Calendar.getInstance();
//
//      //  System.out.println("Current day "+cal.getTime());
//        cal.add(Calendar.DATE,-days);
//        Date date = cal.getTime();
//        cal.setTime(date);
//      //  System.out.println(days+" days earlier"+date);
//        int count_patient=0;
//        for (Patient patient : patient_inside) {
//            int unique_patient = 0;
//            if(this.patient_ID == patient.patientID && unique_patient != this.patient_ID) {
//                unique_patient = this.patient_ID;
//                if(patient.getConsultationDate().after(date) || patient.getConsultationDate().compareTo(date)==0) {
//                    count_patient++;
//                 //   System.out.println("entered ");
//                }
//            }
//        }
//        return count_patient;
//    }
//
//    public int get_patients_visited_currently(int days) {
//
//        Calendar cal = Calendar.getInstance();
//
//        //  System.out.println("Current day "+cal.getTime());
//        cal.add(Calendar.DATE,-days);
//        Date date = cal.getTime();
//        cal.setTime(date);
//        //  System.out.println(days+" days earlier"+date);
//        int count_patient=0;
//
//        for(Patient pat1 : patient_inside) {
//            for(Patient pat2 : patient_inside) {
//                if(pat1.getID() != pat2.getID()) {
//                    if(pat1.getConsultationDate().after(date) || pat1.getConsultationDate().compareTo(date)==0) {
//                        count_patient++;
//                    }
//                }
//            }
//        }
//        return count_patient/2;
//    }
//    public void add_patients(Patient patient)   // Patient added only when both location hospital name is same
//    {
//        if(patient.getLocation().equals(this.location) && patient.hospital_name.equals(this.hospitalname)) {
//            patient_inside.add(patient);
//        }
//    }
//
//    public int getPatientInTimeDuration(Date date1,Date date2) {
//        int count = 0;
//
//        for (Patient element : patient_inside) {
//            boolean check_inside_patient = element.getLocation().equals(this.location) && element.hospital_name.equals(this.hospitalname);
//            boolean a = element.getConsultationDate().after(date1);
//           // System.out.println(check_inside_patient);
//                if (check_inside_patient) {
//                if(element.getConsultationDate().after(date1) && element.getConsultationDate().before(date2)) {
//                    count++;
//                 //   System.out.println("count inside is :"+count);
//                }}
//        }
//     //   System.out.println(count);
//        return count;
//    }

}




