package org.javaacadmey.field_of_miracles;

public enum Round {

     COUNT_ROUNDS(4), //4
     COUNT_GROUP_ROUNDS(3), //3
     FINAL_ROUND_INDEX (3); //3

    final int value;

    Round(int value) {
        this.value = value;
    }
}
