package throwContractRule.part2.item7;

public class Overriding {
//    7. Overriding и throws
//
//    При переопределении (overriding) список исключений потомка не обязан совпадать с таковым у предка.
//    Но он должен быть «не сильнее» списка предка:
            import java.io.FileNotFoundException;
import java.io.IOException;

    public class Parent {
        // предок пугает IOException и InterruptedException
        public void f() throws IOException, InterruptedException {}
    }

    class Child extends Parent {
        // а потомок пугает только потомком IOException
        @Override
        public void f() throws FileNotFoundException {}
    }


//    Однако тут мы попытались «расширить тип» бросаемых исключений
import java.io.IOException;

    public class Parent {
        public void f() throws IOException, InterruptedException {}
    }

    class ChildB extends Parent {
        @Override
        public void f() throws Exception {}
    }

//>> COMPILATION ERROR: overridden method does not throw 'java.lang.Exception'


//    Почему можно сужать тип, но не расширять?
//    Рассмотрим следующую ситуацию:
    public class Parent {
        // предок пугает Exception
        public void f() throws Exception {}
    }


    // тут ошибка компиляции в Java, но, ДОПУСТИМ, ее нет
    public class Child extends Parent {
        // потомок расширил Exception до Throwable
        public void f() throws Throwable {}
    }


    public class Demo {
        public static void test(Parent ref) {
            // тут все компилируется, Parent.f() пугает Exception и мы его ловим catch
            try {
                ref.f();
            } catch(Exception e) {}
        }
    }


    public class App {
        public static void main(String[] args) {
            // тут все компилируется, Demo.test хотел Parent и мы дали ему подтип - Child
            Demo.test(new Child());
        }
    }


//    Внимательно посмотрите на этот пример — если бы потомок мог расширять тип бросаемого исключения предка, то те места которые «ждут» предка, а получают экземпляр «расширенного» потомка могли бы неконтролируемо выбрасывать проверяемые исключения
}
