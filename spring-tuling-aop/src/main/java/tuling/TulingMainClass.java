package tuling;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tuling.aspect.TestBean;

/**
 * Created by smlz on 2019/6/10.
 */
public class TulingMainClass {

    public static void main(String[] args) {

    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);

        Calculate calculate = (Calculate) ctx.getBean("calculate");

        //int retVal = calculate.mod(2,4);
		calculate.div(6,2);

//		TestBean testBean = (TestBean) ctx.getBean("testBean");
//
//		testBean.tech();;
    }
}
