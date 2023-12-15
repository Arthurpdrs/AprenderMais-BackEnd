package br.com.AprenderMais.model;

public enum UserType {

    ADMIN("admin"), USER("user");

    private String role;

    UserType(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public static UserType fromString(String role) {
        for (UserType userType : UserType.values()) {
            if (userType.role.equalsIgnoreCase(role)) {
                return userType;
            }
        }
        throw new IllegalArgumentException("Invalid UserType: " + role);
    }

}