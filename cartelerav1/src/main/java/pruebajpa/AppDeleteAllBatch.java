package pruebajpa;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cartelerav1.app.model.Noticia;
import com.cartelerav1.app.repository.NoticiaRepository;

public class AppDeleteAllBatch {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiaRepository noticiaRepository = context.getBean("noticiaRepository", NoticiaRepository.class);
		
		// Este metodo genera 1 sola sentencia SQL para eliminar en batch (ej: usando tecnicas como bulk collect, etc)
		noticiaRepository.deleteAllInBatch();
		
		context.close();
	}

}
