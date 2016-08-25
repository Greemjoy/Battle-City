package BattleCity.Components.Animation;

import Engine.Component;

/**
 * Created by Gref on 29.05.2016.
 */
public class FadeOut extends Component {

    public float value = 1;
    public float duration;

    public FadeOut(float duration) {
        this.duration = duration;
    }
}