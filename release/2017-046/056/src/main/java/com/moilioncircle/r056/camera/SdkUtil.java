package com.moilioncircle.r056.camera;

import com.sun.jna.ptr.IntByReference;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.moilioncircle.r056.camera.jna.GxIAPI.*;

/**
 * @author trydofor
 * @since 2017-10-24
 */
public class SdkUtil {

    public static BufferedImage rgb24(byte[] rgb24, final int width, final int height) {
        return null;
    }

    public static void printStatus(int status, String msg) {
        String error = transApiStatus(status);
        if (error == null) {
            System.out.println(msg + "，成功：" + status);
        } else {
            System.err.println(msg + "，错误(" + status + "):" + error);
        }
    }

    public static void checkStatus(int status, String msg) {
        String error = transApiStatus(status);
        if (error != null) {
            throw new IllegalStateException(msg + "，错误(" + status + "):" + error);
        }
    }

    public static boolean isApiError(int status) {
        return status != GX_STATUS_SUCCESS;
    }

    public static boolean bool(IntByReference ref) {
        return ref.getValue() != 0;
    }

    public static String transApiStatus(int status) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        String rgbfile = "./2592x1944-1-ori.dat"; // 2592 × 1944
        String imgType = "jpg";
        byte[] rgb24 = Files.readAllBytes(Paths.get(rgbfile));
        BufferedImage img = rgb24(rgb24, 2592, 1944);

        FileOutputStream fos = new FileOutputStream(rgbfile + "." + imgType);
        ImageIO.write(img, imgType, fos);
        fos.close();
    }
}
