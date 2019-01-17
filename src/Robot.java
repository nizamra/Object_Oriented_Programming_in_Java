public class Robot {
    private boolean fuelEmpty;
    private int roboID;
    private String greeting;
    private String securityProtocol;

    // insert Robot constructor here (CHOOSE ONE)
    public Robot(boolean full, int id, String greet, String proto) {
        fuelEmpty = full;
        roboID = id;
        greeting = greet;
        securityProtocol = proto;
    }
    public void destroyAllHumans(){
        while (fuelEmpty == false) {
            //robot begins to destroy all humans
        }
    }
    public int getRoboID(){
        return roboID;
    }
    public void greet(){
        System.out.println(greeting);
    }
    public void setSecurityProtocol(String proto){
        securityProtocol = proto;
    }
}
