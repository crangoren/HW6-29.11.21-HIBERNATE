package data;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "product_id")
    private Long productId;

    public Order() {
    }

    public Order(Long clientId, Long productId) {
        this.clientId = clientId;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", productId=" + productId +
                '}';
    }

    @ManyToOne
    @JoinColumn(name ="client_id", insertable = false, updatable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name ="product_id", insertable = false, updatable = false)
    private Product product;
}
