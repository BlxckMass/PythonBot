package ru.blackmass.bot.keyboards;

import com.vk.api.sdk.objects.messages.*;
import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.blackmass.bot.utils.CommandTextUtil;

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
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.click, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.tasks, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.myAccount, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.info, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsThree = new ArrayList<>();
        stringButtonsThree.add(PythonKeyboardButton.createButton(CommandTextUtil.buyOrSell, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));
        stringButtonsThree.add(PythonKeyboardButton.createButton(CommandTextUtil.vip, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));

        List<KeyboardButton> stringButtonsFour = new ArrayList<>();
        stringButtonsFour.add(PythonKeyboardButton.createButton(CommandTextUtil.games, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsFour.add(PythonKeyboardButton.createButton(CommandTextUtil.top, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsFive = new ArrayList<>();
        stringButtonsFive.add(PythonKeyboardButton.createButton(CommandTextUtil.activity, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

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

    public Keyboard createChatMainKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.tasks, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.myAccount, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.info, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.buyOrSell, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.vip, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));

        List<KeyboardButton> stringButtonsThree = new ArrayList<>();
        stringButtonsThree.add(PythonKeyboardButton.createButton(CommandTextUtil.games, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsThree.add(PythonKeyboardButton.createButton(CommandTextUtil.top, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsFour = new ArrayList<>();
        stringButtonsFour.add(PythonKeyboardButton.createButton(CommandTextUtil.activity, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);
        buttons.add(stringButtonsThree);
        buttons.add(stringButtonsFour);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createMyAccountKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.payBytes, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.myBank, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.withdraw, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsThree = new ArrayList<>();
        stringButtonsThree.add(PythonKeyboardButton.createButton(CommandTextUtil.exitMainMenu, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);
        buttons.add(stringButtonsThree);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createBuyOrSellKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.buyBytes, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.sellVkCoins, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.exitMainMenu, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createTopKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.topCoins, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.topClickers, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.topLvl, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.topPromo, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsThree = new ArrayList<>();
        stringButtonsThree.add(PythonKeyboardButton.createButton(CommandTextUtil.topReferrals, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsFour = new ArrayList<>();
        stringButtonsFour.add(PythonKeyboardButton.createButton(CommandTextUtil.exitMainMenu, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);
        buttons.add(stringButtonsThree);
        buttons.add(stringButtonsFour);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createTaskKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.taskKrutilka, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.taskLottoha, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsThree = new ArrayList<>();
        stringButtonsThree.add(PythonKeyboardButton.createButton(CommandTextUtil.taskFartGame, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsFour = new ArrayList<>();
        stringButtonsFour.add(PythonKeyboardButton.createButton(CommandTextUtil.exitMainMenu, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);
        buttons.add(stringButtonsThree);
        buttons.add(stringButtonsFour);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createGamesKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.thimblesGame, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.moreOrLessGame, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.caseGame, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.fortuneWheelGame, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsThree = new ArrayList<>();
        stringButtonsThree.add(PythonKeyboardButton.createButton(CommandTextUtil.chests, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsFour = new ArrayList<>();
        stringButtonsFour.add(PythonKeyboardButton.createButton(CommandTextUtil.exitMainMenu, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);
        buttons.add(stringButtonsThree);
        buttons.add(stringButtonsFour);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createSetBetGameKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.exitOfGames, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createChooseThimbleKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.thimbleOne, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.thimbleTwo, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.thimbleThree, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createChooseMoreOrLessKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.more, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.less, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createCasesKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.bumCase, KeyboardButtonActionType.TEXT, KeyboardButtonColor.DEFAULT));
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.silverCase, KeyboardButtonActionType.TEXT, KeyboardButtonColor.PRIMARY));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.goldCase, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.premiumCase, KeyboardButtonActionType.TEXT, KeyboardButtonColor.POSITIVE));

        List<KeyboardButton> stringButtonsThree = new ArrayList<>();
        stringButtonsThree.add(PythonKeyboardButton.createButton(CommandTextUtil.exitOfGames, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);
        buttons.add(stringButtonsThree);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createFortuneWheelKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.fortuneWheelRoll, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.fortuneWheelPrizes, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.exitOfGames, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createChestsKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.goldChest, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.magicChest, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.epicChest, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.legendaryChest, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsThree = new ArrayList<>();
        stringButtonsThree.add(PythonKeyboardButton.createButton(CommandTextUtil.pythonChest, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsFour = new ArrayList<>();
        stringButtonsFour.add(PythonKeyboardButton.createButton(CommandTextUtil.exitOfGames, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);
        buttons.add(stringButtonsThree);
        buttons.add(stringButtonsFour);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createGoldChestKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.openGoldChest, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.exitChests, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createMagicChestKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.openMagicChest, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.exitChests, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createEpicChestKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.openEpicChest, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.exitChests, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createLegendaryChestKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.openLegendaryChest, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.exitChests, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

    public Keyboard createPythonChestKeyboard() {
        List<KeyboardButton> stringButtonsOne = new ArrayList<>();
        stringButtonsOne.add(PythonKeyboardButton.createButton(CommandTextUtil.openPythonChest, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<KeyboardButton> stringButtonsTwo = new ArrayList<>();
        stringButtonsTwo.add(PythonKeyboardButton.createButton(CommandTextUtil.exitChests, KeyboardButtonActionType.TEXT, KeyboardButtonColor.NEGATIVE));

        List<List<KeyboardButton>> buttons = new ArrayList<>();
        buttons.add(stringButtonsOne);
        buttons.add(stringButtonsTwo);

        Keyboard keyboard = new Keyboard();
        keyboard.setButtons(buttons);
        return keyboard;
    }

}
