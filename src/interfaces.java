public class interfaces {
    public class Sum  {
        public int doCalc() {
            return 10;
        }

        public int doAnotherCalc() {
            return 20;
        }
    }
    public class BigSum extends Sum {
        public int doCalc() {
            int x = super.doCalc();
            return x + doAnotherCalc();
        }

        public int doAnotherCalc() {
            return 100;
        }
    }
    Sum s = new BigSum();
        System.out.println(s.doCalc());
    /*
    What are interfaces?
In Java, a class can only ever inherit from one super class. This can be rather limiting when you have a large ecosystem of code and you want to form more relationships than simple inheritance allows. Another way to relate objects to one another is through something called an **interface**. An interface is a contract that dictates a minimum amount of behavior. You can think of it like a list of abstract methods, or method headers, that are required to be implemented in any object using the interface.


public interface Flying {
    public int wings();
    public boolean takeOff();
    public boolean land();
}
An interface allows you to relate objects based on their behavior, not just which code they should share. For example, both birds and insects may implement the Flying interface, but they might not share a common parent class.

To apply an interface to an object you use the keyword "implements":


public class Falcon implements Flying {
An object can implement as many interfaces as you need, which can come in handy when you're limited by single inheritance rules.


public class Bee extends Insect implements Flying, Hibernating, Stinging {
Java already has some popular interfaces:

Interface	Usage
Comparable	requires an implementation of a method that determines which object comes first when comparing two of this object type. Allows for objects to be sorted by other class
Iterable	requires an implementation of a method that returns an iterator. Allows for objects to be looped over
List	requires numerous behaviors such as add, remove, clear, equals etc... Allows for object to be used as List type storage for other data
     */
}
