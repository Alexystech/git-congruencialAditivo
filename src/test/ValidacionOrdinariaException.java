package test;

public class ValidacionOrdinariaException {
    public ValidacionOrdinariaException(){}

    public void validarValor(int valor) throws CustomException{
        if (valor < 1){
            throw new CustomException("el valor no puede ser negativo o neutro");
        }
    }
}
