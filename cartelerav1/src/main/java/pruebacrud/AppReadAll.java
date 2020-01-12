package pruebacrud;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cartelerav1.app.model.Noticia;
import com.cartelerav1.app.repository.NoticiaRepository;

public class AppReadAll {

	public static void main(String[] args) {
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		Iterable<Noticia> noticias;
		NoticiaRepository noticiaRepository = context.getBean("noticiaRepository", NoticiaRepository.class);
		noticias = noticiaRepository.findAll();
		
		for (Noticia noticia : noticias)
		{
			System.out.println(noticia.toString());
		}
		
		context.close();
	}

}
