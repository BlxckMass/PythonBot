package ru.blackmass.keyboards;

import com.vk.api.sdk.objects.messages.*;
import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.blackmass.data.CommandText;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class PythonKeyboard {

//    private Keyboard keyboard;
//    private List<List<KeyboardButton>> buttons;
//    private List<KeyboardButton> stringButtons;

    public Keyboard createMainKeyboard() {

        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandText.click, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandText.tasks, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandText.myAccount, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandText.info, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsThree = new ArrayList<>();
        stringButtonsThree.add(PythonKeyboardButton.createButton(CommandText.buy, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));
        stringButtonsThree.add(PythonKeyboardButton.createButton(CommandText.vip, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));

        List<KeyboardButton> stringButtonsFour = new ArrayList<>();
        stringButtonsFour.add(PythonKeyboardButton.createButton(CommandText.games, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsFour.add(PythonKeyboardButton.createButton(CommandText.top, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsFive = new ArrayList<>();
        stringButtonsFive.add(PythonKeyboardButton.createButton(CommandText.activity, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);
        buttons.add(stringButtonsThree);
        buttons.add(stringButtonsFour);
        buttons.add(stringButtonsFive);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createMyAccountKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandText.payBytes, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandText.withdraw, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandText.exitMainMenu, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createTopKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandText.topCoins, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandText.topClickers, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandText.topLvl, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsTwo.add(PythonKeyboardButton.createButton("Промо", KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsThree = new ArrayList<>();
        stringButtonsThree.add(PythonKeyboardButton.createButton(CommandText.exitMainMenu, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);
        buttons.add(stringButtonsThree);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createTaskKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandText.taskVkTarget, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandText.taskKrutilka, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsThree = new ArrayList<>();
        stringButtonsThree.add(PythonKeyboardButton.createButton(CommandText.exitMainMenu, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);
        buttons.add(stringButtonsThree);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

}
