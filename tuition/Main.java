package tuition;
//**************************************************************************************************************
// CLASS: Main
//
// DESCRIPTION
// Reads an input file for information related to a student (ID #, Name, residency status, credits, ect)
// Calculates the students tuition based on input parameters.  Creates a file and prints the students' ID, name,
// and tuition to the file.  Tuition is formatted to display two digits after the decimal.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and data structures: Fall 2017
//
// AUTHOR
// Ryan Van Valkenburg
//**************************************************************************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     *  Instantiate a Main object and call run() on the object.
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.run();
    }

    /**
     * Calculates the tuition for each student. Write an enhanced for loop that iterates over each Student in
     * pStudentList. For each Student, call calcTuition() on that Student. Note: this is a polymorphic method
     * call.
     *
     * PSEUDOCODE
     * EnhancedFor each student in pStudentList Do
     *     student.calcTuition()
     * End EnhancedFor
     */
    private void calcTuition(ArrayList<Student> pStudentList) {
        for (Student student: pStudentList){
            student.calcTuition();
        }
    }

    /**
     * Reads the student information from "p02-students.txt" and returns the list of students as an ArrayList
     * <Student> object.
     *
     * PSEUDOCODE
     * Declare and create an ArrayList<Student> object named studentList.
     * Open "p02-students.txt" for reading using a Scanner object named in.
     * While in.hasNext() returns true Do
     *     String studentType <- read next string from in
     *     If studentType is "C" Then
     *         studentList.add(readOnCampusStudent(in))
     *     Else
     *         studentList.add(readOnlineStudent(in))
     *     End If
     * End While
     * Close the scanner
     * Return studentList
     */
    private ArrayList<Student> readFile() throws FileNotFoundException {
        ArrayList<Student> studentList = new ArrayList<>();
        File inputFile = new File("p02-students.txt");
        Scanner in = new Scanner(inputFile);

        while (in.hasNext()){
            String studentType = in.next();
            if(studentType.equals("C")){
                studentList.add(readOnCampusStudent(in));
            }
            else{
                studentList.add(readOnlineStudent(in));
            }
        }
        in.close();
        return studentList;
    }

    /**
     * Reads the information for an on-campus student.
     *
     * PSEUDOCODE
     * Declare String object id and assign pIn.next() to id
     * Declare String object named lname and assign pIn.next() to lname
     * Declare String object named fname and assign pIn.next() to fname
     * Declare and create an OnCampusStudent object. Pass id, fname, and lname as params to ctor.
     * Declare String object named res and assign pIn.next() to res
     * Declare double variable named fee and assign pIn.nextDouble() to fee
     * Declare int variable named credits and assign pIn.nextInt() to credits
     * If res.equals("R") Then
     *    Call setResidency(true) on student
     * Else
     *    Call setResidency(false) on student
     * End If
     * Call setProgramFee(fee) on student
     * Call setCredits(credits) on student
     * Return student
     */
    private OnCampusStudent readOnCampusStudent(Scanner pIn) {
        String id = pIn.next();
        String lName = pIn.next();
        String fName = pIn.next();
        OnCampusStudent student = new OnCampusStudent(id, fName, lName);
        String res = pIn.next();
        double fee = pIn.nextDouble();
        int credits = pIn.nextInt();

        if (res.equals("R")){
            student.setResidency(true);
        }
        else{
            student.setResidency(false);
        }

        student.setProgramFee(fee);
        student.setCredits(credits);
        return student;
    }

    /**
     * Reads the information for an online student.
     *
     * PSEUDOCODE
     * Declare String object id and assign pIn.next() to id
     * Declare String object named lname and assign pIn.next() to lname
     * Declare String object named fname and assign pIn.next() to fname
     * Declare and create an OnlineStudent object. Pass id, fname, lname as params to the ctor.,
     * Declare String object named fee and assign pIn.next() to fee
     * Declare int variable named credits and assign pIn.nextInt() to credits
     * If fee.equals("T")) Then
     *     Call setTechFee(true) on student
     * Else
     *     Call setTechFee(false) on student
     * End If
     * Call setCredits(credits) on student
     * Return student
     */
    private OnlineStudent readOnlineStudent(Scanner pIn) {
        String id = pIn.next();
        String lName = pIn.next();
        String fName  = pIn.next();
        OnlineStudent student = new OnlineStudent(id, fName, lName);
        String fee = pIn.next();
        int credits = pIn.nextInt();

        if (fee.equals("T")){
            student.setTechFee(true);
        }
        else{
            student.setTechFee(false);
        }

        student.setCredits(credits);
        return student;
    }

    /**
     *  Calls other methods to implement the sw requirements.
     *
     * PSEUDOCODE
     * Declare ArrayList<Student> object named studentList
     * try
     *     studentList = readFile()
     *     calcTuition(studentList)
     *     Call Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING) to sort the list
     *     writeFile(studentList)
     * catch FileNotFoundException
     *     Print "Sorry, could not open 'p02-students.txt' for reading. Stopping."
     *     Call System.exit(-1)
     */
    private void run() {
        ArrayList<Student> studentList = new ArrayList<>();
        try{
            studentList = readFile();
            calcTuition(studentList);
            Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);
            writeFile(studentList);
        }catch (FileNotFoundException pException){
            System.out.println("Sorry, could not open 'p02-studnets.txt' for reading. Stopping,");
            System.exit(-1);
        }
    }

    /**
     *  Writes the output file to "p02-tuition.txt" per the software requirements.
     *
     * PSEUDOCODE
     * Declare and create a PrintWriter object named out. Open "p02-tuition.txt" for writing.
     * EnhancedFor each student in pStudentList Do
     *     out.print(student id + " " + student last name + " " + student first name)
     *     out.printf("%.2f%n" student tuition)
     * End EnhancedFor
     * Close the output file
     */
    private void writeFile(ArrayList<Student> pStudentList) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("p02-tuition.txt"));
        for(Student student: pStudentList){
            out.print(student.getId() + " " + student.getLastName() + " " + student.getFirstName() + " ");
            out.printf("%.2f%n", student.getTuition());
        }
        out.close();

    }
}
