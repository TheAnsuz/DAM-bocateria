package org.amrvimag.bocateria;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class ResourceIO {

    private static final BufferedImage DEFAULT_IMAGE = new BufferedImage(32, 32, BufferedImage.TYPE_4BYTE_ABGR_PRE);

    /**
     * Obtains {@code File} using the given path.
     *
     * @param path file path
     * @return the file denoted by the pathname
     */
    public static File storedFile(String path) {
        return new File(path);
    }

    /**
     * Obtains the stream of data from a resource given its path.
     *
     * @param resourcePath the path of the resource, starting from {@code res/}
     * @return the data stream
     */
    public static InputStream resourceStream(String resourcePath) {
        return ResourceIO.class.getClassLoader()
                .getResourceAsStream(resourcePath);
    }

    /**
     * Retrieves the data of a resource file given its path.
     *
     * @param path the path of the resource, starting from {@code res/}
     * @return the data of the resource file as a {@code stringBuilder}
     */
    public static StringBuilder resourceData(String path) {
        final StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ResourceIO
                .resourceStream(path)))) {

            while (reader.ready()) {
                builder.append(reader.readLine()).append(System.lineSeparator());
            }

        } catch (IOException ex) {
            Logger.getLogger(ResourceIO.class.getName())
                    .log(Level.SEVERE, null, ex);

        }
        return builder;
    }

    /**
     * Gets the data of a resource file as an array of lines.
     *
     * @param path the path of the resource, starting from {@code res/}
     * @return an array of strings that contains the data of the resource file
     */
    public static String[] resourceArray(String path) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ResourceIO
                .resourceStream(path)))) {

            Object[] lines = reader.lines().toArray();
            return Arrays.copyOf(lines, lines.length, String[].class);

        } catch (IOException ex) {
            Logger.getLogger(ResourceIO.class.getName())
                    .log(Level.SEVERE, null, ex);
            return new String[0];
        }
    }

    /**
     * Obtains an image given the path to that resource, capable of reading GIF
     * (only first frame), PNG, JPEG, BMP, WBMP.
     *
     * @param path the path of the resource, starting from {@code res/}
     * @return a buffered image using the given image
     */
    public static BufferedImage resourceImage(String path) {
        return streamImage(ResourceIO.resourceStream(path));
    }

    /**
     * Obtains an image given the data input stream directly.
     *
     * @param stream the data stream to be read
     * @return a buffered image containing the stream or a default image if any
     * exception occurs
     */
    public static BufferedImage streamImage(InputStream stream) {
        try {
            return ImageIO.read(stream);
        } catch (IOException | NullPointerException ex) {
            Logger.getLogger(ResourceIO.class.getName())
                    .log(Level.SEVERE, null, ex);
            return DEFAULT_IMAGE;
        }
    }

    /**
     * Obtains an image given the path to that resource, capable of reading GIF
     * (only first frame), PNG, JPEG, BMP, WBMP.
     *
     * @param path the path of the resource, starting from {@code res/}
     * @param width the width of the result image
     * @param height the hegiht of the result image
     * @return a buffered image using the given image
     */
    public static BufferedImage resourceImage(String path, int width, int height) {
        final BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        try {
            img.createGraphics().drawImage(ImageIO.read(ResourceIO
                    .resourceStream(path)), 0, 0, width, height, null);
            return img;
        } catch (IOException | NullPointerException | IllegalArgumentException ex) {
            Logger.getLogger(ResourceIO.class.getName())
                    .log(Level.SEVERE, null, ex);
            return DEFAULT_IMAGE;
        }
    }

    /**
     * Retrieves an image from a system file given its path capable of reading
     * GIF (only first frame), PNG, JPEG, BMP, WBMP.
     *
     * @param path the path to the file
     * @return a buffered image
     */
    public static BufferedImage storedImage(String path) {
        try {
            return ImageIO.read(ResourceIO.storedFile(path));
        } catch (IOException ex) {
            Logger.getLogger(ResourceIO.class.getName())
                    .log(Level.SEVERE, null, ex);
            return DEFAULT_IMAGE;
        }
    }

    /**
     * Retrieves an image from a system file given its path capable of reading
     * GIF (only first frame), PNG, JPEG, BMP, WBMP.
     *
     * @param path the path to the file
     * @param width the desired width of the image
     * @param height the desired height of the image
     * @return a buffered image
     */
    public static BufferedImage storedImage(String path, int width, int height) {
        final BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        try {
            img.createGraphics().drawImage(ImageIO.read(ResourceIO
                    .storedFile(path)), 0, 0, width, height, null);
            return img;
        } catch (IOException | IllegalArgumentException | NullPointerException ex) {
            Logger.getLogger(ResourceIO.class.getName())
                    .log(Level.SEVERE, null, ex);
            return DEFAULT_IMAGE;
        }
    }

    /**
     * Gets the data of a system file as an array of lines.
     *
     * @param path the path to the file
     * @return an array of strings that contains the data of the file
     */
    public static String[] storedArray(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ResourceIO
                .storedFile(path)))) {

            Object[] lines = reader.lines().toArray();
            return Arrays.copyOf(lines, lines.length, String[].class);

        } catch (IOException ex) {
            Logger.getLogger(ResourceIO.class.getName())
                    .log(Level.SEVERE, null, ex);
            return new String[0];
        }
    }

    /**
     * Retrieves the data of a resource file given its path as a StringBuilder.
     *
     * @param path the path to the file
     * @return the data of the file as a {@code stringBuilder}
     */
    public static StringBuilder storedData(String path) {
        final StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ResourceIO
                .resourceStream(path)))) {

            while (reader.ready()) {
                builder.append(reader.readLine()).append(System.lineSeparator());
            }

        } catch (IOException ex) {
            Logger.getLogger(ResourceIO.class.getName())
                    .log(Level.SEVERE, null, ex);

        }
        return builder;
    }

    /**
     * Saves an array of strings or any other char sequence to a file in the
     * system, returning the result of the operation.
     *
     * @param path the path to the file (it the file does not exisist, it will
     * create it)
     * @param array the data to be saved
     * @return true if the operation was succesful, false otherwise
     */
    public static boolean saveArray(String path, CharSequence[] array) {
        final File file = storedFile(path);

        if (!file.exists())
            if (!createFile(file))
                return false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            for (int i = 0; i < array.length; i++) {
                if (array[i] == null)
                    continue;

                writer.write(array[i].toString());

                if (i + 1 < array.length)
                    writer.newLine();
            }

            return true;

        } catch (IOException ex) {
            Logger.getLogger(ResourceIO.class.getName())
                    .log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Saves a char sequence to a file in the system, returning the result of
     * the operation.
     *
     * @param path the path to the file (it the file does not exisist, it will
     * create it)
     * @param data the data string to be saved
     * @return true if the operation was succesful, false otherwise
     */
    public static boolean saveData(String path, CharSequence data) {
        final File file = storedFile(path);

        if (!file.exists())
            if (!createFile(file))
                return false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(data.toString());
            return true;

        } catch (IOException ex) {
            Logger.getLogger(ResourceIO.class.getName())
                    .log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private static boolean createFile(File file) {
        try {
            return (file.getParentFile() != null ? file.getParentFile().mkdirs() : true) && file
                    .createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(ResourceIO.class.getName())
                    .log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
