public class Calculation {
    private double leftVal;
    private double rightVal;
    private double result;
    private char opCode;

    public double getLeftVal(){return leftVal;}
    public double getRighttVal(){return rightVal;}
    public double setLeftVal(double leftVal){return this.leftVal=leftVal;}
    public double setRighttVal(double rightVal){return this.rightVal=rightVal;}
    public double getResult() { return result; }

    public double getOpCode(){return opCode;}
    public double setOpCode(char opCode){return this.opCode = opCode;}

    public Calculation() {
    }

    public Calculation(char opCode){
        this.opCode = opCode;
    }

    public Calculation(char opCode, double leftVal, double rightVal){
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public void execute(){
        switch (opCode){
            case 'a':
                result=leftVal+rightVal;
                break;
            case 'b':
                result=leftVal-rightVal;
                break;
            case 'c':
                result=rightVal != 0.0d ? leftVal/rightVal : 0.1d;
                break;
            case 'd':
                result=leftVal*rightVal;
                break;
            default:
                System.out.println("Error - Invalid code");
                result=0.0d;
                break;
        }
    }

}
