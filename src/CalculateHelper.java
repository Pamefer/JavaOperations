public class CalculateHelper  {
    private static final char ADD_SYMBOL='+';
    private static final char SUB_SYMBOL='-';
    private static final char MULTIPLY_SYMBOL='*';
    private static final char DIVIDE_SYMBOL='/';
    MathCommand mathCommand;
    double leftValue;
    double rightValue;
    double result ;

    public void process(String statement) throws InvalidStatementException {

        String[] parts = statement.split(" ");
        if(parts.length != 3){
            throw new InvalidStatementException("Incorrect number of fields", statement);
        }
        String commandString = parts[0];
        try {
            leftValue = Double.parseDouble(parts[1]);
            rightValue = Double.parseDouble(parts[2]);
        } catch (NumberFormatException n){
            throw new InvalidStatementException("Non-numeric-data", statement, n);
        }

        setCommandFromString(commandString);
        if(mathCommand==null){
            throw new InvalidStatementException("Invalid command", statement);
        }

        CalculateBase calculateBase=null;

        switch (mathCommand){
            case Add:
                calculateBase = new Adder(leftValue, rightValue);
                break;
            case Substract:
                calculateBase = new Subtracter(leftValue, rightValue);
                break;
            case Divide:
                calculateBase = new Divider(leftValue, rightValue);
                break;
            case Multiply:
                calculateBase = new Multiplier(leftValue, rightValue);
                break;
        }
        calculateBase.calculate();
        result = calculateBase.getResult();
    }

    private void setCommandFromString(String commandFromString){
        if(commandFromString.equalsIgnoreCase(MathCommand.Add.toString())){
            mathCommand = MathCommand.Add;
        } else if(commandFromString.equalsIgnoreCase(MathCommand.Substract.toString())){
            mathCommand = MathCommand.Substract;
        } else if(commandFromString.equalsIgnoreCase(MathCommand.Divide.toString())){
            mathCommand = MathCommand.Divide;
        }else if(commandFromString.equalsIgnoreCase(MathCommand.Multiply.toString())){
            mathCommand = MathCommand.Multiply;
        }
    }

    @Override
    public String toString(){
        char symbol=' ';
        switch (mathCommand){
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Substract:
                symbol = SUB_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
        }
        StringBuilder format= new StringBuilder(20);
        format.append(leftValue);
        format.append(symbol);
        format.append(rightValue);
        format.append("=");
        format.append(result);

        return format.toString();
    }
}
