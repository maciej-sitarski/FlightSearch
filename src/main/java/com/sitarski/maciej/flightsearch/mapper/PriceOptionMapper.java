package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.dao.AgentRepository;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Agent;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.PriceOption;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.PriceOptionApi;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceOptionMapper {

  private final AgentRepository agentRepository;

  @Autowired
  public PriceOptionMapper(AgentRepository agentRepository) {
    this.agentRepository = agentRepository;
  }

  public PriceOption mapPriceOptionApiToEntity(PriceOptionApi priceOptionApi) {

    Optional<PriceOptionApi> priceOptionApiOptional = Optional.ofNullable(priceOptionApi);
    PriceOption priceOption = new PriceOption();

    String linkUrl = priceOptionApiOptional
        .map(PriceOptionApi::getLinkUrl)
        .orElse(null);

    Float price = priceOptionApiOptional
        .map(PriceOptionApi::getPrice)
        .orElse(null);

    List<Agent> agents = priceOptionApiOptional
        .map(PriceOptionApi::getAgents)
        .orElse(Collections.emptyList())
        .stream()
        .map(agentRepository::findAllByAgentId)
        .map(agents1 -> agents1.get(0))
        .collect(Collectors.toList());
    agents.forEach(agent -> agent.getPriceOptions().add(priceOption));

    priceOption.setLinkUrl(linkUrl);
    priceOption.setPrice(price);
    priceOption.setAgents(agents);

    return priceOption;
  }

}
