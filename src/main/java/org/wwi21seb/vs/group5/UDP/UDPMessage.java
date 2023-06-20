package org.wwi21seb.vs.group5.UDP;

public class UDPMessage {

    private Operation operation;
    private String sender;
    private Object data;

    public UDPMessage(Operation operation, String sender, Object data) {
        this.operation = operation;
        this.sender = sender;
        this.data = data;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getSender() {
        return sender;
    }

    public Object getData() {
        return data;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
