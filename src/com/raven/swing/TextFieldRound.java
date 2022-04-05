package com.raven.swing;

import javax.swing.JTextField;

public class TextFieldRound extends JTextField {

    private TextFieldRoundUI textUI;

    public TextFieldRound() {
        textUI = new TextFieldRoundUI(this);
        setUI(textUI);
    }

//    public void addItemSuggestion(String text) {
//        textUI.getItems().add(text);
//    }
//
//    public void removeItemSuggestion(String text) {
//        textUI.getItems().remove(text);
//    }
//
//    public void clearItemSuggestion() {
//        textUI.getItems().clear();
//    }
//
    public void setRound(int round) {
        textUI.setRound(round);
    }
//
//    public int getRound() {
//        return textUI.getRound();
//    }

}
