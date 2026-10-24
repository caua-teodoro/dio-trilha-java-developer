package edu.dio.iphone.model;

import edu.dio.iphone.interfaces.AparelhoTelefonico;
import edu.dio.iphone.interfaces.NavegadorInternet;
import edu.dio.iphone.interfaces.ReprodutorMusical;

public class Iphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {

    @Override
    public void tocar() {
        throw new UnsupportedOperationException("Unimplemented method 'tocar'");
    }

    @Override
    public void pausar() {
        throw new UnsupportedOperationException("Unimplemented method 'pausar'");
    }

    @Override
    public void selecionarMusica(String musica) {
        throw new UnsupportedOperationException("Unimplemented method 'selecionarMusica'");
    }

    @Override
    public void exibirPagina(String url) {
        throw new UnsupportedOperationException("Unimplemented method 'exibirPagina'");
    }

    @Override
    public void adicionarNovaAba() {
        throw new UnsupportedOperationException("Unimplemented method 'adicionarNovaAba'");
    }

    @Override
    public void atualizarPagina() {
        throw new UnsupportedOperationException("Unimplemented method 'atualizarPagina'");
    }

    @Override
    public void ligar(String numero) {
        throw new UnsupportedOperationException("Unimplemented method 'ligar'");
    }

    @Override
    public void atender() {
        throw new UnsupportedOperationException("Unimplemented method 'atender'");
    }

    @Override
    public void iniciarCorreioVoz() {
        throw new UnsupportedOperationException("Unimplemented method 'iniciarCorreioVoz'");
    }
    
}
