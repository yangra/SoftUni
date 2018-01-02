package _03DependencyInversion.operations;

public class OperationDivide implements Strategy {
    @Override
    public long doOperation(int firstOperand, int secondOperand) {
        return firstOperand/secondOperand;
    }
}
