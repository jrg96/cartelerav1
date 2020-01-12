package pruebajpa;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cartelerav1.app.model.Noticia;
import com.cartelerav1.app.repository.NoticiaRepository;

public class AppFindAll {

	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiaRepository noticiaRepository = context.getBean("noticiaRepository", NoticiaRepository.class);
		List<Noticia> noticias = noticiaRepository.findAll();
		
		for (Noticia noticia : noticias)
		{
			System.out.println(noticia.toString());
		}
		
		context.close();
	}

}
