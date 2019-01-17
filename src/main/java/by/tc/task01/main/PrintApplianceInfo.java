package by.tc.task01.main;


import java.util.List;

public class PrintApplianceInfo {

    public static void print(List appliance) {
        if (appliance == null ) {
            System.out.println("Not enough parameters to print");
        } else {
            for (Object res : appliance) {
                System.out.println(res);
            }
        }
    }


}
