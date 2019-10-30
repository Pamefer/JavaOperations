public class CalculateHelper  {
    MathCommand mathCommand;
    double leftValue;
    double rightValue;
    double result ;

    public void process(String statement){
        String[] parts = statement.split(" ");
        String commandString = parts[0];
        leftValue = Double.parseDouble(parts[1]);
        rightValue = Double.parseDouble(parts[2]);

        setCommandFromString(commandString);
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
}
