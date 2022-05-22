import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class RemoteController {

    private Robot rob;

    RemoteController() {
        try {
            rob = new Robot();
        } catch (AWTException e) {
            System.out.println("exception: " + e.getMessage());
        }
    }

    public void press(int key) {
        rob.keyPress(key);
        rob.keyRelease(key);
    }

    public void ctrl(int key) {
        rob.keyPress(KeyEvent.VK_CONTROL);
        wait(500);
        rob.keyPress(key);
        rob.keyRelease(key);
        rob.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void wait(int time_milsec) {
        rob.delay(time_milsec);
    }

    public void move(int x, int y) {
        x += MouseInfo.getPointerInfo().getLocation().x;
        y += MouseInfo.getPointerInfo().getLocation().y;
        rob.mouseMove(x, y);
    }

    public void click(String button, int number) {
        int mouse;
        switch (button) {
            case "left":
                mouse = InputEvent.BUTTON1_DOWN_MASK;
                break;
            case "right":
                mouse = InputEvent.BUTTON3_DOWN_MASK;
                break;
            case "middle":
                mouse = InputEvent.BUTTON2_DOWN_MASK;
                break;
            default:
                mouse = InputEvent.BUTTON1_DOWN_MASK;
                break;
        }
        for (int i = 0; i < number; i++) {
            rob.mousePress(mouse);
            rob.delay(500);
            rob.mouseRelease(mouse);
            rob.delay(500);
        }
    }

    public void mousePressOrRelease(String button, int action) {
        int mouse;
        switch (button) {
            case "left":
                mouse = InputEvent.BUTTON1_DOWN_MASK;
                break;
            case "right":
                mouse = InputEvent.BUTTON3_DOWN_MASK;
                break;
            case "middle":
                mouse = InputEvent.BUTTON2_DOWN_MASK;
                break;
            default:
                mouse = InputEvent.BUTTON1_DOWN_MASK;
                break;
        }

        switch (action) {
            case 0:
                rob.mousePress(mouse);
                break;
            case 1:
                rob.mouseRelease(mouse);
                break;
            case 2:
                rob.mousePress(mouse);
                rob.delay(500);
                rob.mouseRelease(mouse);
                rob.delay(500);
                break;
        }
    }

    public void zzz(int time) throws InterruptedException {
        TimeUnit.MINUTES.sleep(time);
    }

}