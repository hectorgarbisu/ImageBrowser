package Persisten;

import Model.BitMap;
import Model.Image;
import Model.RealImage;
import Persisten.Interface.ImageLoader;

/**
 *
 * @author osvaldo
 */
public class ProxyImage extends Image {

    private ImageLoader imageLoader;
    private RealImage realImage;

    public ProxyImage(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    @Override
    public BitMap getBitMap() {
        checkLoader();
        return realImage.getBitMap();
    }

    private void checkLoader() {
        if (imageLoader!= null)return;
        realImage=imageLoader.load();
    }
}
