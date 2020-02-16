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

    Long agentId = agentApiOptional
        .map(AgentApi::getId)
        .orElse(null);

    String imageUrl = agentApiOptional
        .map(AgentApi::getImageUrl)
        .orElse(null);

    String name = agentApiOptional
        .map(AgentApi::getName)
        .orElse(null);

    String status = agentApiOptional
        .map(AgentApi::getStatus)
        .orElse(null);

    Boolean optimisedForMobile = agentApiOptional
        .map(AgentApi::getOptimisedForMobile)
        .orElse(null);

    String type = agentApiOptional
        .map(AgentApi::getType)
        .orElse(null);

    agent.setAgentId(agentId);
    agent.setImageUrl(imageUrl);
    agent.setName(name);
    agent.setStatus(status);
    agent.setOptimisedForMobile(optimisedForMobile);
    agent.setType(type);

    return agent;
  }
}
