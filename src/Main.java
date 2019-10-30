public class Main {

    public static void main(String[] args) {

        Calculation calculation=new Calculation();
        calculation.execute();
        System.out.println(calculation.getResult());

        useMathEquationWithoutConstructor();
        useMathEquation();
        useInheritance();

        String[] data = {
                "divide 10.0d 34.0d",
                "add 34.5d 2.4d",
                "multiply 23.4d 2.5d",
                "divide 2.5d 1.1d"
        };
        CalculateHelper calculateHelper = new CalculateHelper();
        for(String statement: data){
            calculateHelper.process(statement);
        }
    }

    private static void useMathEquation() {
        Calculation [] data = new Calculation[4];
        data[0] = new Calculation('a',23d,12d);
        data[1] = new Calculation('b',13d,13d);
        data[2] = new Calculation('c',3d,14d);
        data[3] = new Calculation('d',2d,15d);

        for(Calculation result: data){
            result.execute();
            System.out.println("Result"+result.getResult()  );
        }
    }

    private static void useMathEquationWithoutConstructor() {
        Calculation [] data = new Calculation[4];
        data[0] = create(23d,12d,'a');
        data[1] = create(22d,15d,'b');
        data[2] = create(25d,15d,'c');
        data[3] = create(26d,13d,'d');

        for(Calculation result: data){
            result.execute();
            System.out.println("Result"+result.getResult()  );
        }
    }

    public static Calculation create(double leftVal, double rightVal, char opCode){
        Calculation calc = new Calculation();
        calc.setLeftVal(leftVal) ;
        calc.setLeftVal(rightVal) ;
        calc.setOpCode(opCode) ;
        return  calc;
    }

    private static void useInheritance() {
        System.out.println("---Using Inherritance---");
        CalculateBase[] calculateBase = {
            new Divider(100.0d,50.0d),
                new Adder(60.0d,70.0d),
                new Subtracter( 40.0d,56.0d),
                new Multiplier(56.0d,5.0d),
        };
        for (CalculateBase resultTwo: calculateBase){
            resultTwo.calculate();
            System.out.println("result="+resultTwo.getResult());
        }
    }

}
