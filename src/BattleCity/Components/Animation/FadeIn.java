package BattleCity.Components.Animation;

import Engine.Component;

/**
 * Created by Gref on 29.05.2016.
 */
public class FadeIn extends Component {
    public float value = 0;
    public float duration;

    public FadeIn(float duration) {
        this.duration = duration;
    }
}