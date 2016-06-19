package soursoft.secuenciauno.co.soursoft;

/**
 * Created by Andrés Felipe on 9/05/2016.
 */
public class Client {

    String _id;
    String name;
    String[] tel;
    String address;
    String logo;
    String photo;
    String description;


    Client(){};

    Client(String name, String description){
        this.name = name;
        this.description = description;
    }

    Client(String name, String[] tel, String address, String logo, String photo){
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.logo = logo;
        this.photo = photo;
    };
}
