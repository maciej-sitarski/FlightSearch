package com.sitarski.maciej.flightsearch.entity.LiveFlightSearch;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "agent")
public class Agent {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "agent_id")
  private Long agentId;

  @Column(name = "name")
  private String name;

  @Column(name = "imageUrl")
  private String imageUrl;

  @Column(name = "status")
  private String status;

  @Column(name = "optimisedForMobile")
  private Boolean optimisedForMobile;

  @Column(name = "type")
  private String type;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "priceOption_agent",
      joinColumns = @JoinColumn(name = "id_priceOption", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "id_agent", referencedColumnName = "id"))
  private List<PriceOption> priceOptions = new ArrayList<>();

  @Column(name = "clientNumber")
  private String clientNumber;
}
