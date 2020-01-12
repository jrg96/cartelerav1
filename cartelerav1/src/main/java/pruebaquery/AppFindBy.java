package pruebaquery;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;

import com.cartelerav1.app.model.Noticia;
import com.cartelerav1.app.repository.NoticiaRepository;

public class AppFindBy {

	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiaRepository noticiaRepository = context.getBean("noticiaRepository", NoticiaRepository.class);
		
		// Buscando todos los que tengan ese estatus, pagina
		List<Noticia> noticias = noticiaRepository.findAllByEstatus("Activa", PageRequest.of(0, 15));
		
		for (Noticia noticia : noticias)
		{
			System.out.println(noticia.toString());
		}
		
		// Buscando por estatus y que titulo comience por
		System.out.println("------------------------------------------------------------");
		noticias = noticiaRepository.findAllByEstatusAndTituloStartingWith("Activa", "Titulo pelicula", PageRequest.of(0, 15));
		
		for (Noticia noticia : noticias)
		{
			System.out.println(noticia.toString());
		}
		
		
		
		context.close();

	}

}
