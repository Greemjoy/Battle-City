package Engine;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Gref on 29.05.2016.
 */
public class Scene {

    private CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<>();
    private ArrayList<System> systems  = new ArrayList<>();

    public void addEntity(Entity entity){
        entities.add(entity);
    }

    public void addSystem(System system){
        systems.add(system);
    }

    public void update(Double dt){
        for (System s : (ArrayList<System>)systems.clone())
            s.update(dt);
    }

    public CopyOnWriteArrayList<Entity> getEntities(){
        return this.entities;
    }

    public ArrayList<System> getSystems(){
        return this.systems;
    }

}
