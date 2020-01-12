package pruebajpa;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cartelerav1.app.model.Noticia;
import com.cartelerav1.app.repository.NoticiaRepository;

public class AppUpdate {
	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		Optional<Noticia> noticia;
		NoticiaRepository noticiaRepository = context.getBean("noticiaRepository", NoticiaRepository.class);
		noticia = noticiaRepository.findById(1);
		
		if (noticia.isPresent())
		{
			Noticia noti = noticia.get();
			noti.setTitulo("Titulo modificado");
			noti.setDetalle("Detalle modificado");
			
			// Spring toma como referencia el id, si el id esta presente, reconoce que es un UPDATE
			noticiaRepository.save(noti);
			
			System.out.println("Noticia modificada con exito");
			System.out.println(noticia.get().toString());
		}
		
		context.close();
	}
}
