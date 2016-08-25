import BattleCity.GameManager;
import BattleCity.Scenes.StartGameScene;

public class Main {

    public static void main(String[] args) {
        GameManager.instance.setScene(new StartGameScene());
        GameManager.instance.run();

    }
}
