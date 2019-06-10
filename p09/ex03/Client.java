package p09.ex03;
import java.util.ArrayList;

//Patterns used:
//  -Chain-of-Responsability Pattern (and a pretty simple one at that, but the structure's pretty fun xP)

//Exercise:
//  Implement, using chain of responsability, the classes:
//      Plane
//      Train
//      Bus
//      
//  ALl of these classes should inherit from "Transport.java"
//  
//  Each class can treat a different type of transportation:
//      Plane - International/Intercontinental
//      Train - National
//      Bus - Regional


class Client {
    public static void main(String[] args) {
        ArrayList<TripType> tripList = new ArrayList<>();
        tripList.add(TripType.NATIONAL);
        tripList.add(TripType.REGIONAL);
        tripList.add(TripType.INTERNATIONAL);
        tripList.add(TripType.INTERCONTINENTAL);
        tripList.add(TripType.SEA);

        Transport transportChain =
            new Plane().setSuccessor(
                new Bus().setSuccessor(
                    new Train()));

        for (TripType type : tripList) {
            transportChain.travel(type);
        }
    }
}