/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.visao.operacoes;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Felippe
 */
class EnviadorEmail {

    static void enviarEmail(String email_cliente, String mensagem, String assunto) throws EmailException {
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.addTo(email_cliente);
        email.setFrom("noreply.supermercado.boacompra@gmail.com");
        email.setSubject(assunto);
        email.setMsg(mensagem);        
        email.setSSL(true);
        email.setAuthentication("noreply.supermercado.boacompra", "Supermercado.Boacompra");
        email.send();
        }

}
