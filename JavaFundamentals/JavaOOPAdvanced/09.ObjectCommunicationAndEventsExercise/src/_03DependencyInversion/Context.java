package _03DependencyInversion;

import _03DependencyInversion.operations.OperationAdd;
import _03DependencyInversion.operations.Strategy;

public class Context {

    private Strategy strategy;

    public Context() {
        this.strategy = new OperationAdd();
    }

    public void changeStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public long executeStrategy(int firstOperand, int secondOperand){
       return this.strategy.doOperation(firstOperand,secondOperand);
    }
}
