/*public class Animal {
    private DigestiveSystem dSys;
    private NervousSystem nSys;

    public void eat() {
        findFood();
        ingestFood();
    }
    public void breathe() {
        extractO2();
        produceCO2();
    }
}

public class Bird extends Animal {
    private boolean flightless;

    public void fly() {
        if (!flightless) {
            soar();
        }
    }

    private void soar() {
        ...
    }

    public class Horse extends Animal {
        public void gallop() {
        ...
        }
    }}*/

/*Overriding
        Sometimes the things you inherit aren't exactly what you want in your child class. If this is the case you can "override" those methods which replaces whatever is inherited with whatever is explicitly defined in the child class.

        Let's say Birds have a very different way of eating than Animals. Birds inherit the following eat method from Animal:

public void eat() {
        findFood();
        ingestFood();
        }
      To replace this method in our Bird class we simply have to copy the exact method header and implement whatever we need in the child class:

public class Bird extends Animal {
    private boolean flightless;

    public void eat() {
        surveyLand();
        findFood();
        deliverToNest();
    }
        ...
}
   Now when we call eat() in the Bird class it will run that version of the method, not in inherited one.*/