package controller.modelo.gerenciais;

import funct.FunctString;
import modelo.dao.gerenciais.DaoMarca;

/**
 * Classe responsavel por ser o <b>controlador</b> da Classe de Modelo Marca.
 * @author  Marcos
 * @see     modelo.gerenciais.Marca
 * @see     modelo.dao.gerenciais.DaoMarca
 */
public class ControllerMarca {
    private final DaoMarca    daoMarca;
    private final FunctString functString;
    
    /**
     * Metodo construtor padrao.
     */
    public ControllerMarca() {
        this.daoMarca    = new DaoMarca();
        this.functString = new FunctString();
    }
    
    /**
     * Metodo responsavel por verificar se o nome da Marca e maior que 2 caracteres.
     * @param  sNome Nome da Marca.
     * @return Nome e valido para cadastro.
     */
    public boolean checkNome(String sNome) {
        return (sNome.trim().length() > 2);
    }
    
    /**
     * Metodo responsavel por verificar se o nome da Marca ja esta cadastrado.
     * @param  sNome Nome da Marca.
     * @return Nome ja foi cadastrado.
     */
    public boolean nomeIsAvailable(String sNome) {
        return (this.daoMarca.findMarcaByNome(sNome) == null);
    }
    
    /**
     * Metodo responsavel por verificar se a sigla da Marca e valido.
     * @param  sSigla Sigla da Marca.
     * @return Sigla e valido para cadastro.
     */
    public boolean checkSigla(String sSigla) {
        return (sSigla.length() > 1);
    }
    
    /**
     * Metodo responsavel por verificar se a sigla da Marca ja esta cadastrado.
     * @param  sSigla da Marca.
     * @return Sigla ja foi cadastrado.
     */
    public boolean siglaIsAvailable(String sSigla) {
        return (this.daoMarca.findMarcaBySigla(sSigla) == null);
    }
    
    /**
     * Metodo responsavel por verificar se na edicao nao atualize com dados ja cadastrados.
     * @param  sNome  Nome da Marca.
     * @param  sSigla Sigla da Marca.
     * @param  lId    Id da Marca.
     * @return Atulizacao e valida.
     */
    public boolean checkUpdate(String sNome, String sSigla, Long lId) {
        return (this.daoMarca.findMarcaByNomeAndSigla(sNome, sSigla, lId) == null);
    }
    
    /**
     * Metodo responsavel por retornar as Marcas cadastradas no Banco de Dados.
     * @return Vetor com "Selecione" + as Marcas.
     */
    public String[] getMarcas() {
        String[] sMarcas    = new String[this.daoMarca.size() + 1];
                 sMarcas[0] = "Selecione";
        for (int i = 0; i < this.daoMarca.size(); ++i) {
            sMarcas[i + 1] = this.daoMarca.list().get(i).toString();
        }
        return sMarcas;
    }
}