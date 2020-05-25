package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PlayerControl extends KeyAdapter {

    private GameControl gameControl;

    public PlayerControl(GameControl gameControl){
        this.gameControl = gameControl;
    }

    /**
     * 键盘按下事件
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_E:
                this.gameControl.keyUp();
                break;
            case KeyEvent.VK_D:
                this.gameControl.keyDown();
                break;
            case KeyEvent.VK_S:
                this.gameControl.keyLeft();
                break;
            case KeyEvent.VK_F:
                this.gameControl.keyRight();
                break;
            case KeyEvent.VK_UP:
                this.gameControl.testLevelUp();
                break;
        }
    }

}
