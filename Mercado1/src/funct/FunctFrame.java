package funct;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 * <p>Classe responsavel pelas operacoes envolvendo Frames e Imagens.</p>
 * <p>Todos os metodos possuem uma especificacao acima da implementacao.</p>
 * @author  Hadyne
 * @version 1.0
 */
public class FunctFrame {
    private ActionListener controller;
    
    /**
     * <p>Metodo responsavel por retornar uma ImageIcon pela sua descricao.</p>
     * <p>Utiliza como padrao o diretorio <b>/images/</b>.</p>
     * @param  sUrlImage URL da Imagem a ser instanciada. 
     * @return ImageIcon
     */
    public ImageIcon createImage(String sUrlImage) {
         return new ImageIcon(getClass().getResource("/images/" + sUrlImage));
    }
}