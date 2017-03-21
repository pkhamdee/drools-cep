package org.jboss.test.drools.cep.demo.model;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Staff implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;

	public Staff(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

