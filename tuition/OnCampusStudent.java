package tuition;

public class OnCampusStudent extends Student{

    // Instance variables specific to OnCampusStudent
    private boolean mResident;
    private double mProgramFee;

    // Default constructor
    public OnCampusStudent(){}

    // Constructor, calls superclass constructor
    public OnCampusStudent(String pId, String pFname, String pLname){
        super(pId, pFname, pLname);
    }

    // Overridden calcTuition method
    // Uses TuitionConstants and protected setTuition method to set mTuition
    @Override
    public void calcTuition(){
        double t;
        if (getResidency()){
            t = TuitionConstants.ONCAMP_RES_BASE;
        }
        else{
            t = TuitionConstants.ONCAMP_NONRES_BASE;
        }
        t += getProgramFee();
        if(getCredits() > TuitionConstants.MAX_CREDITS){
            t = t + (getCredits() - TuitionConstants.MAX_CREDITS) * TuitionConstants.ONCAMP_ADD_CREDITS;
        }
        setTuition(t);
    }

    // Getter method for mProgramFee
    public double getProgramFee(){
        return mProgramFee;
    }

    // Getter method for mResident
    public boolean getResidency(){
        return mResident;
    }

    // Mutator method for mProgramFee
    public void setProgramFee(double pProgramFee){
        mProgramFee = pProgramFee;
    }

    // Mutator method for mResident
    public void setResidency(boolean pResident){
        mResident = pResident;
    }
}
