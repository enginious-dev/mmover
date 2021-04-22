package com.enginious.mmover;

import org.jnativehook.GlobalScreen;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MMover {

    private static final List<Double> ANGLES = Arrays.asList(0.0, 11.25, 22.5, 33.75, 45.0, 56.25, 67.5, 78.75, 90.0, 101.25, 112.5, 123.75, 135.0, 146.25, 157.5, 168.75, 180.0, 191.25, 202.5, 213.75, 225.0, 236.25, 247.5, 258.75, 270.0, 281.25, 292.5, 303.75, 315.0, 326.25, 337.5, 348.75);
    private static final int SLEEP_S = 200;

    public static void main(String... args) throws Exception {

        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        logger.setUseParentHandlers(false);

        GlobalScreen.registerNativeHook();

        GlobalScreen.addNativeMouseListener(new NativeMouseInputListener() {
            public void nativeMouseClicked(NativeMouseEvent e) {
                System.exit(1);
            }

            public void nativeMousePressed(NativeMouseEvent e) {
            }

            public void nativeMouseReleased(NativeMouseEvent e) {
            }

            public void nativeMouseMoved(NativeMouseEvent e) {
            }

            public void nativeMouseDragged(NativeMouseEvent e) {
            }
        });

        int h = ((int) screenSize.getHeight()) / 2;
        int w = ((int) screenSize.getWidth()) / 2;
        while (true) {
            robot.mouseMove(h, w);
            for (double angle : ANGLES){
                robot.mouseMove(w + ((int) (Math.cos(Math.toRadians(angle)) * 100)), h);
                Thread.sleep(SLEEP_S);
            }
        }
    }
}
