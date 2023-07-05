package CallBack;

public class Example{

    public static void main(String args[]){

        People a;             //声明接口变量

        a=new Studentt();      //实例化，接口变量中存放对象的引用

        Studentt studentt=new Studentt();
        studentt.peopleList();

        Teacher teacher=new Teacher();
        teacher.peopleList();
/*        a.peopleList();        //接口回调

        a=new Teacher();     //实例化，接口变量中存放对象的引用

        a.peopleList();       //接口回调*/

    }

}
