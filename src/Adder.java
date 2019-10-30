public class Adder extends CalculateBase implements MathProcessing{

    public Adder () {}
    public Adder (double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }
    @Override
    public void calculate() {
        double value= getRighttVal() + getLeftVal();
        setResult(value);
    }

    @Override
    public String getKeyBoard() {
        return "add";
    }

    @Override
    public String getSymbol() {
        return "+";
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRighttVal(rightVal);
        calculate();
        return getResult();
    }
}
