package pruebarelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cartelerav1.app.model.Detalle;
import com.cartelerav1.app.model.Noticia;
import com.cartelerav1.app.model.Pelicula;
import com.cartelerav1.app.repository.DetalleRepository;
import com.cartelerav1.app.repository.NoticiaRepository;
import com.cartelerav1.app.repository.PeliculaRepository;

public class AppFindAll {

	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		PeliculaRepository peliculaRepository = context.getBean("peliculaRepository", PeliculaRepository.class);
		DetalleRepository detalleRepository = context.getBean("detalleRepository", DetalleRepository.class);
		
		List<Pelicula> peliculas = peliculaRepository.findAll();
		
		for (Pelicula pelicula : peliculas)
		{
			System.out.println(pelicula.toString());
		}
		
		context.close();
	}

}
