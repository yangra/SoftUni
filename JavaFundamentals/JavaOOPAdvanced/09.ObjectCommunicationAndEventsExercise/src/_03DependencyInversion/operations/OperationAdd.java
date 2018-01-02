package _03DependencyInversion.operations;

public class OperationAdd implements Strategy {
    @Override
    public long doOperation(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }
}
