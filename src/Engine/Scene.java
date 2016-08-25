package Engine;

import java.util.ArrayList;

/**
 * Created by Gref on 29.05.2016.
 */
public class Scene {

    private ArrayList<Entity> entities = new ArrayList<>();
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

    public ArrayList<Entity> getEntities(){
        return this.entities;
    }

    public ArrayList<System> getSystems(){
        return this.systems;
    }

}
