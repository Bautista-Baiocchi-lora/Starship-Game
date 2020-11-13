package edu.austral.dissis.starship.base.framework;

import processing.core.PApplet;
import processing.core.PImage;

import java.net.URL;
import java.util.HashMap;

import static java.util.Objects.requireNonNull;

public class ImageLoader {
    private final PApplet applet;
    private final HashMap<String, PImage> IMAGE_CACHE = new HashMap<>();

    public ImageLoader(PApplet applet) {
        this.applet = applet;
    }

    public PImage load(String fileName) {
        if (IMAGE_CACHE.containsKey(fileName)) {
            return IMAGE_CACHE.get(fileName);
        }
        final URL url = requireNonNull(getClass().getClassLoader().getResource(fileName));
        IMAGE_CACHE.put(fileName, applet.loadImage(url.getPath()));
        return IMAGE_CACHE.get(fileName);
    }
}
