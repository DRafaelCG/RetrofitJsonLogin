package com.dim.retrofitjsonlogin.model;

import java.util.HashMap;
import java.util.Map;

public class LoginResponse {
    public int userId;
    public String success;
    public String mensaje;
    public Map<String, Object> props = new HashMap<>();

    public LoginResponse() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }
}
