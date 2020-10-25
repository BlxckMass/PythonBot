package ru.blackmass.keyboards;

import com.vk.api.sdk.objects.messages.KeyboardButton;
import com.vk.api.sdk.objects.messages.KeyboardButtonAction;
import com.vk.api.sdk.objects.messages.KeyboardButtonActionType;
import com.vk.api.sdk.objects.messages.KeyboardButtonColor;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class PythonKeyboardButton {

    public static KeyboardButton createButton(String text, KeyboardButtonActionType type, KeyboardButtonColor color) {
        KeyboardButtonAction action = new KeyboardButtonAction();
        action.setLabel(text);
        action.setType(type);

        KeyboardButton button = new KeyboardButton();
        button.setAction(action);
        button.setColor(color);

        return button;
    }

}
