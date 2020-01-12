package pruebacrud;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cartelerav1.app.model.Noticia;
import com.cartelerav1.app.repository.NoticiaRepository;

public class AppDelete {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiaRepository noticiaRepository = context.getBean("noticiaRepository", NoticiaRepository.class);
		
		if(noticiaRepository.existsById(2))
		{
			noticiaRepository.deleteById(2);
		}
		
		context.close();
	}

}
