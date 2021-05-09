import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Patient {

    public int patientID;
    private String name;
    private ArrayList<String> location;
    private ArrayList<Hospitalvisit> hospitalvisits;
    public ArrayList<visit> visited_count = new ArrayList<visit>();

    public Patient(int patientID, String name) {
        this.patientID = patientID;
        this.location = new ArrayList<String>();
        this.hospitalvisits = new ArrayList<Hospitalvisit>();
        this.name = name;
    }

    public void add_patient_details(Hospitalvisit hospitalvisit,String location) {
        this.hospitalvisits.add(hospitalvisit);
        this.location.add(location);
    }

    public int getID() {
        return this.patientID;
    }

    public ArrayList getlocation() {
        return this.location;
    }

    public void add_visitcount(String location) {
        long count = gettotalvisitedCount(location);
        visit visit = new visit(location, count);
        visited_count.add(visit);
    }

    public long gettotalvisitedCount(String location) {

        long loca = this.location.stream().filter((s) -> s.matches(location)).count();
        return loca;


    }



}