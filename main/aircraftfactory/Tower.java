package aircraftfactory;

import java.util.List;
import java.util.ArrayList;

public class Tower {

    private List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<Flyable>();
    }

    public void register(Flyable p_flyable){
        observers.add(p_flyable);
        System.out.printf("Tower says: %s#%s(%d) registered to weather tower\n", p_flyable.getType(), p_flyable.getName(), p_flyable.getId());
    }
    public void unregister(Flyable p_flyable){
        observers.remove(observers.indexOf(p_flyable));
        System.out.printf("Tower says: %s#%s(%d) unregistered successfuly from weather tower\n", p_flyable.getType(), p_flyable.getName(), p_flyable.getId());
    }

    protected void conditionChanged(){
        System.out.println("Tower says: Be careful pilots weather changed");
    }

    public List<Flyable> getObservers() {
        return this.observers;
    }

}