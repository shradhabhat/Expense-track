package com.practice.restful_web_services.entity;


public enum Category {
    FOOD("fa-solid fa-utensils"),
    TRANSPORT("fa-solid fa-bus"),
    ENTERTAINMENT("fa-solid fa-film"),
    GROCERIES("fa-solid fa-cart-shopping"),
    CLOTHING("fa-solid fa-tshirt"),
    SHOPPING("fa-solid fa-bag-shopping"),
    BILLS("fa-solid fa-file-invoice-dollar"),
    ELECTRONICS("fa-solid fa-tv"),
    HEALTH("fa-solid fa-heartbeat"),
    BEAUTY("fa-solid fa-spa"),
    SPORTS("fa-solid fa-football-ball"),
    SOCIAL("fa-solid fa-users"),
    OTHER("fa-solid fa-ellipsis-h");

    private final String iconClass;

    Category(String iconClass) {
        this.iconClass = iconClass;
    }

    public String getIconClass() {
        return iconClass;
    }
}
	

