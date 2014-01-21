package Model;
public class RealImage extends Image {

    BitMap bitmap;

    public RealImage(BitMap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public BitMap getBitMap() {
        return bitmap;
    }
}
