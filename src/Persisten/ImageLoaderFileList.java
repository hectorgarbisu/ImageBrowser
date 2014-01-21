package Persisten;

import Model.Image;
import Persisten.Interface.ImageLoaderList;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ImageLoaderFileList implements ImageLoaderList {

    String path;

    public ImageLoaderFileList(String nameFile) {
        this.path = nameFile;
    }

    public String getNameFile() {
        return path;
    }

    @Override
    public List<Image> load() {
        return linkImage(loadImage());
    }

    public List<Image> loadImage() {
        List<Image> imageList = new ArrayList<>();
        for (String name : new File(path).list()) {
            if(name.contains(".npg")||name.contains(".jpg")||name.contains(".bmp")||name.contains(".gif")){
            imageList.add(new ProxyImage(new ImageLoaderFile(path + "/" + name)));
            }
        }
        return imageList;
    }

    public List<Image> linkImage(List<Image> images) {
        for (int i = 0; i < images.size(); i++) {
            Image image = images.get(i);
            image.setNext(images.get((i + 1) % images.size()));
            image.setPrev(images.get((i + images.size() - 1) % images.size()));
        }
        return images;
    }
}
