import java.util.Scanner;
import java.util.ArrayList;

class Game {
    private static ArrayList<Map> zones = new ArrayList<>();
    
    public static void main(String[] args) {
        makeZones();
        Hero hero = new Hero();
        hero.setHealth(100);
        hero.setLocation(getZone("Courtyard"));
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        firstScene();
        
        while (hero.getHealth() > 0) {
        hero.performAction();
        //System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            
            //random encounter
            //double random = (int)(Math.random() * 10);
            //System.out.println(random);
        }        
    }
    
    public static void firstScene() {
        System.out.println("You wake up feeling dizzy. What is this place?");
    }
    
    public static void makeZones() {      
        Map courtyard = new Courtyard("Courtyard", true, false, true, 4);
        Map mainHall = new MainHall("Main Hall", true, true, true, 3);
        
        zones.add(mainHall);
        zones.add(courtyard);
    }
    
     public static Map getZone(String zoneName) {
        Map newZone = null;
        for(Map zone : zones) {
            if (zone.getName().equals(zoneName))
                newZone = zone;
        }
        
        if (newZone == null) {
            System.out.println("There is no such place");
            
        }
     
        return newZone;
    }
}

class Hero {
    private Map currentLocation;
    private int health;
    
    public Hero() {
    }
    
    public void performAction() {
        
        System.out.println("\nWhat do you want to do?");
        System.out.println("1. Look around");
        System.out.println("2. Move");
        System.out.println("3. Explore");
        System.out.println("4. Rest");
        System.out.println("0. Quit game");
        Scanner input = new Scanner(System.in);
        int action = input.nextInt();
        input.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
        if (action == 0) {
            System.out.println("\nQuiting the game");
            System.exit(0);
        }
        
        else if (action == 1) {
            System.out.println(currentLocation.toString());
        }
        
        else if (action == 2) {
            System.out.println("\nWhere do you want to go?\n");
            String area = input.nextLine();
            setLocation(Game.getZone(area));
        }
        
        else if (action == 3) {
           currentLocation.getEnviroment();
        }       
    }
    
    public void setLocation(Map location) {
        this.currentLocation = location;
        System.out.println("Current area: " + currentLocation.getName() + "\n");
    }
    
    public Map getLocation() {
        return currentLocation;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
}

class Map {
    private String name;
    private boolean safe;
    private boolean outside;
    private boolean explored;
    private int visibility;
    private Enviroment enviroment;
    
    public Map(String name, boolean safe, boolean outside,
                boolean explored, int visibility) {
                
        setName(name);
        setSafe(safe);
        setOutside(outside);
        setExplored(explored);
        setVisibility(visibility);
    }
    @Override
    public String toString() {
        return "This is the " + getName() + "\n" + isSafe() + "\n" + 
            isOutside() + "\n" + isExplored() + "\n" + checkVisibility();
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSafe(boolean safe) {
        this.safe = safe;
    }
    
    public void setExplored(boolean explored) {
        this.explored = explored;
    }
    
    public void setOutside(boolean outside) {
        this.outside = outside;
    }
    
    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean getSafe() {
        return safe;
    }
    
    public boolean getExplored() {
        return explored;
    }
    
    public int getVisibility() {
        return visibility;
    }
    
    public String isOutside() {
        if (!outside)
            return "The area is inside";
        else
            return "The area is outside";
    } 
    
    public String isExplored() {
        if (!explored)
            return "The area is not explored";
        else
            return "The area is fully explored";
    }
    
    public String isSafe() {
        if (!safe)
            return "The area is not safe!";
        else
            return "The area seems to be safe";
    }
    
    public String checkVisibility() {
        if (visibility < 1)
            return "It's pitch dark, you can't see at all";
        else if ((visibility >= 1) && (visibility <=3))
            return "The light here is dim, you can barely see";
        else if ((visibility >= 4) && (visibility <=6))
            return "This area is well lit with a few dark corners, you can see normally";
        else
            return "There's bright light, you can see very well";
    }
    
    public Enviroment getEnviroment() {
        enviroment.toString();
        return enviroment;
    }
}

class Courtyard extends Map {
    private Enviroment statue;
    
    public Courtyard(String name, boolean safe, boolean outside,
           boolean explored, int visibility) {
        
        super(name, safe, outside, explored, visibility);
        statue = new Statue("An ancient statue, weathered down to the unrecognizable",
            "\"A boy given fruit today will plant the apple tree tomorrow", true);
    }
    
    @Override
    public String toString() {
        return "\nYou are standing in a wide grassy field littered with ruins. " + 
            super.toString(); 
    }
}   

class MainHall extends Map {
    
    public MainHall(String name, boolean safe, boolean outside,
            boolean explored, int visibility) {
            
        super(name, safe, outside, explored, visibility);       
    }
}

class Enviroment {
    private String description;
    
    public Enviroment(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String toString() {
        return description;
    }
}

class Statue extends Enviroment {
    private String markings;
    private boolean destroyed;
    
    public Statue(String description, String markings, boolean destroyed) {
        super(description);
        setMarkings(markings);
        this.destroyed = destroyed;
    }
    
    public String getMarkings() {
        return markings;
    }
    
    public boolean getDestroyed() {
        return destroyed;
    }
    
    public void setMarkings(String markings) {
        this.markings = markings;
    }
    
    public void setDestroyed() {
        this.destroyed = destroyed;
    }
}
