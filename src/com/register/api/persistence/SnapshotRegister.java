package com.register.api.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="snapshotregister")
public class SnapshotRegister {

	private Integer id;
	private String status;
	private long timestamp;
	private Integer eventDataId;
	public SnapshotRegister(){}
	public SnapshotRegister(long timestamp, String status, Integer eventDataId) {
		setTimestamp(timestamp);
		setStatus(status);
		setEventDataId(eventDataId);
	}
	@Id
	@Column(name="snapshopRegisterId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getEventDataId() {
		return eventDataId;
	}
	public void setEventDataId(Integer eventDataId) {
		this.eventDataId = eventDataId;
	}

}
