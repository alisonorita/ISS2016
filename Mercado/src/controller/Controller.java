package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * <p>Classe responsavel por ser ouvinte de Eventos das View.</p>
 * <p><b>Implementa</b> a Interface ActionListener e KeyListener.</p>
 * @see     java.awt.event.ActionListener
 * @see     java.awt.event.KeyListener
 */
public abstract class Controller implements ActionListener, KeyListener {

    /**
     * <b>Metodo abstrato</b> para interpretar acoes.
     * @param  oActionEvent Evento de Acao.
     */
    
    @Override
    public abstract void actionPerformed(ActionEvent oActionEvent);
    
    @Override
    public void keyTyped(KeyEvent oKeyEvent) {}

    @Override
    public void keyPressed(KeyEvent oKeyEvent) {}

    @Override
    public void keyReleased(KeyEvent oKeyEvent) {}
}