package com.akudrin.p2pnetworks;

import rice.p2p.commonapi.Application;
import rice.p2p.commonapi.Endpoint;
import rice.p2p.commonapi.Id;
import rice.p2p.commonapi.Message;
import rice.p2p.commonapi.Node;
import rice.p2p.commonapi.NodeHandle;
import rice.p2p.commonapi.RouteMessage;

public class FreePastryApplication implements Application {
	protected Endpoint endpoint;
	private final String message;
	private final String instance = " Instance ID";

	public FreePastryApplication(Node node) {
		this.endpoint = node.buildEndpoint(this, instance);
		this.message = "Hello there! from Instance: " + instance + " Sent at: [" + getCurrentTime() + "]";
		this.endpoint.register();
	}

	private long getCurrentTime() {
		return this.endpoint.getEnvironment().getTimeSource().currentTimeMillis();
	}

	public void routeMessage(Id id) {
		System.out.println("Message Sent\n\tCurrent Node: " + this.endpoint.getId() + "\n\tDestination: " + id
				+ "\n\tTime: " + getCurrentTime());
		Message msg = new PastryMessage(endpoint.getId(), id, message);
		endpoint.route(id, msg, null);
	}

	public void deliver(Id id, Message message) {
		System.out.println("Message Received\n\tCurrent Node: " + this.endpoint.getId() + "\n\tMessage: " + message
				+ "\n\tTime: " + getCurrentTime());
	}

	@Override
	public boolean forward(RouteMessage arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(NodeHandle arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

	public void routeMessageDirect(NodeHandle nh) {
		System.out.println("Message Sent Direct\n\tCurrent Node: " + this.endpoint.getId() + " Destination: " + nh
				+ "\n\tTime: " + getCurrentTime());
		Message msg = new PastryMessage(endpoint.getId(), nh.getId(), "DIRECT-" + message);
		endpoint.route(null, msg, nh);
	}

}