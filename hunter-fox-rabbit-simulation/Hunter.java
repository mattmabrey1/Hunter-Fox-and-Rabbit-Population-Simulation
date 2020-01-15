import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * A simple model of a hunter.
 * Hunters move to random places and try to kill animals adjacent to them.
 * If successful the hunter moves to the killed animals location and
 * checks for more adjacent animals to kill.
 * @author Matthew Mabrey
 * @version 2019.04.23
 */
public class Hunter extends Animal
{
  
    private static final Random rand = Randomizer.getRandom();
    
 
    /**
     * Create a hunter. A hunter has no age or food level and never dies.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Hunter(Field field, Location location)
    {
        super(field, location);
    }
    
    /**
     * This is what the hunter: it hunts for
     * rabbits and foxes and moves to random locations.
     * @param field The field currently occupied.
     * @param newHunters An empty list for the current simulation.
     */
    public void act(List<Animal> newHunters)
    {
        if(isAlive()) {
                    
            
            // Move towards the prey if found.
            Location newLocation = findPrey();
            if(newLocation == null) { 
                // No prey found - try to move to a random location.
                newLocation = getField().randomLocation(getLocation());
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }
    

  
    /**
     * Look for rabbits and foxes adjacent to the current location.
     * Only the first live animal is killed.
     */
    private Location findPrey()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        int killChance = rand.nextInt(10);
        
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Rabbit) {
               Rabbit rabbit = (Rabbit) animal;
               
               if(killChance <= 6)
               {
                   if(rabbit.isAlive()) { 
                        rabbit.setDead();
                        return where;
                    }
               }
            }
            else if(animal instanceof Fox) {
                Fox fox = (Fox) animal;
                
                if (killChance <= 4)
                {
                    if(fox.isAlive()) { 
                        fox.setDead();
                        return where;
                    }
                }
            }
           
        }
        return null;
    }
    
    

  
}
