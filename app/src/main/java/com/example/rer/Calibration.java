package com.example.rer;

public class Calibration {
    float distanceFor30cm = (float) 405.98877;
    float distanceFor50cm = (float) 494.9826;
    float distanceFor100cm = (float) 584.989;
    float proximateDistance;

    public void getDistanceFromDevice(float calculatedDistance) {
        System.out.println("Analizando datos...");

        if (calculatedDistance <= distanceFor30cm) {
            System.out.println("entra a 30");
            proximateDistance = ((calculatedDistance * 30)/distanceFor30cm);
            System.out.println("Se encuentra a " + proximateDistance + " centimetros del objetivo");
        }

        if (distanceFor30cm < calculatedDistance && calculatedDistance <= distanceFor50cm) {
            System.out.println("entra a 50");
            proximateDistance = ((calculatedDistance * 50)/distanceFor50cm);
            System.out.println("Se encuentra a " + proximateDistance + " centimetros del objetivo");
        }

        if (distanceFor50cm < calculatedDistance && calculatedDistance <= distanceFor100cm) {
            System.out.println("entra a 100");
            proximateDistance = ((calculatedDistance * 100)/distanceFor100cm);
            System.out.println("Se encuentra a " + proximateDistance + " centimetros del objetivo");
        }


    }

}
