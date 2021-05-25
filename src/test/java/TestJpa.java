import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.pokebowl.AppConfig;

public class TestJpa {

	public static void main(String[] args) {
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebowl");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.close();
		//emf.close();
//		System.out.println("Hello");
	}
}
