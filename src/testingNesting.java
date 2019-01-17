public class testingNesting {
    public class A {
        public void method1() {
            System.out.println("a 1");
        }
    }
    public class B extends A {
        public void method2() {
            System.out.println("b 2");
        }
    }
    public class C extends B {
        public void method3() {
            System.out.println("c 3");
        }
    }
    public class D extends C {
        public void method4() {
            System.out.println("d 4");
        }
    }

    D var = new D();
    var.method4();
    var.method1();
    var.method3();
}

/*
Inheriting Constructors
So far the only keyword you've had to use to inherit things is "extends". By adding that to your class header you
automatically inherit all fields and methods. You may not have noticed, but all along you've also been automatically
inheriting the default constructor. In effect, Java provides this code so you don’t have to:

Class	                                    Constructor
School Member	                        public SchoolMember () { super(); }
Staff	                                public Staff () { super(); }
Teacher                             	public Teacher () { super(); }

However, if the super class has a non default constructor defined- that is not inherited.
If you have a non default constructor in your super class, you must implement a constructor in the child class.
Chances are that constructor will be very similar to the super class constructor as you likely are just initializing all
the fields in the child class in the same way you are in the super class. You can resolve that redundancy by using "super" to call
the super class constructor like so:

public class Student {
    public Student(String name) {
        super(name);
    }
}
This calls the super class constructor and passes along the parameters to initialize the fields. If you are going to use
the super constructor in your child class you MUST put the super() call as the first thing in your constructor.
You can’t make a Teacher until you have a Staff, you can’t make a Staff until you have an SchoolMember, and you can’t make
an SchoolMember until you have an Object!
 */



/*
For example, a Turkey does indeed flap its wings, and soar (briefly), but then it sinks back down again.
Recall that the Bird method for fly is:

public void fly() {
    wing[1].flapWith(wing[2]);
    soar();
}
We can incorporate this method in to the Turkey’s version by calling the Bird version, and then adding our own code:

public class Turkey {
    public void fly() {
        super.fly();
        sink();
    }
}
 */