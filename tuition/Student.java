package tuition;

public abstract class Student implements Comparable<Student> {

    // Instance variables
    private int mCredits;
    private String mFname;
    private String mId;
    private String mLname;
    private double mTuition;

    // Default constructor
    public Student() {
    }

    // Constructor for Student object
    public Student(String pId, String pFname, String pLname) {
        mId= pId;
        mFname = pFname;
        mLname = pLname;
    }

    // Abstract tuition calculator method
    public void calcTuition() {

    }

    // Overridden compare interface method
    @Override
    public int compareTo(Student pStudent) {
        return getId().compareTo(pStudent.getId());
    }

    // Getter method for mCredits
    public int getCredits() {
        return mCredits;
    }

    // Getter method for mFname
    public String getFirstName() {
        return mFname;
    }

    // Getter method for mId
    public String getId() {
        return mId;
    }

    // Getter method for mLname
    public String getLastName() {
        return mLname;
    }

    // Getter method for mTuition
    public double getTuition() {
        return mTuition;
    }

    // Mutator method for mCredits
    public void setCredits(int pCredits) {
        mCredits = pCredits;
    }

    // Mutator method for mFname
    public void setFname(String pFname) {
        mFname = pFname;
    }

    // Mutator method for mLname
    public void setLname(String pLname) {
        mLname = pLname;
    }

    // Mutator method for mId
    public void setId(String pId) {
        mId = pId;
    }

    // Protected mutator method for mTuition
    // To be called by subclasses
    protected void setTuition(double pTuition) {
        mTuition = pTuition;
    }
}
