package com.livraison.livraison.service;

import com.livraison.livraison.model.Agent;
import com.livraison.livraison.repository.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Optional<Agent> getAgentById(Long id) {
        return agentRepository.findById(id);
    }

    public Agent saveAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }
}
