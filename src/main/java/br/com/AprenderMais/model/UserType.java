package br.com.AprenderMais.model;

public enum UserType {

    ADMIN("admin"), PROFESSOR("professor"), STUDENT("student");

    private String role;

    UserType(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}