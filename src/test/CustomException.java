package test;

public class CustomException extends Throwable{
    private static final long serialVersionUID = 700L;

    CustomException(String mesaje){
        super(mesaje);
    }
}
