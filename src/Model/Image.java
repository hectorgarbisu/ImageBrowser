package Model;
public abstract class Image {
    private Image next;
    private Image prev;
    private String title;
    public abstract BitMap getBitMap();

    public Image getNext() {
        return next;
    }

    public Image getPrev() {
        return prev;
    }

    public void setNext(Image next) {
        this.next = next;
    }

    public void setPrev(Image prev) {
        this.prev = prev;
    }
    
    public void setTitle(String fileName) {
        this.title = fileName;
    }
    public String getTitle(){
        return this.title;
    }
}
