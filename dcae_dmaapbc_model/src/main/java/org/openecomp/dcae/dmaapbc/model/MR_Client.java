/*-
 * ================================================================================
 * DCAE DMaaP Bus Controller Models
 * ================================================================================
 * Copyright (C) 2017 AT&T Intellectual Property
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ================================================================================
 */
package org.openecomp.dcae.dmaapbc.model;

/**
 * Bean that models a DMaaP Message Router client.
 */
public class MR_Client extends DmaapObject {

	/** dcaeLocation tag where this client is deployed */
	private String dcaeLocationName;
	/** fully qualified topic name */
	private String fqtn;
	/**
	 * name of role of client which will be
	 * granted the AAF permission associated with any action
	 */
	private String clientRole;
	/** an array of actions. Current possibilities are view, pub, sub */
	private String[] action;
	/** unique handle for this client, generated by DMaaP Bus Controller */
	private String mrClientId;
	/** TODO */
	private String topicURL;

	public MR_Client() {
	}

	public MR_Client(String lastMod, Dmaap_Status status, String dcaeLocationName, String fqtn, String clientRole,
			String[] action, String mrClientId, String topicURL) {
		super(lastMod, status);
		this.dcaeLocationName = dcaeLocationName;
		this.fqtn = fqtn;
		this.clientRole = clientRole;
		this.action = action;
		this.mrClientId = mrClientId;
		this.topicURL = topicURL;
	}

	public String getDcaeLocationName() {
		return dcaeLocationName;
	}

	public void setDcaeLocationName(String dcaeLocationName) {
		this.dcaeLocationName = dcaeLocationName;
	}

	public String getFqtn() {
		return fqtn;
	}

	public void setFqtn(String fqtn) {
		this.fqtn = fqtn;
	}

	public String getClientRole() {
		return clientRole;
	}

	public void setClientRole(String clientRole) {
		this.clientRole = clientRole;
	}

	public String[] getAction() {
		return action;
	}

	public void setAction(String[] action) {
		this.action = action;
	}

	public String getMrClientId() {
		return mrClientId;
	}

	public void setMrClientId(String mrClientId) {
		this.mrClientId = mrClientId;
	}

	public String getTopicURL() {
		return topicURL;
	}

	public void setTopicURL(String topicURL) {
		this.topicURL = topicURL;
	}

	@Override
	public String toString() {
		return "MR_Client[dcaeLocationName=" + dcaeLocationName + ", fqtn=" + fqtn + ", ...]";
	}

}
