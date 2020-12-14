package JavaMentor;

class Calculator {
    byte a, b;
    String mark;

    Calculator () {}

    Calculator (byte a, byte b, String mark) {
        this.a = a;
        this.b = b;
        this.mark = mark;
    }

    void getA (byte a) {
        this.a = a;
    }

    void getB (byte b) {
        this.b = b;
    }

    void getMark (String marks) {
        this.mark = mark;
    }

    byte calculate () {
        byte result = 0;
        switch (this.mark) {
            case "+": result = (byte) (this.a + this.b); break;
            case "-": result = (byte) (this.a - this.b); break;
            case "*": result = (byte) (this.a * this.b); break;
            case "/": result = (byte) (this.a / this.b); break;
        }
        return result;
    }
}
