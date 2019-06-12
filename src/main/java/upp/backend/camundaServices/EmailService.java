package upp.backend.camundaServices;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import upp.backend.model.Rad;


@Service
public class EmailService {
	public static String email = "naucna.cetralau.upp@gmail.com";
	public static String pass = "uppsifra";

	public void KreiranRadMejl(String posaljiAutoru, String posaljiUredniku, Rad rad) {
		
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", email);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");


		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(email));

			InternetAddress autorovaAdresa = new InternetAddress(posaljiAutoru);
			InternetAddress urednikovaAdresa = new InternetAddress(posaljiUredniku);
			
			message.addRecipient(Message.RecipientType.TO, autorovaAdresa);
			message.addRecipient(Message.RecipientType.TO, urednikovaAdresa);

			message.setSubject("Novi rad je kreiran");
			message.setText("Rad: " + rad.getNaslov() + " je stigao za pregledanje.");
			
			Transport transport = session.getTransport("smtp");
			transport.connect(host, email, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}
	
	public void posaljiMejl(String kome, String naslov, String text) {
		
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", email);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.ssl.trust", "smtp.gmail.com");


		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(email));

			InternetAddress toAddress = new InternetAddress(kome);
			
			message.addRecipient(Message.RecipientType.TO, toAddress);

			message.setSubject(naslov);
			message.setText(text);
			
			Transport transport = session.getTransport("smtp");
			transport.connect(host, email, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}
}
