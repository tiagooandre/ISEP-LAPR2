package app.domain.model;

import java.util.List;

public class RegisterClientStore {

    private final  List<Client> clientList;

    /**
     * creates RegisterClientStore with all the client already registered
     * @param list
     */
    public RegisterClientStore(List<Client> list){
        this.clientList= list;
    }

    /**
     * creates client using constructor from Client
     * @param name
     * @param cc
     * @param birth
     * @param nhsid
     * @param tin
     * @param email
     * @param phonenumber
     * @param sex
     * @return the created client
     */
    public Client createClient(String name, String cc, String birth, String nhsid, String tin, String email, String phonenumber, String sex){
        return new Client(name, cc, birth, nhsid, tin, email, phonenumber,  sex);
    }
    /**
     * @param ct The client to be validated
     * @return Validation if the client does not exist
     */
    public boolean validateClient(Client ct) {
        if (ct == null)
            return false;
        return ! this.clientList.contains(ct);
    }
    /**
     * @param ct The client to be added to the List of Clients
     * @return true if the client was added successfully
     */
    public boolean saveClient(Client ct) {
        if (!validateClient(ct))
            return false;
        return this.clientList.add(ct);
    }

    /**
     * creates client using the constructor form Client
     * @param name
     * @param cc
     * @param birth
     * @param nhsid
     * @param tin
     * @param email
     * @param phone
     * @return created client
     */
    public Client createClient(String name, String cc, String birth, String nhsid, String tin, String email, String phone) {
        return new Client(name, cc, birth, nhsid, tin, email, phone);
    }
    
    /**
     * Gets the list of registered clients
     * @return the list of clients
     */
    public List<Client> getClients(){
        return this.clientList;
    }

    /**
     *  returns client using nhs
     * @param tin client TIN
     * @return client with the same nhs
     */
    public Client getClientByTIN(String tin){
        for(Client ccc : this.clientList){
            if(ccc.getTin().compareTo(tin)==0)
                return ccc;
        }
        return null;
    }

    /**
     *
     * returns client using email
     * @param email client´s email
     * @return client wtih the same email
     */
    public Client getClientByEmail(String email){
        for(Client c : this.clientList){
            if(c.getEmail().compareTo(email)==0)
                return c;
        }
        return null;
    }
}

