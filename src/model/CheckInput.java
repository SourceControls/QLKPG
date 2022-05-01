/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author TuanHung
 */
public final class CheckInput extends PlainDocument {

    private final int limit;
    private final boolean allowNumber;
    private final boolean allowWord;
    private final boolean allowSpecial;
    private final String number = "0123456789";
    private final String special = "!@#$%^&*()~?>'<:{}|+_/\".,;'][=-`\\";

    public CheckInput(int limit, boolean allowNumber, boolean allowWord, boolean allowSpecial) {
        this.limit = limit;
        this.allowNumber = allowNumber;
        this.allowWord = allowWord;
        this.allowSpecial = allowSpecial;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException {
        if (str == null) {
            return;
        }
        if (getLength() > 0) {
            if (str.equals(" ") & getText(offs - 1, 1).equals(" ")) {
                return;
            }
        }
        if(str.length() == 1){
        if (!allowNumber & number.contains(str)) {
            return;
        }
        if (!allowSpecial & special.contains(str)) {
            return;
        }
        if (!allowWord & !(number.contains(str) | special.contains(str))) {
            System.out.println(str);
            return;
        }
        }
        if ((getLength() + str.length()) <= limit) {
            super.insertString(offs, str, a);
        }
    }
}
