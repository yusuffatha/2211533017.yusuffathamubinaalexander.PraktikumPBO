package model;

public class CustomerBuilder {
    private String id;
    private String nama;
    private String email = "*";
    private String alamat;
    private String hp;

    public CustomerBuilder() {
        // TODO Auto-generated constructor stub
    }
    
    public CustomerBuilder setId(String id) {
        this.id = id;
        return this;
    }
    
    public CustomerBuilder setNama(String nama) {
        this.nama = nama;
        return this;
    }
    
    public CustomerBuilder setEmail(String email) {
        this.email = email;
        return this;
    }
    
    public CustomerBuilder setAlamat(String alamat) {
        this.alamat = alamat;
        return this;
    }
    
    public CustomerBuilder setHp(String hp) {
        this.hp = hp;
        return this;
    }
    
    public Costumer build() {
        return new Costumer(id, nama, email, alamat, hp);
    }

}
