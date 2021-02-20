//TODO Задумка в том что бы шифруемая строка балы объектом,
// и можно было понять зашифрована данная строка или нет, и каким алгоритмом
package deshifrator;

public final class EncryptedString {

    private String str;
    private int typeCryptMethod;
    private boolean encrypted;

    public EncryptedString(String str) {
        this.str = str;
        typeCryptMethod = 0;
        encrypted =false;
    }


    public String getStr() {
        return str;
    }

    public void setStr(String str){
        this.str = str;
    }

    public void setTypeCryptMethod(int typeCryptMethod){
        this.typeCryptMethod = typeCryptMethod;
    }

    public void encrypted(){
        encrypted=true;
    }

    public void notEncrypted(){
        encrypted=false;
    }


    public void getStrInfo(){
        System.out.println(typeCryptMethod);
        System.out.println(encrypted);
    }




}
