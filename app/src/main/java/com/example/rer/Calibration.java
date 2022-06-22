package com.example.rer;

public class Calibration {
    float distanceFor25cm = (float) 312.97851;
    float distanceFor30cm = (float) 352.99072;
    float distanceFor40cm = (float) 425.99488;
    float distanceFor50cm = (float) 475.99365;
    float distanceFor70cm = (float) 528.00294;
    float distanceFor85cm = (float) 562.97242;
    float distanceFor100cm = (float) 576.98;
    float proximateDistance;

    public float getDistanceFromDevice(float calculatedDistance) {
        System.out.println("Analizando datos...");

        if (calculatedDistance <= distanceFor25cm) {
            System.out.println("entra a 25");
            proximateDistance = ((calculatedDistance * 25)/distanceFor25cm);
            System.out.println("Se encuentra a " + proximateDistance + " centimetros del objetivo");
        }

        if (distanceFor25cm < calculatedDistance && calculatedDistance <= distanceFor30cm) {
            System.out.println("entra a 30");
            proximateDistance = ((calculatedDistance * 30)/distanceFor30cm);
            System.out.println("Se encuentra a " + proximateDistance + " centimetros del objetivo");
        }

        if (distanceFor30cm < calculatedDistance && calculatedDistance <= distanceFor40cm) {
            System.out.println("entra a 40");
            proximateDistance = ((calculatedDistance * 40)/distanceFor40cm);
            System.out.println("Se encuentra a " + proximateDistance + " centimetros del objetivo");
        }

        if (distanceFor40cm < calculatedDistance && calculatedDistance <= distanceFor50cm) {
            System.out.println("entra a 50");
            proximateDistance = ((calculatedDistance * 50)/distanceFor50cm);
            System.out.println("Se encuentra a " + proximateDistance + " centimetros del objetivo");
        }

        if (distanceFor50cm < calculatedDistance && calculatedDistance <= distanceFor70cm) {
            System.out.println("entra a 70");
            proximateDistance = ((calculatedDistance * 70)/distanceFor70cm);
            System.out.println("Se encuentra a " + proximateDistance + " centimetros del objetivo");
        }

        if (distanceFor70cm < calculatedDistance && calculatedDistance <= distanceFor85cm) {
            System.out.println("entra a 85");
            proximateDistance = ((calculatedDistance * 85)/distanceFor85cm);
            System.out.println("Se encuentra a " + proximateDistance + " centimetros del objetivo");
        }

        if (distanceFor85cm < calculatedDistance ) {
            System.out.println("entra a 100");
            proximateDistance = ((calculatedDistance * 100)/distanceFor100cm);
            System.out.println("Se encuentra a " + proximateDistance + " centimetros del objetivo");
        }

        return proximateDistance;

    }

}
