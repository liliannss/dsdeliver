package com.devsuperior.dsdeliver.entites;

import com.devsuperior.dsdeliver.enums.OrderStatus;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order implements Serializable {

    private static final long serialVersionUID = -116887169810009076L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;

    //O mesmo pedido não pode ter mais de uma ocorrência do mesmo produto
    //O Set garante a criação da tabela de associação
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    public Order(Long id, String adress, Double latitude, Double longitude, Instant moment, OrderStatus status) {
        this.id = id;
        this.address = adress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moment = moment;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    //O setter foi removido
    public Set<Product> getProducts() {
        return products;
    }

}