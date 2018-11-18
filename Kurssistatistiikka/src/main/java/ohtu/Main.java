package ohtu;

import com.google.gson.Gson;

import java.io.IOException;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if (args.length > 0) {
            studentNr = args[0];
        }
//        String railURL = "https://studies.cs.helsinki.fi/courses/rails2018/stats";
        String courseInfo = "https://studies.cs.helsinki.fi/courses/courseinfo";
        String url = "https://studies.cs.helsinki.fi/courses/students/" + studentNr + "/submissions";
        String courseInfoString = Request.Get(courseInfo).execute().returnContent().asString();
        String bodyText = Request.Get(url).execute().returnContent().asString();
//        String railString = Request.Get(railURL).execute().returnContent().asString();
//        String ohtuString = Request.Get(ohtu2018URL).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        String statsResponse = "https://studies.cs.helsinki.fi/courses/ohtu2018/stats"; // palvelimelta haettu opiskelijoiden palautusstatistiikka
//
//        JsonParser parser = new JsonParser();
//        JsonObject parsittuData = parser.parse(statsResponse).getAsJsonObject();
        
        
        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Course[] courses = mapper.fromJson(courseInfoString, Course[].class);

        System.out.println("Opiskelijanumero " + studentNr);
        for (Course course : courses) {
            System.out.println(course.getFullName());
            int addPoints = 0;
            int addHours = 0;

            for (Submission sub : subs) {
                if (sub.getCourse().equals(course.getName())) {
                    System.out.println("Viikko : " + sub.getWeek());
                    System.out.println("Tehtyjä tehtäviä: " + sub.getExercisesAmount() + "/" + course.getExercises()[sub.getWeek()]);
                    System.out.println("Tehdyt tehtävät " + sub.getExercisesString());
                    System.out.println("");
                    addPoints = addPoints + sub.getExercisesAmount();
                    addHours = addHours + sub.getHours();
                }
            }
            System.out.println("Yhteensä: " + addPoints + ". Aikaa mennyt: " + addHours);
            System.out.println("");

        }
    }
}
