package com.core.pizzaEnum;

public enum PizzaType {

    VEG {
        @Override
        public String description() {
            return "Loaded with fresh vegetables";
        }
    },

    NON_VEG {
        @Override
        public String description() {
            return "Loaded with chicken and meat";
        }
    },

    CHEESE_BURST {
        @Override
        public String description() {
            return "Extra cheese inside crust";
        }
    };

    public abstract String description();

}

