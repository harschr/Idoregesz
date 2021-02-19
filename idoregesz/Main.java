package harschr.idoregesz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Scene startScene = new Scene("Kezdeti helyszín");
        Scene otherScene = new Scene("Kisszoba");
        Door d = new Door(startScene, otherScene, true);
        Kulcs kisszobaKulcs = new Kulcs("kisszoba", false);
        Belongings terkep = new Belongings();

        startScene.setDoor(d);
        otherScene.setDoor(d);

        Scene currentScene = startScene;

        System.out.println("2546-ot írunk. Most alakult meg az Időrégészeti Társaság, melynek egyik ügynöke vagy.");
        System.out.println("Egy gazdag gyűjtő megrendelésére vissza kell menned a középkorba, és meg kell szerezned a mesebeli griffmadár egyik tojását.");
        System.out.println("Utadon nem segít a modern technika, mindent egyedül kell csinálnod!");
        System.out.println("");
        System.out.println("Légy nagyon körültekintő, mindent vizsgálj meg!");

        String command;
        do {
            System.out.println("\n" + currentScene.getDescription() + "\nMit csinálsz?");
            command = sc.nextLine();
            switch (command) {
                case "kinyit":
                    d.open();
                    break;
                case "becsuk":
                    d.close();
                    break;
                case "kizár":
                    if (d.unlock("")) {
                        System.out.println("Kinyitod az ajtón a zárat.");
                    } else {
                        System.out.println("Nem tudod kinyitni az ajtót.");
                    }
                    break;
                case "bezár":
                    if (d.lock("")) {
                        System.out.println("Bezárod az ajtót.");
                    } else {
                        System.out.println("Nem tudod bezárni az ajtót.");
                    }
                    break;
                case "átmegy":
                    Scene newScene = currentScene.goThrough();
                    if (newScene != currentScene) {
                        System.out.println("Átmentél a másik szobába.");
                        currentScene = newScene;
                    } else {
                        System.out.println("Nem tudsz átmenni a másik szobába.");
                    }
                    break;
                case "kilép":
                    System.out.println("A küldetést nem teljesítetted. Viszlát!");
                    return;
                default:
                    System.out.println("Nem értem, próbálkozz újra!");
                    break;
            }
        } while (!command.equals("átmegy"));

        System.out.println("\nA kisszobában vagy.");
        System.out.println("Előtted az asztalon egy kulcs hever. ");
        System.out.println("A szoba nyugati sarkában egy ágy található. A keleti sarokban egy szekrény áll, rajta egy ósdi könyv. Északra egy ajtó van.");

        do {
            System.out.println("\nMit csinálsz?");
            command = sc.nextLine();

            switch (command) {
                case "felvesz kulcs":
                    kisszobaKulcs.setKey();
                    System.out.println("Felvetted a kulcsot.");
                    break;
                case "kinyit ajtó":
                    if (kisszobaKulcs.isThereAKey("")) {
                        System.out.println("Kinyitottad az ajtót.");
                    } else {
                        System.out.println("Nincs kulcsod hozzá!");
                    }
                    break;
                case "megnéz könyv":
                    terkep.setMap();
                    System.out.println("A könyvben találsz egy térképet, mely az útvonalat mutatja küldetésed céljához. Elteszed a térképet, még jól jöhet.");
                    System.out.println("Eltett tárgyaid: " + (terkep.getMap() ? "térkép" : ""));
                    break;
                case "lefekszik":
                    System.out.println("Nincs idő lustálkodni! Meg kell találnod a griffmadár egyik tojását!");
                    break;
                case "átmegy":
                    Scene newScene = currentScene.goThrough();
                    if (newScene != currentScene) {
                        System.out.println("Kimentél a házból.");
                        currentScene = newScene;
                    } else {
                        System.out.println("Nem tudsz átmenni a másik szobába.");
                    }
                    break;
                case "kilép":
                    System.out.println("A küldetést nem teljesítetted. Viszlát!");
                    return;
                default:
                    System.out.println("Nem értem, próbálkozz újra!");
                    break;
            }
        } while (!command.equals("átmegy"));

        System.out.println("Egy mezőre érkeztél.");
        System.out.println("Egy ösvény vezet nyugatra és egy másik keletre.");
        System.out.println("Mit csinálsz?");
        
        
    }

}
