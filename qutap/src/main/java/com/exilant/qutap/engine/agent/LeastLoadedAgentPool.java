package com.exilant.qutap.engine.agent;

import java.util.ArrayList;

import com.exilant.qutap.engine.data.AgentInfo;
import com.exilant.qutap.engine.data.IAgentInfo;
import com.exilant.qutap.engine.exception.ITAPEngineException;

public class LeastLoadedAgentPool extends AbstractAgentPool {

	public LeastLoadedAgentPool(){
		activeAgents = new ArrayList<IAgentInfo>();
		passiveAgents = new ArrayList<IAgentInfo>();
	}
	
	@Override
	public IAgentInfo barrowAgent() throws ITAPEngineException {
		// TODO Auto-generated method stub
		//sort agents by load ascending order
		//get the first one
		if(activeAgents.isEmpty()){
			throw new ITAPEngineException("Active agents not available");
		}
		activeAgents.sort((p1,p2)->p1.getCurrentLoad().compareTo(p2.getCurrentLoad()));
		IAgentInfo agent =  activeAgents.get(0);
		agent.incrementCurrentLoad();
		return agent;
	}
	
	//for testing purpose
	public static void main(String[] args){
		LeastLoadedAgentPool  llpool = new LeastLoadedAgentPool();
		AgentInfo agent1 = new AgentInfo();
		agent1.setAgentId(1);
		agent1.setAgentName("1");
		llpool.addAgent(agent1);
		AgentInfo agent2 = new AgentInfo();
		agent2.setAgentId(2);
		agent2.setAgentName("2");
		llpool.addAgent(agent2);
		
		for(int i = 0 ; i < 100; i++){
			llpool.activeAgents.forEach(t-> System.out.println(t.getAgentId()+":"+t.getCurrentLoad()+"\n"));
				System.out.println("agent barrowed:"+llpool.barrowAgent().getAgentName());
				if(i%3==0){
					llpool.releaseAgent(agent2);
				}
			}
		
		
		
	}

	

}
