public class DynamicHelper {
    private MathProcessing[] hanlders;

    public DynamicHelper(MathProcessing[] hanlders) {
        this.hanlders = hanlders;
    }

    public String process(String statement){
        String [] parts = statement.split(MathProcessing.SEPARATOR);
        String keyboard = parts[0];

        MathProcessing theHandler = null;

        for(MathProcessing handler: hanlders){
            if(keyboard.equals(handler.getKeyBoard())){
                theHandler = handler;
                break;
            }
        }

        double rightVal = Double.parseDouble(parts[1]);
        double leftVal = Double.parseDouble(parts[2]);

        double result = theHandler.doCalculation(leftVal, rightVal);
        StringBuilder format= new StringBuilder(20);
        format.append(leftVal);
        format.append(theHandler.getSymbol());
        format.append(rightVal);
        format.append("=");
        format.append(result);

        return format.toString();
    }
}
