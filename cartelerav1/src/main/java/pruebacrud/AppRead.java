package pruebacrud;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cartelerav1.app.model.Noticia;
import com.cartelerav1.app.repository.NoticiaRepository;

public class AppRead {

	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		Optional<Noticia> noticia;
		NoticiaRepository noticiaRepository = context.getBean("noticiaRepository", NoticiaRepository.class);
		noticia = noticiaRepository.findById(1);
		
		if (noticia.isPresent())
		{
			System.out.println(noticia.get().toString());
		}
		
		context.close();
	}

}
