package banner.example.banner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {



    @Qualifier("theBean")
    @Autowired
    private MyFristClass myFirstClass;

//    public  MyFirstService(@Qualifier("theBean") MyFristClass myFristClass) {
//        this.myFirstClass = myFristClass;
//    }

    @Autowired
    public void  injectDependencies(MyFristClass myFristClass) {
        this.myFirstClass = myFristClass;
    }




    public  String tellStory() {
//        myFirstClass= new MyFristClass("village");
        return  "the dependency" + myFirstClass.sayHello();
    }
}
