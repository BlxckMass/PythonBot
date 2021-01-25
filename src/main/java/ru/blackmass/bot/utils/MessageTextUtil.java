package ru.blackmass.bot.utils;

import ru.blackmass.bot.entities.Flag;
import ru.blackmass.bot.entities.Statistic;
import ru.blackmass.bot.entities.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class MessageTextUtil {

    public static String getDailyStatisticText(Statistic statistic) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return "Салам, лови статистику за " + formatter.format(statistic.getDate()) + ".\n\n" +
                "\uD83D\uDC0DКоличество кликов: " + statistic.getClicksCount() + "\uD83D\uDC0D\n" +
                "\uD83D\uDC0DКоличество промокодов: " + statistic.getPromoCodeCount() + "\uD83D\uDC0D\n" +
                "\uD83D\uDC0DКоличество выводов: " + statistic.getWithdrawCount() + "\uD83D\uDC0D\n" +
                "\uD83D\uDC0DСумма выводов: " + statistic.getWithdrawnAmount() + "\uD83D\uDC0D\n" +
                "\uD83D\uDC0DСыграно игр: " + statistic.getGamesCount() + "\uD83D\uDC0D\n" +
                "\uD83D\uDC0DВыиграно игр: " + statistic.getWinGamesCount() + "\uD83D\uDC0D\n" +
                "\uD83D\uDC0DПроиграно игр: " + statistic.getLoseGamesCount() + "\uD83D\uDC0D\n" +
                "\uD83D\uDC0DВыиграно байтов: " + statistic.getWinBytesInGames() + "\uD83D\uDC0D\n" +
                "\uD83D\uDC0DПроиграно байтов: " + statistic.getLoseBytesInGames() + "\uD83D\uDC0D\n" +
                "\uD83D\uDC0DСыграно в Наперстки: " + statistic.getThimblesGamesCount() + "\uD83D\uDC0D\n" +
                "\uD83D\uDC0DСыграно в Больше-Меньше: " + statistic.getMoreOrLessGamesCount() + "\uD83D\uDC0D\n" +
                "\uD83D\uDC0DОткрыто Кейсов: " + statistic.getCasesGamesCount() + "\uD83D\uDC0D\n" +
                "\uD83D\uDC0DПрокручено Колесо фортуны: " + statistic.getFortuneWheelGamesCount() + "\uD83D\uDC0D";
    }

    public static String getBeginText() {
        return "Салам! Я бот-кликер, меня зовут Python-Bot, просим прочитать до конца, у меня ты можешь кликать и зарабатывать байты в играх!\n" +
                "\n" +
                "За каждый клик ты получаешь 5 байтов на 0 уровне!\n" +
                "Уровень повышается с помощью ваших кликов, за каждый клик ты получишь 1 опыт, на 2,4,6,8,10 уровне ты получишь +1 к клику (на 10 уровне клик = 10 байтам). \n" +
                "Далее за уровни, к сожалению, не даем +1 к клику, но лимит вывода будет повышаться!Опыт с повышением уровня обнуляется!\n" +
                "\n" +
                "Также при клике с вероятностью 15% есть шанс, что модератор Брицкий украдет у вас байты(в зависимости от уровня) и клик не удастся:\n" +
                "На 0 и 1 уровне - кража от 5 до 8 байтов\n" +
                "На 2 и 3 уровне - кража от 6 до 9 байтов\n" +
                "На 4 и 5 уровне - кража от 7 до 11 байтов\n" +
                "На 6 и 7 уровне - кража от 8 до 12 байтов\n" +
                "На 8 и 9 уровне - кража от 9 до 14 байтов\n" +
                "На 10 и выше уровнях - кража от 10 до 15 байтов\n" +
                "Еще ты можешь заработать байтов, поиграв в игры, нажав 'Игры'\uD83C\uDF81\n" +
                "\n" +
                "Система уровней:\n" +
                "⭐1 уровень ⇨ 250 опыта⭐\n" +
                "⭐2 уровень ⇨ 500 опыта⭐\n" +
                "⭐3 уровень ⇨ 750 опыта⭐\n" +
                "⭐4 уровень ⇨ 1000 опыта⭐\n" +
                "⭐5 уровень ⇨ 1500 опыта⭐\n" +
                "⭐6 уровень ⇨ 2000 опыта⭐\n" +
                "⭐7 уровень ⇨ 2500 опыта⭐\n" +
                "⭐8 уровень ⇨ 3000 опыта⭐\n" +
                "⭐9 уровень ⇨ 3500 опыта⭐\n" +
                "⭐10 уровень ⇨ 5000 опыта⭐\n" +
                "⭐11 уровень ⇨ 6000 опыта⭐\n" +
                "⭐12 уровень ⇨ 7000 опыта⭐\n" +
                "⭐13 уровень ⇨ 8000 опыта⭐\n" +
                "⭐14 уровень ⇨ 9000 опыта⭐\n" +
                "⭐15 уровень ⇨ 12000 опыта⭐\n" +
                "⭐16 уровень ⇨ 14000 опыта⭐\n" +
                "⭐17 уровень ⇨ 16000 опыта⭐\n" +
                "⭐18 уровень ⇨ 18000 опыта⭐\n" +
                "⭐19 уровень ⇨ 20000 опыта⭐\n" +
                "⭐20 уровень ⇨ 25000 опыта⭐\n" +
                "\n" +
                "К примеру, чтобы перейти на 1 уровень, нужно кликнуть 250 раз, на 2 - 500 раз.\n" +
                "\n" +
                "❗Автоматический вывод, к сожалению сделать не смогли, Модераторы не одобрили наш сервис.❗\n" +
                "Поэтому вывод осуществляется каждый день с 12:00 до 14:00 и 21:00 до 22:00 ПО МСК. Минимальная сумма - 1к, лимит вывода в день - 3к. \n" +
                "\n" +
                "❗С каждым уровнем лимит повышается на 500 байтов.❗\n" +
                "\n" +
                "\uD83C\uDF81ПРИМЕР ВВОДА ПРОМОКОДА: Промокод FGDFHBSDJ\uD83C\uDF81\n" +
                "\n" +
                "\uD83D\uDCB0ПРИМЕР ПЕРЕВОДА БАЙТОВ: Перевод 345654765(ID того, кому переводишь) 400(сумма)\uD83D\uDCB0\n" +
                "(ID можете найти в Мой аккаунт!)\n" +
                "\n" +
                "\uD83E\uDD19Хочешь сменить ник в боте? Пиши сюда, мы ответим, цена смены - 10к, твой ник будет отображаться вместо имени и фамилии\n" +
                "Либо можешь сменить ник по команде - Ник (ник), только без скобок! Цена - 50000 байтов на балансе в боте!\uD83E\uDD19" +
                "\n\n" +
                "\uD83D\uDC82\u200D♂Приглашай рефералов по ссылке в Мой аккаунт и получай 20 000 на счет в боте и 20 очков в Конкурс активности и твой друг также получит 20 000 байтов!\uD83D\uDC82\u200D♂\n\n" +
                "\uD83D\uDCB8Также выполняй наши задания в меню Задания и получай реальные деньги и байты!\uD83D\uDCB8\n" +
                "\n" +
                "\uD83D\uDC0DЕсли будут вопросы, пишите сюда, админы ответят!\uD83D\uDC0D";
    }

    public static String getBuyText() {
        return "Выберите действие.";
    }

    public static String getBuyByteCoinText() {
        return "Перейди по ссылке и оплати необходимую сумму, к примеру, если хочешь купить 100к - отправь 10 рублей.\n" +
                "\n" +
                "Курс: 1 рубль ⇨ 10к ByteCoin\n" +
                "Байты зачислятся в ваше приложение в течении 1-5 минут.\n" +
                "vk.com/app6471849_-180945535";
    }

    public static String getSellVkCoinText() {
        Random random = new Random();
        return "Перейди по ссылке и переведи необходимую сумму Vk Coin, к примеру, если хочешь купить 20к ByteCoin - отправь 1кк Vk Coin.\n Отправляйте коины от 100к! Все, что меньше - рассматриваем как подарок.\n" +
                "\n" +
                "Курс: 1кк Vk Coins ⇨ 20к ByteCoin\n" +
                "Байты зачислятся в ваше приложение в течении 1-5 минут.\n" +
                "vk.com/coin#x380857594_1000_" + random.nextInt(2000000001) + "_1";
    }

    public static String getVipText() {
        return "У нас в группе также существует VIP-статус, купив его, ты будешь получать каждый день по 35к байтов + попадешь в элитную беседу только для випок, где проходят жирные конкурсы! Также для випок вывод из бота х2!\n" +
                "\n" +
                "Мало VIPки? У нас есть PREMIUM-статус, каждый день выплаты по 70к байтов + элитная беседа + вывод из бота х3!\n" +
                "\n" +
                "Если захочешь купить, переходи по ссылке и оплачивай тариф из предложенных!\n" +
                "\n" +
                "vk.com/app6887721_-180945535\n" +
                "\n" +
                "Цены на VIP:\n" +
                "⭐25 руб ⇨ 12 дней⭐\n" +
                "⭐50 руб ⇨ 30 дней⭐\n" +
                "\n" +
                "Цены на PREMIUM:\n" +
                "⭐100 руб ⇨ 30 дней⭐";
    }

    public static String getTasksText() {
        return "Мамка не дает денег на байты?\uD83E\uDD2C\n" +
                "Батя хуярит, потому что пиздишь у него деньги с кошелька?\uD83E\uDD2C\n" +
                "Мы поможем, выполняй наши задания и получай прибыль, " +
                "которая указана в задании + с самого сервиса сможешь вывести деньги и купить байтов!";
    }

    public static String getTaskVkTargetText() {
        return "\uD83D\uDCAD1 задание - сервис VKTarget\uD83D\uDCAD\n" +
                "\n" +
                "Инструкция:\n" +
                "1)КОПИРУЕМ ССЫЛКУ И ВСТАВЛЯЕМ В БРАУЗЕР, вк блокирует ссылки! Регистрируешься, входишь в свои соц.сети(YouTube, VK, Telegram и т.д.).\n" +
                "2)Далее выполняешь 3 задания, но можешь и больше!\n" +
                "3)После выполнения - пишешь нам, ты получишь вознаграждение - 5к байтов в приложение + 5к промо в бота! ВСЁ!\n" +
                "\n" +
                "Также можешь еще повыполнять задания, которые там есть и вывести свою прибыль!\n" +
                "Ссылка для регистрации(сокращенная) - bit.ly/34sNmlT";
    }

    public static String getTaskKrutilkaText() {
        return "\uD83D\uDCAD1 задание - сервис KRUTILKA\uD83D\uDCAD\n" +
                "\n" +
                "Инструкция:\n" +
                "1)Переходишь по ссылке(если не переходит, копируй в браузер), крутишь бесплатную рулетку, тебе выпадет примерно от 5 рублей.\n" +
                "2)Далее входишь через Вконтакте и выбираешь сверху раздел - Тестовый.\n" +
                "3)После этого играешь на свои деньги, тебе нужно сделать 4 ставки, чтобы вывести оттуда деньги!\n" +
                "4)Как сделал 4 ставки, можешь уже писать нам, мы выдадим 5к в приложение и 5к промо в бота! А оставшиеся деньги можешь вывести, либо поиграть еще!\n" +
                "\n" +
                "Ссылка для регистрации(сокращенная) - vk.cc/ayMbh9";
    }

    public static String getTaskLottohaText() {
        return "\uD83D\uDCAD2 задание - сервис LOTTOHA\uD83D\uDCAD\n" +
                "\n" +
                "Инструкция:\n" +
                "1)Переходишь по ссылке(если не переходит, копируй в браузер).\n" +
                "2)Далее входишь через Вконтакте и крутишь бесплатный билет(можно крутить раз в час).\n" +
                "3)После этого можешь перейти в Задания - там будет - подписаться на их группу - выполняешь и получаешь 2 монеты и на них можно поиграть и заработать.\n" +
                "4)Как проделал пункты - можешь уже писать нам, мы выдадим 5к в приложение и 5к промо в бота! А оставшиеся деньги можешь вывести, либо поиграть еще!\n" +
                "\n" +
                "Ссылка для регистрации(сокращенная) - vk.cc/bWZN2O";
    }

    public static String getTaskFartGameText() {
        return "\uD83D\uDCAD3 задание - сервис FART GAME\uD83D\uDCAD\n" +
                "\n" +
                "Инструкция:\n" +
                "1)Переходишь по ссылке(если не переходит, копируй в браузер).\n" +
                "2)Далее входишь через Вконтакте и крутишь бесплатный билет, в котором выпадут трофеи. Также в меню аккаунта есть вкладка - Бонусы - вступаешь в их группу и получаешь еще 10 трофеев!\n" +
                "3)После этого заходишь в режим - Чайка или Бомж и играешь на эти трофеи - нужно сделать 3-4 ставки.\n" +
                "4)Как проделал пункты - можешь уже писать нам, мы выдадим 5к в приложение и 5к промо в бота! А оставшиеся деньги можешь вывести, либо поиграть еще!\n" +
                "\n" +
                "Ссылка для регистрации(сокращенная) - bit.ly/35tome1";
    }

    public static String getClickText(User user) {
        return "Вы кликнули " + user.getClickPower() + " байтов! \n Опыт увеличен на 1!";
    }

    public static String getLvlUpText() {
        return "Ваш уровень повышен, продолжайте кликать!";
    }

    public static String getStealClickText(int stealSum) {
        return "Клик неудачен! Брицкий украл у вас " + stealSum + " байтов!";
    }

    public static String getMyAccountText(User user, int withdrawLimit) {
        return "\uD83D\uDC0DВаш баланс ⇨ " + user.getBalance() + "\n" +
                "\uD83D\uDC0DВаш уровень ⇨ " + user.getLvl() + "\n" +
                "\uD83D\uDC0DВаш опыт ⇨ " + user.getExp() + " / " + user.getMaxExp() + "\n" +
                "\uD83D\uDC0DСила вашего клика ⇨ " + user.getClickPower() + "\n" +
                "\uD83D\uDC0DВсего кликнули ⇨ " + user.getClicksCount() + "\n" +
                "\uD83D\uDC0DЛимит вывода ⇨ " + withdrawLimit + "\n" +
                "\uD83D\uDC0DОчков активности ⇨ " + user.getPoints() + "\n" +
                "\uD83D\uDC0DОткрыто сундуков ⇨ " + user.getOpenChests() + "\n" +
                "\uD83D\uDC0DПриглашено рефералов ⇨ " + user.getReferralsCount() + "\n" +
                "\uD83D\uDC0DВаш ник ⇨ " + user.getNickname() + "\n" +
                "\uD83D\uDC0DВаш ID ⇨ " + user.getId() + "\n\n" +
                "Ваша реф.ссылка ⇨ vk.com/write-180945535?ref=" + user.getId();
    }

    public static String getMyBankText(int bankBalance) {
        return "\uD83D\uDC0DВ вашем банке ⇨ " + bankBalance + " байтов\uD83D\uDC0D\n\n" +
                "В банк вы можете вложить свои байты на хранение и вывести в любой момент!\n" +
                "Жми пополнить счет, там указаны контакты тех, кто пополняет!";
    }

    public static String getWithdrawText(Calendar calendar, int sumWithdraw) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String date = dateFormat.format(calendar.getTime());
        String time = timeFormat.format(calendar.getTime());
        return "#Заявка на вывод " + sumWithdraw + " байтов принята, ожидайте.\n" +
                "Дата: " + date + "\n" +
                "Время: " + time;
    }

    public static String getWithdrawTimeIsNotWithdrawText() {
        return "Вывод доступен c 12:00 до 14:00 и 21:00 до 22:00 ПО МСК.";
    }

    public static String getWithdrawNoCoinsText() {
        return "Минимальный вывод от 1000 байтов!";
    }

    public static String getErrorWithdrawInChat() {
        return "В беседе нельзя выводить, напиши в ЛС боту!";
    }

    public static String getWithdrawAlreadyText() {
        return "Вы уже выводили сегодня!\n" +
                "Вывод разрешен 1 раз в день!";
    }

    public static String getPayBytesText() {
        return "По пополнению в бота пишите админам беседы:\n" +
                "@id380857594(Динису)\n@id233894995(Эдику)\n" +
                "Переводите байты - получаете промо в бота\n" +
                "\n" +
                "Если вас наебали, пишите в поддержку - @id607890206(Поддержка)";
    }

    public static String getMoreOrLessBeginText() {
        return "\uD83C\uDFB2Игра - \"Больше-меньше\"\uD83C\uDFB2\n" +
                "\n" +
                "Вам необходимо ввести вашу ставку, затем бот выберет случайное число от 0 до 100, далее вы выбираете \"Больше\" или \"Меньше\", если сгенерируемое число окажется больше или меньше(смотря что вы выбрали) числа 50 и вы угадали - вы выиграли, в другом случае - проиграли!\n" +
                "Если вы выбрали больше и число больше 50 - выиграли двойную ставку, если меньше - ставка сгорела\n" +
                "Если вы выбрали меньше и число меньше 50 - выиграли двойную ставку, если больше - ставка сгорела\n" +
                "Удачи!";
    }

    public static String getThimblesBeginText() {
        return "\uD83C\uDFB2Игра - \"Наперстки\"\uD83C\uDFB2\n" +
                "\n" +
                "Вам необходимо ввести вашу ставку, затем под 1 из 3 наперстков кладется монетка и наперстки меняются местами, далее вам необходимо выбрать, под каким наперстком лежит монетка, если угадали - получаете 3х-байтов от вашей ставки, если проиграли, ваша ставка - сгорает.\n" +
                "Удачи!";
    }

    public static String getCasesBeginText() {
        return "\uD83D\uDCBCТы зашел к диллеру кейсов!\uD83D\uDCBC\n" +
                "Здесь ты можешь купить кейсы и заработать!(не точно)\n" +
                "Цены на кейсы и сумма, которая в них находится:\n" +
                "\n" +
                "\uD83D\uDCE6Бомж-Кейс\uD83D\uDCE6\n" +
                "Цена: 500 байтов\uD83D\uDCB0\n" +
                "Выпадает от 250 до 750 байтов\uD83D\uDCB8\n" +
                "\n" +
                "\uD83D\uDCD8Silver-Кейс\uD83D\uDCD8\n" +
                "Цена: 5 000 байтов\uD83D\uDCB0\n" +
                "Выпадает от 2 500 до 7 500 байтов\uD83D\uDCB8\n" +
                "\n" +
                "\uD83D\uDCD9Gold-Кейс\uD83D\uDCD9\n" +
                "Цена: 50 000 байтов\uD83D\uDCB0\n" +
                "Выпадает от 25 000 до 75 000 байтов\uD83D\uDCB8\n" +
                "\n" +
                "\uD83D\uDCD7Premium-Кейс\uD83D\uDCD7\n" +
                "Цена: 150 000 байтов\uD83D\uDCB0\n" +
                "Выпадает от 75 000 до 225 000 байтов\uD83D\uDCB8";
    }

    public static String getChestsText(Flag flag) {
        return "\uD83D\uDC0DПриветствую, странник! Ты зашел в меню таинственных сундуков!\uD83D\uDC0D\n\n " +
                "\uD83D\uDC0DЗдесь ты можешь открыть различные типы сундуков, " +
                "отличающиеся наградой, но чтобы их открыть - тебе понадобятся ключи.\n" +
                "\uD83D\uDC0DДля каждого сундука необходим свой ключ (Gold-Ключ откроет Gold-Сундук)." +
                "Ключи ты можешь получить разными способами - розыгрыш в фасте, конкурсе, либо один из админов может вам " +
                "его подарить.\n" +
                "\uD83D\uDC0DСамый загадочный - это Python-Сундук, никто не знает, где его достать и где получить ключ.\n" +
                "\uD83D\uDC0DЧто выпадает в сундуках? Ты можешь нажать на каждый сундук и посмотреть, что в нем может выпасть (байты, " +
                "очки, повышение лимита вывода, VIP-Статус, Premium-Статус, ключ для следующего сундука и многое другое!)\n\n" +
                "Количество ваших ключей:\n" +
                "\uD83D\uDD10Gold-Ключей ⇨ " + flag.getGoldKeys() + " \uD83D\uDD10\n" +
                "\uD83D\uDD2EMagic-Ключей ⇨ " + flag.getMagicKeys() + " \uD83D\uDD2E\n" +
                "\uD83C\uDF2AEpic-Ключей ⇨ " + flag.getEpicKeys() + " \uD83C\uDF2A\n" +
                "\uD83C\uDF1FLegendary-Ключей ⇨ " + flag.getLegendaryKeys() + " \uD83C\uDF1F\n" +
                "\uD83D\uDC32Python-Ключей ⇨ " + flag.getPythonKeys() + " \uD83D\uDC32";
    }

    public static String getGoldChestText(int countKeys) {
        return "\uD83D\uDD10Gold-Сундук\uD83D\uDD10\n\n" +
                "\uD83D\uDD10Gold-Сундуки были найдены под землей в древних веках, немногие смогли открыть его без ключа, он был выкован " +
                "лучшими кузнецами всех времен, в него вложили самое прочное золото, которое существовало на тот момент, " +
                "находи ключ и скорей открывай его!\n\n" +
                "\uD83D\uDD10Gold-Ключей ⇨ " + countKeys + " \uD83D\uDD10\n\n" +
                "Что лежит в сундуке?\n" +
                "\uD83D\uDCB0от 10000 до 30000 байтов\uD83D\uDCB0\n" +
                "\uD83C\uDFC5от 25 до 50 очков\uD83C\uDFC5\n" +
                "\uD83D\uDCB3+200 или +300 к лимиту вывода\uD83D\uDCB3";
    }

    public static String getMagicChestText(int countKeys) {
        return "\uD83D\uDD2EMagic-Сундук\uD83D\uDD2E\n\n" +
                "\uD83D\uDD2EMagic-Сундуки сундуки были созданы самыми Великими Магами с древних веков, просто так его не открыть, " +
                "на них стоит мощная магическая печать, которую разрушает только Magic-Ключ, добывай ключ и скорей открывай!\n\n" +
                "\uD83D\uDD2EMagic-Ключей ⇨ " + countKeys + " \uD83D\uDD2E\n\n" +
                "Что лежит в сундуке?\n" +
                "\uD83D\uDCB0от 30000 до 50000 байтов\uD83D\uDCB0\n" +
                "\uD83C\uDFC5от 50 до 75 очков\uD83C\uDFC5\n" +
                "\uD83D\uDCB3+400 или +500 к лимиту вывода\uD83D\uDCB3\n" +
                "\uD83D\uDCD2х2 вывод на неделю - шанс 40%\uD83D\uDCD2";
    }

    public static String getEpicChestText(int countKeys) {
        return "\uD83C\uDF2AEpic-Сундук\uD83C\uDF2A\n\n" +
                "\uD83C\uDF2AEpic-Сундуки появились внезапно и никто не знает, каким образом они попали на свет, некоторые говорят, " +
                "что Боги его создали, другие считают, что их послали из Ада или Рая.\n\uD83C\uDF2AЭпические сундуки перемещаются в мире " +
                "с помощью ураганов, телепортаций, невидимости, их сложно найти, а Epic-Ключ - еще сложней. " +
                "В любом случае, находи ключ и получай награду!\n\n" +
                "\uD83C\uDF2AEpic-Ключей ⇨ " + countKeys + " \uD83C\uDF2A\n\n" +
                "Что лежит в сундуке?\n" +
                "\uD83D\uDCB0от 70000 до 150000 байтов\uD83D\uDCB0\n" +
                "\uD83C\uDFC5от 100 до 200 очков\uD83C\uDFC5\n" +
                "\uD83D\uDCB3+600 или +700 к лимиту вывода\uD83D\uDCB3\n" +
                "\uD83D\uDCD9VIP на 12 дней - шанс 60%\uD83D\uDCD9";
    }

    public static String getLegendaryChestText(int countKeys) {
        return "\uD83C\uDF1FLegendary-Сундук\uD83C\uDF1F\n\n" +
                "\uD83C\uDF1FLegendary-Сундуки всегда присваивали лучшим войнам, которые сражались на арене, самым кровожадным, самым " +
                "беспощадным людям отдавали этот сундук и Legendary-Ключ, даже если у человека оказался Легендарный сундук, " +
                "то он его просто не мог открыть, сундук открывается только тем, кто пролил много крови.\n" +
                "\uD83C\uDF1FЕсли ты кровожадный " +
                "варвар - скорей ищи ключ и пробуй открыть сундук и получить много призов!\n\n" +
                "\uD83C\uDF1FLegendary-Ключей ⇨ " + countKeys + " \uD83C\uDF1F\n\n" +
                "Что лежит в сундуке?\n" +
                "\uD83D\uDCB0от 200000 до 350000 байтов\uD83D\uDCB0\n" +
                "\uD83C\uDFC5от 250 до 400 очков\uD83C\uDFC5\n" +
                "\uD83D\uDCB3+1000 или +1500 к лимиту вывода\uD83D\uDCB3\n" +
                "\uD83D\uDCD9VIP на месяц - шанс 75%\uD83D\uDCD9\n" +
                "\uD83D\uDCD7PREMIUM на 12 дней - шанс 40%\uD83D\uDCD7";
    }

    public static String getPythonChestText(int countKeys) {
        return "\uD83D\uDC32Python-Сундук\uD83D\uDC32\n\n" +
                "\uD83D\uDC32Python-Сундуки - неизвестные, нетронутые, невидимые сундуки, их никогда не видели, только говорили, " +
                "кто-то считает, что их не существует, кто-то говорит, что видел их.\n" +
                "\uD83D\uDC32Мудрецы считают, что Python-Сундук - " +
                "это сундук Дракона, который раньше был змеей и открыть его могут только люди с кровью дракона - Драконорожденные.\n" +
                "\uD83D\uDC32Если ты чувствуешь в себе силу Дракона, ищи Python-Ключ и бери из сундука всю мощь Пайтона!\n\n" +
                "\uD83D\uDC32Python-Ключей ⇨ " + countKeys + " \uD83D\uDC32\n\n" +
                "Что лежит в сундуке?\n" +
                "\uD83D\uDCB0от ? до ? байтов\uD83D\uDCB0\n" +
                "\uD83C\uDFC5от ? до ? очков\uD83C\uDFC5\n" +
                "\uD83D\uDCB3+? или +? к лимиту вывода\uD83D\uDCB3\n" +
                "\uD83D\uDCD9VIP на ? - шанс ?%\uD83D\uDCD9\n" +
                "\uD83D\uDCD7PREMIUM на ? - шанс ?%\uD83D\uDCD7";
    }

    public static String getChestsText() {
        return "Вы вошли в меню сундуков.";
    }

    public static String getNoKeysText() {
        return "У вас нет ключей для этого сундука.";
    }

    public static String getFortuneWheelBeginText() {
        return "\uD83C\uDFB0Колесо Фортуны\uD83C\uDFB0\n" +
                "\n" +
                "Каждый день ты можешь 1 раз крутить Колесо Фортуны и выигрывать призы, также можешь выиграть дополнительный спин + 45 очков!\n" +
                "Для просмотра призов - нажми на кнопку \"Призы\"\n" +
                "Удачи!";
    }

    public static String getFortuneWheelPrizesText() {
        return "\uD83C\uDFB0Призы Колеса Фортуны\uD83C\uDFB0\n" +
                "\n" +
                "\uD83D\uDCB8Дополнительный спин + 45 очков ⇨ 2.5%\uD83D\uDCB8\n" +
                "\uD83D\uDCB825000 байтов ⇨ 7.5%\uD83D\uDCB8\n" +
                "\uD83D\uDCB810000 байтов ⇨ 15%\uD83D\uDCB8\n" +
                "\uD83D\uDCB85000 байтов ⇨ 25%\uD83D\uDCB8\n" +
                "\uD83D\uDCB81000 байтов ⇨ 25%\uD83D\uDCB8\n" +
                "\uD83D\uDCB8500 байтов ⇨ 25%\uD83D\uDCB8";
    }

    public static String getFortuneWheelPrepareText() {
        return "Подготавливаем колесо...";
    }

    public static String getFortuneWheelPreparePrizeText(int prize) {
        if (prize == 500) {
            return "5️⃣0️⃣0️⃣ 5️⃣0️⃣0️⃣ 5️⃣0️⃣0️⃣";
        } else if (prize == 1000) {
            return "1️⃣0️⃣0️⃣0️⃣ 1️⃣0️⃣0️⃣0️⃣ 1️⃣0️⃣0️⃣0️⃣";
        } else if (prize == 5000) {
            return "5️⃣0️⃣0️⃣0️⃣ 5️⃣0️⃣0️⃣0️⃣ 5️⃣0️⃣0️⃣0️⃣";
        } else if (prize == 10000) {
            return "1️⃣0️⃣0️⃣0️⃣0️⃣ 1️⃣0️⃣0️⃣0️⃣0️⃣ 1️⃣0️⃣0️⃣0️⃣0️⃣";
        } else if (prize == 25000) {
            return "2️⃣5️⃣0️⃣0️⃣0️⃣ 2️⃣5️⃣0️⃣0️⃣0️⃣ 2️⃣5️⃣0️⃣0️⃣0️⃣";
        } else if (prize == 0) {
            return "0️⃣ 0️⃣ 0️⃣";
        }
        return "";
    }

    public static String getFortuneWheelWinedPrizeText(int prize, boolean nullWithdraw) {
        if (nullWithdraw) {
            return "Мега джекпот! Вы выиграли дополнительный спин и 45 очков! Крути еще раз!";
        }
        return "Вы выиграли " + prize + " байтов!";
    }

    public static String getFortuneWheelFlippedText() {
        return "Вы уже крутили сегодня Колесо Фортуны, возвращайтесь завтра!";
    }

    public static String getChooseThimbleText() {
        return "Выберите наперсток!";
    }

    public static String getPutCoinInThimbleText() {
        return "Кладем монетку в наперсток...";
    }

    public static String getChangingThimblesText() {
        return "Меняем наперстки местами...";
    }

    public static String getUpThimbleText() {
        return "Поднимаем наперсток...";
    }

    public static String getNoCoinsOnGameText(int balance) {
        return "Недостаточно коинов!\n" +
                "Ваш баланс ⇨ " + balance + " байтов";
    }

    public static String getResultsOfThimbleGameText(int prize, int bet, int gameChoose, boolean result) {
        if (result) {
            return "\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\n" +
                    "　Вы выиграли " + prize + " байтов!\n" +
                    "　Монетка была в " + gameChoose + " наперстке.\n" +
                    "\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D";
        }
        return "\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\n" +
                "　Вы проиграли " + bet + " байтов!\n" +
                "　Монетка была в " + gameChoose + " наперстке.\n" +
                "\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D";
    }

    public static String getResultsOfMoreOrLessGameText(int prize, int bet, int gameChoose, boolean result) {
        if (result) {
            return "\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\n" +
                    "　Вы выиграли " + prize + " байтов!\n" +
                    "　Выпало число: " + gameChoose + "\n" +
                    "\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D";
        }
        return "\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\n" +
                "　Вы проиграли " + bet + " байтов!\n" +
                "　Выпало число: " + gameChoose + "\n" +
                "\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D";
    }

    public static String getResultsDrawMoreOrLessText() {
        return "\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\n" +
                "　Ничья! Ваша ставка возвращена!\n" +
                "　Выпало число: 50\n" +
                "\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D\uD83D\uDC0D";
    }

    public static String getResultsCasesGameText(String nameOfCase, int costOfCase, int prize, int balance) {
        return "Вы открыли " + nameOfCase +  " за " + costOfCase + " байтов и получили " + prize + " байтов!\n" +
                "Ваш баланс ⇨ " + balance;
    }

    public static String getNoPromoCodesText() {
        return "Такой промокод отсутствует или уже был использован!";
    }

    public static String getActivatedPromoCodeText() {
        return "Вы уже использовали этот промокод!";
    }

    public static String getNullPromoCodeText() {
        return "Вы не ввели промокод!";
    }

    public static String getSuccessfulActivatePromoCodeText(int cost) {
        return "Вы успешно активировали промокод и получили " + cost + " байтов!";
    }

    public static String getGeneratingNumberText() {
        return "Генерируем число от 0 до 100...";
    }

    public static String getCheckNumberText() {
        return "Проверяем число...";
    }

    public static String getChooseMoreOrLessText() {
        return "Выберите, число будет больше или меньше 50?";
    }

    public static String getEnterBetText() {
        return "Введите ставку!";
    }

    public static String getNoSubscribeText() {
        return "Чтобы играть, нужно подписаться на наше сообщество и нажать кнопку начать!";
    }

    public static String getNoCoinsForChangeNicknameText(int balance) {
        return "У вас недостаточно коинов для смены ника, цена - 50000 байтов на балансе в боте!\n" +
                "Ваш баланс ⇨ " + balance + " байтов";
    }

    public static String getEnterNicknameText() {
        return "Введите ник!";
    }

    public static String getChangedNicknameText() {
        return "Поздравляем! Вы успешно сменили ник!";
    }

    public static String getSuccessTransferBytesText() {
        return "Вы успешно перевели байты по заданному айди!";
    }

    public static String getNoCoinsToTransferBytesText(int balance) {
        return "У вас недостаточно коинов для перевода!\n" +
                "Ваш баланс ⇨ " + balance + " байтов";
    }

    public static String getValidateTransferBytesText() {
        return "Ошибка. Проверьте введенные данные!";
    }

    public static String getEnterGamesText() {
        return "Вы вошли в игры.";
    }

    public static String getExitOfGameText() {
        return "Вы вышли из игры.";
    }

    public static String getActivityText(double fondBalance) {
        return "Конкурс активности в боте:\n" +
                "Мем в предложку - 10 очков\uD83D\uDC4D\n" +
                "Приглашение друга, который запустит бота - 20 очков\uD83D\uDC65\n" +
                "Ввод промокода - 2 очка\uD83D\uDCB8\n" +
                "Победа в игре (ставка от 3000 байтов) - 2 очка в \uD83D\uDEE2Наперстках\uD83D\uDEE2 и 1 очко в ⚖Больше-меньше⚖\n" +
                "\uD83C\uDFB0Колесо фортуны - 5 очков\uD83C\uDFB0\n" +
                "\n" +
                "Фонд с начала недели равен - 100 000, увеличивается от кликов всех игроков (плюсуется сила клика), поэтому фонд зависит от вас!\n" +
                "Выплата в реальных байтах!\n" +
                "\n" +
                "\uD83C\uDF81Первое место получает х2 вывод в боте на неделю!\uD83C\uDF81\n" +
                "\uD83D\uDCB8Фонд составляет ⇨ " + (int) fondBalance + " байтов\uD83D\uDCB8\n\n";
    }

    public static String getActivityResultsText(double fondBalance) {
        return "Результаты конкурса активности в боте.\n\n" +
                "\uD83C\uDF81Первое место получает х2 вывод в боте на неделю!\uD83C\uDF81\n" +
                "\uD83D\uDCB8Фонд составляет ⇨ " + (int) fondBalance + " байтов\uD83D\uDCB8\n\n";
    }

    public static String getExitMainMenuText() {
        return "Вы вышли в главное меню.";
    }

}
