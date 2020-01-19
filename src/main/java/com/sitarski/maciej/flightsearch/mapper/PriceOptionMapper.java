package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.dao.AgentRepository;
import com.sitarski.maciej.flightsearch.dao.CarrierRepository;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Agent;
import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.PriceOption;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.PriceOptionApi;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceOptionMapper {

  @Autowired
  AgentRepository agentRepository;

  public PriceOption mapPriceOptionApiToEntity(PriceOptionApi priceOptionApi) {

    Optional<PriceOptionApi> priceOptionApiOptional = Optional.ofNullable(priceOptionApi);
    PriceOption priceOption = new PriceOption();

    priceOption.setLinkUrl(priceOptionApiOptional
        .map(PriceOptionApi::getLinkUrl)
        .orElse(null));

    priceOption.setPrice(priceOptionApiOptional
        .map(PriceOptionApi::getPrice)
        .orElse(null));

    List<Agent> agents = priceOptionApiOptional
        .map(PriceOptionApi::getAgents)
        .map(agentRepository::findAllByAgentId)
        .orElse(Collections.emptyList());
    priceOption.setAgents(agents);

    return priceOption;
  }

}
