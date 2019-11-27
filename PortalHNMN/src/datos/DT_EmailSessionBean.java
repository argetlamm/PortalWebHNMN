package datos;

import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.*;
import entidades.EN_Protocol;
import java.nio.charset.StandardCharsets;
import java.util.Base64.*;
import static java.util.Base64.*;

/**
 * Session Bean implementation class EmailSessionBean
 */
@Stateless
@LocalBean
public class DT_EmailSessionBean {


    private String port = "587"; //587, 465
    private String host = "smtp.gmail.com";
    private boolean auth = true;
    private String username = "";
    private String password = "";
    private String nombreRemitente = "";
    private EN_Protocol protocol = EN_Protocol.TLS;
    private boolean debug = true;

    public boolean sendEmail(String to, String subject, String cpCorreo, String nombre, String remitente, String contrasenia) {
        boolean enviado = false;
    	Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        switch (protocol) {
            case SMTP:
                props.put("mail.smtp.ssl.enable", "true");
            case SMTPS:
                props.put("mail.smtp.ssl.enable", "true");
                break;
            case TLS:
                props.put("mail.smtp.starttls.enable", "true");
                break;
        }

        password = contrasenia;
        username = remitente;
        nombreRemitente = nombre;
        
        //String link = "\nhttp://165.98.12.158:8080/sigra/pages/inscripcion/registroEstudiantePropio.jsp?e="+cifrarBase64(to);
        String cuerpoCorreo = cpCorreo;

        Authenticator authenticator = null;
        if (auth) {
            props.put("mail.smtp.auth", "true");
            authenticator = new Authenticator() {
                private PasswordAuthentication pa = new PasswordAuthentication(username,password);
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return pa;
                }
            };
        }

        Session session = Session.getInstance(props, authenticator);
        session.setDebug(debug);

        MimeMessage message = new MimeMessage(session);
        try {
            try {
                message.setFrom(new InternetAddress(username, nombreRemitente));
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        	
        	//CORREO INDIVIDUAL
            InternetAddress[] address = {new InternetAddress(to)};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(cuerpoCorreo);
            Transport.send(message);

        	enviado = true;
        	
        } catch(AuthenticationFailedException ex){
        	ex.printStackTrace();
        	System.out.println("DATOS: ERROR de autenticación");
        	enviado = false;
    	} catch (MessagingException ex) {
            ex.printStackTrace();
        	enviado = false;
        }
        return enviado;
    }
    
    public static String cifrarBase64(String a){
        Encoder encoder = getEncoder();
        String b = encoder.encodeToString(a.getBytes(StandardCharsets.UTF_8) );        
        return b;
    }

}
