package ohtu;

public class Submission {

    private int week;
    private int hours;
    private String course;
    private int[] exercises;

    public void setExercises(int[] excersises) {
        this.exercises = excersises;
    }

    public int getExercisesAmount() {
        return this.exercises.length;
    }

    public String getExercisesString() {
        String temp = "";
        for (int i = 0; i < this.exercises.length; i++) {
            temp = temp + this.exercises[i] + ", ";

        }
        return temp;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return this.course;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return this.hours;
    }

    @Override
    public String toString() {
        return "Kurssi:" + this.course + ". Viikko " + week + ". Käytettyjä tunteja: " + hours + ". Tehdyt tehtävät: " + this.getExercisesString();
    }

}
