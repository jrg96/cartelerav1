package pruebajpa;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import com.cartelerav1.app.model.Noticia;
import com.cartelerav1.app.repository.NoticiaRepository;

public class findAllOrderBy {

	public static void main(String[] args) {
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiaRepository noticiaRepository = context.getBean("noticiaRepository", NoticiaRepository.class);
		
		List<Noticia> noticias =  
				noticiaRepository.findAll(
											Sort.by("fecha").descending()
											.and( Sort.by("titulo").descending()
											.and( Sort.by("estatus").ascending() ))
										);
		
		for (Noticia noticia : noticias)
		{
			System.out.println(noticia.toString());
		}
		
		context.close();
	}

}
