package tuling;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tuling.aspect.TestBean;
import tuling.aspect.TulingCalculate;

/**
 * Created by smlz on 2019/6/10.
 */
@Configuration
@EnableAspectJAutoProxy(exposeProxy = false)
public class MainConfig {

    @Bean
    public Calculate calculate() {
        return new TulingCalculate();
    }

    @Bean
    public TulingLogAspect tulingLogAspect() {
        return new TulingLogAspect();
    }

	@Bean
	public TestBean testBean() {
		return new TestBean();
	}
}
