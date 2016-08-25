package Engine;

import java.util.HashMap;

/**
 * Created by Gref on 29.05.2016.
 */
public class Entity {

    private HashMap<Class<?>, Component> components = new HashMap<>();

    public <T extends Component> T getComponent (Class<T>  componentType){
        return (T)components.get(componentType);
    }

    public <T extends Component> T addComponent (T component){
        return (T)components.put(component.getClass(), component);
    }

    public Boolean hasComponent(Class<? extends Component> componentType){
        return this.components.containsKey(componentType);
    }

    public Component removeComponent(Class<? extends Component> componentType){
        return this.components.remove(componentType);
    }


}
