package registration.util;

import registration.models.Course;
import registration.models.Faculty;

import java.io.*;
public class MainDriver {


    static BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args){
        boolean isRunning = true;


        String welcome = "Welcome to the Registration Hub!";
        String option1 = "1) Login";
        String option2 = "2) Register";
        String option3 = "3) View/Create course";
        String option4 = "4) View all courses";
        String option5 = new String("5) Exit the Hub"); // This is the same as ""

        while(isRunning) {
            // This is where we take the above variables and print them using a formatter
            // %s for STrings or %d for digits (numbers) in the string provided initially, then you provide the respective variables
            // println() is just invoking another method from out to add a new line after
            System.out.printf("%s \n %s \n %s \n %s \n %s \n %s", welcome, option1, option2, option3, option4, option5).println();

            // try-block specifically does what....
            // if any execption it was throw to the catch-block. It's considered "risky", a potential for the statements within to throw an excpetion.

            try {
                System.out.print("\n Select number from above\n >"); // just print, prints out to console and that's it, no appended new line
                // What's happening here?
                // Taking input from the readline in terminalReader as a String!!! Always a STRING From BufferedReader
                String userSelection = terminalReader.readLine();

                // What's a switch statement?
                // If we hve many cases or conditions and well continue to evaluated until coditions is met based
                // on the user selection
                switch (userSelection) {
                    case "1":
                        System.out.println("User has selected login...");
                        break;
                    case "2":
                        System.out.println("User has selected register...");
                        register(); // ctrl + left-click
                        break;
                    case "3":
                        System.out.println("User has selected view/create course...");
                        courseInput(); // ctrl + left-click
                        break;
                    case "4":
                        System.out.println("User has selected view students...");
                        Course[] courses = readCourse();

                        for (int i = 0; i < courses.length; i++) {
                            course student = courses[i];
                            System.out.println(student.toString());
                        }


                        break;
                    case "5":
                        System.out.println("User has selected exit...");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("No valid user input provide");
                        break;
                }

            } catch (IOException | RuntimeException e) {
                e.printStackTrace();
            }
        }


    }

    static void courseInput() throws IOException {
        System.out.println("What is your course's name?");
        String cName = terminalReader.readLine();

        System.out.println("What is the course id?");
        String cId = terminalReader.readLine();

        System.out.println("How many credit-hours is the course?");
        String cCredit = terminalReader.readLine();


        Course course1 = new Course(
                cName,
                Integer.parseInt(cId),
                Integer.parseInt(cName)

        );


        System.out.println(course1);
    }


    static void register() throws IOException {

        System.out.println("What is your full name?");
        String fullName = terminalReader.readLine();

        System.out.println("What is your email?");
        String email = terminalReader.readLine();

        System.out.println("What is your password?");
        String password = terminalReader.readLine();

        System.out.println("Re-enter password");
        String passwordCheck = terminalReader.readLine();

        System.out.println("DOB?");
        String dob = terminalReader.readLine();

        // What's happening here???
        // Breaking or splitting the String fullName into an String array by " " spaces
        String[] nameArray = fullName.split(" ");
        String fname = nameArray[0];
        String lname = nameArray[nameArray.length - 1];

        // What's happening here??
        //
        if (!password.equals(passwordCheck)) { // password != passwordCheck
            System.out.println("Passwords don't match");
            return; // why return??? Control Flow, this breaks this method and returns us to main
        }


        // Faculty Faculty = new Faculty(); // why is this red?? there isn't a No-Arg constructor
        // What's happening here? Intialization a new Faculty object in memory
        Faculty newFaculty = new Faculty(fname, lname, email, password, dob);
        System.out.println(newFaculty); // What happens here? Java knows to invoke the toString() method when printing the object to the terminal

        // What's this??? Obtaining the file from the relative path
        File FacultyPersist = new File("resources/data.txt"); // Note check out maxwells stuff.

        // What's happening here???
        // try-with-resoruces - it works with auto-closable classes.
        try(FileWriter fileWriter = new FileWriter(FacultyPersist, true)) {
            fileWriter.write(newFaculty.toFileString() + "\n"); // write is method to write into the specified fill
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    static Faculty[] readFaculty() throws IOException {

        // FileWriter's evil counterpart, to read files
        FileReader fileReader = new FileReader("resources/data.txt");
        BufferedReader reader = new BufferedReader(fileReader); // BufferedReader is now reading the file, line-by-line

        // Initializing an array of 10 Facultys
        Faculty[] Facultys = new Faculty[10]; // when we specify a size, the array cannot grow. It's max limit is 10 because we gave 10
        // Faculty[] Facultys = new Faculty[100]; you have to specify a size in the []
        // Reading the input, being the file, one line a time
        String line = reader.readLine();
        int index = 0; // we want to keep track of where we are placing each Faculty from the file into the the array

        while (line != null){ // the last line of the file is null
            String[] FacultyInfo = line.split(","); // What's happening? If comma, split into individual string in array

            String fname = FacultyInfo[0];
            String lname = FacultyInfo[1];
            String email = FacultyInfo[2];
            String password = FacultyInfo[3];
            String dob = FacultyInfo[4];

            Faculty Faculty = new Faculty(fname, lname, email, password, dob);
            Facultys[index] = Faculty;

            index++; // increment the index by 1, must occur after the Faculty[index] re-assignment
            line = reader.readLine(); // re-assigns the line variable to the next line in the file, not-impacted by any means by index
        }
        reader.close(); // we need to close our reader

        return Facultys;
    }
}
