package com.weichuang.day08Demo;
/**
 * 若类想要被clone，那么此类必须实现CloneAble接口，此接口没有任何方法与属性（标记接口）
 * clone : 克隆绵羊 ，没爹没娘
 * 战斗机发射子弹，此子弹需要克隆技术实现
 */
public class CloneDemo {
    public static void main(String[] args) {
        Bullet b1 = new Bullet(10 ,20 , "灰色");
        Bullet b2 = new Bullet(10 , 20 , "灰色");
        System.out.println(b1 == b2);

        try {
            Bullet b3 = (Bullet) b1.clone();//只是做了复制，进了缓存。但并没有在堆中申请内存空间
            System.out.println(b1.hashCode());
            System.out.println(b3.hashCode());
            System.out.println(b1 == b3);
            System.out.println(b3);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}

/**
 * 子弹
 */
class Bullet implements Cloneable{//标记此类可以被克隆
    private int width;
    private int height;
    private String color;

    public Bullet() {
    }

    public Bullet(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 重写clone方法
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                '}';
    }
}
