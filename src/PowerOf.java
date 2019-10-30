public class PowerOf implements MathProcessing {
    @Override
    public String getKeyBoard() {
        return "power";
    }

    @Override
    public String getSymbol() {
        return "^";
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return Math.pow(leftVal, rightVal);
    }
}
