package BattleCity.Components;

import Engine.Component;

/**
 * Created by Gref on 29.05.2016.
 */
public class Speed extends Component{

    public int value;
    public Speed(int value) {
        this.value = value;
    }

    public void setSpeed(int value){
        this.value = value;
    }

}
