package _03DependencyInversion.operations;

public class OperationSubtract implements Strategy {

    @Override
    public long doOperation(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}
