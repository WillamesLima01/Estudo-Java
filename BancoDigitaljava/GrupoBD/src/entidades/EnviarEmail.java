package entidades;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EnviarEmail {

    private String emailRemetente;
    private String senhaRemetente;

    public EnviarEmail(String emailRemetente, String senhaRemetente) {
        this.emailRemetente = emailRemetente;
        this.senhaRemetente = senhaRemetente;
    }

    public void enviarEmail(String emailDestino) {
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(emailRemetente, senhaRemetente));
        email.setSSLOnConnect(true);

        try {
            email.setFrom(emailRemetente);
            email.setSubject("Conta e senha");
            email.setMsg("Seja bem-vindo ao Banco Digital!");
            email.addTo(emailDestino);
            email.send();
            System.out.println("E-mail enviado com sucesso!");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
