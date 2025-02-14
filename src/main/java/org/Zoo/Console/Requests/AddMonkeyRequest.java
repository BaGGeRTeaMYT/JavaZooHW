package org.Zoo.Console.Requests;

public class AddMonkeyRequest extends Request {

    public AddMonkeyRequest(int food, int kindness) {
        super(food, kindness);
    }

    public AddMonkeyRequest(int food) {
        super(food);
    }

    @Override
    public int execute(RequestableType smth) {
        return 0;
    }
}
