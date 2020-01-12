package pruebacrud;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cartelerav1.app.model.Noticia;
import com.cartelerav1.app.repository.NoticiaRepository;

public class AppCreate {

	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		System.out.println("Creando objeto noticia");
		Noticia noticia = new Noticia();
		noticia.setTitulo("Titulo de la noticia 2");
		noticia.setDetalle("Cuerpo de la noticia a desplegar en pantalla 2");
		
		// Persistir en la DB oracle
		System.out.println("Persistiendo objeto");
		NoticiaRepository noticiaRepository = context.getBean("noticiaRepository", NoticiaRepository.class);
		noticiaRepository.save(noticia);
		System.out.println("Persistencia creada con exito");
		
		context.close();
	}

}
