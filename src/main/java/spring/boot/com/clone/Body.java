package spring.boot.com.clone;


/**
 * @author: yiqq
 * @date: 2019/5/6
 * @description: 拷贝与深拷贝、浅拷贝
 * https://mp.weixin.qq.com/s?__biz=MzI5NTYwNDQxNA==&mid=2247484821&idx=1&sn=aed61eee7146952a7664fe4231949b05&chksm=ec505c44db27d552630cec64c90248ebe266d2eef2b4ae7a0a023984efa68a13fe1cd998bee9&scene=0&xtrack=1#rd
 */
public class Body implements Cloneable {
    public Head head;

    public Body(){}
    public Body(Head head) {
        this.head = head;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
        Body body = (Body) super.clone();
        body.head = (Head)head.clone();
        return body;
    }

    static class Head implements Cloneable{
        public Face face;
        public Head(){}

        public Head(Face face) {
            this.face = face;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
//            return super.clone();
            Head newHead = (Head) super.clone();
            newHead.face=(Face)this.face.clone();
            return newHead;
        }
    }


    static class Face implements Cloneable{
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return (Face)super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Body body = new Body(new Head(new Face()));
        Body body1 = (Body) body.clone();
        System.out.println("body == body1 : " + (body == body1));
        System.out.println("body.head == body1.head : " +  (body.head == body1.head));
        System.out.println("body.head.face == body1.head.face : " +  (body.head.face == body1.head.face));

    }
}
