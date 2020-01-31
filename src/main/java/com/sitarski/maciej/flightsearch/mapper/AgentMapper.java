package com.sitarski.maciej.flightsearch.mapper;

import com.sitarski.maciej.flightsearch.entity.LiveFlightSearch.Agent;
import com.sitarski.maciej.flightsearch.jsonApi.jsonLiveFlightSearchApi.AgentApi;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class AgentMapper {

  public Agent mapAgentApiToEntity (AgentApi agentApi){

    Optional<AgentApi> agentApiOptional = Optional.ofNullable(agentApi);
    Agent agent = new Agent();

    agent.setAgentId(agentApiOptional
        .map(AgentApi::getId)
        .orElse(null));
    agent.setImageUrl(agentApiOptional
        .map(AgentApi::getImageUrl)
        .orElse(null));
    agent.setName(agentApiOptional
        .map(AgentApi::getName)
        .orElse(null));
    agent.setStatus(agentApiOptional
        .map(AgentApi::getStatus)
        .orElse(null));
    agent.setOptimisedForMobile(agentApiOptional
        .map(AgentApi::getOptimisedForMobile)
        .orElse(null));
    agent.setType(agentApiOptional
        .map(AgentApi::getType)
        .orElse(null));

    return agent;
  }
}
