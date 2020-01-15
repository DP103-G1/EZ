package com.example.ezeats;

import java.io.Serializable;

public class Menu implements Serializable{

        private String MENU_ID;
        private String FOOD_NAME;
        private int FOOD_PRICE;
        private boolean FOOD_STATUS;
        private String FOOD_CONTENT;

        public Menu(String MENU_ID, String FOOD_NAME, int FOOD_PRICE,  String FOOD_CONTENT) {
            this.MENU_ID = MENU_ID;
            this.FOOD_NAME = FOOD_NAME;
            this.FOOD_PRICE = FOOD_PRICE;
            this.FOOD_CONTENT = FOOD_CONTENT;
        }

        public Menu(String MENU_ID, String FOOD_NAME, int FOOD_PRICE, boolean FOOD_STATUS, String FOOD_CONTENT) {
        this.MENU_ID = MENU_ID;
        this.FOOD_NAME = FOOD_NAME;
        this.FOOD_PRICE = FOOD_PRICE;
        this.FOOD_STATUS = FOOD_STATUS;
        this.FOOD_CONTENT = FOOD_CONTENT;
    }

//    public Menu(String id, String name, int price, String content) {
//        this.MENU_ID = id;
//        this.FOOD_NAME = name;
//        this.FOOD_PRICE = price;
//        this.FOOD_CONTENT = content;
//    }

    @Override
    public boolean equals(Object obj) {
        return this.MENU_ID == ((Menu) obj).MENU_ID;
    }

        public String getMENU_ID() {
            return MENU_ID;
        }

        public void setMENU_ID(String menu_id) {
            this.MENU_ID = menu_id;
        }

        public String getFOOD_NAME() {
            return FOOD_NAME;
        }

        public void setFOOD_NAME(String food_name) {
            this.FOOD_NAME = food_name;
        }

        public int getFOOD_PRICE() {
            return FOOD_PRICE;
        }

        public void setFOOD_PRICE(int food_price) {
            this.FOOD_PRICE = food_price;
        }

        public boolean isFOOD_STATUS() {
            return FOOD_STATUS;
        }

        public void setFOOD_STATUS(boolean food_status) {
            this.FOOD_STATUS = food_status;
        }

        public String getFOOD_CONTENT() {
            return FOOD_CONTENT;
        }

        public void setFOOD_CONTENT(String food_content) {
            this.FOOD_CONTENT = food_content;
        }

}
