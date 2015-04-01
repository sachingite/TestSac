package com.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name="COURCES")
@NamedQuery(name="test", query="select c from COURCES c")
public class COURCES {
	
	private String courceId;
	
	private String courceName;

	@Id
	@Column(name="COURCE_ID")
	public String getCourceId() {
		return courceId;
	}

	public void setCourceId(String courceId) {
		this.courceId = courceId;
	}

	@Column(name="COURCE_NAME")
	public String getCourceName() {
		return courceName;
	}

	public void setCourceName(String courceName) {
		this.courceName = courceName;
	}

	@Override
	public String toString() {
		return "COURCES [courceId=" + courceId + ", courceName=" + courceName
				+ "]";
	}
	
	
	
}
