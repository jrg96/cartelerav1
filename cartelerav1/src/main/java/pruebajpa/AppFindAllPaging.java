package pruebajpa;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.cartelerav1.app.model.Noticia;
import com.cartelerav1.app.repository.NoticiaRepository;

public class AppFindAllPaging {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiaRepository noticiaRepository = context.getBean("noticiaRepository", NoticiaRepository.class);
		
		// Solamente paginacion
		// Page<Noticia> noticias = noticiaRepository.findAll(PageRequest.of(0, 15));
		
		// Paginacion y ordenamiento
		Page<Noticia> noticias = 
				noticiaRepository.findAll(
						PageRequest.of(
								0, 
								15,
								Sort.by("titulo")
						)
				);
		
		for (Noticia noticia : noticias)
		{
			System.out.println(noticia.toString());
		}
		
		context.close();
	}

}
