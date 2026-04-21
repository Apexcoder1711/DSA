

public class OOPS {
    public static void main(String[] args) {
        Pen p1 = new Pen(); //created a pen object called p1
        p1.setColor("red");
        System.out.println(p1.getColor());
        p1.setTip(3);
        System.out.println(p1.getTip());
        //p1.color = "yellow"; //cant set directly , it is set by using setter function
        //System.out.println(p1.color);


        //usimg Access Specifier
        bankAccount myAcc = new bankAccount();
        myAcc.username = "Ayush";
        System.out.println(myAcc.username);
        myAcc.setPassword("1234");


        Horse h = new Horse();
        h.eat();
        h.walk();

        Chicken c = new Chicken();
        c.eat();
        c.walk();


        Child ch = new Child();
        //grandparent -> parent -> child
    }
}

class Pen {
    private String color;
    private int tip;

    void setColor(String newColor){   //-->setter
        color = newColor;
    }

    String getColor(){ //--> getter
        return this.color;
    }

    void setTip(int newTip){  //->setter
        tip = newTip;
    }

    int getTip(){  //--> getterr
        return this.tip;
    }
}

class bankAccount {
    public String username;
    private String password;//cannot directly accesible outside this class so we make a function to access or to set the password
    public void setPassword(String pwd){
        password = pwd;
    }
}


//Abstraction :- 

abstract class Animal { //abstract class ke obejcts nhi bnte hai so animal class ka object nhi bn skta hai but abstract class ke constructor bna skte hai
    void eat(){ //normal  function
        System.out.println("eat");
    }

    abstract void walk(); //gives idea mtlb jo koi isko inherit krega whi implement krega
}

class Horse extends Animal{ //extends from walk class
    void walk(){ //abstract class ka walk ka implemntation yha ho rha hai
        System.out.println("4 legs");
    }
}

class Chicken extends Animal {
    void walk(){ //abstract class ka walk ka implentation for this class yha ho rha hai
        System.out.println("2 legs");
    }
}


//constructor called
class Grandparent {
    Grandparent(){
        System.out.println("grandparent constructor called");
    }
}

class Parent extends Grandparent{
    Parent(){
        System.out.println("parent constructor called");
    }
}

class Child extends Parent{
    Child(){
        System.out.println("Child constructor called");
    }
}