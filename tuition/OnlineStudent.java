package tuition;

public class OnlineStudent extends Student{

    // Instance variable specific to subclass
    private boolean mTechFee;

    // Default constructor
    public OnlineStudent(){}

    // Constructor, calls superclass constructor
    public OnlineStudent(String pId, String pFname, String pLname){
        super(pId, pFname, pLname);
    }

    // Overridden calcTuition method.  Used TuitionConstants and protected setTuition method to assign tuition
    @Override
    public void calcTuition(){
        double t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;
        if (getTechFee()){
            t += TuitionConstants.ONLINE_TECH_FEE;
        }
        setTuition(t);
    }

    // Getter method for mTechFee
    public boolean getTechFee(){
        return mTechFee;
    }

    // Mutator method for mTechFee
    public void setTechFee(boolean pTechFee){
        mTechFee = pTechFee;
    }
}
