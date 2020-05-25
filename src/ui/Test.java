package ui;

public class Test {
     int value = 33;

    public static void main(String[] args) throws Exception{
        new Test().printValue();
    }

    private void printValue(){
        int value = 3;
        System.out.println(this.value);
    }
    }

