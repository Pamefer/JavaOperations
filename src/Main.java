public class Main {

    public static void main(String[] args) {

//        useMathEquation();
//        useInheritance();
//        useCalculateHelper();
        String[] data = {
                "add 2.4d 12d",
                "power 2.4d 12d",
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[]{
                new Adder(),
                new PowerOf()});

        for(String statement: data){
            String output = helper.process(statement);
            System.out.println(output);
        }
    }

//    private static void useCalculateHelper() {
//        String[] data = {
//                "add 2.4d",
//                "substract xx 10.0d",
//                "multiply 23.4d 2.5d",
//                "divide 2.5d 1.1d"
//        };
//        CalculateHelper calculateHelper = new CalculateHelper();
//
//        for(String statement: data){
//            try {
//                calculateHelper.process(statement);
//                System.out.println(calculateHelper );
//            } catch (InvalidStatementException e){
//                System.out.println(e.getMessage());
//                if(e.getCause() != null ){
//                    System.out.println("Original exception"+e.getCause().getMessage());
//                }
//            }
//        }
//    }

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
